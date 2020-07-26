package com.akash.springboot.jpa.mysql.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.akash.springboot.jpa.mysql.dao.MovieDao;
import com.akash.springboot.jpa.mysql.dao.UserMovieRatingsDao;
import com.akash.springboot.jpa.mysql.entity.MovieDto;
import com.akash.springboot.jpa.mysql.entity.Movie;
import com.akash.springboot.jpa.mysql.entity.User;
import com.akash.springboot.jpa.mysql.entity.ResponseMovieContainer;
import com.akash.springboot.jpa.mysql.entity.UserMovieRatings;
import com.akash.springboot.jpa.mysql.entity.mapper.MovieDtoMapper;
import com.akash.springboot.jpa.mysql.exception.MovieNotFoundException;

/**
 * @author Akash
 *
 */

@RestController
public class MovieController {

	@Autowired
	MovieDao movieDao;

	@Autowired
	UserMovieRatingsDao userMovieRatingsDao;

	MovieDtoMapper movieDtoMapper = new MovieDtoMapper();

	// RestTemplate executing synchronous HTTP requests
	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.key}")
	private String apiKry;

//	@GetMapping(value = { "", "/", "/movie", "/movie/NowPlaying", "/user/movie" })
//	public Movie[] getNowPlaying() {
//		// Integrating API ->
//		// https://api.themoviedb.org/3/movie/now_playing?api_key=<<api_key>>
//		// API Description -> https://developers.themoviedb.org/3/movies/get-now-playing
//
//		// String result = restTemplate.getForObject(now_playing_url + apiKry,
//		// String.class);
//
//		ResponseMovieContainer resp = restTemplate.getForObject(
//				"https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKry, ResponseMovieContainer.class);
//		return resp.getResults();
//	}
//
//	@GetMapping(value = { "/movie/Popular" })
//	public Movie[] getPopularMovies() {
//		// Integrating API ->
//		// https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>
//		// API Description ->
//		// https://developers.themoviedb.org/3/movies/get-popular-movies
//
//		ResponseMovieContainer resp = restTemplate.getForObject(
//				"https://api.themoviedb.org/3/movie/popular?api_key=" + apiKry, ResponseMovieContainer.class);
//		return resp.getResults();
//	}
//
//	@GetMapping(value = { "/movie/TopRated" })
//	public Movie[] getTopRated() {
//		// Integrating API ->
//		// https://api.themoviedb.org/3/movie/top_rated?api_key=<<api_key>>
//		// API Description ->
//		// https://developers.themoviedb.org/3/movies/get-top-rated-movies
//
//		ResponseMovieContainer resp = restTemplate.getForObject(
//				"https://api.themoviedb.org/3/movie/top_rated?api_key=" + apiKry, ResponseMovieContainer.class);
//		return resp.getResults();
//	}
//
//	@GetMapping(value = { "/movie/Upcoming" })
//	public Movie[] getUpcoming() {
//		// Integrating API ->
//		// https://api.themoviedb.org/3/movie/upcoming?api_key=<<api_key>>
//		// API Description -> https://developers.themoviedb.org/3/movies/get-upcoming
//
//		ResponseMovieContainer resp = restTemplate.getForObject(
//				"https://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKry, ResponseMovieContainer.class);
//		return resp.getResults();
//	}
//
//	@GetMapping(value = { "/movie/{movieId}" })
//	public Movie geMovieInfo(@PathVariable String movieId) {
//		Movie movie = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKry,
//				Movie.class);
//		return movie;
//	}

	/* ########################----User Related Call----######################## */

	/**
	 * @param userId
	 * @param movieName
	 * @return List of movies searching by name
	 */
	@GetMapping(value = { "/user/{userId}/movie/{movieName}" })
	public List<MovieDto> getMovieSearch(@PathVariable Integer userId, @PathVariable String movieName) {
		List<MovieDto> moviesDtos = new ArrayList<MovieDto>();
		ResponseMovieContainer resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKry + "&query=" + movieName,
				ResponseMovieContainer.class);
		if (resp.getResults().length != 0) {
			moviesDtos = Arrays.asList(resp.getResults());
			moviesDtos.forEach(movieDto -> {
				UserMovieRatings userMovieRating = userMovieRatingsDao.findByUserIdAndMovieId(userId, movieDto.getId());
				if (Objects.nonNull(userMovieRating)) {
					movieDto.setMyRating(userMovieRating.getRating());
				}
			});
		} else {
			throw new MovieNotFoundException("Movie Not Found - " + movieName);
		}
		return moviesDtos;
	}

	/**
	 * @param userId
	 * @param movieId
	 * @param myRating
	 * @return 10 Recently rated movies list Rated by given user
	 */
	@PostMapping(value = { "/user/{userId}/movie" })
	public List<MovieDto> saveUserRatedMovies(@PathVariable Integer userId, @RequestParam Integer movieId,
			@RequestParam Double myRating) {
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

	/**
	 * @param userId
	 * @return Movies list Rated by given user
	 */
	@GetMapping(value = { "/user/{userId}/movies" })
	public List<MovieDto> getUserRatedMovies(@PathVariable Integer userId) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserId(userId);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}

	/**
	 * @param userId
	 * @return Top 10 Rated movies list Rated by given user
	 */
	@GetMapping(value = { "/user/{userId}/movies/TopRated" })
	public List<MovieDto> getUserTopRatedMovies(@PathVariable Integer userId) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByRatingDesc(userId, pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}

	/**
	 * @param userId
	 * @return 10 Recently rated movies list Rated by given user
	 */
	@GetMapping(value = { "/user/{userId}/movies/RecentRated" })
	public List<MovieDto> getUserRecentlyRatedMovies(@PathVariable Integer userId) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();

		Pageable pageable = PageRequest.of(0, 10);
		List<UserMovieRatings> userMovieRatings = userMovieRatingsDao.findByUserIdOrderByTimestampDesc(userId, pageable);

		movieDtos = movieDtoMapper.getMovieDtoListFromUserMovieRatingList(userMovieRatings);
		return movieDtos;
	}
}
