package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.BookDto;

public interface BookService {
    public BookDto getByNameV1(String name);

    public BookDto getByNameV2(String name);

    public BookDto getByNameV3(String name);
}