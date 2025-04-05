package me.beatrizcosta.domain.repository;

import me.beatrizcosta.domain.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    void deleteByUser_IdAndForumThread_Id(Long userId, Long threadId);

    void deleteByUser_IdAndComment_Id(Long userId, Long commentId);
}
