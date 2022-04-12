package com.example.controller;

import com.example.model.Book;
import com.example.model.BorrowingCard;
import com.example.service.IBookService;
import com.example.service.IBorrowingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBorrowingCardService iBorrowingCardService;

    @GetMapping("")
    public String showListBook(Model model){
        List<Book> books = iBookService.findAll();
        model.addAttribute("books", books);
        return "/Book/list";
    }

    @GetMapping("/return-book")
    public String returnBook(){
        return "/Book/return-book";
    }

    @PostMapping("/return-book")
    public String returnBook(@RequestParam Integer id){
        System.out.println(id);
        BorrowingCard borrowingCard = iBorrowingCardService.findById(id);

        if (borrowingCard != null) {
            Book book = iBookService.findById(borrowingCard.getBook().getId());
            iBookService.returnBook(book);

            iBorrowingCardService.delete(borrowingCard.getId());
            return "redirect:/book";
        } else {
            return "/not-find-borrowing-card-id";
        }

    }
}
