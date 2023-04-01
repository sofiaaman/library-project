package ru.itgirl.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject.dto.AuthorDto;
import ru.itgirl.libraryproject.dto.BookDto;
import ru.itgirl.libraryproject.dto.GenreDto;
import ru.itgirl.libraryproject.model.Genre;
import ru.itgirl.libraryproject.repository.GenreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow();

        List<BookDto> bookDtoList = genre.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .genre(book.getGenre().getName())
                        .authors(book.getAuthors()
                                .stream()
                                .peek(author -> AuthorDto.builder()
                                        .id(author.getId())
                                        .name(author.getName())
                                        .surname(author.getSurname()))
                                .collect(Collectors.toList()))
                        .build())
                .toList();

        GenreDto genreDto = new GenreDto();
        genreDto.setId(genre.getId());
        genreDto.setName(genre.getName());
        genreDto.setBooks(bookDtoList);
        return genreDto;
    }
}
