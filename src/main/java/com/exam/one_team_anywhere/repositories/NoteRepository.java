package com.exam.one_team_anywhere.repositories;

import java.util.List;

import com.exam.one_team_anywhere.entities.Note;
import com.exam.one_team_anywhere.requests.NoteRequest;

public interface NoteRepository {
    public int save(NoteRequest noteRequest);
    public List<Note> fetchAll();
    public Note findById(int id);
    public List<Note> deleteId(int id);
    public void updateNoteById(int id, NoteRequest noteRequest);
}
