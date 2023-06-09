package ru.itgirl.libraryproject.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject.dto.GenreAndBookAndAuthorDto;
import ru.itgirl.libraryproject.service.GenreService;

@RestController
@RequiredArgsConstructor
public class GenreRestController {
        private final GenreService genreService;

        @GetMapping("/genre/{id}")
        public GenreAndBookAndAuthorDto getGenreById(@PathVariable("id") Long id) {
            return genreService.getGenreById(id);
        }
}
