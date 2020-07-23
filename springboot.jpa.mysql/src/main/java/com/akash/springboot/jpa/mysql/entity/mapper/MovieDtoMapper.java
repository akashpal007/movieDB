package com.akash.springboot.jpa.mysql.entity.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.akash.springboot.jpa.mysql.entity.MovieDto;
import com.akash.springboot.jpa.mysql.entity.Movie;
import com.akash.springboot.jpa.mysql.entity.UserMovieRatings;

public class MovieDtoMapper {
	public MovieDto getMovieToDto(Movie movie) {
		MovieDto movieDto = new MovieDto();
		if (Objects.nonNull(movie)) {
			movieDto.setId(movie.getId());
			movieDto.setOverview(movie.getOverview());
			movieDto.setTitle(movie.getTitle());
			movieDto.setVote_average(movie.getAverageRating());
			return movieDto;
		}
		return null;
	}

	public List<MovieDto> getMovieToDtoList(List<Movie> movies) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		if (!movies.isEmpty()) {
			for (Movie movie : movies) {
				movieDtos.add(getMovieToDto(movie));
			}
			return movieDtos;
		}
		return null;
	}

	public Movie getDtoToMovie(MovieDto movieDto) {
		Movie movie = new Movie();
		if (Objects.nonNull(movieDto)) {
			movie.setId(movieDto.getId());
			movie.setOverview(movieDto.getOverview());
			movie.setTitle(movieDto.getTitle());
			movie.setAverageRating(movieDto.getVote_average());

			return movie;
		}
		return null;
	}

	public List<Movie> getDtoToMovieList(List<MovieDto> movieDtos) {
		List<Movie> movies = new ArrayList<Movie>();
		if (!movieDtos.isEmpty()) {
			for (MovieDto movieDto : movieDtos) {
				movies.add(getDtoToMovie(movieDto));
			}
			return movies;
		}
		return null;
	}

	public MovieDto getRatingToMovieDto(UserMovieRatings userMovieRating) {
		MovieDto movieDto = new MovieDto();
		if (Objects.nonNull(userMovieRating)) {
			movieDto.setId(userMovieRating.getMovie().getId());
			movieDto.setOverview(userMovieRating.getMovie().getOverview());
			movieDto.setTitle(userMovieRating.getMovie().getTitle());
			movieDto.setVote_average(userMovieRating.getMovie().getAverageRating());
			movieDto.setMyRating(userMovieRating.getRating());
			return movieDto;
		}
		return null;
	}

	public List<MovieDto> getRatingListToMovieDtoList(List<UserMovieRatings> userMovieRatings) {
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		if (!userMovieRatings.isEmpty()) {
			for (UserMovieRatings userMovieRating : userMovieRatings) {
				movieDtos.add(getRatingToMovieDto(userMovieRating));
			}
			return movieDtos;
		}
		return null;
	}
}
