package com.dusty.javabeltexam.services;

import com.dusty.javabeltexam.models.Guild;
import com.dusty.javabeltexam.repositories.GuildRepository;
import org.springframework.stereotype.Service;

@Service
public class GuildService {
    GuildRepository guildRepository;
    public GuildService(GuildRepository guildRepository){
        this.guildRepository = guildRepository;
    }
    public Iterable<Guild> getAll(){
        return guildRepository.findAll();
    }
    public void createGuild(String name, Integer size){
        Guild newGuild = new Guild(name, size);
        guildRepository.save(newGuild);
    }
    public Guild getById(Long id){
        return guildRepository.findOne(id);
    }
    public void saveGuild(Guild guild){
        guildRepository.save(guild);
    }
}
