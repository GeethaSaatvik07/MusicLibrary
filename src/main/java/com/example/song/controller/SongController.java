package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.song.model.Song;
import com.example.song.service.SongJpaService;

@RestController
public class SongController{

    @Autowired
    public SongJpaService songService;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getById(@PathVariable("songId") int id){
        return songService.getById(id);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songService.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable("songId") int songId, @RequestBody Song song){
        return songService.updateSong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSong(@PathVariable("songId") int songId){
        songService.deleteSong(songId);
    }
}

// Write your code here

// https://github.com/GeethaSaatvik07/MusicLibrary.git

// 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