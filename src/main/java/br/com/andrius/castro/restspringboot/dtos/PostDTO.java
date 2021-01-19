package br.com.andrius.castro.restspringboot.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PostDTO implements Serializable {
    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Instant date;

    private String title;
    private String content;

    private AuthorDTO author;
    private List<CommentDTO> comments = new ArrayList<>();

    public PostDTO() {
    }

    public PostDTO(String id, Instant date, String title, String content, AuthorDTO author, List<CommentDTO> comments) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments.addAll(comments);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }
}
