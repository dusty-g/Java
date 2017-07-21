package com.dusty.dojoninjas.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by dusty on 7/20/17.
 */
@Entity
@Table(name = "dojos")
public class Dojo {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(min = 2, max = 25)
    private String dojoName;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }

    @OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

    public Dojo(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDojoName() {
        return dojoName;
    }

    public void setDojoName(String dojoName) {
        this.dojoName = dojoName;
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

    public Dojo(String dojoName){
        this.dojoName = dojoName;

    }

}
