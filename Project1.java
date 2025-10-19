import java.util.Random;
import java.util.Scanner;

public class Project1 {

    private static final Scanner SC = new Scanner(System.in, "UTF-8");
    private static final Random RAND = new Random();

    public static void main(String[] args) {
        showWelcome();
        mainLoop();
    }

    // ===================== UI & Helpers =====================
    public static void showWelcome() {
        clearScreen();
        System.out.println("################################################################");
        System.out.println("#  #");
        System.out.println("#       ");
        System.out.println("#      ");
        System.out.println("#      ");
        System.out.println("#    ");
        System.out.println("#                                                              #");
        System.out.println("#   CMPE343 - Fundamentals of Java Programming - Project #1     #");
        System.out.println("#   Team:                                 #");
        System.out.println("#                                                              #");
        System.out.println("################################################################\n");
    }

    public static void mainLoop() {
        boolean running = true;
        while (running) {
            printMainMenu();
            String choice = SC.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A":
                    submenuPrimary();
                    break;
                case "B":
                    submenuSecondary();
                    break;
                case "C":
                    submenuHighSchool();
                    break;
                case "D":
                    submenuUniversity();
                    break;
                case "E":
                    System.out.println("Terminating... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select A, B, C, D or E.");
            }
        }
    }

    public static void printMainMenu() {
        clearScreen();
        System.out.println("Main Menu - Select an option:");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate");
        System.out.print("Choice: ");
    }

    public static void clearScreen() {
        // Try ANSI clear; may not work in some consoles but is widely supported
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
