import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.*;

/**
 * A console project with Java showcasing programming fundamentals through an
 * interactive menu system. The project includes multiple school levels with
 * unique features implemented with structured programming and recursions.
 *
 * @author Abdul Hadi Khan
 * @author Muhammed Izaan Ul Haque
 * @author Sena Berra Soydugan
 * @author Emre Mekec
 * @version 1.0
 */

public class Project1 {

    // Global Constants

    /**
     * An object of the class Scanner to take user inputs
     *
     */
    public static final Scanner SC = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     * An object of the class random to get random values when needed
     *
     */
    public static final Random RAND = new Random();

    /**
     * A long constant to be used as the amount of time program should stop when
     * used with waitBeforeProceed() or waitMillis() methods
     *
     */
    public static final long DELAY_AMOUNT = 500;

    /**
     * ANSI reset code for the ASCII art.
     *
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * ANSI green code for the ASCII art.
     *
     */
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * ANSI blue code for the ASCII art.
     *
     */
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * ANSI purple code for the ASCII art.
     *
     */
    public static final String ANSI_PURPLE = "\u001B[35m";

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * The entry point of the program: calls the mainLoop(), then clears up the
     * screen on program exit.
     *
     * @param args command-line arguments
     * @author Emre Mekec
     */
    public static void main(String[] args) {
        clearScreen();
        showWelcome();
        mainLoop();
        clearScreen();
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Menu Logic

    /**
     * Shows the colorized ASCII art as the welcome message.
     *
     * @author Emre Mekec
     * @author Abdul Hadi Khan
     */
    public static void showWelcome() {
        System.out.println(ANSI_BLUE + "                            .--." + ANSI_RESET);
        System.out.println(ANSI_BLUE + "                           /  ..\\" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "                      ____.'  _o/" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "       .--.          '--.     |.__"  + ANSI_RESET);
        System.out.println(ANSI_BLUE + "      /..  \\         _.-'     /--'" + ANSI_GREEN + " Abdul Hadi Khan" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "      \\ o  /    _.--'        /" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "      /    \\   ~'--....___.-'" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "     /      \\" + ANSI_GREEN + " Muhammed Izaan Ul Haque" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "    (/      \\)      ,_" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "     |      \\        |`\\" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "      \\      '._     \\  `'-._" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "       '._      '-.   \\      '-._/)" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "          `'- ,~- _.`  '.        '.--." + ANSI_RESET);
        System.out.println(ANSI_BLUE + "                         `-.,    / ..`\\" + ANSI_GREEN + " Sena Berra Soydugan" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "       .--.                 //'-.   o /" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "      /..  \\               (/     '--'" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "      \\o _ (____" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "    __.|    .--'" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "   '---\\    '.         ," + ANSI_RESET);
        System.out.println(ANSI_BLUE + "        '.    '-.___.-'/" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "          '-.__     _.'" + ANSI_GREEN + " Emre Mekec" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "               `````" + ANSI_RESET);

        System.out.println(ANSI_PURPLE + "\nWelcome to the CMPE-343 Project 1!\n" + ANSI_RESET);
    }

    /**
     * The main loop of the program: calls the menuMain().
     *
     * @author Emre Mekec
     */
    public static void mainLoop() {
        menuMain();
    }

    /**
     * Wraps up the methods for displaying everything within the main screen and
     * start selecting from the main menu in one call, and keeps running until the
     * user terminates it.
     *
     * @author Emre Mekec
     */
    public static void menuMain() {
        boolean running = true;
        while (running) {
            showMenuMain();
            running = selectMenuMain();
            clearScreen();
        }
    }

    /**
     * Shows the main menu.
     *
     * @author Emre Mekec
     * @author Muhammed Izaan
     */
    public static void showMenuMain() {
        System.out.println("Main Menu - Select an option:");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate");
    }

    /**
     * Selects the options from the main menu.
     *
     * @return A boolean value weather keeping the program main loop running or
     *         terminating it.
     * @author Emre Mekec
     * @author Muhammed Izaan
     */
    public static boolean selectMenuMain() {
        boolean running = true;
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();
        do {
            switch (choice) {
                case "A":
                    menuPrimarySchool();
                    running = false;
                    break;
                case "B":
                    menuSecondarySchool();
                    running = false;
                    break;
                case "C":
                    menuHighSchool();
                    running = false;
                    break;
                case "D":
                    menuUniversity();
                    running = false;
                    break;
                case "E":
                    System.out.println("Terminating... Goodbye!");
                    waitMillis(DELAY_AMOUNT);
                    return false;
                default:
                    do {
                        System.out.println("Invalid option. Please select A, B, C, D or E.");
                        System.out.print("Choice: ");
                        choice = SC.nextLine().trim().toUpperCase();
                    } while(!choice.equals("A")&&!choice.equals("B")&&!choice.equals("C")&&!choice.equals("D")&&!choice.equals("E"));
            }
        } while (running);
        return true;
    }

    /**
     * Wraps up the methods for displaying the primary school menu screen and start
     * selecting from the primary school menu in one call, and keeps running until
     * the user terminates it.
     *
     * @author Emre Mekec
     */
    public static void menuPrimarySchool() {
        boolean running = true;
        while (running) {
            clearScreen();
            showMenuPrimarySchool();
            running = selectMenu("primary school");
        }
    }

    /**
     * Shows the primary school menu.
     *
     * @author Emre Mekec
     * @author Muhammed Izaan
     */
    public static void showMenuPrimarySchool() {
        System.out.println("Sub Menu - Primary School - Select an option:");
        System.out.println("[A] Age and Zodiac Sign Detection");
        System.out.println("[B] Reverse the Words");
        System.out.println("[C] Return to the Main Menu");
    }

    /**
     * Wraps up the methods for displaying the secondary school menu screen and
     * start selecting from the secondary school menu in one call, and keeps running
     * until the user terminates it.
     *
     * @author Emre Mekec
     */
    public static void menuSecondarySchool() {
        boolean running = true;
        while (running) {
            clearScreen();
            showMenuSecondarySchool();
            running = selectMenu("secondary school");
        }
    }

    /**
     * Shows the secondary school menu.
     *
     * @author Emre Mekec
     * @author Muhammed Izaan
     */
    public static void showMenuSecondarySchool() {
        System.out.println("Sub Menu - Secondary School - Select an option:");
        System.out.println("[A] Prime Numbers");
        System.out.println("[B] Step by Step Evaluation of Expression");
        System.out.println("[C] Return to Main Menu");
    }

    /**
     * Wraps up the methods for displaying the high school menu screen and start
     * selecting from the high school menu in one call, and keeps running until the
     * user terminates it.
     *
     * @author Emre Mekec
     */
    public static void menuHighSchool() {
        boolean running = true;
        while (running) {
            clearScreen();
            showMenuHighSchool();
            running = selectMenu("high school");
        }
    }

    /**
     * Shows the high school menu.
     *
     * @author Emre Mekec
     * @author Muhammed Izaan
     */
    public static void showMenuHighSchool() {
        System.out.println("Sub Menu - High School - Select an option:");
        System.out.println("[A] Statistical Information About an Array");
        System.out.println("[B] Distance Between Two Arrays");
        System.out.println("[C] Return to Main Menu");
    }

    /**
     * Wraps up the methods for displaying the university menu screen and start
     * selecting from the university menu in one call, and keeps running until the
     * user terminates it.
     *
     * @author Emre Mekec
     */
    public static void menuUniversity() {
        boolean running = true;
        while (running) {
            clearScreen();
            showMenuUniversity();
            running = selectMenu("university");
        }
    }

    /**
     * Shows the university menu.
     *
     * @author Emre Mekec
     * @author Muhammed Izaan
     */
    public static void showMenuUniversity() {
        System.out.println("Sub Menu - University - Select an option:");
        System.out.println("[A] Play Connect Four");
        System.out.println("[B] Return to Main Menu");
    }

    /**
     * Selects the options from either primary school, or secondary school, or high school menu, or university menu, depending on the menuType parameter.
     *
     * @param menuType A string value holding the value for the given menu type to run the method based on
     * @return A boolean value weather keeping the selected menu running or terminating it.
     * @author Emre Mekec
     */
    public static boolean selectMenu(String menuType) {
        boolean running =  true;
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();

        if (menuType.equals("university")) {
            do {
                boolean showMessage = true;
                switch (choice) {
                    case "A":
                        connectFour();
                        playAgain(menuType, showMessage, "A");
                        running = false;
                        break;
                    case "B":
                        System.out.println("Returning to main menu...");
                        waitMillis(DELAY_AMOUNT);
                        return false;
                    default:
                        do {
                            System.out.println("Invalid option. Please select A or B.");
                            System.out.print("Choice: ");
                            choice = SC.nextLine().trim().toUpperCase();
                        } while (!choice.equals("A") && !choice.equals("B"));
                }
            } while(running);
        }

        else
            do {
                boolean showMessage = true;
                switch (choice) {
                    case "A":
                        switch (menuType) {
                            case "primary school" -> ageZodiac();
                            case "secondary school" -> primeNumbers();
                            case "high school" -> arrayStat();
                        }
                        playAgain(menuType, showMessage, "A");
                        running = false;
                        break;
                    case "B":
                        switch (menuType) {
                            case "primary school" -> reverseWords();
                            case "secondary school" -> evalExpression();
                            case "high school" -> arraysDistance();
                        }
                        playAgain(menuType, showMessage, "B");
                        running = false;
                        break;
                    case "C":
                        System.out.println("Returning to main menu...");
                        waitMillis(DELAY_AMOUNT);
                        return false;
                    default:
                        do {
                            System.out.println("Invalid option. Please select A, B, or C.");
                            System.out.print("Choice: ");
                            choice = SC.nextLine().trim().toUpperCase();
                        } while (!choice.equals("A") && !choice.equals("B") && !choice.equals("C"));
                }
            } while(running);

        return true;
    }

    /**
     * Asks the user whether they want to make the same selection within the selected sub menu or return to that sub menu.
     *
     * @param menuType A string value holding the value for the given menu type to run the method based on
     * @param showMessage A boolean value deciding whether to show to message to ask user to play again or not
     * @param menuSelection A string value holding the value for the selection between A and B within the selected
     *                      sub menu that the string menuType holds the value for
     * @author Emre Mekec
     */
    public static void playAgain(String menuType, boolean showMessage, String menuSelection) {
        String replay;

        while(showMessage) {
            do {
                System.out.printf("%nDo you want to play again or return to the %s menu?%n%n", menuType);
                System.out.printf("[A] Play Again%n[B] Return to the %s Menu%n", menuType);
                System.out.print("Choice: ");
                replay = SC.nextLine().trim().toUpperCase();

                if (!replay.equals("A") && !replay.equals("B")) {
                    System.out.println("Invalid option. Please select A or B.");
                }
            } while (!replay.equals("A") && !replay.equals("B"));

            switch (replay) {
                case "A":
                    clearScreen();
                    switch (menuType) {
                        case "primary school":
                            switch (menuSelection) {
                                case "A" -> ageZodiac();
                                case "B" -> reverseWords();
                            }
                            break;
                        case "secondary school":
                            switch (menuSelection) {
                                case "A" -> primeNumbers();
                                case "B" -> evalExpression();
                            }
                            break;
                        case "high school":
                            switch (menuSelection) {
                                case "A" -> arrayStat();
                                case "B" -> arraysDistance();
                            }
                            break;
                        case "university":
                            connectFour();
                            break;
                    }
                    break;
                case "B":
                    showMessage = false;
                    System.out.printf("Returning to %s menu...%n", menuType);
                    waitMillis(DELAY_AMOUNT);
                    break;
                default:
                    do {
                        System.out.println("Invalid option. Please select A or B.");
                        System.out.print("Choice: ");
                        replay = SC.nextLine().trim().toUpperCase();
                    } while (!replay.equals("A") && !replay.equals("B"));
            }
        }
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Methods for the selectMenu("primary school") call

    /**
     * Finds the zodiac sign of the user based on the day, month, and year input,
     * and tells them how old they are as years, months, and days.
     *
     * @author Abdul Hadi Khan
     */
    public static void ageZodiac() {
        // Get the birthdate from user
        int year = getYear();
        int month = getMonth();
        int day = getDay(month, year);

        // Get today's date
        LocalDate now = LocalDate.now();
        int currentDay = now.getDayOfMonth();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();

        // Calculate the difference
        int daysDifference = currentDay - day;
        int monthsDifference = currentMonth - month;
        int yearsDifference = currentYear - year;

        // Fix days if negative
        if (daysDifference < 0) {
            monthsDifference = monthsDifference - 1;

            int previousMonth;
            if (month == 12) {
                previousMonth = 1;
            } else {
                previousMonth = month + 1;
            }

            daysDifference = daysDifference + daysInMonth(previousMonth, year);
        }

        // Fix months if negative
        if (monthsDifference < 0) {
            yearsDifference = yearsDifference - 1;
            monthsDifference = monthsDifference + 12;
        }

        // Print the age
        System.out.println("You are " + yearsDifference + " years, " + monthsDifference + " months, and "
                + daysDifference + " days old.");

        // Get and print zodiac sign
        String zodiac = getZodiacSign(day, month);
        System.out.println("Your Zodiac sign is: " + zodiac + "\n");
    }

    /**
     * Gets the year from the user for the method ageZodiac().
     *
     * @return Year taken from the user
     * @author Abdul Hadi Khan
     */
    public static int getYear() {
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();

        boolean validInput = false;
        int year = 0;

        while (!validInput) {
            try {
                System.out.print("Enter year of birth: ");
                String input = SC.nextLine();
                year = Integer.parseInt(input);

                if (year < 1900) {
                    System.out.println("Error: Year must be 1900 or later. Please try again.\n");
                } else if (year > currentYear) {
                    System.out.println("Error: Year cannot be in the future. Please try again.\n");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number. Please try again.\n");
            }
        }

        return year;
    }

    /**
     * Gets the month from the user for the method ageZodiac().
     *
     * @return Month taken from the user
     * @author Abdul Hadi Khan
     */
    public static int getMonth() {
        boolean validInput = false;
        int month = 0;

        while (!validInput) {
            try {
                System.out.print("Enter month of birth (1-12): ");
                String input = SC.nextLine();
                month = Integer.parseInt(input);

                if (month < 1) {
                    System.out.println("Error: Month must be at least 1. Please try again.\n");
                } else if (month > 12) {
                    System.out.println("Error: Month cannot be more than 12. Please try again.\n");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number. Please try again.\n");
            }
        }

        return month;
    }

    /**
     * Gets the day from the user for the method ageZodiac().
     *
     * @param month The month to be used inside the method ageZodiac()
     * @param year  The year to be used inside the method ageZodiac()
     * @return Day taken from the user
     * @author Abdul Hadi Khan
     */
    public static int getDay(int month, int year) {
        LocalDate now = LocalDate.now();
        boolean isLeapYear = isLeapYear(year);
        int maxDays = daysInMonth(month, year);

        boolean validInput = false;
        int day = 0;

        while (!validInput) {
            try {
                System.out.print("Enter day of birth: ");
                String input = SC.nextLine();
                day = Integer.parseInt(input);

                if (day < 1) {
                    System.out.println("Error: Day must be at least 1. Please try again.\n");
                } else if (day > maxDays) {
                    if (month == 2 && isLeapYear) {
                        System.out.println(
                                "Error: February has only 29 days in leap year " + year + ". Please try again.\n");
                    } else {
                        System.out.println(
                                "Error: Month " + month + " has only " + maxDays + " days. Please try again.\n");
                    }
                } else {
                    // Check if date is in the future
                    LocalDate birthDate = LocalDate.of(year, month, day);
                    if (birthDate.isAfter(now)) {
                        System.out.println("Error: Birth date cannot be in the future. Please try again.\n");
                    } else {
                        validInput = true;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number. Please try again.\n");
            } catch (Exception e) {
                System.out.println("Error: Invalid date. Please try again.\n");
            }
        }

        return day;
    }

    /**
     * Checks if a year is a leap year or not.
     *
     * @param year The year taken from the user
     * @return Boolean value concluding if a year is a leap year or not
     * @author Abdul Hadi Khan
     */
    public static boolean isLeapYear(int year) {
        // A year is a leap year if:
        // It is divisible by 4 AND not divisible by 100
        // OR it is divisible by 400

        boolean divisibleBy4 = (year % 4 == 0);
        boolean divisibleBy100 = (year % 100 == 0);
        boolean divisibleBy400 = (year % 400 == 0);

        if (divisibleBy400) {
            return true;
        }

        return (divisibleBy4 && !divisibleBy100);
    }

    /**
     * Gets the days in a month to be used in the method getZodiac.
     *
     * @param month The month taken from the user
     * @param year  The year taken from the user
     * @return A number of the days in the month
     * @author Abdul Hadi Khan
     */
    public static int daysInMonth(int month, int year) {
        boolean isLeapYear = isLeapYear(year);

        if (month == 1) {
            return 31;
        } else if (month == 2) {
            if (isLeapYear) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 3) {
            return 31;
        } else if (month == 4) {
            return 30;
        } else if (month == 5) {
            return 31;
        } else if (month == 6) {
            return 30;
        } else if (month == 7) {
            return 31;
        } else if (month == 8) {
            return 31;
        } else if (month == 9) {
            return 30;
        } else if (month == 10) {
            return 31;
        } else if (month == 11) {
            return 30;
        } else if (month == 12) {
            return 31;
        } else {
            return 30;
        }
    }

    /**
     * Gets the zodiac sign result.
     *
     * @param day   The day taken from the user
     * @param month The month taken from the user
     * @return The found zodiac sign of the user
     * @author Abdul Hadi Khan
     */
    public static String getZodiacSign(int day, int month) {
        if (month == 1) {
            if (day <= 19) {
                return "Capricorn";
            } else {
                return "Aquarius";
            }
        } else if (month == 2) {
            if (day <= 18) {
                return "Aquarius";
            } else {
                return "Pisces";
            }
        } else if (month == 3) {
            if (day <= 20) {
                return "Pisces";
            } else {
                return "Aries";
            }
        } else if (month == 4) {
            if (day <= 19) {
                return "Aries";
            } else {
                return "Taurus";
            }
        } else if (month == 5) {
            if (day <= 20) {
                return "Taurus";
            } else {
                return "Gemini";
            }
        } else if (month == 6) {
            if (day <= 20) {
                return "Gemini";
            } else {
                return "Cancer";
            }
        } else if (month == 7) {
            if (day <= 22) {
                return "Cancer";
            } else {
                return "Leo";
            }
        } else if (month == 8) {
            if (day <= 22) {
                return "Leo";
            } else {
                return "Virgo";
            }
        } else if (month == 9) {
            if (day <= 22) {
                return "Virgo";
            } else {
                return "Libra";
            }
        } else if (month == 10) {
            if (day <= 22) {
                return "Libra";
            } else {
                return "Scorpio";
            }
        } else if (month == 11) {
            if (day <= 21) {
                return "Scorpio";
            } else {
                return "Sagittarius";
            }
        } else if (month == 12) {
            if (day <= 21) {
                return "Sagittarius";
            } else {
                return "Capricorn";
            }
        } else {
            return "Unknown";
        }
    }

    /**
     * Reverses the words of a sentence taken from the user.
     *
     * @author Abdul Hadi Khan
     */
    public static void reverseWords() {
        System.out.print("Enter a sentence: ");
        String text = SC.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (isTurkishLetter(c)) {
                word.append(c);
            } else {
                if (word.length() > 1) {
                    result.append(reverseRecursive(word.toString()));
                } else {
                    result.append(word);
                }
                word.setLength(0);
                result.append(c);
            }
        }

        // Handle last word if sentence ends with a letter
        if (word.length() > 1)
            result.append(reverseRecursive(word.toString()));
        else
            result.append(word);

        String reversed = result.toString();
        System.out.println("\nReversed Sentence:\n" + reversed + "\n");
    }

    /**
     * Checks for the Turkish letters.
     *
     * @param c A char variable representing characters to be checked one by one
     *          from the words of a given sentence
     * @return A boolean value deciding if a word taken as input is a Turkish word
     *         or not
     * @author Abdul Hadi Khan
     */
    public static boolean isTurkishLetter(char c) {
        // Check if character is a letter (English or Turkish)
        if (Character.isLetter(c)) {
            return true;
        }

        // Check for Turkish-specific lowercase characters
        if (c == 'ç') {
            return true;
        }
        if (c == 'ğ') {
            return true;
        }
        if (c == 'ı') {
            return true;
        }
        if (c == 'ö') {
            return true;
        }
        if (c == 'ş') {
            return true;
        }
        if (c == 'ü') {
            return true;
        }

        // Check for Turkish-specific uppercase characters
        if (c == 'Ç') {
            return true;
        }
        if (c == 'Ğ') {
            return true;
        }
        if (c == 'İ') {
            return true;
        }
        if (c == 'Ö') {
            return true;
        }
        if (c == 'Ş') {
            return true;
        }
        if (c == 'Ü') {
            return true;
        }

        // If none of the above, it's not a Turkish letter
        return false;
    }

    /**
     * Reverses a given word recursively.
     *
     * @param s A string parameter, standing for a word to be reversed recursively
     * @return A boolean value deciding if a word taken as input is a Turkish word
     *         or not
     * @author Abdul Hadi Khan
     */
    public static String reverseRecursive(String s) {
        if (s.isEmpty())
            return s;
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Methods for the selectMenu("secondary school") call

    // Necessary Variables

    /**
     * Array holding the most recently generated prime numbers.
     *
     * <p>
     * Note: this is reused by the different sieve methods; the returned array
     * reference from each method points to a newly sized array assigned here.
     */
    static int[] Primes;

    /**
     * Number of primes stored in {@code Primes} after the last generation call.
     */
    static int count = 0;

    /**
     * The EratosthenesFormula() is the function made to find prime numbers using
     * the Eratosthenes method.
     * 
     * @param n The maximum value up to which the method should search for and
     *          identify prime numbers
     * @return A new int[] array containing all prime numbers found up to and
     *         including the maximum value n, sorted in ascending order.
     * @author Muhammad Izaan Ul Haque
     */
    public static int[] eratosthenesFormula(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        if (n >= 2) {
            for (int x = 2; x * x <= n; x++) {
                if (isPrime[x]) {
                    for (long multiples = (long) x * x; multiples <= n; multiples += x) {
                        isPrime[(int) multiples] = false;
                    }

                }
            }
        } else {
            return new int[0];
        }

        count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        Primes = new int[count];
        int index = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                Primes[index] = i;
                index++;
            }
        }

        return Primes;
    }

    /**
     * The sieveSundaramArray() is the function made to find prime numbers using
     * the Sieve of Sundaram method.
     *
     * @param n The upper limit (inclusive) for finding prime numbers
     * @return A new int[] array containing all prime numbers found up to and
     *         including n, sorted in ascending order
     * @author Muhammad Izaan Ul Haque
     */
    public static int[] sieveSundaramArray(int n) {

        if (n < 2) {
            return new int[0];
        }

        // k is the upper bound for the Sundaram index (we generate primes up to 2*k +
        // 1)
        int k = (n - 2) / 2;
        if (k < 1) {
            // Only possible prime is 2 if n >= 2
            if (n >= 2)
                return new int[] { 2 };
            else
                return new int[0];
        }

        // Use a boolean marker array indexed 0...k (we'll ignore index 0 in marking
        // logic)
        boolean[] marked = new boolean[k + 1]; // default false

        // Mark indices of form i + j + 2*i*j (1 <= i <= j) up to k
        for (int i = 1; i <= k; i++) {
            // j starts at i (as per Sundaram)
            for (int j = i;; j++) {
                long s = (long) i + j + 2L * i * j; // long to avoid overflow in intermediate
                if (s > k)
                    break;
                marked[(int) s] = true;
            }
        }

        // Count primes: include 2 if within range, and then 2*i + 1 for each unmarked i
        count = 0;
        if (n >= 2) {
            count++; // for prime 2
        }
        for (int i = 1; i <= k; i++) {
            if (!marked[i]) {
                int p = 2 * i + 1;
                if (p <= n)
                    count++;
            }
        }

        // Compact into int[] primes
        Primes = new int[count];
        int idx = 0;
        if (n >= 2) {
            Primes[idx++] = 2;
        }
        for (int i = 1; i <= k; i++) {
            if (!marked[i]) {
                int p = 2 * i + 1;
                if (p <= n)
                    Primes[idx++] = p;
            }
        }

        return Primes;
    }

    /**
     * The sieveAtkinArray() is the function made to find prime numbers using the
     * Sieve of Atkin method.
     *
     * @param n The upper limit (inclusive) for finding prime numbers
     * @return A new int[] array containing all prime numbers found up to and
     *         including n, sorted in ascending order
     * @author Muhammad Izaan Ul Haque
     */
    public static int[] sieveAtkinArray(int n) {
        if (n < 2) {
            return new int[0];
        }

        boolean[] isPrime = new boolean[n + 1]; // default false
        int limit = (int) Math.sqrt(n);

        // Main Atkin quadratic residue toggling
        for (int x = 1; x <= limit; x++) {
            for (int y = 1; y <= limit; y++) {
                long x2 = 1L * x * x;
                long y2 = 1L * y * y;

                long m = 4 * x2 + y2;
                if (m <= n) {
                    int mm = (int) m;
                    if (mm % 12 == 1 || mm % 12 == 5)
                        isPrime[mm] = !isPrime[mm];
                }

                m = 3 * x2 + y2;
                if (m <= n) {
                    int mm = (int) m;
                    if (mm % 12 == 7)
                        isPrime[mm] = !isPrime[mm];
                }

                m = 3 * x2 - y2;
                if (x > y && m <= n) {
                    int mm = (int) m;
                    if (mm % 12 == 11)
                        isPrime[mm] = !isPrime[mm];
                }
            }
        }

        // Eliminate multiples of squares
        for (int r = 5; r <= limit; r++) {
            if (isPrime[r]) {
                int r2 = r * r;
                for (int k = r2; k <= n; k += r2) {
                    isPrime[k] = false;
                }
            }
        }

        // Count primes (include 2 and 3 if in range)
        count = 0;
        if (n >= 2) {
            count++;
        }
        if (n >= 3) {
            count++;
        }
        for (int i = 5; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        // Build compact result array
        Primes = new int[count];
        int idx = 0;
        if (n >= 2) {
            Primes[idx++] = 2;
        }

        if (n >= 3) {
            Primes[idx++] = 3;
        }

        for (int i = 5; i <= n; i++) {
            if (isPrime[i]) {
                Primes[idx++] = i;
            }
        }

        return Primes;
    }

    /**
     * Build a short string representation showing the first {@code k} elements
     * of an integer array.
     *
     * <p>
     * Used for compact display: prints "[a, b, c]" when length &le; k, otherwise
     * prints "[a, b, c, ...]". Returns "[]" for null or empty arrays.
     * </p>
     *
     * @param arr the array to inspect (could be null)
     * @param k   maximum number of elements to include from the start
     * @return a compact string representing the first up to {@code k} elements
     *         of {@code arr}
     */
    public static String firstK(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return "[]";
        int n = Math.min(k, arr.length);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < n; i++) {
            if (i > 0)
                sb.append(", ");
            sb.append(arr[i]);
        }
        if (arr.length > n)
            sb.append(", ...");
        sb.append("]");
        return sb.toString();
    }

    /**
     * Build a short string representation showing the last {@code k} elements
     * of an integer array.
     *
     * <p>
     * Used for compact display: prints "[..., x, y]" when array is longer
     * than {@code k}. Returns "[]" for null or empty arrays.
     *
     * @param arr the array to inspect (could be null)
     * @param k   maximum number of elements to include from the end
     * @return a compact string representing the last up to {@code k} elements
     *         of {@code arr}
     */
    public static String lastK(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return "[]";
        int n = Math.min(k, arr.length);
        StringBuilder sb = new StringBuilder("[");
        for (int i = arr.length - n; i < arr.length; i++) {
            if (i > arr.length - n)
                sb.append(", ");
            sb.append(arr[i]);
        }
        if (arr.length > n)
            sb.insert(1, "..., ");
        sb.append("]");
        return sb.toString();
    }

    /**
     * Format a millisecond duration to a string with three decimal places.
     *
     * @param ms duration in milliseconds
     * @return formatted string like "12.345"
     */
    public static String fmtMs(double ms) {
        return String.format("%.3f", ms);
    }

    // Prime Numbers main function

    /**
     * Interactive console routine to:
     * - prompt the user for an integer {@code n >= 12},
     * - run the three sieve algorithms (Eratosthenes, Sundaram, Atkin),
     * - measure runtime of each in milliseconds,
     * - and print a compact comparative summary.
     *
     * <p>
     * Uses {@code SC} (a Scanner) to read console input and writes results to
     * standard output. The method loops until a valid integer >= 12 is entered.<br>
     *
     * <strong>Side effects:</strong> reads from input, prints to output, and
     * measures system time with {@code System.nanoTime()}.
     *
     * @see #eratosthenesFormula(int)
     * @see #sieveSundaramArray(int)
     * @see #sieveAtkinArray(int)
     */
    public static void primeNumbers() {

        int num = 0;

        while (true) {
            System.out.print("Enter an integer n (n >= 12 and n <= 1000): ");
            String line = SC.nextLine().trim();
            try {
                num = Integer.parseInt(line);
                if (num >= 12 && num <= 1000) {
                    break;
                } else {
                    System.out.println("Value out of range. Try again!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Not a valid integer. Try again!");
            }
        }

        // Eratosthenes
        long startE = System.nanoTime();
        int[] erPrimes = eratosthenesFormula(num);
        long eTimeNs = System.nanoTime() - startE;
        double eTimeMs = eTimeNs / 1_000_000.0;

        // Sundaram
        long startS = System.nanoTime();
        int[] suPrimes = sieveSundaramArray(num);
        long sTimeNs = System.nanoTime() - startS;
        double sTimeMs = sTimeNs / 1_000_000.0;

        long startA = System.nanoTime();
        int[] atPrimes = sieveAtkinArray(num);
        long aTimeNs = System.nanoTime() - startA;
        double aTimeMs = aTimeNs / 1_000_000.0;

        // store them in variables
        double runtimeEratosthenes_ms = eTimeMs;
        double runtimeSundaram_ms = sTimeMs;
        double runtimeAtkin_ms = aTimeMs;

        // print summary nicely
        System.out.println("Eratosthenes: count=" + erPrimes.length
                + " first 3 =" + firstK(erPrimes, 3) + " last 2 =" + lastK(erPrimes, 2)
                + " time_ms =" + fmtMs(runtimeEratosthenes_ms));

        System.out.println("Sundaram:     count=" + suPrimes.length
                + " first 3 =" + firstK(suPrimes, 3) + " last 2 =" + lastK(suPrimes, 2)
                + " time_ms =" + fmtMs(runtimeSundaram_ms));

        System.out.println("Atkin:        count=" + atPrimes.length
                + " first 3 =" + firstK(atPrimes, 3) + " last 2 =" + lastK(atPrimes, 2)
                + " time_ms =" + fmtMs(runtimeAtkin_ms));

    }

    /**
     * Interactive, step-by-step evaluator for arithmetic expressions.
     *
     * <p>
     * Prompts the user to enter an expression consisting of integers,
     * parentheses, and operators {@code +}, {@code -}, {@code x} (or {@code X},
     * {@code *}),
     * and {@code :} (or {@code /}). The method validates input, normalizes
     * operator synonyms, then repeatedly simplifies the expression one step at a
     * time
     * printing each intermediate form until a final value is reached.
     *
     * <p>
     * Unary minus is supported. Leading '+' is considered invalid per spec.
     * Uses helper routines for validation, tokenization and evaluation.<br>
     *
     * <strong>Side effects:</strong> reads from input via {@code SC} and prints
     * steps.
     *
     * @see #isValidExpression(String)
     * @see #normalizeOperators(String)
     * @see #simplifyOnce(String)
     */
    public static void evalExpression() {
        clearScreen();
        System.out.println("Step-by-step Evaluation of Expression");
        System.out.println("Allowed characters: digits, +, -, x (or X, *, ×), : (or /), (, )");
        System.out.println("Unary minus is allowed (e.g. -3). Leading '+' is considered invalid per spec.\n");

        String expr;
        while (true) {
            System.out.print("Enter expression: ");
            expr = SC.nextLine().trim();
            if (expr.isEmpty()) {
                System.out.println("Empty input. re-enter a valid expression.");
                continue;
            }
            if (!isValidExpression(expr)) {
                System.out.println("re-enter a valid expression.");
                continue;
            }
            // convert common operator synonyms to canonical forms, but keep formatting for
            // display
            expr = normalizeOperators(expr);
            break;
        }

        // Print step-by-step; each step simplifies just one subexpression (parenthesis
        // or one op)
        List<String> steps = new ArrayList<>();
        steps.add(expr);

        try {
            String current = expr;
            while (true) {
                String simplified = simplifyOnce(current);
                // If no further simplification possible, break
                if (simplified.equals(current)) {
                    break;
                }
                steps.add(simplified);
                current = simplified;
            }

            // Print steps in the required format
            for (String s : steps) {
                System.out.println("= " + normalizeSpacing(s));
            }

            // If final is a single number, print final value (already printed as last step)
            // Nothing else required
        } catch (ArithmeticException ae) {
            System.out.println("Error during evaluation: " + ae.getMessage());
            System.out.println("re-enter a valid expression.");
        } catch (Exception ex) {
            System.out.println("An error occurred during evaluation. re-enter a valid expression.");
        }
    }

    /*
     * ---------- Helpers for validation, tokenization, and step-by-step evaluation
     * ----------
     */

    /**
     * Replace common operator synonyms with canonical internal symbols.
     *
     * <p>
     * Specifically:
     * <ul>
     * <li>'×', '*', and 'X' -> 'x' (multiplication)</li>
     * <li>'/' -> ':' (division)</li>
     * </ul>
     *
     * @param s the input expression string (may contain various operator glyphs)
     * @return a new string where operator synonyms are normalized to internal
     *         tokens
     */
    public static String normalizeOperators(String s) {
        // Replace multiple canonical synonyms with a single internal symbol:
        // multiplication: 'x', 'X', '*', '×' -> 'x'
        // division: ':' or '/' -> ':'
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '×' || c == '*' || c == 'X') {
                sb.append('x');
            } else if (c == '/') {
                sb.append(':');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Validate the syntax of an arithmetic expression according to the project
     * rules.
     *
     * <p>
     * Checks allowed characters (digits, whitespace, +, -, x/X/*, :/ /,
     * parentheses),
     * balanced parentheses, proper placement of operators, and unary minus rules.
     * Leading '+' and illegal operator sequences are rejected.
     *
     * @param s the expression string to validate
     * @return true if {@code s} is considered a valid expression; false otherwise
     */
    public static boolean isValidExpression(String s) {
        // Allowed chars: digits, spaces, + - x X * × : / ( )
        // Normalize for checks
        if (s.trim().isEmpty())
            return false;

        String t = s;
        // Quick character validity check
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (Character.isDigit(c) || Character.isWhitespace(c))
                continue;
            if (c == '+' || c == '-' || c == '(' || c == ')' || c == ':' || c == 'x' || c == 'X' || c == '*' || c == '×'
                    || c == '/')
                continue;
            return false;
        }

        // Balance parentheses
        int bal = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c == '(')
                bal++;
            if (c == ')') {
                bal--;
                if (bal < 0)
                    return false; // closing before opening
            }
        }
        if (bal != 0)
            return false;

        // Disallow starting with '+' or other invalid leading tokens
        int firstNonSpace = -1;
        for (int i = 0; i < t.length(); i++) {
            if (!Character.isWhitespace(t.charAt(i))) {
                firstNonSpace = i;
                break;
            }
        }
        if (firstNonSpace == -1) {
            return false;
        }
        char first = t.charAt(firstNonSpace);
        if (first == '+') {
            return false; // per spec sample "+3-4" => invalid
        }
        if (first == 'x' || first == 'X' || first == '*' || first == ':' || first == '/' || first == ')') {
            return false;
        }

        // Check operator sequences and unary minus rules.
        // We treat '-' as unary if at start or after '(' or after another operator.
        boolean prevIsOp = true; // start = as-if previous is operator (so unary minus allowed)
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (Character.isDigit(c)) {
                prevIsOp = false;
                // consume continuous digits
                while (i + 1 < t.length() && Character.isDigit(t.charAt(i + 1))) {
                    i++;
                }
                continue;
            }
            if (c == '(') {
                prevIsOp = true;
                continue;
            }
            if (c == ')') {
                prevIsOp = false;
                continue;
            }
            // operator chars
            if (c == '+' || c == '-' || c == 'x' || c == 'X' || c == '*' || c == '×' || c == ':' || c == '/') {
                if (c == '-') {
                    // unary minus allowed if prevIsOp==true
                    if (prevIsOp) {
                        // must be followed by a digit or '('
                        int j = i + 1;
                        while (j < t.length() && Character.isWhitespace(t.charAt(j))) {
                            j++;
                        }
                        if (j >= t.length()) {
                            return false;
                        }
                        char next = t.charAt(j);
                        if (!(Character.isDigit(next) || next == '(')) {
                            return false;
                        }
                        // prevIsOp remains true until we see the number/paren content
                    } else {
                        // binary minus
                        prevIsOp = true;
                    }
                    continue;
                } else if (c == '+') {
                    // unary '+' is not allowed per sample, and we disallow leading '+'
                    if (prevIsOp) {
                        return false;
                    }
                    prevIsOp = true;
                    continue;
                } else {
                    // other operators (x,: etc.) cannot be unary
                    if (prevIsOp) {
                        return false; // e.g., "*3" or ":(1+1)" invalid
                    }
                    prevIsOp = true;
                    continue;
                }
            }
            return false; // any other char (shouldn't reach)
        }

        // Expression shouldn't end with binary operator
        // find last non-space char
        int lastIndex = -1;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (!Character.isWhitespace(t.charAt(i))) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex >= 0) {
            char last = t.charAt(lastIndex);
            if (last == '+' || last == '-' || last == 'x' || last == 'X' || last == '*' || last == '×' || last == ':'
                    || last == '/') {
                // trailing '-' could be part of a number only if it's unary, but trailing
                // operator is invalid
                return false;
            }
        }

        return true;
    }

    // helper to detect numeric tokens (including signed numbers like "-12")

    /**
     * Returns true if the token is a signed integer literal (e.g. "123", "-42").
     *
     * @param t token string (may be null)
     * @return {@code true} when {@code t} matches {@code -?\d+}, otherwise
     *         {@code false}
     */
    private static boolean isNumberToken(String t) {
        return t != null && t.matches("-?\\d+");
    }

    // insert explicit 'x' tokens where implicit multiplication is intended

    /**
     * Insert explicit multiplication tokens ("x") where multiplication is implied.
     *
     * <p>
     * Transforms adjacency cases like {@code 2(3+4}, {@code (2+3)(4+5)},
     * {@code 3(4)}
     * or {@code ) (} into an explicit form by inserting an "x" token between:
     * for example {@code ["2","(","3","+","4",")"]} ->
     * {@code ["2","x","(","3","+","4",")"]}.
     *
     * @param tokens list of tokens (numbers, operators, parentheses) produced by
     *               {@code tokenize}
     * @return a new list of tokens with implicit multiplications replaced by
     *         explicit "x" tokens
     */
    private static List<String> insertImplicitMultiplication(List<String> tokens) {
        List<String> out = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            String cur = tokens.get(i);

            if (!out.isEmpty()) {
                String prev = out.get(out.size() - 1);

                // If previous token is a number or ')' and current is a number or '(',
                // this is implicit multiplication: insert 'x' between them.
                boolean prevNumOrClose = isNumberToken(prev) || ")".equals(prev);
                boolean curNumOrOpen = isNumberToken(cur) || "(".equals(cur);

                if (prevNumOrClose && curNumOrOpen) {
                    out.add("x");
                }
            }

            out.add(cur);
        }
        return out;
    }

    /**
     * Convert an expression string into a list of canonical tokens.
     *
     * <p>
     * Output tokens are:
     * <ul>
     * <li>signed integer literals like "-123" or "456"</li>
     * <li>operator tokens: "+", "-", "x" (multiplication), ":" (division)</li>
     * <li>parentheses "(" and ")"</li>
     * </ul>
     *
     * <p>
     * Unary minus immediately preceding a number produces a single signed-number
     * token;
     * a unary minus before a parenthesis is emitted as a separate "-" token.
     *
     * @param expr the input expression string (operator synonyms will be
     *             normalized)
     * @return ordered list of token strings suitable for evaluation routines
     */
    public static List<String> tokenize(String expr) {
        expr = normalizeOperators(expr);
        List<String> tokens = new ArrayList<>();
        int i = 0;
        int n = expr.length();
        while (i < n) {
            char c = expr.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }
            if (c == '(' || c == ')') {
                tokens.add(String.valueOf(c));
                i++;
                continue;
            }
            if (c == '+' || c == 'x' || c == '*' || c == ':' || c == '/') {
                // treat '*' and '/' should have been normalized; but just in case:
                char op = c;
                if (c == '*')
                    op = 'x';
                if (c == '/')
                    op = ':';
                tokens.add(String.valueOf(op));
                i++;
                continue;
            }
            if (c == '-') {
                // unary minus if at start or after '(' or after another operator
                boolean unary = false;
                if (tokens.isEmpty())
                    unary = true;
                else {
                    String prev = tokens.get(tokens.size() - 1);
                    if ("(".equals(prev) || "+".equals(prev) || "-".equals(prev) || "x".equals(prev)
                            || ":".equals(prev)) {
                        unary = true;
                    }
                }
                if (unary) {
                    // capture sign and following number or parenthesis as separate token (for
                    // number case)
                    // If next non-space char is '(' then push unary '-' as separate token so that
                    // "( -3 )" handled when parsing parentheses.
                    int j = i + 1;
                    while (j < n && Character.isWhitespace(expr.charAt(j)))
                        j++;
                    if (j < n && Character.isDigit(expr.charAt(j))) {
                        // consume digits
                        int k = j;
                        StringBuilder num = new StringBuilder();
                        num.append('-');
                        while (k < n && Character.isDigit(expr.charAt(k))) {
                            num.append(expr.charAt(k));
                            k++;
                        }
                        tokens.add(num.toString());
                        i = k;
                    } else {
                        // treat '-' as operator token (will allow e.g., (-3) where '-' + '(' handled)
                        tokens.add("-");
                        i++;
                    }
                } else {
                    tokens.add("-");
                    i++;
                }
                continue;
            }
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < n && Character.isDigit(expr.charAt(i))) {
                    num.append(expr.charAt(i));
                    i++;
                }
                tokens.add(num.toString());
                continue;
            }
            // fallback (shouldn't reach due to validation)
            tokens.add(String.valueOf(c));
            i++;
        }
        // handle implicit multiplication such as: 2(3+4), (2+3)(4+5), 3(4) or )(
        return insertImplicitMultiplication(tokens);
    }

    // Simplify the expression exactly once (one step). Returns the new expression
    // string.
    // If no further simplification possible, returns the same expression.

    /**
     * Perform a single simplification step on an arithmetic expression string.
     *
     * <p>
     * The method:
     * <ol>
     * <li>reduces the innermost parenthesised subexpression to a single numeric
     * token
     * (evaluating it completely), or</li>
     * <li>performs the leftmost multiplication/division, or</li>
     * <li>performs the leftmost addition/subtraction</li>
     * </ol>
     * If no simplification is possible the original expression is returned.
     *
     * <p>
     * Tokenization and helper evaluation methods are used internally.
     *
     * @param expr the current expression string
     * @return a new expression string with one step simplified, or the original
     *         {@code expr} if nothing could be simplified
     * @throws ArithmeticException if a division by zero occurs while computing a
     *                             step
     */
    public static String simplifyOnce(String expr) {
        // Tokenize
        List<String> tokens = tokenize(expr);

        // First, find innermost parentheses pair
        int openIndex = -1;
        int closeIndex = -1;

        for (int i = 0; i < tokens.size(); i++) {
            if ("(".equals(tokens.get(i))) {
                openIndex = i;
            } else if (")".equals(tokens.get(i)) && openIndex != -1) {
                closeIndex = i;
                break;
            }
        }

        if (openIndex != -1 && closeIndex != -1) {
            // Extract sublist between openIndex+1 ... closeIndex-1
            List<String> sub = new ArrayList<>();
            for (int i = openIndex + 1; i < closeIndex; i++) {
                sub.add(tokens.get(i));
            }
            // If sub is empty -> replace "()" with "0"? But invalid per validation. We'll
            // just remove.
            if (sub.isEmpty()) {
                // remove the empty parentheses
                List<String> newTokens = new ArrayList<>();
                for (int i = 0; i < tokens.size(); i++) {
                    if (i == openIndex) {
                        i = closeIndex; // skip both
                        continue;
                    }
                    newTokens.add(tokens.get(i));
                }
                return joinTokens(newTokens);
            }

            // Evaluate the sub-expression fully (not step-by-step inside), producing a
            // single number token.
            String value = evaluateTokensFully(sub);
            // Replace tokens from openIndex...closeIndex with the value token (note: value
            // may be negative)
            List<String> newTokens = new ArrayList<>();
            for (int i = 0; i < openIndex; i++) {
                newTokens.add(tokens.get(i));
            }
            /*
             * If there is a '-' operator immediately before and it is a unary minus token
             * (i.e. a '-' operator token and previous token was operator or '('), keep it.
             * But our tokenization handles unary negatives inside numbers, so we just add
             * the numeric value token now.
             */
            newTokens.add(value);
            for (int i = closeIndex + 1; i < tokens.size(); i++) {
                newTokens.add(tokens.get(i));
            }
            return joinTokens(newTokens);
        }

        // No parentheses; perform a single operation according to precedence.
        // Prefer multiplication ('x') over division (':') for this single
        // simplification step.
        // Find the leftmost 'x', if none found then find the leftmost ':'.
        int idx = -1;
        // find leftmost multiplication 'x'
        for (int x = 0; x < tokens.size(); x++) {
            if ("x".equals(tokens.get(x))) {
                idx = x;
                break;
            }
        }
        // if no 'x' found, find leftmost division ':'
        if (idx == -1) {
            for (int k = 0; k < tokens.size(); k++) {
                if (":".equals(tokens.get(k))) {
                    idx = k;
                    break;
                }
            }
        }

        if (idx != -1) {
            // tokens idx-1 (lhs) and idx+1 (rhs) should exist (validation should guarantee
            // this)
            if (idx - 1 >= 0 && idx + 1 < tokens.size()) {
                String lhs = tokens.get(idx - 1);
                String rhs = tokens.get(idx + 1);
                String result = computeBinary(lhs, tokens.get(idx), rhs);
                List<String> newTokens = new ArrayList<>();
                for (int j = 0; j < idx - 1; j++) {
                    newTokens.add(tokens.get(j));
                }
                newTokens.add(result);
                for (int j = idx + 2; j < tokens.size(); j++) {
                    newTokens.add(tokens.get(j));
                }
                return joinTokens(newTokens);
            }
        }

        // No mult/div found; perform first addition/subtraction left-to-right
        for (int i = 0; i < tokens.size(); i++) {
            String t = tokens.get(i);
            if ("+".equals(t) || "-".equals(t)) {
                if (i - 1 < 0 || i + 1 >= tokens.size()) {
                    continue;
                }

                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                String result = computeBinary(lhs, t, rhs);
                List<String> newTokens = new ArrayList<>();

                for (int j = 0; j < i - 1; j++) {
                    newTokens.add(tokens.get(j));
                }
                newTokens.add(result);
                for (int j = i + 2; j < tokens.size(); j++) {
                    newTokens.add(tokens.get(j));
                }

                return joinTokens(newTokens);
            }
        }

        // Nothing to simplify (maybe a single number)
        return expr;
    }

    /**
     * Evaluate a token list fully and return a single numeric token string.
     *
     * <p>
     * This performs:
     * <ol>
     * <li>resolution of any parenthesis (recursively),</li>
     * <li>multiplication/division left-to-right,</li>
     * <li>addition/subtraction left-to-right.</li>
     * </ol>
     *
     * <p>
     * All arithmetic is integer arithmetic using {@code long}; division is integer
     * division. The returned string represents the final integer value (could be
     * negative).
     *
     * @param tokensIn list of tokens representing a (sub)expression without
     *                 external context
     * @return the single numeric string representing the evaluated value
     * @throws ArithmeticException   if division by zero occurs
     * @throws NumberFormatException if an integer token cannot be parsed as long
     */
    public static String evaluateTokensFully(List<String> tokensIn) {
        // Make a mutable copy
        List<String> tokens = new ArrayList<>(tokensIn);

        // First, if there are parentheses inside, recursively resolve them (shouldn't
        // happen here because we only call for innermost).
        // But be safe:
        while (tokens.contains("(")) {
            // find innermost '(' index (last '(') and its matching ')'
            int open = -1, close = -1;
            for (int i = 0; i < tokens.size(); i++) {
                if ("(".equals(tokens.get(i)))
                    open = i;
            }
            if (open == -1)
                break;
            for (int i = open + 1; i < tokens.size(); i++) {
                if (")".equals(tokens.get(i))) {
                    close = i;
                    break;
                }
            }
            if (close == -1)
                break;

            // extract subexpression between open+1 ... close-1
            List<String> sub = new ArrayList<>();
            for (int i = open + 1; i < close; i++)
                sub.add(tokens.get(i));

            // evaluate subexpression fully to a single token
            String val = evaluateTokensFully(sub);

            // rebuild tokens: prefix + val + suffix
            List<String> newT = new ArrayList<>();
            for (int i = 0; i < open; i++)
                newT.add(tokens.get(i));
            newT.add(val);
            for (int i = close + 1; i < tokens.size(); i++)
                newT.add(tokens.get(i));

            tokens = newT;
        }

        // Evaluate multiplications first (leftmost 'x' repeatedly), then divisions.
        // We loop: as long as there is any 'x', do the leftmost one; when no 'x'
        // remains,
        // perform leftmost ':' operations until none remain.
        while (true) {
            // find leftmost multiplication 'x'
            int idxX = -1;
            for (int i = 0; i < tokens.size(); i++) {
                if ("x".equals(tokens.get(i))) {
                    idxX = i;
                    break;
                }
            }
            if (idxX != -1) {
                // perform the multiplication
                String lhs = tokens.get(idxX - 1);
                String rhs = tokens.get(idxX + 1);
                String res = computeBinary(lhs, "x", rhs);
                List<String> newTokens = new ArrayList<>();
                for (int j = 0; j < idxX - 1; j++)
                    newTokens.add(tokens.get(j));
                newTokens.add(res);
                for (int j = idxX + 2; j < tokens.size(); j++)
                    newTokens.add(tokens.get(j));
                tokens = newTokens;
                // continue loop to prefer more multiplications
                continue;
            }

            // no multiplication left; find leftmost division ':'
            int idxDiv = -1;
            for (int i = 0; i < tokens.size(); i++) {
                if (":".equals(tokens.get(i))) {
                    idxDiv = i;
                    break;
                }
            }
            if (idxDiv != -1) {
                String lhs = tokens.get(idxDiv - 1);
                String rhs = tokens.get(idxDiv + 1);
                String res = computeBinary(lhs, ":", rhs);
                List<String> newTokens = new ArrayList<>();
                for (int j = 0; j < idxDiv - 1; j++)
                    newTokens.add(tokens.get(j));
                newTokens.add(res);
                for (int j = idxDiv + 2; j < tokens.size(); j++)
                    newTokens.add(tokens.get(j));
                tokens = newTokens;
                // after division, loop again to check for any remaining multiplications
                continue;
            }

            // no multiplications or divisions left
            break;
        }

        // Then addition/subtraction left->right
        for (int i = 0; i < tokens.size();) {
            String t = tokens.get(i);

            // defensive guards: ensure lhs and rhs exist
            if ("+".equals(t) || "-".equals(t)) {
                if (i - 1 < 0 || i + 1 >= tokens.size()) {
                    // malformed sequence; skip this operator safely
                    i++;
                    continue;
                }

                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                String res = computeBinary(lhs, t, rhs);

                List<String> newTokens = new ArrayList<>();
                for (int j = 0; j < i - 1; j++)
                    newTokens.add(tokens.get(j));
                newTokens.add(res);
                for (int j = i + 2; j < tokens.size(); j++)
                    newTokens.add(tokens.get(j));

                tokens = newTokens;
                i = 0; // restart scanning from left after replacement
            } else {
                i++;
            }
        }

        // At the end we should have a single token which is a number
        if (tokens.size() != 1) {
            // Something went wrong; fallback try to compute left-to-right
            while (tokens.size() > 1) {
                String lhs = tokens.get(0);
                String op = tokens.get(1);
                String rhs = tokens.get(2);
                String res = computeBinary(lhs, op, rhs);
                List<String> newT = new ArrayList<>();
                newT.add(res);
                for (int j = 3; j < tokens.size(); j++)
                    newT.add(tokens.get(j));
                tokens = newT;
            }
        }
        return tokens.get(0);
    }

    /**
     * Compute a binary operation between two numeric string tokens using integer
     * arithmetic.
     *
     * <p>
     * Supported operators:
     * <ul>
     * <li>"x" -> multiplication</li>
     * <li>":" -> integer division (throws ArithmeticException on divide by
     * zero)</li>
     * <li>"+" -> addition</li>
     * <li>"-" -> subtraction</li>
     * </ul>
     *
     * @param lhsStr left-hand side numeric token (could be signed)
     * @param op     operator token ("x", ":", "+", or "-")
     * @param rhsStr right-hand side numeric token (could be signed)
     * @return numeric result as a string
     * @throws ArithmeticException   for division by zero
     * @throws NumberFormatException if inputs are not valid integers
     */
    public static String computeBinary(String lhsStr, String op, String rhsStr) {
        long lhs = parseLongSafe(lhsStr);
        long rhs = parseLongSafe(rhsStr);

        switch (op) {
            case "x":
                return Long.toString(lhs * rhs);
            case ":":
                if (rhs == 0)
                    throw new ArithmeticException("Division by zero");
                return Long.toString(lhs / rhs); // integer division
            case "+":
                return Long.toString(lhs + rhs);
            case "-":
                return Long.toString(lhs - rhs);
            default:
                // Unexpected operator
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    /**
     * Parse a string into a {@code long}, trimming whitespace and treating an
     * empty string as zero.
     *
     * @param s string containing an integer (possibly with leading/trailing spaces)
     * @return parsed long value
     * @throws NumberFormatException if {@code s} (after trim) is not a valid
     *                               integer
     */
    public static long parseLongSafe(String s) {
        // s may include spaces, but tokenization shouldn't have them
        s = s.trim();
        if (s.length() == 0)
            return 0;
        return Long.parseLong(s);
    }

    /**
     * Join tokens into a single expression string with single-space separators.
     *
     * <p>
     * This helper is used to reconstruct expressions after token-level
     * modifications.
     *
     * @param tokens list of token strings
     * @return single string expression with tokens separated by one space
     */
    public static String joinTokens(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.size(); i++) {
            String t = tokens.get(i);
            // Avoid inserting unnecessary spaces for negative numbers: keep tokens joined
            // with single space
            if (i > 0)
                sb.append(' ');
            sb.append(t);
        }
        return sb.toString();
    }

    /**
     * Produce a nicely spaced string representation of an expression.
     *
     * <p>
     * Tokenizes the expression and joins tokens with single spaces to normalize
     * inconsistent spacing around operators and parentheses.
     *
     * @param expr input expression (possibly with irregular spacing)
     * @return expression string with normalized spacing (single spaces between
     *         tokens)
     */
    public static String normalizeSpacing(String expr) {
        // Normalize spaces around operators and parentheses for nicer output
        List<String> tokens = tokenize(expr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.size(); i++) {
            if (i > 0)
                sb.append(' ');
            sb.append(tokens.get(i));
        }
        return sb.toString().replaceAll("\\s+", " ").trim();
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Methods for the selectMenu("secondary school") call

    // ---------------------- MENU (Option C) ----------------------

    /**
     * Presents the High School submenu for Option C.
     * Lists:
     *  - Statistical Information about an Array
     *  - Distance between Two Arrays
     *  - Return to Main Menu
     * Clears the console on entry.
     * @author Sena Berra Soydugan
     */
    public static void selectMenuHighSchool() {
        clearScreen();
        while (true) {
            System.out.println("High School Menu (Option C)");
            System.out.println("---------------------------");
            System.out.println("1) Statistical Information about an Array");
            System.out.println("2) Distance between Two Arrays");
            System.out.println("0) Return to Main Menu");
            int choice = readIntInRange("Select: ", 0, 2);
            switch (choice) {
                case 1 -> arrayStat();
                case 2 -> arraysDistance();
                case 0 -> {
                    clearScreen();
                    return; // Return to Main Menu
                }
            }
            System.out.println();
        }
    }

    // ------------------ 1) ARRAY STATISTICS ---------------------

    /**
     * Asks the user for array size and elements (double), then computes:
     *  - Median (for even n: average of the two middle values)
     *  - Arithmetic mean
     *  - Geometric mean (defined only if all elements > 0)
     *  - Harmonic mean (computed recursively; undefined if any element == 0)
     * Clears the console on entry.
     * @author Sena Berra Soydugan
     */
    public static void arrayStat() {
        clearScreen();
        System.out.println("High School > Statistical Information About an Array");
        System.out.println("----------------------------------------------------");

        int n = readPositiveInt("Enter array size (n >= 1): ");

        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = readDouble("Enter element #" + (i + 1) + " (double): ");
        }

        // Sort copy for median
        double[] s = Arrays.copyOf(a, n);
        Arrays.sort(s);

        // Arithmetic mean
        double sum = 0.0;
        for (double v : a) sum += v;
        double mean = sum / n;

        // Median
        double median = medianSorted(s);

        // Geometric mean (only if all > 0)
        Double gMean = geometricMean(a);

        // Harmonic mean via recursion (undefined if any == 0)
        Double hMean = harmonicMeanRecursive(a);

        // Output
        System.out.println();
        System.out.println("Results");
        System.out.println("-------");
        System.out.printf("Count (n)         : %d%n", n);
        System.out.printf("Mean (Arithmetic) : %.6f%n", mean);
        System.out.printf("Median            : %.6f%n", median);
        if (gMean == null) {
            System.out.println("Geometric Mean    : undefined (all elements must be > 0)");
        } else {
            System.out.printf("Geometric Mean    : %.6f%n", gMean);
        }
        if (hMean == null) {
            System.out.println("Harmonic Mean     : undefined (no element may be zero)");
        } else {
            System.out.printf("Harmonic Mean     : %.6f%n", hMean);
        }
    }

    /**
     * Computes the median of a sorted array.
     * For even n, returns the average of the two middle values.
     * @param sorted an already sorted double[] (ascending)
     * @return the median value of the array as double
     * @author Sena Berra Soydugan
     */
    public static double medianSorted(double[] sorted) {
        int n = sorted.length;
        return (n % 2 == 1) ? sorted[n / 2]
                            : (sorted[n / 2 - 1] + sorted[n / 2]) / 2.0;
    }

    /**
     * Computes the geometric mean of array a.
     * Returns null if any element &le; 0 (undefined).
     * @param a input array of doubles
     * @return geometric mean as Double, or null if undefined (any a[i] &le; 0)
     * @author Sena Berra Soydugan
     */
    public static Double geometricMean(double[] a) {
        double logSum = 0.0;
        for (double v : a) {
            if (v <= 0.0) return null;
            logSum += Math.log(v);
        }
        return Math.exp(logSum / a.length);
    }

    /**
     * Computes the harmonic mean of array a using recursion to sum reciprocals.
     * Returns null if any element equals zero.
     * @param a input array of doubles
     * @return harmonic mean as Double, or null if undefined (any a[i] == 0)
     * @author Sena Berra Soydugan
     */
    public static Double harmonicMeanRecursive(double[] a) {
        for (double v : a) if (v == 0.0) return null;
        double recSum = reciprocalSum(a, 0);
        return a.length / recSum;
    }

    /**
     * Recursive helper that returns the sum of reciprocals of a[i..end].
     * @param a input array of doubles
     * @param i starting index (0 &le; i &le; a.length)
     * @return sum_{k=i}^{n-1} (1 / a[k]); returns 0 when i == a.length
     * @author Sena Berra Soydugan
     */
    public static double reciprocalSum(double[] a, int i) {
        if (i == a.length) return 0.0;
        return (1.0 / a[i]) + reciprocalSum(a, i + 1);
    }

    // -------------- 2) DISTANCE BETWEEN TWO ARRAYS ---------------

    /**
     * Reads dimension n, then two integer arrays A and B (each entry in [0..9]).
     * Invalid entries trigger a warning and a retry.
     * Computes and prints:
     *  - Manhattan distance
     *  - Euclidean distance
     *  - Cosine similarity and Cosine distance (= 1 - similarity)
     * Clears the console on entry.
     * @author Sena Berra Soydugan
     */
    public static void arraysDistance() {
        clearScreen();
        System.out.println("High School > Distance Between Two Arrays");
        System.out.println("-----------------------------------------");

        int n = readPositiveInt("Enter dimension (n >= 1): ");

        int[] A = readIntArrayDigits("Enter elements for Array A (each in [0-9])", n, 0, 9);
        int[] B = readIntArrayDigits("Enter elements for Array B (each in [0-9])", n, 0, 9);

        // Manhattan
        long manhattan = 0;
        for (int i = 0; i < n; i++) manhattan += Math.abs(A[i] - B[i]);

        // Euclidean
        long sq = 0;
        for (int i = 0; i < n; i++) {
            int d = A[i] - B[i];
            sq += (long) d * d;
        }
        double euclidean = Math.sqrt(sq);

        // Cosine similarity
        long dot = 0, normA2 = 0, normB2 = 0;
        for (int i = 0; i < n; i++) {
            dot    += (long) A[i] * B[i];
            normA2 += (long) A[i] * A[i];
            normB2 += (long) B[i] * B[i];
        }
        Double cosSim = null, cosDist = null;
        if (normA2 != 0 && normB2 != 0) {
            cosSim  = dot / (Math.sqrt(normA2) * Math.sqrt(normB2));
            cosDist = 1.0 - cosSim;
        }

        // Output
        System.out.println();
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Manhattan (L1)    : " + manhattan);
        System.out.printf("Euclidean (L2)    : %.6f%n", euclidean);
        if (cosSim == null) {
            System.out.println("Cosine Similarity : undefined (a zero vector encountered)");
            System.out.println("Cosine Distance   : undefined");
        } else {
            System.out.printf("Cosine Similarity : %.6f%n", cosSim);
            System.out.printf("Cosine Distance   : %.6f%n", cosDist);
        }
    }

    // ---------------------- INPUT HELPERS ------------------------

    /**
     * Prompts the user until a valid integer >= 1 is entered.
     * @param prompt message shown to the user
     * @return an integer value v such that v >= 1
     * @author Sena Berra Soydugan
     */
    public static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= 1) return v;
                System.out.println("Invalid input. Please enter an integer >= 1.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    /**
     * Prompts for an integer in the inclusive range [min, max].
     * Retries until valid.
     * @param prompt message shown to the user
     * @param min minimum allowed integer (inclusive)
     * @param max maximum allowed integer (inclusive)
     * @return an integer v such that min &le; v &le; max
     * @author Sena Berra Soydugan
     */
    public static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max) return v;
                System.out.println("Invalid input. Enter an integer in [" + min + "," + max + "].");
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    /**
     * Prompts for a double; retries until a valid double is entered.
     * @param prompt message shown to the user
     * @return the parsed double value (e.g., 3.14, -2.0)
     * @author Sena Berra Soydugan
     */
    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid double. Try e.g. 3.14 or -2");
            }
        }
    }

    /**
     * Reads an integer array of length n; each element must lie in [min, max].
     * Invalid entries trigger a warning and a retry.
     * @param head title/info message displayed to the user
     * @param n number of array elements to read (n >= 1)
     * @param min inclusive minimum allowed value per element
     * @param max inclusive maximum allowed value per element
     * @return an int[] of length n with each entry in [min, max]
     * @author Sena Berra Soydugan
     */
    public static int[] readIntArrayDigits(String head, int n, int min, int max) {
        System.out.println(head + " -> total " + n + " items.");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readIntInRange("  value[" + (i + 1) + "] = ", min, max);
        }
        return arr;
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Methods for the method selectMenuUniversity()

    // The Constants
    /**
     * A char constant representing both the player 1 itself and their mark to be
     * placed on the game board
     *
     */
    public static final char MARK_PLAYER_1 = '1';

    /**
     * A char constant representing both the player 2 itself and their mark to be
     * placed on the game board
     *
     */
    public static final char MARK_PLAYER_2 = '2';

    /**
     * A char constant representing both the user computer and their mark to be
     * placed on the game board
     *
     */
    public static final char MARK_COMPUTER = 'B'; // (Stands for bot)

    /**
     * A char constant representing the empty slots on the game board
     *
     */
    public static final char EMPTY_CELL = ' ';

    /**
     * Handles the setup (board size, game mode) for Connect Four and then launches
     * the game.
     *
     * @author Emre Mekec
     */
    public static void connectFour() {
        String dimension = " ";
        String gameMode = " ";

        // Board Size Selection Phase
        while (dimension.equals(" ")) {
            clearScreen();
            showDimensionsConnectFour();
            dimension = selectDimensionConnectFour();
        }

        // Game Mode Selection Phase
        while (gameMode.equals(" ")) {
            clearScreen();
            showModesConnectFour();
            gameMode = selectModeConnectFour();
        }

        // Start the Game
        switch (dimension) {
            case "7x6":
                gameLoop(7, 6, gameMode);
                break;
            case "6x5":
                gameLoop(6, 5, gameMode);
                break;
            case "5x4":
                gameLoop(5, 4, gameMode);
                break;
        }
    }

    /**
     * Shows the dimension options for connect four.
     *
     * @author Emre Mekec
     */
    public static void showDimensionsConnectFour() {
        System.out.println("--- Connect Four: Board Sizes ---");
        System.out.println("[A] 5x4 (5 Rows, 4 Cols)");
        System.out.println("[B] 6x5 (6 Rows, 5 Cols)");
        System.out.println("[C] 7x6 (7 Rows, 6 Cols)");
    }

    /**
     * Selects the dimension for connect four.
     *
     * @return A String value representing the dimension selection
     * @author Emre Mekec
     */
    public static String selectDimensionConnectFour() {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();

        switch (choice) {
            case "A":
                return "5x4";
            case "B":
                return "6x5";
            case "C":
                return "7x6";
            default:
                System.out.println("Invalid choice. Please try again.");
                waitMillis(DELAY_AMOUNT);
        }

        return " ";
    }

    /**
     * Shows the game modes for connect four.
     *
     * @author Emre Mekec
     */
    public static void showModesConnectFour() {
        System.out.println("--- Connect Four: Game Modes ---");
        System.out.println("[A] Single-Player (vs. Computer)");
        System.out.println("[B] Two-Players");
    }

    /**
     * Selects the game mode for connect four.
     *
     * @return A String value representing the game mode selection, if successfully
     *         made.
     *         Defaults to empty string, representing the need to try again.
     * @author Emre Mekec
     */
    public static String selectModeConnectFour() {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();

        switch (choice) {
            case "A":
                return "singleplayer";
            case "B":
                return "multiplayer";
            default:
                System.out.println("Invalid choice. Please try again.");
                waitMillis(DELAY_AMOUNT);
        }

        return " ";
    }

    /**
     * The main game loop for Connect Four
     *
     * @param rows     The number of rows in the board
     * @param cols     The number of columns in the board
     * @param gameMode 1 for single-player, 2 for two-player
     * @author Emre Mekec
     */
    public static void gameLoop(int rows, int cols, String gameMode) {
        char[][] board = initializeBoard(rows, cols);
        boolean isConcluded = false;
        char currentPlayer = MARK_PLAYER_1; // First, player 1 puts their mark.

        while (!isConcluded) {
            clearScreen();
            printBoard(board);

            int colSelected;

            if (gameMode.equals("multiplayer")) {
                colSelected = getPlayerMove(board, currentPlayer);
            } else {
                if (currentPlayer == MARK_PLAYER_1) {
                    colSelected = getPlayerMove(board, currentPlayer);
                } else {
                    colSelected = getComputerMove(board);
                    waitMillis(DELAY_AMOUNT / 2); // The bot is thinking.
                    System.out.println("Computer (Y) chose column " + (colSelected + 1));
                    waitMillis(DELAY_AMOUNT);
                }
            }

            // Check for forfeit
            if (colSelected == -1) {
                System.out.println("Player " + currentPlayer + " has forfeited the game.");
                return;
            }

            insertMark(board, colSelected, currentPlayer); // Insert the mark on the board

            // Check for the win conditions
            if (checkWin(board, currentPlayer)) {
                clearScreen();
                printBoard(board);
                System.out.println("\nPlayer " + currentPlayer + " won!\n");
                isConcluded = true;
            } else if (isBoardFull(board)) {
                clearScreen();
                printBoard(board);
                System.out.println("\nDraw!\n");
                isConcluded = true;
            } else {
                // Switch players
                if (currentPlayer == MARK_PLAYER_1) {
                    currentPlayer = (gameMode.equals("singleplayer")) ? MARK_COMPUTER : MARK_PLAYER_2;
                } else {
                    currentPlayer = MARK_PLAYER_1;
                }
            }
        }
    }

    /**
     * Creates a new Connect Four board filled with empty slots.
     *
     * @param rows Number of rows
     * @param cols Number of columns
     * @return The initialized 2D char array
     * @author Emre Mekec
     */
    public static char[][] initializeBoard(int rows, int cols) {
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
        return board;
    }

    /**
     * Prints the Connect Four board to the console.
     *
     * @param board The current game board
     * @author Emre Mekec
     */
    public static void printBoard(char[][] board) {
        System.out.println();
        int cols = board[0].length;

        for (char[] chars : board) {
            System.out.print("| ");
            for (int i = 0; i < cols; i++) {
                System.out.print(chars[i] + " | ");
            }
            System.out.println();
        }

        for (int j = 0; j < cols; j++) {
            System.out.print("----");
        }
        System.out.println("-");

        // Display the columns numbers
        System.out.print("  ");
        for (int j = 0; j < cols; j++) {
            System.out.print((j + 1) + "   ");
        }
        System.out.println("\n");
    }

    /**
     * Gets a valid column move from a human player
     *
     * @param board  The current game board
     * @param player A character value representing the player
     * @return The 0-based column index, or -1 as the sentinel value if the player
     *         quits
     * @author Emre Mekec
     */
    public static int getPlayerMove(char[][] board, char player) {
        int cols = board[0].length;
        while (true) {
            System.out.print("Player " + player + ", enter column (1-" + cols + ") or 'Q' to quit: ");
            String input = SC.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                return -1; // Forfeit
            }

            try {
                int col = Integer.parseInt(input) - 1; // Convert to 0-based index

                if (col < 0 || col >= cols) {
                    System.out.println("Invalid column. Please choose between 1 and " + cols + ".");
                } else if (!isAllowed(board, col)) {
                    System.out.println("Column " + (col + 1) + " is full. Please choose another.");
                } else {
                    return col;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Gets a valid random column move for the computer
     *
     * @param board The current game board
     * @return The 0-based column index
     * @author Emre Mekec
     */
    public static int getComputerMove(char[][] board) {
        int cols = board[0].length;
        while (true) {
            int col = RAND.nextInt(cols); // Pick a random column number from 0 to cols-1
            if (isAllowed(board, col))
                return col;
            // If column is not available, try again.
        }
    }

    /**
     * Checks if a move is valid (i.e., the column is not full).
     *
     * @param board The current game board
     * @param col   The 0-based column index
     * @return true if the column is not full, false otherwise
     * @author Emre Mekec
     */
    public static boolean isAllowed(char[][] board, int col) {
        return board[0][col] == EMPTY_CELL; // If the top row of the selected column is not free, this will return
                                            // false, meaning it's not allowed.
    }

    /**
     * Inserts a mark into the specified column.
     *
     * @param board      The game board (will be modified)
     * @param col        The 0-based column index
     * @param playerMark A char value representing player's mark
     * @author Emre Mekec
     */
    public static void insertMark(char[][] board, int col, char playerMark) {
        int rows = board.length;

        for (int i = rows - 1; i >= 0; i--) {
            if (board[i][col] == EMPTY_CELL) {
                board[i][col] = playerMark;
                return;
            }
        }
    }

    /**
     * Checks the entire board for a 4-in-a-row win for the specified player.
     *
     * @param board      The current game board
     * @param playerMark A char value representing the player's mark to check for
     * @return true if a win is found, false otherwise
     * @author Emre Mekec
     */
    public static boolean checkWin(char[][] board, char playerMark) {
        int rows = board.length;
        int cols = board[0].length;

        // Checking the Horizontals
        for (char[] chars : board) {
            for (int j = 0; j <= cols - 4; j++) {
                if (chars[j] == playerMark && chars[j + 1] == playerMark && chars[j + 2] == playerMark
                        && chars[j + 3] == playerMark)
                    return true;
            }
        }

        // Checking the Verticals
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i <= rows - 4; i++) {
                if (board[i][j] == playerMark && board[i + 1][j] == playerMark && board[i + 2][j] == playerMark
                        && board[i + 3][j] == playerMark)
                    return true;
            }
        }

        // Checking the Diagonals from the Bottom Left to the Top Right
        for (int i = 3; i < rows; i++) { // Start from row 3 (0-indexed)
            for (int j = 0; j <= cols - 4; j++) {
                if (board[i][j] == playerMark && board[i - 1][j + 1] == playerMark && board[i - 2][j + 2] == playerMark
                        && board[i - 3][j + 3] == playerMark)
                    return true;
            }
        }

        // Checking the Diagonals from the Top Left to the Bottom Right
        for (int i = 0; i <= rows - 4; i++) {
            for (int j = 0; j <= cols - 4; j++) {
                if (board[i][j] == playerMark && board[i + 1][j + 1] == playerMark && board[i + 2][j + 2] == playerMark
                        && board[i + 3][j + 3] == playerMark)
                    return true;
            }
        }

        return false;
    }

    /**
     * Checks if the board is completely full (a draw condition).
     *
     * @param board The current game board
     * @return true if the board is full, false otherwise
     * @author Emre Mekec
     */
    public static boolean isBoardFull(char[][] board) {
        int cols = board[0].length;
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == EMPTY_CELL)
                return false;
        }
        return true;
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Helpers

    /**
     * Clears the screen.
     *
     * @author Muhammed Izaan
     */
    public static void clearScreen() {
        // Try ANSI clear; may not work in some consoles but is widely supported
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }

    /**
     * Waits for a specified amount of time.
     *
     * @param periodMillis A variable to specify the time in milliseconds that
     *                     program will wait whenever the method is called.
     * @author Emre Mekec
     */
    public static void waitMillis(long periodMillis) {
        try {
            // Thread.sleep() accepts the period in milliseconds (long type)
            Thread.sleep(periodMillis);
        } catch (InterruptedException e) {
            // Always reset the interrupt status when catching InterruptedException
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Prompts the user for a keystroke "ENTER" to proceed so that they will have
     * the time to stop before moving on whatever's next after something's done.
     *
     * @author Emre Mekec
     */
    public static void waitBeforeProceed() {
        System.out.println("Press ENTER when you want to proceed...");
        SC.nextLine();
    }
}

