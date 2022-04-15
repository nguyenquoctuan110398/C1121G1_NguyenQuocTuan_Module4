package com.example.controller;

import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/category")
@Controller
public class CategoryRestController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<Page<Category>> showCategoryList(@PageableDefault(value = 2) Pageable pageable){
        Page<Category> categories = iCategoryService.findAllPage(pageable);

        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
