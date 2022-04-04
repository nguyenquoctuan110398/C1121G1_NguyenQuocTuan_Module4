package com.codegym.model;

import javax.persistence.*;

@Entity(name = "comment")
public class PictureComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment_vote")
    private String commentVote;

    @Column(name = "comment_author")
    private String commentAuthor;

    @Column(name = "comment_feedback")
    private String commentFeedback;

    @Column(name = "comment_like")
    private Integer commentLike;

    public PictureComment() {
    }

    public PictureComment(Integer id, String commentVote, String commentAuthor,
                          String commentFeedback, Integer commentLike) {
        this.id = id;
        this.commentVote = commentVote;
        this.commentAuthor = commentAuthor;
        this.commentFeedback = commentFeedback;
        this.commentLike = commentLike;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentVote() {
        return commentVote;
    }

    public void setCommentVote(String commentVote) {
        this.commentVote = commentVote;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentFeedback() {
        return commentFeedback;
    }

    public void setCommentFeedback(String commentFeedback) {
        this.commentFeedback = commentFeedback;
    }

    public Integer getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(Integer commentLike) {
        this.commentLike = commentLike;
    }
}
