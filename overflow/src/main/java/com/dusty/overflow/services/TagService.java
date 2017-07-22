package com.dusty.overflow.services;

import com.dusty.overflow.models.Tag;
import com.dusty.overflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

/**
 * Created by dusty on 7/21/17.
 */
@Service
public class TagService {
    TagRepository tagRepo;
    public TagService(TagRepository tagRepo){
        this.tagRepo = tagRepo;
    }
    public Iterable<Tag> getAll(){
        return tagRepo.findAll();
    }
    public Tag getById(Long id){
        return tagRepo.findOne(id);
    }
    public void saveTag(Tag tag){
        tagRepo.save(tag);
    }
    public Tag findBySubject(String subject){
        return tagRepo.findBySubjectEquals(subject);
    }
}
