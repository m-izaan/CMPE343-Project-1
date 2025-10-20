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
        System.out.println("#                                                              #");
        System.out.println("#                                                              #");
        System.out.println("#                                                              #");
        System.out.println("#   CMPE343 - Fundamentals of Java Programming - Project #1    #");
        System.out.println("#   Team: Team Jarvis                                          #");
        System.out.println("#                                                              #");
        System.out.println("#                                                              #");
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
                    subMenuPrimary();
                    break;
                case "B":
                    subMenuSecondary();
                    break;
                case "C":
                    subMenuHighSchool();
                    break;
                case "D":
                    subMenuUniversity();
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
        // clearScreen();
        System.out.println("Main Menu - Select an option:");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate");
        System.out.print("Choice: ");
    }

    public static void subMenuPrimary() {
        clearScreen();
        System.out.println("Sub Menu - Primary School - Select an option:");
        System.out.println("[A] Age and Zodiac Sign Detection");
        System.out.println("[B] Reverse the Words");
        System.out.println("[C] Return to the Main Menu");
        System.out.print("Choice: ");
    }

    public static void subMenuSecondary() {
        clearScreen();
        System.out.println("Sub Menu - Secondary School - Select an option:");
        System.out.println("[A] Prime Numbers");
        System.out.println("[B] Step by Step Evaluation of Expression");
        System.out.println("[C] Return to Main Menu");
        System.out.print("Choice: ");
    }

    public static void subMenuHighSchool() {
        clearScreen();
        System.out.println("Sub Menu - High School - Select an option:");
        System.out.println("[A] Statistical Information About an Array");
        System.out.println("[B] Distance Between Two Arrays");
        System.out.println("[C] Return to Main Menu");
        System.out.print("Choice: ");
    }

    public static void subMenuUniversity() {
        clearScreen();
        System.out.println("Welcome to the Connect Four Game! - Select the Board Size and then the Game Mode to Start:");
        System.out.println("Board Size Options:%n[A] 5x4%n[B] 6x5%n[C] 7x6");
        System.out.println("Game Mode Options:%n[A] single-player vs computer%n[B] two-players");
        System.out.print("Choice: ");
    }

    public static void ageZodiac(int day, int month, int year) {

    }

    public static void reverseWords(String text) {
        
    }

    public static void primeNumbers(int number) {
        
    }
    
    public static void evalExpression(String expression) {
        
    }

    public static void arrayStat(int arraySize, int[] elements) {
        
    }

    public static void arraysDistance(int arrayDimension, int[] array1Elements, int[] array2Elements) {
        
    }
    
    public static void connectFour(int rows, int columns, String gameMode) {
        
    }

    public static void clearScreen() {
        // Try ANSI clear; may not work in some consoles but is widely supported
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}
