package me.beatrizcosta.service.impl;

import me.beatrizcosta.domain.model.ForumThread;
import me.beatrizcosta.domain.repository.ForumThreadRepository;
import me.beatrizcosta.service.ForumThreadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumThreadServiceImpl implements ForumThreadService {

    private final ForumThreadRepository forumThreadRepository;

    public ForumThreadServiceImpl(ForumThreadRepository forumThreadRepository) {
        this.forumThreadRepository = forumThreadRepository;
    }

    @Override
    public ForumThread findById(Long id) {
        return forumThreadRepository.findById(id).orElse(null);
    }

    @Override
    public ForumThread create(ForumThread threadToCreate) {
        return forumThreadRepository.save(threadToCreate);
    }

    @Override
    public List<ForumThread> findAll() {
        return forumThreadRepository.findAll();
    }

    @Override
    public ForumThread update(Long id, ForumThread threadToUpdate) {
        ForumThread threadFound = findById(id);
        if (threadFound == null) return null;

        threadFound.setTitle(threadToUpdate.getTitle());
        threadFound.setContent(threadToUpdate.getContent());

        return forumThreadRepository.save(threadFound);
    }

    @Override
    public void delete(Long id) {
        forumThreadRepository.deleteById(id);
    }
}