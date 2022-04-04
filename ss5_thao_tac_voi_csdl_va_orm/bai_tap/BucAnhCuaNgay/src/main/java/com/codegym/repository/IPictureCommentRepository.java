package com.codegym.repository;

import com.codegym.model.PictureComment;

import java.util.List;

public interface IPictureCommentRepository {
    List<PictureComment> findAll();

    void save(PictureComment pictureComment);

    PictureComment findById(Integer id);

    void like(PictureComment pictureComment);
}
