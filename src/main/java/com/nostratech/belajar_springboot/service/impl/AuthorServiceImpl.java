package com.nostratech.belajar_springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nostratech.belajar_springboot.dto.AuthorDTO;
import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.repository.AuthorRepository;
import com.nostratech.belajar_springboot.service.AuthorService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public void createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.name());
        author.setDescription(authorDTO.description());

        log.info("author: ", author);
        authorRepository.save(author);
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = findAuthorById(id);
        
        log.info("{}", author);
        return mapToDTO(author);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return mapToDTOList(authors);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        Author author = findAuthorById(id);
        authorRepository.delete(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = findAuthorById(id);
        author.setName(authorDTO.name());
        author.setDescription(authorDTO.description());
        
        log.info("author: ", author);
    }

    private Author findAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + id));
    }

    private AuthorDTO mapToDTO(Author author) {
        return new AuthorDTO(author.getId(), author.getName(), author.getDescription());
    }

    private List<AuthorDTO> mapToDTOList(List<Author> authors) {
        List<AuthorDTO> authorDTOs = new ArrayList<>();
        for(Author author : authors) {
            AuthorDTO authorDTO = new AuthorDTO(author.getId(), author.getName(), author.getDescription());
            authorDTOs.add(authorDTO);
        }
        return authorDTOs;
    }

}
