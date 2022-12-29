package ru.rsatu.hibernatetutorial.resource;


import ru.rsatu.hibernatetutorial.pojo.dto.AuthorDto;
import ru.rsatu.hibernatetutorial.service.AuthorsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors/api/v1")
public class AuthorResource {

    @Inject
    AuthorsService authorsService;

    @GET
    @Path("/loadAuthorList")
    public List<AuthorDto> loadAuthorList() {
        return authorsService.loadAuthorList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saveAuthor")
    public AuthorDto saveAuthor(AuthorDto authorDto) {
        return authorsService.saveAuthor(authorDto);
    }

    @DELETE
    @Path("/author/{authorId}")
    public void deleteAuthor(@PathParam("authorId") Long authorId) {
        authorsService.deleteAuthor(authorId);
    }
}
