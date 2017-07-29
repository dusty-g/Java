package com.dusty.javabeltexam.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "guilds")
public class Guild {
    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, max = 29)
    private String name;

    @Min(1)
    @Max(10)
    private Integer guildSize;

    public Long getId() {
        return id;
    }
    public Guild(){}
    public Guild(String name, Integer size){
        this.name = name;
        this.guildSize = size;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGuildSize() {
        return guildSize;
    }

    public void setGuildSize(Integer guildSize) {
        this.guildSize = guildSize;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_guilds",
            joinColumns = @JoinColumn(name = "guild_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;


    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
