package com.nostratech.belajar_springboot.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nostratech.belajar_springboot.dto.AuthorDTO;
import com.nostratech.belajar_springboot.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    @GetMapping("new")
    public String displayAuthorForm(Model model) {
        // model.addAttribute("authorDTO", new AuthorDTO("", ""));
        return "author/author-new";
    }

    @PostMapping("new")
    public String submitForm(@ModelAttribute AuthorDTO authorDTO, RedirectAttributes redirectAttributes) {
        authorService.createAuthor(authorDTO);
        redirectAttributes.addFlashAttribute("authorDTO", authorDTO);

        return "redirect:/authors/list";
    }

    @GetMapping("/{id}")
    public String displayAuthorById(@PathVariable Long id, Model model) {
        AuthorDTO authorDTO = authorService.getAuthorById(id);
        model.addAttribute("authorDTO", authorDTO);
        
        return "author/author-detail";
    }

    @GetMapping("result")
    public String displayResult(@ModelAttribute("authorDTO") AuthorDTO authorDTO) {
        return "author/author-result";
    }

    @GetMapping("list")
    public String displayList(Model model) {
        List<AuthorDTO> authorDTOs = authorService.getAllAuthors();
        model.addAttribute("authorDTOs", authorDTOs);
        return "author/author-list";
    }
}
