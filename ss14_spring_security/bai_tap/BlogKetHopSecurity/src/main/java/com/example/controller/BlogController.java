package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/blog")
@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public List<Category> categories(){
        return iCategoryService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam("author") Optional<String> search,
                           @PageableDefault(value = 2) Pageable pageable,
                           Model model) {

        String searchAuthor = search.orElse("");

        Page<Blog> blogList = iBlogService.findAll(searchAuthor, pageable);
        model.addAttribute("blogs", blogList);
        model.addAttribute("searchAuthor", searchAuthor);

        return "/blog/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/delete";
    }

    @PostMapping("delete")
    public String delete(Blog blog) {
        iBlogService.delete(blog.getId());
        return "redirect:/blog";
    }

    @GetMapping(value = "/like")
    public String like(@RequestParam Integer id) {
        Blog blog = iBlogService.findById(id);
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/blog/view";
    }

    @GetMapping("/listByCategory/{id}")
    public String listByCategory(@PathVariable Integer id,
                                 @PageableDefault(value = 2) Pageable pageable,
                                 Model model){
        model.addAttribute("blogByCategory", iBlogService.findAllByCategory(id, pageable));
        model.addAttribute("id", id);

        return "/blog/listByCategory";
    }
}
