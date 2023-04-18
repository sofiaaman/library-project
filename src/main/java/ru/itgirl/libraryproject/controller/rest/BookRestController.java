package ru.itgirl.libraryproject.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.libraryproject.dto.BookCreateDto;
import ru.itgirl.libraryproject.dto.BookDto;
import ru.itgirl.libraryproject.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/book/v1")
    BookDto getBookByNameV1(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV1(name);
    }

    @GetMapping("/book/v2")
    BookDto getBookByNameV2(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV2(name);
    }

    @GetMapping("/book/v3")
    BookDto getBookByNameV3(@RequestParam(value = "name", required = false) String name) {
        return bookService.getByNameV3(name);
    }

    @PostMapping("/book/create")
    BookDto createBook(@RequestBody BookCreateDto bookCreateDto) {
        return bookService.createBook(bookCreateDto);
    }
}
