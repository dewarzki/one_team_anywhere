package com.exam.one_team_anywhere.services;

import java.util.List;

import com.exam.one_team_anywhere.entities.Note;
import com.exam.one_team_anywhere.requests.NoteRequest;

public interface NoteService {
    public int createNewNotes(NoteRequest noteRequest);
    public List<Note> retrieveAll();
    public Note findById(int id);
    public void deleteId(int id);
    public void updateNoteById(int id, NoteRequest noteRequest);
}
