package com.dusty.lookify.controllers;

import com.dusty.lookify.models.Song;
import com.dusty.lookify.services.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by dusty on 7/19/17.
 */
@Controller
public class Songs {
    private final SongService songService;
    public Songs(SongService songService){
        this.songService = songService;
    }
    @RequestMapping("/dashboard")
    public String dashboard(Model model){
        //logic to get songs
        Iterable<Song> songs = songService.getAllSongs();
        model.addAttribute("songs", songs);
        return "/WEB-INF/views/dashboard.jsp";
    }
    @RequestMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id){
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
    @PostMapping("/search")
    public String searchSong(@RequestParam("search") String search, Model model){
        Iterable<Song> songs = songService.searchSongs(search);
        model.addAttribute("songs", songs);
        System.out.println(songs);
        return "/WEB-INF/views/searchSong.jsp";
    }
    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song){

        return "/WEB-INF/views/newSong.jsp";
    }
    @PostMapping("/songs/new")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result){
        if(result.hasErrors()){
            return "/WEB-INF/views/newSong.jsp";
        }else{
            //add song to db
            songService.createSong(song);
            return "redirect:/dashboard";
        }
    }
    @RequestMapping("/songs/top")
    public String topSongs(Model model){
        model.addAttribute("songs", songService.topSongs());
        return "/WEB-INF/views/topten.jsp";
    }
    @RequestMapping("/songs/{id}")
    public String getOneSong(@PathVariable("id") Long id, Model model){
        Song song = songService.getSong(id);
        model.addAttribute("song", song);
        return "/WEB-INF/views/song.jsp";

    }
}
