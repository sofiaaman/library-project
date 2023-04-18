package ru.itgirl.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject.dto.*;
import ru.itgirl.libraryproject.model.Genre;
import ru.itgirl.libraryproject.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreAndBookAndAuthorDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();

        List<AuthorAndBookDto> authorAndBookDtoList = genre.getBooks()
                .stream()
                .map(book -> AuthorAndBookDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .author(book.getAuthors()
                                .stream()
                                .map(author -> author.getName() + " " + author.getSurname())
                                .collect(Collectors.joining(", ")))
                        .build())
                .toList();

        GenreAndBookAndAuthorDto responseGenreAndBookAndAuthorDto = new GenreAndBookAndAuthorDto();
        responseGenreAndBookAndAuthorDto.setId(genre.getId());
        responseGenreAndBookAndAuthorDto.setName(genre.getName());
        responseGenreAndBookAndAuthorDto.setBooks(authorAndBookDtoList);
        return responseGenreAndBookAndAuthorDto;
    }
}
