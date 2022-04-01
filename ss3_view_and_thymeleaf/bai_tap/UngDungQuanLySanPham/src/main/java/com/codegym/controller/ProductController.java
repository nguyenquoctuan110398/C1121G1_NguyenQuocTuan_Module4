package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public String showList(Model model) {

        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success", "Create product success!");
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Product product = iProductService.findByID(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Update product success");
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        Product product = iProductService.findByID(id);

        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        iProductService.delete(product.getId());
        redirectAttributes.addFlashAttribute("success", "Delete product success");
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findByID(id));
        return "/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String name, Model model){
        List<Product> products = iProductService.searchByName(name);
        model.addAttribute("products", products);
        return "/list";
    }
}
