package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.BookCreateDto;
import ru.itgirl.libraryproject.dto.BookDto;

import java.util.List;

public interface BookService {
    public BookDto getByNameV1(String name);

    public BookDto getByNameV2(String name);

    public BookDto getByNameV3(String name);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookCreateDto bookCreateDto);
}