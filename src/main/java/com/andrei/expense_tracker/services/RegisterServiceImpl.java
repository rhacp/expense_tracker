package com.andrei.expense_tracker.services;

import com.andrei.expense_tracker.models.DayRegister;
import com.andrei.expense_tracker.models.Entry;
import com.andrei.expense_tracker.models.Register;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterServiceImpl {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");

    public Register createRegistry() {
        Register register = new Register();
        return register;
    }

//    public DayRegister createDay() {
//        return new DayRegister();
//    }

    public void addDay(DayRegister dayRegister, Register register) {
        register.getDayRegisterList().add(dayRegister);
    }

    public void addEntry(Entry entry, Register register) {
        LocalDateTime test = LocalDateTime.now();
        if (register.getDayRegisterList().isEmpty()) {
            DayRegister dayRegister = new DayRegister();
            dayRegister.getEntryMap().put(entry, dayRegister.getEntryMap().getOrDefault(entry, 0) + 1);
            register.getDayRegisterList().add(dayRegister);
        } else {
            if (Integer.valueOf(entry.getDate().format(formatter)) > Integer.valueOf(register.getDayRegisterList().get(register.getDayRegisterList().size() - 1).getDate().format(formatter))) {
                DayRegister dayRegister = new DayRegister();
                dayRegister.getEntryMap().put(entry, dayRegister.getEntryMap().getOrDefault(entry, 0) + 1);
                register.getDayRegisterList().add(dayRegister);
            } else {
                register.getDayRegisterList().get(register.getDayRegisterList().size() - 1).getEntryMap().put(entry, register.getDayRegisterList().get(register.getDayRegisterList().size() - 1).getEntryMap().getOrDefault(entry, 0) + 1);
            }
        }
    }

    public void printRegister(Register register) {
        for (DayRegister day : register.getDayRegisterList()) {
            day.printDay();
        }
    }
}
