package com.andrei.expense_tracker.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Data
public class DayRegister {

    private LocalDateTime date;
    private DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("yyyy-MM-dd : HH:mm");
    private DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Map<Entry, Integer> entryMap = new HashMap<>();

    public DayRegister() {
        date = LocalDateTime.now();
    }

    public void printDay() {
        System.out.println("DATE: " + date.format(formatterTime));
        System.out.println("");
        for (Map.Entry element : entryMap.entrySet()) {
            System.out.println(element.getKey() + " , Counter: " + element.getValue());
        }
    }
}
