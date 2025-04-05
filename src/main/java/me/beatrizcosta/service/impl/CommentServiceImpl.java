package me.beatrizcosta.service.impl;

import me.beatrizcosta.domain.model.Comment;
import me.beatrizcosta.domain.repository.CommentRepository;
import me.beatrizcosta.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment create(Comment commentToCreate) {
        return commentRepository.save(commentToCreate);
    }

    @Override
    public List<Comment> findAllByThreadId(Long threadId) {
        return commentRepository.findByThreadId(threadId);
    }

    @Override
    public Comment update(Long id, Comment commentToUpdate) {
        Comment commentFound = findById(id);
        if (commentFound == null) return null;

        commentFound.setContent(commentToUpdate.getContent());
        return commentRepository.save(commentFound);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
