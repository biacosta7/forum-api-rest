package me.beatrizcosta.service.impl;

import me.beatrizcosta.domain.model.Comment;
import me.beatrizcosta.domain.model.ForumThread;
import me.beatrizcosta.domain.model.Like;
import me.beatrizcosta.domain.model.User;
import me.beatrizcosta.domain.repository.CommentRepository;
import me.beatrizcosta.domain.repository.LikeRepository;
import me.beatrizcosta.domain.repository.ThreadRepository;
import me.beatrizcosta.domain.repository.UserRepository;
import me.beatrizcosta.service.LikeService;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;
    private final CommentRepository commentRepository;

    public LikeServiceImpl(
            LikeRepository likeRepository,
            UserRepository userRepository,
            ThreadRepository threadRepository,
            CommentRepository commentRepository
    ) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.threadRepository = threadRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Like likeThread(Long userId, Long threadId) {
        User user = userRepository.findById(userId).orElseThrow();
        ForumThread thread = threadRepository.findById(threadId).orElseThrow();
        Like like = new Like(user, thread);
        return likeRepository.save(like);
    }

    @Override
    public Like likeComment(Long userId, Long commentId) {
        User user = userRepository.findById(userId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        Like like = new Like(user, comment);
        return likeRepository.save(like);
    }

    @Override
    public void unlikeThread(Long userId, Long threadId) {
        likeRepository.deleteByUserIdAndThreadId(userId, threadId);
    }

    @Override
    public void unlikeComment(Long userId, Long commentId) {
        likeRepository.deleteByUserIdAndCommentId(userId, commentId);
    }
}
