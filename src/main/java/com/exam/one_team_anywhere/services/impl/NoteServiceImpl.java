package com.exam.one_team_anywhere.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.one_team_anywhere.entities.Note;
import com.exam.one_team_anywhere.repositories.NoteRepository;
import com.exam.one_team_anywhere.requests.NoteRequest;
import com.exam.one_team_anywhere.services.NoteService;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public int createNewNotes(NoteRequest noteRequest) {
        return noteRepository.save(noteRequest);
    }
    
    @Override
    public void deleteId(int id){
        noteRepository.deleteId(id);
    }

    @Override
    public List<Note> retrieveAll() {
        return noteRepository.fetchAll();
    }

    @Override
    public Note findById(int id) {
        return noteRepository.findById(id);
    }

    @Override
    public void updateNoteById(int id, NoteRequest noteRequest) {
        noteRepository.updateNoteById(id, noteRequest);
    } 

    
}
