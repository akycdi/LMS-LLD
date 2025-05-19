package com.lms.service.impl;

import com.lms.model.Patron;
import com.lms.service.PatronService;

import java.util.*;
import java.util.logging.Logger;

public class PatronServiceImpl implements PatronService {
    private static final Logger logger = Logger.getLogger(PatronServiceImpl.class.getName());
    private final Map<String, Patron> patrons = new HashMap<>();
    
    @Override
    public void registerPatron(Patron patron) {
        if (patron == null)
            throw new IllegalArgumentException("Patron cannot be null");
        if (patrons.containsKey(patron.getId()))
            throw new IllegalArgumentException("Patron already exists with ID: " + patron.getId());
        patrons.put(patron.getId(), patron);
        logger.info("Patron registered: " + patron);
    }
    
    @Override
    public Patron findPatronById(String id) {
        Patron patron = patrons.get(id);
        if (patron == null)
            throw new NoSuchElementException("No patron found with ID: " + id);
        return patron;
    }
    
    @Override
    public void updatePatronName(String id, String newName) {
        Patron patron = findPatronById(id);
        patron.setName(newName);
        logger.info("Patron updated: id=" + id + ", newName=" + newName);
    }
    
    @Override
    public void removePatron(String id) {
        if (!patrons.containsKey(id))
            throw new NoSuchElementException("No patron found with ID: " + id);
        Patron removed = patrons.remove(id);
        logger.info("Patron removed: " + removed);
    }
    
    @Override
    public List<Patron> getAllPatrons() {
        return new ArrayList<>(patrons.values());
    }
    
    @Override
    public String getBorrowingHistory(String id) {
        Patron patron = findPatronById(id);
        StringBuilder sb = new StringBuilder();
        patron.getHistory().forEach(record -> sb.append(record).append("\n"));
        return sb.toString();
    }
}