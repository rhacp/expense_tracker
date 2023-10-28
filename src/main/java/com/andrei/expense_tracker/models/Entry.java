package com.andrei.expense_tracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Entry {

    private String name;
    private LocalDateTime date;
    private double value;
    private Category category;

    public Entry(String name, double value, Category category) {
        this.name = name;
        this.value = value;
        date = LocalDateTime.now();
        this.category = category;
    }

    @Override
    public String toString() {
        return name + ", " + value + "$, " + category;
    }
}
