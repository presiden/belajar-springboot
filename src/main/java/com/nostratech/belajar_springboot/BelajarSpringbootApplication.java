package com.nostratech.belajar_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nostratech.belajar_springboot.config.AppConfig;
import com.nostratech.belajar_springboot.entity.Author;
import com.nostratech.belajar_springboot.entity.Book;
import com.nostratech.belajar_springboot.entity.EmailService;

@SpringBootApplication
public class BelajarSpringbootApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BelajarSpringbootApplication.class, args);
        
        Author author = (Author) context.getBean("author1");
        System.out.println("Author ID: " + author.getId());
        System.out.println("Author Name: " + author.getName());
        
        Book book = (Book) context.getBean("book1");
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Author Name: " + book.getAuthor().getName());

        // EmailService emailService = (EmailService) context.getBean(EmailService.class);
        // try {
        //     emailService.sendMail();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
	}

}
