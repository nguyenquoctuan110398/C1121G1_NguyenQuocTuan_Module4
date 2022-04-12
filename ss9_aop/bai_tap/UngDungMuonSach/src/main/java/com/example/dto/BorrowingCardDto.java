package com.example.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BorrowingCardDto {

    private Integer id;

//    @Pattern(regexp = "^(?:(?:31(\\\\/|-|\\\\.)(?:0?[13578]|1[02]))\\\\1|(?:(?:29|30)(\\\\/|-|\\\\.)(?:0?[13-9]|1[0-2])\\\\2))(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$|^(?:29(\\\\/|-|\\\\.)0?2\\\\3(?:(?:(?:1[6-9]|[2-9]\\\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\\\d|2[0-8])(\\\\/|-|\\\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\\\4(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$")
    @NotEmpty
    private String startDay;

//    @Pattern(regexp = "^(?:(?:31(\\\\/|-|\\\\.)(?:0?[13578]|1[02]))\\\\1|(?:(?:29|30)(\\\\/|-|\\\\.)(?:0?[13-9]|1[0-2])\\\\2))(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$|^(?:29(\\\\/|-|\\\\.)0?2\\\\3(?:(?:(?:1[6-9]|[2-9]\\\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\\\d|2[0-8])(\\\\/|-|\\\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\\\4(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$")
    @NotEmpty
    private String endDay;

    private BookDto bookDto;

    public BorrowingCardDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}
