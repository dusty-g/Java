package com.dusty.overflow.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by dusty on 7/21/17.
 */
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 1, max = 15)
    @Column
    private String subject;
    @UpdateTimestamp
    private Date updatedAt;
    @CreationTimestamp
    private Date createdAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "questions_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
    public Tag(){}
    public Tag(String subject){
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
