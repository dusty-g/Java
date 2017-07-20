package com.dusty.lookify.services;

import com.dusty.lookify.models.Song;
import com.dusty.lookify.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dusty on 7/20/17.
 */
@Service
public class SongService {
    SongRepository songRepo;
    SongService(SongRepository songRepo){
        this.songRepo = songRepo;
    }
    //get all songs
    public Iterable<Song> getAllSongs(){
        return songRepo.findAll();
    }
    //create new song
    public void createSong(Song song){
        songRepo.save(song);
    }
    //update (does the same thing as create?)
    public void updateSong(Song song){
        songRepo.save(song);
    }
    //get one song
    public Song getSong(Long id){
       return songRepo.findOne(id);
    }
    //delete
    public void deleteSong(Long id){
        songRepo.delete(id);
    }
    public Iterable<Song> searchSongs(String search){
        return songRepo.findBySongNameContaining(search);
    }
    public Iterable<Song> topSongs(){

        return songRepo.findTop10ByOrderByRatingDesc();
    }

}
