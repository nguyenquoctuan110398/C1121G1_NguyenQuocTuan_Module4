package com.codegym.repository.impl;

import com.codegym.model.PictureComment;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.IPictureCommentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PictureCommentRepository implements IPictureCommentRepository {

    @Override
    public List<PictureComment> findAll() {
        TypedQuery<PictureComment> commentTypedQuery =
                BaseRepository.entityManager.createQuery("select p from comment p", PictureComment.class);

        return commentTypedQuery.getResultList();
    }

    @Override
    public void save(PictureComment pictureComment) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        if (pictureComment.getId() == null) {
            BaseRepository.entityManager.persist(pictureComment);
        }
        entityTransaction.commit();
    }

    @Override
    public PictureComment findById(Integer id) {
        return BaseRepository.entityManager.find(PictureComment.class, id);
    }

    @Override
    public void like(PictureComment pictureComment) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();

        pictureComment.setCommentLike(pictureComment.getCommentLike() + 1);
        BaseRepository.entityManager.merge(pictureComment);
        entityTransaction.commit();
    }
}
