package me.beatrizcosta.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private ForumThread forumThread;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Like() {}

    public Like(User user, ForumThread forumThread) {
        this.user = user;
        this.forumThread = forumThread;
    }

    public Like(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public ForumThread getThread() { return forumThread; }
    public void setThread(ForumThread forumThread) { this.forumThread = forumThread; }

    public Comment getComment() { return comment; }
    public void setComment(Comment comment) { this.comment = comment; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
