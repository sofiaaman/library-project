package ru.itgirl.libraryproject.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject.dto.AuthorCreateDto;
import ru.itgirl.libraryproject.dto.AuthorDto;
import ru.itgirl.libraryproject.dto.BookDto;
import ru.itgirl.libraryproject.model.Author;
import ru.itgirl.libraryproject.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    @Override
    public AuthorDto getAuthorBySurnameV1(String surname) {
        Author author = authorRepository.findAuthorBySurname(surname).orElseThrow();
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    @Override
    public AuthorDto getAuthorBySurnameV2(String surname) {
        Author author = authorRepository.findAuthorBySurnameBySql(surname).orElseThrow();
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    @Override
    public AuthorDto getAuthorBySurnameV3(String surname) {
        Specification<Author> authorSpecification = Specification.where(new Specification<Author>() {
            @Override
            public Predicate toPredicate(Root<Author> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("surname"), surname);
            }
        });
        Author author = authorRepository.findOne(authorSpecification).orElseThrow();
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(this::convertEntityToDto).collect(Collectors.toList());

    }

    @Override
    public AuthorDto createAuthor(AuthorCreateDto authorCreateDto) {

        Author author = authorRepository.save(convertDtoToEntity(authorCreateDto));
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    private Author convertDtoToEntity(AuthorCreateDto authorCreateDto) {
        return Author.builder()
                .name(authorCreateDto.getName())
                .surname(authorCreateDto.getSurname())
                .build();
    }

    private AuthorDto convertEntityToDto(Author author) {
        List<BookDto> bookDtoList = null;
        if (author.getBooks() != null) {
            bookDtoList = author.getBooks()
                    .stream()
                    .map(book -> BookDto.builder()
                            .genre(book.getGenre().getName())
                            .name(book.getName())
                            .id(book.getId())
                            .build())
                    .toList();
        }
        AuthorDto authorDto = AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .books(bookDtoList)
                .build();
        return authorDto;
    }
}
