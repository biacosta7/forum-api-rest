package me.beatrizcosta.service;

import me.beatrizcosta.domain.model.Comment;

import java.util.List;

public interface CommentService {
    Comment findById(Long id);

    Comment create(Comment commentToCreate);

    List<Comment> findAllByThreadId(Long threadId);

    Comment update(Long id, Comment commentToUpdate);

    void delete(Long id);
}
