package me.beatrizcosta.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "thread_id", nullable = false)
    private ForumThread forumThread;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    public Comment() {}

    public Comment(String content, User author, ForumThread forumThread) {
        this.content = content;
        this.author = author;
        this.forumThread = forumThread;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public ForumThread getThread() { return forumThread; }
    public void setThread(ForumThread forumThread) { this.forumThread = forumThread; }

    public List<Like> getLikes() { return likes; }

    public Long getAuthorId() {
        if (author != null) {
            return author.getId();
        } else {
            return null;
        }
    }

    public Long getThreadId() {
        if (forumThread != null) {
            return forumThread.getId();
        } else {
            return null;
        }
    }

}
