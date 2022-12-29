package ru.rsatu.hibernatetutorial.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuthorDto {

    private Long id;
    private String name;
    private Date birthDate;
    private String nickName;

}
