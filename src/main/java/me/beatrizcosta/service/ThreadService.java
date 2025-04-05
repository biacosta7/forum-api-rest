package me.beatrizcosta.service;
import me.beatrizcosta.domain.model.ForumThread;

import java.util.List;

public interface ThreadService {
    ForumThread findById(Long id);

    ForumThread create(ForumThread forumThreadToCreate);

    List<ForumThread> findAll();

    ForumThread update(Long id, ForumThread forumThreadToUpdate);

    void delete(Long id);
}
