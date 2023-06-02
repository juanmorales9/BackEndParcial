package src.main.java.com.dh.movie.controller;

import com.dh.movie.model.Movie;
import com.dh.movie.service.MovieService;
import com.springframework.http.ResponseEntity;
import com.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {


    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }
}
