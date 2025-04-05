package me.beatrizcosta.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "threads")
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    public Thread() {}

    public Thread(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public List<Comment> getComments() { return comments; }
    public List<Like> getLikes() { return likes; }

    public Long getAuthorId() {
        return author != null ? author.getId() : null;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setThread(this);
    }

    public void addLike(Like like) {
        likes.add(like);
        like.setThread(this);
    }
}
