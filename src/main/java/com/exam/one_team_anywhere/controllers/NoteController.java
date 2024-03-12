package com.exam.one_team_anywhere.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.one_team_anywhere.entities.Note;
import com.exam.one_team_anywhere.requests.NoteRequest;
import com.exam.one_team_anywhere.services.NoteService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/notes")
public class NoteController {
    
    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<String> createNewNotes(@RequestBody NoteRequest noteRequest) {
        if(Optional.ofNullable(noteRequest.getTitle()).isPresent()
        && Optional.ofNullable(noteRequest.getBody()).isPresent()){
            return ResponseEntity.ok().body("Succesfully created new entry for note. Id created is " + noteService.createNewNotes(noteRequest));
        } else {
            return ResponseEntity.badRequest().body("title and body is/are not null.");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Note>> retrieveAllNotes() {
        return ResponseEntity.ok().body(noteService.retrieveAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") int id){
        Note existingNote = noteService.findById(id);
        if(Optional.ofNullable(existingNote).isPresent()){
            return ResponseEntity.ok().body(existingNote);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteId(@PathVariable("id") int id){
        Note existingNote = noteService.findById(id);
        if(Optional.ofNullable(existingNote).isPresent()){
            noteService.deleteId(id);
            return ResponseEntity.ok().body("Successfully deleted id " + id);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateNoteById(@PathVariable("id") int id, @RequestBody NoteRequest noteRequest){
        Note existingNote = noteService.findById(id);
        if(Optional.ofNullable(existingNote).isPresent()){
            if(Optional.ofNullable(noteRequest.getTitle()).isPresent() 
        && Optional.ofNullable(noteRequest.getBody()).isPresent()){
                noteService.updateNoteById(id, noteRequest);
                return ResponseEntity.ok().body("Successfully updated id " + id);
            } else {
                return ResponseEntity.badRequest().body("title and body is/are not null.");
            }
        }
        return ResponseEntity.notFound().build();
    }
}
