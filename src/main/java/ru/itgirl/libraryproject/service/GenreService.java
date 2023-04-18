package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.GenreAndBookAndAuthorDto;

public interface GenreService {
    public GenreAndBookAndAuthorDto getGenreById(Long id);
}
