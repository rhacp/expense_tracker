package com.andrei.expense_tracker;

import com.andrei.expense_tracker.models.Category;
import com.andrei.expense_tracker.models.Register;
import com.andrei.expense_tracker.services.EntryServiceImpl;
import com.andrei.expense_tracker.services.RegisterServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ExpenseTrackerApplication {

    public static void main(String[] args) {

//		SpringApplication.run(ExpenseTrackerApplication.class, args);
        RegisterServiceImpl registerService = new RegisterServiceImpl();
        EntryServiceImpl entryService = new EntryServiceImpl();
        Register register = registerService.createRegistry();
        menu(register, entryService, registerService);
    }

    public static void menu(Register register, EntryServiceImpl entryService, RegisterServiceImpl registerService) {
        Scanner scanner = new Scanner(System.in);
        int helpCounter;
        MENU_LOOP:
        while (true) {
            System.out.println("");
            System.out.println("MENU");
            System.out.println("---");
            System.out.println("Choose your item:");
            System.out.println("1. Create entry.");
            System.out.println("2. Show the entire register.");
            System.out.println("3. Delete entry.");
            System.out.println("4. Edit entry.");
            System.out.println("5. Show daily register.");
            System.out.println("6. See account details.");
            System.out.println("7. Transfer from one account to another.");
            System.out.println("0. Exit.");
            System.out.println("");
            System.out.print("Choose the item by number: ");
            String secondHelpCounter = scanner.nextLine();
            while (!secondHelpCounter.matches("\\d+")) {
                System.out.print("Invalid input. Try again: ");
                secondHelpCounter = scanner.nextLine();
            }
            helpCounter = Integer.parseInt(secondHelpCounter);
            System.out.println("");

            switch (helpCounter) {
                case 1 -> {
                    Category category = Category.DEFAULT;
                    System.out.println("Select category:");
                    System.out.println("1. FOOD.");
                    System.out.println("2. TRANSPORT");
                    System.out.println("3. BILLS.");
                    System.out.print("Choose the item by number: ");
                    String categoryIndex = scanner.nextLine();

                    switch (categoryIndex) {
                        case "1" -> category = Category.FOOD;
                        case "2" -> category = Category.TRANSPORT;
                        case "3" -> category = Category.BILLS;
                    }

                    System.out.print("Enter item name: ");
                    String nameValue = scanner.nextLine();

                    System.out.print("Enter value: ");
                    String valueHelp = scanner.nextLine();
                    double value = Double.parseDouble(valueHelp);

                    registerService.addEntry(entryService.createEntry(nameValue, value, category), register);
                    System.out.println("Entry added!");
                }
                case 2 -> {
                    registerService.printRegister(register);
                }
                case 0 -> {
                    break MENU_LOOP;
                }
            }
        }
    }
}
