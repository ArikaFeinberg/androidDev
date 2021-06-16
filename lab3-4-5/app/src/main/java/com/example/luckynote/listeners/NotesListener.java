package com.example.luckynote.listeners;

import com.example.luckynote.entities.Note;

public interface NotesListener {
    void onNoteClicked(Note note, int position);
}
