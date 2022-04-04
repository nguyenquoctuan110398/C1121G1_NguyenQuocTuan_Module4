package com.codegym.service.impl;

import com.codegym.model.PictureComment;
import com.codegym.repository.IPictureCommentRepository;
import com.codegym.service.IPictureCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureCommentCommentService implements IPictureCommentService {

    @Autowired
    IPictureCommentRepository iPictureCommentRepository;

    @Override
    public List<PictureComment> findAll() {
        return iPictureCommentRepository.findAll();
    }

    @Override
    public void save(PictureComment pictureComment) {
        iPictureCommentRepository.save(pictureComment);
    }

    @Override
    public PictureComment findById(Integer id) {
        return iPictureCommentRepository.findById(id);
    }

    @Override
    public void like(PictureComment pictureComment) {
        iPictureCommentRepository.like(pictureComment);
    }
}
