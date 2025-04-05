package me.beatrizcosta.controller;

import me.beatrizcosta.domain.model.Comment;
import me.beatrizcosta.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Long id) {
        var comment = commentService.findById(id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/thread/{threadId}")
    public ResponseEntity<List<Comment>> findAllByThread(@PathVariable Long threadId) {
        return ResponseEntity.ok(commentService.findAllByThreadId(threadId));
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment commentToCreate) {
        var created = commentService.create(commentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@PathVariable Long id, @RequestBody Comment commentToUpdate) {
        var updated = commentService.update(id, commentToUpdate);
        return updated == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
