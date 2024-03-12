package com.exam.one_team_anywhere.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.exam.one_team_anywhere.entities.Note;
import com.exam.one_team_anywhere.repositories.NoteRepository;
import com.exam.one_team_anywhere.requests.NoteRequest;

//Assuming this is db repository
@Component
public class NoteRepositoryImpl implements NoteRepository{
    
    // Use this arrayList to contain the list of note
    private List<Note> noteList = new ArrayList<Note>();
    private int id;
    public int save(NoteRequest noteRequest){
        id++;
        noteList.add(Note.builder()
        .id(id)
        .title(noteRequest.getTitle())
        .Body(noteRequest.getBody())
        .build());
        return id;
    }

    public List<Note> fetchAll(){
        return noteList;
    }

    public Note findById(int id){
        return noteList.stream().filter(note -> note.getId() == id).collect(Collectors.toList()).get(0);
    }

    public List<Note> deleteId(int id){
        noteList.removeIf(n ->{return n.getId() == id;});
        return noteList;
    }

    public void updateNoteById(int id, NoteRequest noteRequest){
        noteList.stream()
        .map(n -> {
            if(n.getId() == id){
                n.setTitle(noteRequest.getTitle());
                n.setBody(noteRequest.getBody());
            }
                return n;
        })
        .collect(Collectors.toList());
    }
}
