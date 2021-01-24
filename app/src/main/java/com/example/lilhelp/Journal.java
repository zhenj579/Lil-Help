package com.example.lilhelp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Journal {

    private String journalName;
    private HashMap<LocalDate, JournalEntry> entries;

    public Journal(String Name) {
        this.journalName = Name;
        this.entries = new HashMap<LocalDate, JournalEntry>();
    }

    public void addEntry(LocalDate day, JournalEntry entry) {
        entries.put(day, entry);
    }

    public JournalEntry getEntry(LocalDateTime day) {
        return entries.get(day);
    }

}
