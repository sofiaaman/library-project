package ru.itgirl.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.libraryproject.dto.AuthorDto;
import ru.itgirl.libraryproject.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/author/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author/v1")
    AuthorDto getAuthorBySurnameV1(@RequestParam(value = "surname", required = false) String surname) {
        return authorService.getAuthorBySurnameV1(surname);
    }

    @GetMapping("/author/v2")
    AuthorDto getAuthorBySurnameV2(@RequestParam(value = "surname", required = false) String surname) {
        return authorService.getAuthorBySurnameV2(surname);
    }

    @GetMapping("/author/v3")
    AuthorDto getAuthorBySurnameV3(@RequestParam(value = "surname", required = false) String surname) {
        return authorService.getAuthorBySurnameV3(surname);
    }

}
