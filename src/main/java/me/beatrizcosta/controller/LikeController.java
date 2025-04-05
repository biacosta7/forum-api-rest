package me.beatrizcosta.controller;

import me.beatrizcosta.domain.model.Like;
import me.beatrizcosta.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/thread")
    public ResponseEntity<Like> likeThread(@RequestParam Long userId, @RequestParam Long threadId) {
        var like = likeService.likeThread(userId, threadId);
        return ResponseEntity.ok(like);
    }

    @PostMapping("/comment")
    public ResponseEntity<Like> likeComment(@RequestParam Long userId, @RequestParam Long commentId) {
        var like = likeService.likeComment(userId, commentId);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/thread")
    public ResponseEntity<Void> unlikeThread(@RequestParam Long userId, @RequestParam Long threadId) {
        likeService.unlikeThread(userId, threadId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/comment")
    public ResponseEntity<Void> unlikeComment(@RequestParam Long userId, @RequestParam Long commentId) {
        likeService.unlikeComment(userId, commentId);
        return ResponseEntity.noContent().build();
    }
}
