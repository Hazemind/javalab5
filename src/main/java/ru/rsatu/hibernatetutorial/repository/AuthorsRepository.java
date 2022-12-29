package ru.rsatu.hibernatetutorial.repository;

import ru.rsatu.hibernatetutorial.mapper.AuthorMapper;
import ru.rsatu.hibernatetutorial.pojo.dto.AuthorDto;
import ru.rsatu.hibernatetutorial.pojo.entity.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Репозиторий для работы с авторами
 */
@ApplicationScoped
public class AuthorsRepository {
    @Inject
    EntityManager entityManager;
    @Inject
    AuthorMapper authorMapper;

    /**
     * Загрузить всех авторов
     */
    public List<Author> loadAuthors() {
        return entityManager.createQuery("select b from Author b", Author.class)
                .getResultList();
    }
    /**
     * Сохранение автора
     */
    @Transactional
    public Author saveAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toAuthor(authorDto);
        if (author.getId() != null) {
            entityManager.merge(author);
        } else {
            entityManager.persist(author);
        }
        entityManager.flush();
        return author;
    }
    /**
     * Удаление автора
     */
    @Transactional
    public void deleteAuthor(long authorId){
        Author author = entityManager.find(Author.class, authorId);
        entityManager.remove(author);
    }
}
