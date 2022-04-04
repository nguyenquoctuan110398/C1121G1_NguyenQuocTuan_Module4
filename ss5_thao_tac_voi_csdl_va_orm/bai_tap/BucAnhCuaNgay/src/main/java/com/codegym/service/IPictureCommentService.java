package com.codegym.service;

import com.codegym.model.PictureComment;

import java.util.List;

public interface IPictureCommentService {
    List<PictureComment> findAll();

    void save(PictureComment pictureComment);

    PictureComment findById(Integer id);

    void like(PictureComment pictureComment);
}
