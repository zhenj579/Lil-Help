package com.example.lilhelp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Journal {

    private String journalName;
    private HashMap<LocalDate, JournalEntries> entries;

    public Journal(String Name) {
        this.journalName = Name;
        this.entries = new HashMap<LocalDate, JournalEntries>();
    }

    public void addEntry(LocalDate day, JournalEntries entry) {
        entries.put(day, entry);
    }

    public JournalEntries getEntry(LocalDateTime day) {
        return entries.get(day);
    }

}
