package com.akash.springboot.jpa.mysql.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.akash.springboot.jpa.mysql.dao.MovieDao;
import com.akash.springboot.jpa.mysql.dao.UserDao;
import com.akash.springboot.jpa.mysql.dao.UserMovieRatingsDao;
import com.akash.springboot.jpa.mysql.exception.MovieNotFoundException;
import com.akash.springboot.jpa.mysql.vo.dto.MovieDto;
import com.akash.springboot.jpa.mysql.vo.entity.Movie;
import com.akash.springboot.jpa.mysql.vo.entity.ResponseMovieContainer;
import com.akash.springboot.jpa.mysql.vo.entity.User;
import com.akash.springboot.jpa.mysql.vo.entity.UserMovieRatings;
import com.akash.springboot.jpa.mysql.vo.mapper.MovieDtoMapper;

/**
 * @author Akash
 *
 */

@RestController
public class MovieController {

	@Autowired
	MovieDao movieDao;

	@Autowired
	UserDao userDao;

	@Autowired
	UserMovieRatingsDao userMovieRatingsDao;

	MovieDtoMapper movieDtoMapper = new MovieDtoMapper();

	// RestTemplate executing synchronous HTTP requests
	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.key}")
	private String apiKry;

	@GetMapping(value = { "/", "/movies" })
	public List<MovieDto> getUserRatedMovies(Principal principal) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));

		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserId(user.get().getId());

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}

	@GetMapping(value = { "/movie/{movieName}" })
	public List<MovieDto> getMovieSearch(Principal principal, @PathVariable String movieName) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));

		List<MovieDto> moviesDtos = new ArrayList<MovieDto>();
		ResponseMovieContainer resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKry + "&query=" + movieName,
				ResponseMovieContainer.class);
		if (resp.getResults().length != 0) {
			moviesDtos = Arrays.asList(resp.getResults());
			moviesDtos.forEach(movieDto -> {
				UserMovieRatings userMovieRating = userMovieRatingsDao.findByUserIdAndMovieId(user.get().getId(),
						movieDto.getId());
				if (Objects.nonNull(userMovieRating)) {
					movieDto.setMyRating(userMovieRating.getRating());
				}
			});
		} else {
			throw new MovieNotFoundException("Movie Not Found - " + movieName);
		}
		return moviesDtos;
	}

	@PostMapping(value = { "/movie" })
	public List<MovieDto> saveUserRatedMovies(Principal principal, @RequestParam Integer movieId,
			@RequestParam Double myRating) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));
		Integer userId = user.get().getId();
		
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		if (Objects.nonNull(movieId) && Objects.nonNull(myRating)) {
			Optional<Movie> movie = movieDao.findById(movieId);
			if (movie.isPresent()) {
				User userData = new User(userId, null, null);
				Movie movieData = new Movie(movieId, null, null, null);
				UserMovieRatings userMovieRating = new UserMovieRatings(userId, movieId, userData, movieData, myRating,
						new Date());
				userMovieRatingsDao.save(userMovieRating);
			} else {
				MovieDto movieDto = restTemplate.getForObject(
						"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKry, MovieDto.class);
				if (Objects.nonNull(movieDto)) {
					User userData = new User(userId, "", "");
					Movie movieData = movieDtoMapper.getMovieFromDto(movieDto);
					movieData = movieDao.save(movieData);
					UserMovieRatings userMovieRating = new UserMovieRatings(userId, movieId, userData, movieData,
							myRating, new Date());
					userMovieRatingsDao.save(userMovieRating);
				}
			}
		} else {
			throw new RuntimeException("Movie_Id or My_Rating not found");
		}

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByTimestampDesc(userId,
				pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);

		return movieDtos;
	}

	
	@GetMapping(value = { "/movies/TopRated" })
	public List<MovieDto> getUserTopTenRatedMovies(Principal principal) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));
		
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByRatingDesc(user.get().getId(), pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}

	@GetMapping(value = { "/movies/RecentRated" })
	public List<MovieDto> getUserTenRecentlyRatedMovies(Principal principal) {
		Optional<User> user = userDao.findByName(principal.getName());
		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found - Name -" + principal.getName()));
		
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByTimestampDesc(user.get().getId(),
				pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}
}
