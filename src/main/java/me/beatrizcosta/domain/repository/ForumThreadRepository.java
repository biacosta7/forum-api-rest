package me.beatrizcosta.domain.repository;

import me.beatrizcosta.domain.model.ForumThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumThreadRepository extends JpaRepository<ForumThread, Long> {
    List<ForumThread> findByAuthor_Id(Long authorId);
}
