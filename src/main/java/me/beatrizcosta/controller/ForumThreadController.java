package me.beatrizcosta.controller;

import me.beatrizcosta.domain.model.ForumThread;
import me.beatrizcosta.service.ForumThreadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/threads")
public class ForumThreadController {

    private final ForumThreadService threadService;

    public ForumThreadController(ForumThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumThread> findById(@PathVariable Long id) {
        var thread = threadService.findById(id);
        return ResponseEntity.ok(thread);
    }

    @GetMapping
    public ResponseEntity<List<ForumThread>> findAll() {
        return ResponseEntity.ok(threadService.findAll());
    }

    @PostMapping
    public ResponseEntity<ForumThread> create(@RequestBody ForumThread threadToCreate) {
        var createdThread = threadService.create(threadToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdThread.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdThread);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForumThread> update(@PathVariable Long id, @RequestBody ForumThread threadToUpdate) {
        var updated = threadService.update(id, threadToUpdate);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        threadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
