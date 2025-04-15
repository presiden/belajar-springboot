package com.nostratech.belajar_springboot.service;

import java.util.List;

import com.nostratech.belajar_springboot.dto.AuthorDTO;

public interface AuthorService {

    void createAuthor(AuthorDTO authorDTO);

    AuthorDTO getAuthorById(Long id);

    List<AuthorDTO> getAllAuthors();

    void deleteAuthor(Long id);

    void updateAuthor(Long id, AuthorDTO authorDTO);
}
