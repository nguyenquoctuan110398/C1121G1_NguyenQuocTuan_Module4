package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/blogRest")
@RestController
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public List<Category> categories(){
        return iCategoryService.findAll();
    }

    @GetMapping("")
    public ResponseEntity<Page<Blog>> showListBlogRest
            (@RequestParam("author") Optional<String> search,
             @PageableDefault(value = 2) Pageable pageable) {

        String searchAuthor = search.orElse("");

        Page<Blog> blogList = iBlogService.findAll(searchAuthor, pageable);

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> goDetailBlog(@PathVariable Integer id){
        Blog blog = iBlogService.findById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("blog", new Blog());
//        return "/create";
//    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody BlogDto blogDto) {

        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);

        Category category = new Category();
        category.setId(blogDto.getCategoryDto().getId());
        category.setName(blogDto.getCategoryDto().getName());

        blog.setCategory(category);

        iBlogService.save(blog);

        return new ResponseEntity<>(HttpStatus.OK);
    }



//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model) {
//        model.addAttribute("blog", iBlogService.findById(id));
//        return "/edit";
//    }
//
//    @PostMapping("/update")
//    public String update(Blog blog) {
//        iBlogService.save(blog);
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id, Model model) {
//        model.addAttribute("blog", iBlogService.findById(id));
//        return "/delete";
//    }
//
//    @PostMapping("delete")
//    public String delete(Blog blog) {
//        iBlogService.delete(blog.getId());
//        return "redirect:/blog";
//    }
//
//    @GetMapping(value = "/like")
//    public String like(@RequestParam Integer id) {
//        Blog blog = iBlogService.findById(id);
//        iBlogService.save(blog);
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/view/{id}")
//    public String view(@PathVariable Integer id, Model model) {
//        model.addAttribute("blog", iBlogService.findById(id));
//        return "/view";
//    }
//
    @GetMapping("/listByCategory/{id}")
    public ResponseEntity<Page<Blog>> listByCategory(@PathVariable Integer id,
                                 @PageableDefault(value = 2) Pageable pageable){

        Page<Blog> blogs = iBlogService.findAllByCategory(id, pageable);

        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
