package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.AuthorDto;

public interface AuthorService {

    public AuthorDto getAuthorById(Long id);

    public AuthorDto getAuthorBySurnameV1(String surname);

    public AuthorDto getAuthorBySurnameV2(String surname);

    public AuthorDto getAuthorBySurnameV3(String surname);
}
