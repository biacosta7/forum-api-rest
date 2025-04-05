package me.beatrizcosta.service.impl;

import me.beatrizcosta.domain.model.ForumThread;
import me.beatrizcosta.domain.repository.ThreadRepository;
import me.beatrizcosta.service.ThreadService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService {

    private final ThreadRepository threadRepository;

    public ThreadServiceImpl(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    @Override
    public ForumThread findById(Long id) {
        return threadRepository.findById(id).orElse(null);
    }

    @Override
    public ForumThread create(ForumThread threadToCreate) {
        return threadRepository.save(threadToCreate);
    }

    @Override
    public List<ForumThread> findAll() {
        return threadRepository.findAll();
    }

    @Override
    public ForumThread update(Long id, ForumThread threadToUpdate) {
        ForumThread threadFound = findById(id);
        if (threadFound == null) return null;

        threadFound.setTitle(threadToUpdate.getTitle());
        threadFound.setContent(threadToUpdate.getContent());

        return threadRepository.save(threadFound);
    }

    @Override
    public void delete(Long id) {
        threadRepository.deleteById(id);
    }
}