package BarangayManagementSystem;

import java.util.Scanner;

public abstract class BaseMenu implements Menu {
        @Override
    public void processMenu(Scanner scan) {
        boolean running = true;
        while (running) {
            displayMenu();
            running = chooseMenu(scan);   // chooseMenu controls when loop ends
        }
        try {
            System.out.println("Exiting Program...");
            Thread.sleep(2000);
            System.out.println("Program Terminated.");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
