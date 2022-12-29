package ru.rsatu.hibernatetutorial.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Автор книги
 */
@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_id_gen")
    @SequenceGenerator(name = "books_id_gen", sequenceName = "books_id_gen_seq", initialValue = 10, allocationSize = 10)
    private Long id;
    private String name;
    private Date birthDate;
    private String nickName;

}
