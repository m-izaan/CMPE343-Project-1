
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Project1 {
    private static final Scanner SC = new Scanner(System.in, StandardCharsets.UTF_8);
    private static final Random RAND = new Random();

    public static void main(String[] args) {
        showWelcome();
        menuMain();
    }

    // ===================== UI & Helpers =====================
    public static void showWelcome() {
        clearScreen();
        System.out.println("                            .--.");
        System.out.println("                           /  ..\\");
        System.out.println("                      ____.'  _o/");
        System.out.println("       .--.          '--.     |.__");
        System.out.println("      /..  \\         _.-'     /--'");
        System.out.println("      \\ o  /    _.--'        /");
        System.out.println("      /    \\   ~'--....___.-'");
        System.out.println("     /      \\");
        System.out.println("    (/      \\)      ,_");
        System.out.println("     |      \\        |`\\");
        System.out.println("      \\      '._     \\  `'-._");
        System.out.println("       '._      '-.   \\      '-._/)");
        System.out.println("          `'- ,~- _.`  '.        '.--.");
        System.out.println("jgs                      `-.,    / ..`\\");
        System.out.println("       .--.                 //'-.   o /");
        System.out.println("      /..  \\               (/     '--'");
        System.out.println("      \\o _ (____");
        System.out.println("    __.|    .--'");
        System.out.println("   '---\\    '.         ,");
        System.out.println("        '.    '-.___.-'/");
        System.out.println("          '-.__     _.'");
        System.out.println("               `````");
    }

    public static void menuMain() {
        showMenuMain();
        selectMenuMain();
    }
    public static void showMenuMain() {
        clearScreen();
        System.out.println("Main Menu - Select an option:");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate");
    }
    public static void selectMenuMain() {
        boolean running = true;
        while (running) {
            System.out.print("Choice: ");
            String choice = SC.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A":
                    menuPrimarySchool();
                    break;
                case "B":
                    menuSecondarySchool();
                    break;
                case "C":
                    menuHighSchool();
                    break;
                case "D":
                    menuUniversity();
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

    public static void menuPrimarySchool() {
        showMenuPrimarySchool();
        selectMenuPrimarySchool();
    }
    public static void showMenuPrimarySchool()
    {
        clearScreen();
        System.out.println("Sub Menu - Primary School - Select an option:");
        System.out.println("[A] Age and Zodiac Sign Detection");
        System.out.println("[B] Reverse the Words");
        System.out.println("[C] Return to the Main Menu");
    }
    public static void selectMenuPrimarySchool()
    {
        boolean back = false;
        while (!back)
        {
            System.out.print("Choice: ");
            String subChoice = SC.nextLine().trim().toUpperCase();
            switch (subChoice)
            {
                case "A":
                    try {
                        System.out.print("Enter day of birth: ");
                        int day = Integer.parseInt(SC.nextLine());
                        System.out.print("Enter month of birth: ");
                        int month = Integer.parseInt(SC.nextLine());
                        System.out.print("Enter year of birth: ");
                        int year = Integer.parseInt(SC.nextLine());
                        ageZodiac(day, month, year);
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter valid numbers.");
                    }
                    break;
                case "B":
                    System.out.print("Enter a sentence: ");
                    String text = SC.nextLine();
                    String reversed = reverseWords(text);
                    System.out.println("\nReversed Sentence:\n" + reversed + "\n");
                    break;
                case "C":
                    back = true;
                    clearScreen();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void menuSecondarySchool() {
        showMenuSecondarySchool();
        selectMenuSecondarySchool();
    }
    public static void showMenuSecondarySchool() {
        clearScreen();
        System.out.println("Sub Menu - Secondary School - Select an option:");
        System.out.println("[A] Prime Numbers");
        System.out.println("[B] Step by Step Evaluation of Expression");
        System.out.println("[C] Return to Main Menu");
        System.out.print("Choice: ");
    }
    public static void selectMenuSecondarySchool() {

    }

    public static void menuHighSchool() {
        showMenuHighSchool();
        selectMenuHighSchool();
    }
    public static void showMenuHighSchool() {
        clearScreen();
        System.out.println("Sub Menu - High School - Select an option:");
        System.out.println("[A] Statistical Information About an Array");
        System.out.println("[B] Distance Between Two Arrays");
        System.out.println("[C] Return to Main Menu");
        System.out.print("Choice: ");
    }
    public static void selectMenuHighSchool() {

    }

    public static void menuUniversity() {
        showMenuUniversity();
        selectMenuUniversity();
    }
    public static void showMenuUniversity() {
        clearScreen();
        System.out.println("Welcome to the Connect Four Game! - Select the Board Size and then the Game Mode to Start:");
        System.out.println("Board Size Options:%n[A] 5x4%n[B] 6x5%n[C] 7x6");
        System.out.println("Game Mode Options:%n[A] single-player vs computer%n[B] two-players");
        System.out.print("Choice: ");
    }
    public static void selectMenuUniversity() {

    }

    public static void ageZodiac(int day, int month, int year)
    {
        clearScreen();
        LocalDate now = LocalDate.now();

        int currentDay = now.getDayOfMonth();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();

        int d = currentDay - day;
        int m = currentMonth - month;
        int y = currentYear - year;

        // Borrow days if needed
        if (d < 0) 
        {
            m--;
            d += daysInMonth((month == 12) ? 1 : month);
        }
        // Borrow months if needed
        if (m < 0) 
        {
            y--;
            m += 12;
        }

        System.out.printf("You are %d years, %d months, and %d days old.%n", y, m, d);

        String zodiac = getZodiacSign(day, month);
        System.out.println("Your Zodiac sign is: " + zodiac + "\n");

    }
    private static int daysInMonth(int month)
    {
        switch (month)
        {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2:
                return 28;
            default:
                return 30;
        }
    }
    private static String getZodiacSign(int day, int month) 
    {
        return switch (month) 
        {
            case 1 -> (day <= 19) ? "Capricorn" : "Aquarius";
            case 2 -> (day <= 18) ? "Aquarius" : "Pisces";
            case 3 -> (day <= 20) ? "Pisces" : "Aries";
            case 4 -> (day <= 19) ? "Aries" : "Taurus";
            case 5 -> (day <= 20) ? "Taurus" : "Gemini";
            case 6 -> (day <= 20) ? "Gemini" : "Cancer";
            case 7 -> (day <= 22) ? "Cancer" : "Leo";
            case 8 -> (day <= 22) ? "Leo" : "Virgo";
            case 9 -> (day <= 22) ? "Virgo" : "Libra";
            case 10 -> (day <= 22) ? "Libra" : "Scorpio";
            case 11 -> (day <= 21) ? "Scorpio" : "Sagittarius";
            case 12 -> (day <= 21) ? "Sagittarius" : "Capricorn";
            default -> "Unknown";
        };
    }
    // Recursive reverse function
    public static String reverseWords(String text) 
    {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) 
        {
            char c = text.charAt(i);
            if (Character.isLetter(c)) 
            {
                word.append(c);
            } 
            else 
            {
                if (word.length() > 1) 
                {
                    result.append(reverseRecursive(word.toString()));
                } 
                else 
                {
                    result.append(word);
                }
                word.setLength(0);
                result.append(c);
            }
         }

        // Handle last word if sentence ends with a letter
        if (word.length() > 1) result.append(reverseRecursive(word.toString()));
        else result.append(word);

        return result.toString();
    }
    private static String reverseRecursive(String s)
    {
        if (s.isEmpty()) return s;
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }

    public static void primeNumbers(int number) 
    {
        
    }

    public static void evalExpression(String expression)
    {
        
    }

    public static void arrayStat(int arraySize, int[] elements) 
    {
        
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