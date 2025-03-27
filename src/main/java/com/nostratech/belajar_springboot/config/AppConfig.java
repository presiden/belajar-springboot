package com.nostratech.belajar_springboot.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.entity.Book;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

@Configuration
public class AppConfig {
    @Bean
    public Author author1() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Author 1");
        return author;
    }

    @Bean
    public Book book1(@Qualifier("author1") Author author) {
        Book book = new Book();
        book.setTitle("Book 1");
        book.setAuthor(author);
        return book;
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("224cd838c5d6d2", "aff57fef7b08b0");
    }

    @Bean
    public Properties properties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "587");
        return prop;
    }

    @Bean
    public Session mailSession(@Qualifier("properties") Properties properties,
            PasswordAuthentication passwordAuthentication) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return passwordAuthentication;
            }
        });
    }
}
