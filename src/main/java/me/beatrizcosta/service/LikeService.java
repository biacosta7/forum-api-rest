package me.beatrizcosta.service;

import me.beatrizcosta.domain.model.Like;

public interface LikeService {
    Like likeThread(Long userId, Long threadId);

    Like likeComment(Long userId, Long commentId);

    void unlikeThread(Long userId, Long threadId);

    void unlikeComment(Long userId, Long commentId);
}
