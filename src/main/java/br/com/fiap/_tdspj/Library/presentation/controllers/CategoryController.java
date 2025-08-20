package br.com.fiap._tdspj.Library.presentation.controllers;

import br.com.fiap._tdspj.Library.domainmodel.Category;
import br.com.fiap._tdspj.Library.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    // injetar no service
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/listAll")
    public String fetchAll(Model model){
        // padrão null object --> não permito que as coisas não injetadas tenham a possibilidade de dar um null point
        List<Category> categories = Collections.EMPTY_LIST;
        categories.addAll(this.categoryService.findAll());
        model.addAttribute("categories", categories);

            // nome da tela
        return "list_categories";
    }
}
