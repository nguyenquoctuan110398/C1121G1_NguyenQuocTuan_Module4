package com.example.controller;

import com.example.dto.BookDto;
import com.example.dto.BorrowingCardDto;
import com.example.model.Book;
import com.example.model.BorrowingCard;
import com.example.service.IBookService;
import com.example.service.IBorrowingCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/borrowing-card")
@Controller
public class BorrowingCardController {

    @Autowired
    private IBorrowingCardService iBorrowingCardService;

    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String showListBorrowingCard(Model model){
        model.addAttribute("borrowingCards", iBorrowingCardService.findAll());
        return "/BorrowingCard/list";
    }

    @GetMapping("/borrow/{id}")
    public String createBorrowingCard(Model model, @PathVariable String id) {

        BorrowingCard borrowingCard = new BorrowingCard();
        BorrowingCardDto borrowingCardDto = new BorrowingCardDto();

        Integer borrowId = (int) (Math.random() * 100000);
        borrowingCard.setId(borrowId);
        BeanUtils.copyProperties(borrowingCard, borrowingCardDto);

        Book book = iBookService.findById(id);
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);

        borrowingCardDto.setBookDto(bookDto);

        model.addAttribute("borrowingCardDto", borrowingCardDto);
        return "/BorrowingCard/borrow";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute BorrowingCardDto borrowingCardDto,
                       BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()){
            return "/BorrowingCard/borrow";
        }

        BorrowingCard borrowingCard = new BorrowingCard();
        BeanUtils.copyProperties(borrowingCardDto, borrowingCard);

        if (borrowingCard.getBook().getQuantity()<=0){
            return "/error";
        } else {
            Book book = new Book();

            book.setId(borrowingCardDto.getBookDto().getId());
            book.setName(borrowingCardDto.getBookDto().getName());

            borrowingCard.setBook(book);
            iBookService.reduceQuatityBook(iBookService.findById(borrowingCard.getBook().getId()));
            iBorrowingCardService.save(borrowingCard);
            return "redirect:/borrowing-card";
        }
    }
}
