package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showListUser(@PageableDefault(value = 2) Pageable pageable, Model model){
        Page<User> users = iUserService.findAll(pageable);

        model.addAttribute("users", users);

        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model){

        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute UserDto userDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,
                         User user){

        userDto.validate(userDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }

        BeanUtils.copyProperties(userDto, user);

        redirectAttributes.addFlashAttribute("message", "Create User Success");
        iUserService.save(user);
        return "redirect:/user";
    }

}
