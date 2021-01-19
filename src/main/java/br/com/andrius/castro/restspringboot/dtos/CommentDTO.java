package br.com.andrius.castro.restspringboot.dtos;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {
    private String content;
    private Instant date;

    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(String content, Instant date, AuthorDTO author) {
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
