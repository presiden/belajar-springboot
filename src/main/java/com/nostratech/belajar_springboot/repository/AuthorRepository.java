package com.nostratech.belajar_springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nostratech.belajar_springboot.entity.Author;

import jakarta.persistence.EntityManager;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // @Autowired
    // private EntityManager entityManager;
    // public Author findById(Long id) {
    //     return entityManager.find(Author.class, id);
    // }
    // public void save(Author author) {
    //     entityManager.persist(author);
    // }
}
