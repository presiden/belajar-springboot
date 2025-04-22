package com.nostratech.belajar_springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nostratech.belajar_springboot.dto.AuthorDTO;
import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    List<Author> authors = new ArrayList<>();

    @Override
    public void createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setId((long) (authors.size() + 1));
        author.setName(authorDTO.name());
        author.setDescription(authorDTO.description());

        System.out.println("author: " + author);

        authors.add(author);
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = authors.get((int) (id - 1));
        if (author != null) {
            return new AuthorDTO(author.getId(), author.getName(), author.getDescription());
        } else {
            throw new IllegalArgumentException("Author not found with id: " + id);
        }
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> authorDTOs = new ArrayList<>();
        for (Author author : authors) {
            authorDTOs.add(new AuthorDTO(author.getId(), author.getName(), author.getDescription()));
        }
        return authorDTOs;
    }

    @Override
    public void deleteAuthor(Long id) {
        AuthorDTO author = getAuthorById(id);
        authors.remove(author);
    }

    @Override
    public void updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = authors.get((int) (id - 1));
        if (author != null) {
            author.setName(authorDTO.name());
            author.setDescription(authorDTO.description());
        } else {
            throw new IllegalArgumentException("Author not found with id: " + id);
        }
    }

}
