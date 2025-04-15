package com.nostratech.belajar_springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nostratech.belajar_springboot.dto.AuthorDTO;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @GetMapping("new")
    public String displayAuthorForm(Model model) {
        // model.addAttribute("authorDTO", new AuthorDTO("", ""));
        return "author/author-new";
    }

    @PostMapping("new")
    public String submitForm(@ModelAttribute AuthorDTO authorDTO, RedirectAttributes redirectAttributes) {
        // model.addAttribute("authorDTO", authorDTO);

        System.out.println("Author Name: " + authorDTO.name());
        System.out.println("Author Description: " + authorDTO.description());
        redirectAttributes.addFlashAttribute("authorDTO", authorDTO);

        return "redirect:/authors/result";
    }

    @GetMapping("result")
    public String displayResult(@ModelAttribute("authorDTO") AuthorDTO authorDTO) {
        if (authorDTO != null) {
            System.out.println("displayResult Author Name: " + authorDTO.name());
        }
        return "author/author-result";
    }
}
