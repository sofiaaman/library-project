package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.AuthorCreateDto;
import ru.itgirl.libraryproject.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    public AuthorDto getAuthorById(Long id);

    public AuthorDto getAuthorBySurnameV1(String surname);

    public AuthorDto getAuthorBySurnameV2(String surname);

    public AuthorDto getAuthorBySurnameV3(String surname);

    public List<AuthorDto> getAllAuthors();

    public AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
}
