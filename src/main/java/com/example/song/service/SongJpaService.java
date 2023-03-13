package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.repository.SongRepository;
import com.example.song.model.Song;
import com.example.song.repository.SongJpaRepository;

@Service
public class SongJpaService implements SongRepository{

    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override
    public ArrayList<Song> getAllSongs(){
        List<Song> allSongs = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(allSongs);
        return songs;
    }

    @Override
    public Song getById(int id){
        try{
            Song song = songJpaRepository.findById(id).get();
            return song;
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song){
        songJpaRepository.save(song);
        return song;
    }

    public Song updateSong(int songId, Song song){
        try{
            Song newSong = songJpaRepository.findById(songId).get();
            if (song.getSongName() != null){
                newSong.setSongName(song.getSongName());
            }
            if (song.getLyricist() != null){
                newSong.setLyricist(song.getLyricist());
            }
            if(song.getSinger() != null){
                newSong.setSinger(song.getSinger());
            }
            if(song.getMusicDirector() != null){
                newSong.setMusicDirector(song.getMusicDirector());
            }
            songJpaRepository.save(newSong);
            return newSong;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteSong(int songId){
        try{
            songJpaRepository.deleteById(songId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

// Write your code here

// https://github.com/GeethaSaatvik07/MusicLibrary.git