package com.andrei.expense_tracker.services;

import com.andrei.expense_tracker.models.Category;
import com.andrei.expense_tracker.models.Entry;

import java.time.LocalDateTime;

public class EntryServiceImpl {

    public Entry createEntry(String name, double value, Category category){
        return new Entry(name, value, category);
    }
}
