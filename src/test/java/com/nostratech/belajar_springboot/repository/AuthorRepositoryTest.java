package com.nostratech.belajar_springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nostratech.belajar_springboot.entity.Author;

@SpringBootTest
public class AuthorRepositoryTest {
@Autowired
    private AuthorRepository authorRepository;

    @Test
    void testSaveAuthor() {
        // given
        Author author = new Author();
        author.setName("Test Author");
        author.setDescription("Test Description");

        // when
        Author savedAuthor = authorRepository.save(author);

        // then
        assertNotNull(savedAuthor.getId());
        assertEquals("Test Author", savedAuthor.getName());
        assertEquals("Test Description", savedAuthor.getDescription());
    }
}
