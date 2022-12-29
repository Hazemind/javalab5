package ru.rsatu.hibernatetutorial.service;

import ru.rsatu.hibernatetutorial.mapper.AuthorMapper;
import ru.rsatu.hibernatetutorial.pojo.dto.AuthorDto;
import ru.rsatu.hibernatetutorial.repository.AuthorsRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с авторами
 */
@ApplicationScoped
public class AuthorsService {
    @Inject
    AuthorMapper authorMapper;
    @Inject
    AuthorsRepository authorsRepository;
    /**
     * Загрузить всех авторов
     */
    public List<AuthorDto> loadAuthorList() {
        return authorsRepository.loadAuthors()
                .stream()
                .map(authorMapper::toAuthorDto)
                .collect(Collectors.toList());
    }
    /**
     * Сохранение автора
     */
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        return authorMapper.toAuthorDto(authorsRepository.saveAuthor(authorDto));
    }
    /**
     * Удаление автора
     */
    public void deleteAuthor(Long authorId) {
        authorsRepository.deleteAuthor(authorId);
    }

}
