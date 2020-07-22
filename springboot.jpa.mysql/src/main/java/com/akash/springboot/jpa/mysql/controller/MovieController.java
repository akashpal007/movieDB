package com.akash.springboot.jpa.mysql.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
import com.akash.springboot.jpa.mysql.entity.Movie;
import com.akash.springboot.jpa.mysql.entity.ResponseMovieContainer;
import com.akash.springboot.jpa.mysql.entity.User;
/**
 * @author Akash
 *
 */

@RestController
public class MovieController {

	@Autowired
	MovieDao movieDao;

	// RestTemplate executing synchronous HTTP requests
	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.key}")
	private String apiKry;

	@GetMapping(value = { "", "/", "/movie", "/movie/NowPlaying", "/user/movie" })
	public Movie[] getNowPlaying() {
		// Integrating API ->
		// https://api.themoviedb.org/3/movie/now_playing?api_key=<<api_key>>
		// API Description -> https://developers.themoviedb.org/3/movies/get-now-playing

		// String result = restTemplate.getForObject(now_playing_url + apiKry,
		// String.class);

		ResponseMovieContainer resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKry, ResponseMovieContainer.class);
		return resp.getResults();
	}

	@GetMapping(value = { "/movie/Popular" })
	public Movie[] getPopularMovies() {
		// Integrating API ->
		// https://api.themoviedb.org/3/movie/popular?api_key=<<api_key>>
		// API Description ->
		// https://developers.themoviedb.org/3/movies/get-popular-movies

		ResponseMovieContainer resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/popular?api_key=" + apiKry, ResponseMovieContainer.class);
		return resp.getResults();
	}

	@GetMapping(value = { "/movie/TopRated" })
	public Movie[] getTopRated() {
		// Integrating API ->
		// https://api.themoviedb.org/3/movie/top_rated?api_key=<<api_key>>
		// API Description ->
		// https://developers.themoviedb.org/3/movies/get-top-rated-movies

		ResponseMovieContainer resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/top_rated?api_key=" + apiKry, ResponseMovieContainer.class);
		return resp.getResults();
	}

	@GetMapping(value = { "/movie/Upcoming" })
	public Movie[] getUpcoming() {
		// Integrating API ->
		// https://api.themoviedb.org/3/movie/upcoming?api_key=<<api_key>>
		// API Description -> https://developers.themoviedb.org/3/movies/get-upcoming

		ResponseMovieContainer resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKry, ResponseMovieContainer.class);
		return resp.getResults();
	}

	@GetMapping(value = { "/movie/{movieId}" })
	public Movie geMovieInfo(@PathVariable String movieId) {
		Movie movie = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKry,
				Movie.class);
		return movie;
	}

	/* ########################----User Related Call----######################## */

	@GetMapping(value = { "/user/{userId}/movie/{movieName}" })
	public List<Movie> getUserRatedMovies(@PathVariable long userId, @PathVariable String movieName) {
		List<Movie> movies = new ArrayList<Movie>();
		ResponseMovieContainer resp = restTemplate.getForObject(
				"https://api.themoviedb.org/3/search/movie?api_key=" + apiKry + "&query=" + movieName,
				ResponseMovieContainer.class);
		if (resp.getResults().length != 0) {
			movies = Arrays.asList(resp.getResults());
		}
		// I also have to search in my db so that if any movieId present in my db which
		// is came from 3rd party api that must be added
		return movies;
	}

	/**
	 * @param userId
	 * @param movieId
	 * @param myRating
	 * @return 10 Recently rated movies list Rated by given user
	 */
	@PostMapping(value = { "/user/{userId}/movie" })
	public List<Movie> saveUserRatedMovies(@PathVariable Integer userId, @RequestParam String movieId,
			@RequestParam String myRating) {
		List<Movie> movies = new ArrayList<Movie>();
		if (Objects.nonNull(movieId) && Objects.nonNull(myRating)) {
			Movie movie = restTemplate
					.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKry, Movie.class);
			if (Objects.nonNull(movie)) {
				movie.setMyRating(myRating);
				User user = new User();
				user.setId(userId);
				movie.setUser(user);
				movieDao.save(movie);
			}
		} else {
			throw new RuntimeException("Movie_Id or My_Rating not found");
		}

		Pageable pageable = PageRequest.of(0, 10);
		movies = movieDao.findByUser_IdOrderByTimestampDesc(userId, pageable);
		return movies;
	}

	/**
	 * @param userId
	 * @return Movies list Rated by given user
	 */
	@GetMapping(value = { "/user/{userId}/movies" })
	public List<Movie> getUserRatedMovies(@PathVariable Integer userId) {
		List<Movie> movies = new ArrayList<Movie>();

		movies = movieDao.findByUser_IdOrderByTimestampDesc(userId);
		return movies;
	}

	/**
	 * @param userId
	 * @return Top 10 Rated movies list Rated by given user
	 */
	@GetMapping(value = { "/user/{userId}/movies/TopRated" })
	public List<Movie> getUserTopRatedMovies(@PathVariable Integer userId) {
		List<Movie> movies = new ArrayList<Movie>();

		Pageable pageable = PageRequest.of(0, 10);
		movies = movieDao.findByUser_IdOrderByMyRatingDesc(userId, pageable);
		return movies;
	}

	/**
	 * @param userId
	 * @return 10 Recently rated movies list Rated by given user
	 */
	@GetMapping(value = { "/user/{userId}/movies/RecentRated" })
	public List<Movie> getUserRecentRatedMovies(@PathVariable Integer userId) {
		List<Movie> movies = new ArrayList<Movie>();

		Pageable pageable = PageRequest.of(0, 10);
		movies = movieDao.findByUser_IdOrderByTimestampDesc(userId, pageable);
		return movies;
	}
}
