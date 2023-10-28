package com.andrei.expense_tracker.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Register {

    private List<DayRegister> dayRegisterList = new ArrayList<>();
}
