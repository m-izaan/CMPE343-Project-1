import java.nio.charset.StandardCharsets; //needed to scan for strings.
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException; //needed for the method waitForProceed().

public class Project1 {
    // Global Constants
    private static final Scanner SC = new Scanner(System.in, StandardCharsets.UTF_8);
    private static final Random RAND = new Random();
    private static final long delayAmount = 500;

    // Global Constants for connectFour
    private static final char PLAYER_ONE_DISC = 'R'; // Player 1 (Red)
    private static final char PLAYER_TWO_DISC = 'Y'; // Player 2 (Yellow)
    private static final char COMPUTER_DISC = 'Y'; // Computer (Yellow)
    private static final char EMPTY_SLOT = ' ';
    private static final int GAME_MODE_SINGLE_PLAYER = 1;
    private static final int GAME_MODE_TWO_PLAYER = 2;

    // Global Variables
    static int Primes[];
    static int count = 0;

    // Main Method
    public static void main(String[] args) {
        menuMain();
        clearScreen();
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Menu Logic
    public static void menuMain() {
        boolean running = true;
        while (running) {
            showInitialScreen();
            running = selectMenuMain();
        }
    }

    public static void showInitialScreen() {
        clearScreen();
        showWelcome();
        showMenuMain();
    }

    public static void showWelcome() {
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

    public static void showMenuMain() {
        System.out.println("Main Menu - Select an option:");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School");
        System.out.println("[C] High School");
        System.out.println("[D] University");
        System.out.println("[E] Terminate");
    }

    public static boolean selectMenuMain() {
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
                waitMillis(delayAmount);
                return false;
            default:
                System.out.println("Invalid option. Please select A, B, C, D or E.");
        }
        return true;
    }

    public static void menuPrimarySchool() {
        boolean running = true;
        while (running) {
            showMenuPrimarySchool();
            running = selectMenuPrimarySchool();
        }
    }

    public static void showMenuPrimarySchool() {
        clearScreen();
        System.out.println("Sub Menu - Primary School - Select an option:");
        System.out.println("[A] Age and Zodiac Sign Detection");
        System.out.println("[B] Reverse the Words");
        System.out.println("[C] Return to the Main Menu");
    }

    public static boolean selectMenuPrimarySchool() {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();
        switch (choice) {
            case "A":
                ageZodiac();
                waitBeforeProceed();
                break;
            case "B":
                reverseWords();
                waitBeforeProceed();
                break;
            case "C":
                System.out.println("Returning to main menu...");
                waitMillis(delayAmount);
                return false;
            default:
                System.out.println("Invalid option. Please select A, B, or C.");
        }

        return true;
    }

    public static void menuSecondarySchool() {
        boolean running = true;
        while (running) {
            showMenuSecondarySchool();
            running = selectMenuSecondarySchool();
        }
    }

    public static void showMenuSecondarySchool() {
        clearScreen();
        System.out.println("Sub Menu - Secondary School - Select an option:");
        System.out.println("[A] Prime Numbers");
        System.out.println("[B] Step by Step Evaluation of Expression");
        System.out.println("[C] Return to Main Menu");
    }

    public static boolean selectMenuSecondarySchool() {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();
        switch (choice) {
            case "A":
                primeNumbers();
                waitBeforeProceed();
                break;
            case "B":
                evalExpression();
                waitBeforeProceed();
                break;
            case "C":
                System.out.println("Returning to Main Menu");
                waitMillis(delayAmount);
                return false;
            default:
                System.out.println("Invalid option. Please select A, B, or C.");
        }

        return true;
    }

    public static void menuHighSchool() {
        boolean running = true;
        while (running) {
            showMenuHighSchool();
            running = selectMenuHighSchool();
        }
    }

    public static void showMenuHighSchool() {
        clearScreen();
        System.out.println("Sub Menu - High School - Select an option:");
        System.out.println("[A] Statistical Information About an Array");
        System.out.println("[B] Distance Between Two Arrays");
        System.out.println("[C] Return to Main Menu");
    }

    public static boolean selectMenuHighSchool() {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();
        switch (choice) {
            case "A":
                arrayStat();
                waitBeforeProceed();
                break;
            case "B":
                arraysDistance();
                waitBeforeProceed();
                break;
            case "C":
                System.out.println("Returning to main menu...");
                waitMillis(delayAmount);
                return false;
            default:
                System.out.println("Invalid option. Please select A, B, or C.");
        }

        return true;
    }

    public static void menuUniversity() {
        boolean running = true;
        while (running) {
            showMenuUniversity();
            running = selectMenuUniversity();
        }
    }

    public static void showMenuUniversity() {
        clearScreen();
        System.out.println("Sub Menu - University - Select an option:");
        System.out.println("[A] Play Connect Four");
        System.out.println("[B] Return to Main Menu");
    }

    public static boolean selectMenuUniversity() {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();
        switch (choice) {
            case "A":
                connectFour();
                waitBeforeProceed();
                break;
            case "B":
                System.out.println("Returning to main menu...");
                waitMillis(delayAmount);
                return false;
            default:
                System.out.println("Invalid option. Please select A or B.");
                waitMillis(delayAmount);
        }

        return true;
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Methods for selectPrimarySchool()
    public static void ageZodiac() {
        // Get the birthdate from user
        int year = getYear();
        int month = getMonth(year);
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

    private static int getYear() {
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

    private static int getMonth(int year) {
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

    private static int getDay(int month, int year) {
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

    private static boolean isLeapYear(int year) {
        // A year is a leap year if:
        // It is divisible by 4 AND not divisible by 100
        // OR it is divisible by 400

        boolean divisibleBy4 = (year % 4 == 0);
        boolean divisibleBy100 = (year % 100 == 0);
        boolean divisibleBy400 = (year % 400 == 0);

        if (divisibleBy400) {
            return true;
        }

        if (divisibleBy4 && !divisibleBy100) {
            return true;
        }

        return false;
    }

    private static int daysInMonth(int month, int year) {
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

    private static String getZodiacSign(int day, int month) {
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

    // Recursive reverse function
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

    private static boolean isTurkishLetter(char c) {
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

    private static String reverseRecursive(String s) {
        if (s.isEmpty())
            return s;
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Methods for secondarySchool

    // All 3 Algorithm for Finding Prime Numbers

    // EratosthenesFormula
    public static int[] eratosthenesFormula(int n) {
        boolean isPrime[] = new boolean[n + 1];
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

    // Sieve of Sundaram

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

        // Use a boolean marker array indexed 0..k (we'll ignore index 0 in marking
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

    // Sieve of Atkin

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

    private static String firstK(int[] arr, int k) {
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

    private static String lastK(int[] arr, int k) {
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

    private static String fmtMs(double ms) {
        return String.format("%.3f", ms);
    }

    // Prime Numbers main function
    public static void primeNumbers() {

        int num = 0;

        while (true) {
            System.out.print("Enter an integer n (n >= 12): ");
            String line = SC.nextLine().trim();
            try {
                num = Integer.parseInt(line);
                if (num >= 12) {
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

    // Replace the existing empty evalExpression() with the following methods:

    public static void evalExpression() {
        clearScreen();
        System.out.println("Step-by-step Evaluation of Expression");
        System.out.println("Allowed characters: digits, +, -, x (or X, *, ×), : (or /), (, )");
        System.out.println("Unary minus is allowed (e.g. -3). Leading '+' is considered invalid per spec.\n");

        String expr;
        while (true) {
            System.out.print("Enter expression: ");
            expr = SC.nextLine().trim();
            if (expr.length() == 0) {
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

    private static String normalizeOperators(String s) {
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

    private static boolean isValidExpression(String s) {
        // Allowed chars: digits, spaces, + - x X * × : / ( )
        // Normalize for checks
        if (s.trim().length() == 0)
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
                        prevIsOp = true;
                        continue;
                    } else {
                        // binary minus
                        prevIsOp = true;
                        continue;
                    }
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

    // Convert expression string to canonical tokens (numbers, operators,
    // parentheses).
    // Returns list of tokens in order. Numbers are signed integers as full token
    // strings.
    private static List<String> tokenize(String expr) {
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
                        continue;
                    } else {
                        // treat '-' as operator token (will allow e.g., (-3) where '-' + '(' handled)
                        tokens.add("-");
                        i++;
                        continue;
                    }
                } else {
                    tokens.add("-");
                    i++;
                    continue;
                }
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
        return tokens;
    }

    // Simplify the expression exactly once (one step). Returns the new expression
    // string.
    // If no further simplification possible, returns the same expression.
    private static String simplifyOnce(String expr) {
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
            // Extract sublist between openIndex+1 .. closeIndex-1
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
            // Replace tokens from openIndex..closeIndex with the value token (note: value
            // may be negative)
            List<String> newTokens = new ArrayList<>();
            for (int i = 0; i < openIndex; i++) {
                newTokens.add(tokens.get(i));
            }
            /* If there is a '-' operator immediately before and it is a unary minus token (i.e. a '-' operator token and previous token was operator or '('), keep it.
               But our tokenization handles unary negatives inside numbers, so we just add the numeric value token now. */
            newTokens.add(value);
            for (int i = closeIndex + 1; i < tokens.size(); i++) {
                newTokens.add(tokens.get(i));
            }
            return joinTokens(newTokens);
        }

        // No parentheses; perform a single operation according to precedence.
        // First, find first multiplication/division (left-to-right)
        for (int i = 0; i < tokens.size(); i++) {

            String t = tokens.get(i);
            if ("x".equals(t) || ":".equals(t)) {
                // tokens i-1 (lhs) should exist and i+1 (rhs) should exist
                if (i - 1 < 0 || i + 1 >= tokens.size()) {
                    continue; // shouldn't happen due validation
                }

                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                String result = computeBinary(lhs, t, rhs);
                // replace i-1..i+1 by result
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

    // Evaluate a list of tokens fully returning a single numeric string (handles
    // precedence inside subexpression).
    // Uses integer arithmetic (long) and integer division behavior.
    private static String evaluateTokensFully(List<String> tokensIn) {
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

            // extract subexpression between open+1 .. close-1
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

        // Now perform mult/div left->right
        for (int i = 0; i < tokens.size();) {
            String t = tokens.get(i);
            if ("x".equals(t) || ":".equals(t)) {
                String lhs = tokens.get(i - 1);
                String rhs = tokens.get(i + 1);
                String res = computeBinary(lhs, t, rhs);
                List<String> newTokens = new ArrayList<>();
                for (int j = 0; j < i - 1; j++) {
                    newTokens.add(tokens.get(j));
                }
                newTokens.add(res);
                for (int j = i + 2; j < tokens.size(); j++) {
                    newTokens.add(tokens.get(j));
                }
                tokens = newTokens;
                i = 0; // restart scan from beginning
            } else {
                i++;
            }
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

    // Compute binary operation between two numeric string tokens using integer
    // arithmetic
    private static String computeBinary(String lhsStr, String op, String rhsStr) {
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

    private static long parseLongSafe(String s) {
        // s may include spaces, but tokenization shouldn't have them
        s = s.trim();
        if (s.length() == 0)
            return 0;
        return Long.parseLong(s);
    }

    private static String joinTokens(List<String> tokens) {
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

    private static String normalizeSpacing(String expr) {
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
    // Methods for menuHighSchool()

    public static void arrayStat() {
        clearScreen();
        System.out.println("High School > Statistical Information About an Array");
        System.out.println("----------------------------------------------------");

        int n = readPositiveInt("Enter array size (n >= 1): ");

        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = readDouble("Enter element #" + (i + 1) + " (double): ");
        }

        double[] s = java.util.Arrays.copyOf(a, n);
        java.util.Arrays.sort(s);

        double sum = 0.0, min = s[0], max = s[n - 1];
        boolean allPositive = s[0] > 0.0;
        boolean hasZero = false;

        for (double v : a) {
            sum += v;
            if (v <= 0.0)
                allPositive = false;
            if (v == 0.0)
                hasZero = true;
        }

        double mean = sum / n;

        // Median, Q1, Q3, IQR
        double median = medianSorted(s);
        double q1 = quantileSorted(s, 0.25);
        double q3 = quantileSorted(s, 0.75);
        double iqr = q3 - q1;

        // Variance & Std (Population & Sample)
        double varPop = variance(a, mean, false);
        double varSmp = variance(a, mean, true);
        double stdPop = Math.sqrt(varPop);
        double stdSmp = Math.sqrt(varSmp);

        // Geometric & Harmonic
        Double gmean = allPositive ? geometricMean(a) : null;
        Double hmean = hasZero ? null : harmonicMeanRecursive(a);

        // Outliers by 1.5*IQR
        int outliers = 0;
        double lowFence = q1 - 1.5 * iqr, highFence = q3 + 1.5 * iqr;
        for (double v : a)
            if (v < lowFence || v > highFence)
                outliers++;

        // Output
        System.out.println();
        System.out.println("Summary");
        System.out.println("-------");
        System.out.printf("Count (n)            : %d%n", n);
        System.out.printf("Min / Max            : %.6f / %.6f%n", min, max);
        System.out.printf("Sum                  : %.6f%n", sum);
        System.out.printf("Mean (Arithmetic)    : %.6f%n", mean);
        System.out.printf("Median               : %.6f%n", median);
        System.out.printf("Q1 / Q3              : %.6f / %.6f%n", q1, q3);
        System.out.printf("IQR                  : %.6f%n", iqr);
        System.out.printf("Variance (Population): %.6f%n", varPop);
        System.out.printf("Std Dev (Population) : %.6f%n", stdPop);
        System.out.printf("Variance (Sample)    : %.6f%n", varSmp);
        System.out.printf("Std Dev (Sample)     : %.6f%n", stdSmp);

        if (gmean == null)
            System.out.println("Geometric Mean       : undefined (all elements must be > 0)");
        else
            System.out.printf("Geometric Mean       : %.6f%n", gmean);

        if (hmean == null)
            System.out.println("Harmonic Mean        : undefined (no element may be zero)");
        else
            System.out.printf("Harmonic Mean        : %.6f%n", hmean);

        System.out.printf("Outliers (1.5*IQR)   : %d%n", outliers);

        // A Small Overview
        int k = Math.min(5, s.length);
        System.out.print("Sorted preview       : ");
        for (int i = 0; i < k; i++)
            System.out.print(fmt6(s[i]) + (i < k - 1 ? ", " : ""));
        if (s.length > 10)
            System.out.print(", ..., ");
        int startTail = Math.max(k, s.length - k);
        for (int i = startTail; i < s.length; i++) {
            System.out.print(fmt6(s[i]) + (i < s.length - 1 ? ", " : ""));
        }
        System.out.println();

        pressEnter();
    }

    public static void arraysDistance() {
        clearScreen();
        System.out.println("High School > Distance Between Two Arrays");
        System.out.println("-----------------------------------------");

        int n = readPositiveInt("Enter dimension (n >= 1): ");

        int[] A = readIntArrayDigits("Enter elements for Array A (each in [0-9])", n, 0, 9);
        int[] B = readIntArrayDigits("Enter elements for Array B (each in [0-9])", n, 0, 9);

        // Manhattan
        long manhattan = 0;
        for (int i = 0; i < n; i++)
            manhattan += Math.abs(A[i] - B[i]);

        // Euclidean
        long sq = 0;
        for (int i = 0; i < n; i++) {
            int d = A[i] - B[i];
            sq += (long) d * d;
        }
        double euclidean = Math.sqrt(sq);

        // Chebyshev
        int chebyshev = 0;
        for (int i = 0; i < n; i++)
            chebyshev = Math.max(chebyshev, Math.abs(A[i] - B[i]));

        // Hamming
        int hamming = 0;
        for (int i = 0; i < n; i++)
            if (A[i] != B[i])
                hamming++;

        // Cosine
        long dot = 0, normA2 = 0, normB2 = 0;
        for (int i = 0; i < n; i++) {
            dot += (long) A[i] * B[i];
            normA2 += (long) A[i] * A[i];
            normB2 += (long) B[i] * B[i];
        }
        Double cosSim = null, cosDist = null;
        if (normA2 != 0 && normB2 != 0) {
            cosSim = dot / (Math.sqrt(normA2) * Math.sqrt(normB2));
            cosDist = 1.0 - cosSim;
        }

        // Minkowski
        double p = readDoubleInRange("Enter Minkowski order p (>= 1, e.g., 3): ", 1.0, Double.POSITIVE_INFINITY);
        double mkSum = 0.0;
        for (int i = 0; i < n; i++)
            mkSum += Math.pow(Math.abs(A[i] - B[i]), p);
        double minkowski = Math.pow(mkSum, 1.0 / p);

        // Output
        System.out.println();
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Manhattan (L1)      : " + manhattan);
        System.out.printf("Euclidean (L2)      : %.6f%n", euclidean);
        System.out.println("Chebyshev (L∞)      : " + chebyshev);
        System.out.println("Hamming (positions) : " + hamming);
        if (cosSim == null) {
            System.out.println("Cosine Similarity   : undefined (a zero vector encountered)");
            System.out.println("Cosine Distance     : undefined");
        } else {
            System.out.printf("Cosine Similarity   : %.6f%n", cosSim);
            System.out.printf("Cosine Distance     : %.6f%n", cosDist);
        }
        System.out.printf("Minkowski (p=%.3f)  : %.6f%n", p, minkowski);

        pressEnter();
    }

    // Robust input helpers (for Sena's Part)
    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= 1)
                    return v;
                System.out.println("Invalid input. Please enter an integer >= 1.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= min && v <= max)
                    return v;
                System.out.println("Invalid input. Enter an integer in [" + min + "," + max + "].");
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    private static double readDouble(String prompt) {
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

    private static double readDoubleInRange(String prompt, double min, double maxInclOrInf) {
        while (true) {
            double v = readDouble(prompt);
            if (v >= min && v <= maxInclOrInf)
                return v;
            System.out.println("Out of range. Value must be >= " + min
                    + (Double.isInfinite(maxInclOrInf) ? "" : (" and <= " + maxInclOrInf)));
        }
    }

    private static int[] readIntArrayDigits(String head, int n, int min, int max) {
        System.out.println(head + " -> total " + n + " items.");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = readIntInRange("  value[" + (i + 1) + "] = ", min, max);
        }
        return arr;
    }

    private static void pressEnter() {
        System.out.println();
        System.out.println("Press ENTER to continue...");
        SC.nextLine();
    }

    // Statistics internals (for Sena's Part)
    private static String fmt6(double v) {
        return String.format("%.6f", v);
    }

    private static double medianSorted(double[] sorted) {
        int n = sorted.length;
        return (n % 2 == 1) ? sorted[n / 2] : (sorted[n / 2 - 1] + sorted[n / 2]) / 2.0;
    }

    private static double quantileSorted(double[] sorted, double q) {
        int n = sorted.length;
        if (n == 1)
            return sorted[0];
        double pos = q * (n - 1);
        int idx = (int) Math.floor(pos);
        double frac = pos - idx;
        if (idx >= n - 1)
            return sorted[n - 1];
        return sorted[idx] * (1 - frac) + sorted[idx + 1] * frac;
    }

    private static double variance(double[] a, double mean, boolean sample) {
        if (a.length <= (sample ? 1 : 0))
            return 0.0;
        double ss = 0.0;
        for (double v : a) {
            double d = v - mean;
            ss += d * d;
        }
        return ss / (sample ? (a.length - 1) : a.length);
    }

    private static Double geometricMean(double[] a) {
        double logSum = 0.0;
        for (double v : a) {
            if (v <= 0.0)
                return null;
            logSum += Math.log(v);
        }
        return Math.exp(logSum / a.length);
    }

    private static Double harmonicMeanRecursive(double[] a) {
        for (double v : a)
            if (v == 0.0)
                return null;
        double recSum = reciprocalSum(a, 0);
        return a.length / recSum;
    }

    private static double reciprocalSum(double[] a, int i) {
        if (i == a.length)
            return 0.0;
        return (1.0 / a[i]) + reciprocalSum(a, i + 1);
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Methods for selectMenuUniversity()
    /**
     * Handles the setup (board size, game mode) for Connect Four
     * and then launches the game.
     */
    public static void connectFour() {
        int rows = 0;
        int cols = 0;
        int gameMode = 0;

        // 1. Select Board Size
        boolean sizeSelected = false;
        while (!sizeSelected) {
            clearScreen();
            System.out.println("--- Connect Four: Board Size ---");
            System.out.println("[A] 5x4 (5 Rows, 4 Cols)");
            System.out.println("[B] 6x5 (6 Rows, 5 Cols)");
            System.out.println("[C] 7x6 (7 Rows, 6 Cols)");
            System.out.print("Select board size: ");
            String choice = SC.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    rows = 5;
                    cols = 4;
                    sizeSelected = true;
                    break;
                case "B":
                    rows = 6;
                    cols = 5;
                    sizeSelected = true;
                    break;
                case "C":
                    rows = 7;
                    cols = 6;
                    sizeSelected = true;
                    break;
                default:
                    System.out.println("Invalid choice. Press Enter to try again.");
                    SC.nextLine(); // Wait for user acknowledgment
            }
        }

        // 2. Select Game Mode
        boolean modeSelected = false;
        while (!modeSelected) {
            clearScreen();
            System.out.println("--- Connect Four: Game Mode ---");
            System.out.println("[A] Single-Player (vs. Computer)");
            System.out.println("[B] Two-Players");
            System.out.print("Select game mode: ");
            String choice = SC.nextLine().trim().toUpperCase();

            switch (choice) {
                case "A":
                    gameMode = GAME_MODE_SINGLE_PLAYER;
                    modeSelected = true;
                    break;
                case "B":
                    gameMode = GAME_MODE_TWO_PLAYER;
                    modeSelected = true;
                    break;
                default:
                    System.out.println("Invalid choice. Press Enter to try again.");
                    SC.nextLine(); // Wait for user acknowledgment
            }
        }

        // 3. Start the game
        runConnectFourGame(rows, cols, gameMode);
    }

    /**
     * The main game loop for Connect Four.
     * 
     * @param rows     The number of rows in the board.
     * @param cols     The number of columns in the board.
     * @param gameMode 1 for single-player, 2 for two-player.
     */
    public static void runConnectFourGame(int rows, int cols, int gameMode) {
        char[][] board = initializeBoard(rows, cols);
        boolean gameRunning = true;
        char currentPlayer = PLAYER_ONE_DISC; // Player 1 always starts

        while (gameRunning) {
            clearScreen();
            printBoard(board);

            // 1. Get the current player's move
            int moveCol = -1;
            boolean moveMade = false;

            if (gameMode == GAME_MODE_TWO_PLAYER) {
                // --- Two-Player Mode ---
                moveCol = getHumanMove(board, currentPlayer);
            } else {
                // --- Single-Player Mode ---
                if (currentPlayer == PLAYER_ONE_DISC) {
                    moveCol = getHumanMove(board, currentPlayer);
                } else {
                    moveCol = getComputerMove(board);
                    System.out.println("Computer (Y) chose column " + (moveCol + 1));
                    waitMillis(delayAmount * 2); // Pause to simulate thinking
                }
            }

            // Check for forfeit
            if (moveCol == -1) {
                gameRunning = false;
                System.out.println("Player " + currentPlayer + " has forfeited the game.");
                continue; // Skip to the end
            }

            // 2. Drop the disc in the board
            dropDisc(board, moveCol, currentPlayer);

            // 3. Check for game end conditions
            if (checkWin(board, currentPlayer)) {
                clearScreen();
                printBoard(board);
                System.out.println("\n!!! PLAYER " + currentPlayer + " WINS! !!!\n");
                gameRunning = false;
            } else if (isBoardFull(board)) {
                clearScreen();
                printBoard(board);
                System.out.println("\n!!! GAME OVER! It's a DRAW! !!!\n");
                gameRunning = false;
            } else {
                // 4. Switch player
                if (currentPlayer == PLAYER_ONE_DISC) {
                    currentPlayer = (gameMode == GAME_MODE_SINGLE_PLAYER) ? COMPUTER_DISC : PLAYER_TWO_DISC;
                } else {
                    currentPlayer = PLAYER_ONE_DISC;
                }
            }
        }
    }

    /**
     * Creates a new Connect Four board filled with empty slots.
     * 
     * @param rows Number of rows.
     * @param cols Number of columns.
     * @return The initialized 2D char array.
     */
    private static char[][] initializeBoard(int rows, int cols) {
        char[][] board = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = EMPTY_SLOT;
            }
        }
        return board;
    }

    /**
     * Prints the Connect Four board to the console.
     * 
     * @param board The current game board.
     */
    private static void printBoard(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        System.out.println("\n--- CONNECT FOUR ---");
        // Print board contents
        for (int r = 0; r < rows; r++) {
            System.out.print("| ");
            for (int c = 0; c < cols; c++) {
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
        }

        // Print separator
        for (int c = 0; c < cols; c++) {
            System.out.print("----");
        }
        System.out.println("-");

        // Print column numbers
        System.out.print("  ");
        for (int c = 0; c < cols; c++) {
            System.out.print((c + 1) + "   ");
        }
        System.out.println("\n");
    }

    /**
     * Gets a valid column move from a human player.
     * 
     * @param board  The current game board.
     * @param player The character representing the player.
     * @return The 0-based column index, or -1 if the player quits.
     */
    private static int getHumanMove(char[][] board, char player) {
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
                } else if (!isValidMove(board, col)) {
                    System.out.println("Column " + (col + 1) + " is full. Please choose another.");
                } else {
                    return col; // Valid move
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Gets a valid random column move for the computer.
     * 
     * @param board The current game board.
     * @return The 0-based column index.
     */
    private static int getComputerMove(char[][] board) {
        int cols = board[0].length;
        while (true) {
            int col = RAND.nextInt(cols); // Pick a random column (0 to cols-1)
            if (isValidMove(board, col)) {
                return col; // Return if the column is not full
            }
            // If column is full, the loop repeats to find another
        }
    }

    /**
     * Checks if a move is valid (i.e., the column is not full).
     * 
     * @param board The current game board.
     * @param col   The 0-based column index.
     * @return true if the column is not full, false otherwise.
     */
    private static boolean isValidMove(char[][] board, int col) {
        return board[0][col] == EMPTY_SLOT; // Check only the top row
    }

    /**
     * "Drops" a disc into the specified column.
     * 
     * @param board  The game board (will be modified).
     * @param col    The 0-based column index.
     * @param player The player's disc character.
     */
    private static void dropDisc(char[][] board, int col, char player) {
        int rows = board.length;
        // Start from the bottom row and go up
        for (int r = rows - 1; r >= 0; r--) {
            if (board[r][col] == EMPTY_SLOT) {
                board[r][col] = player; // Place the disc
                return; // Exit the method
            }
        }
    }

    /**
     * Checks if the board is completely full (a draw condition).
     * 
     * @param board The current game board.
     * @return true if the board is full, false otherwise.
     */
    private static boolean isBoardFull(char[][] board) {
        int cols = board[0].length;
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == EMPTY_SLOT) {
                return false; // If any slot in the top row is empty, not full
            }
        }
        return true; // All top slots are full
    }

    /**
     * Checks the entire board for a 4-in-a-row win for the specified player.
     * 
     * @param board  The current game board.
     * @param player The player's disc character to check for.
     * @return true if a win is found, false otherwise.
     */
    private static boolean checkWin(char[][] board, char player) {
        int rows = board.length;
        int cols = board[0].length;

        // 1. Check Horizontal
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c <= cols - 4; c++) {
                if (board[r][c] == player &&
                        board[r][c + 1] == player &&
                        board[r][c + 2] == player &&
                        board[r][c + 3] == player) {
                    return true;
                }
            }
        }

        // 2. Check Vertical
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r <= rows - 4; r++) {
                if (board[r][c] == player &&
                        board[r + 1][c] == player &&
                        board[r + 2][c] == player &&
                        board[r + 3][c] == player) {
                    return true;
                }
            }
        }

        // 3. Check Diagonal (Bottom-Left to Top-Right)
        for (int r = 3; r < rows; r++) { // Start from row 3 (0-indexed)
            for (int c = 0; c <= cols - 4; c++) {
                if (board[r][c] == player &&
                        board[r - 1][c + 1] == player &&
                        board[r - 2][c + 2] == player &&
                        board[r - 3][c + 3] == player) {
                    return true;
                }
            }
        }

        // 4. Check Diagonal (Top-Left to Bottom-Right)
        for (int r = 0; r <= rows - 4; r++) {
            for (int c = 0; c <= cols - 4; c++) {
                if (board[r][c] == player &&
                        board[r + 1][c + 1] == player &&
                        board[r + 2][c + 2] == player &&
                        board[r + 3][c + 3] == player) {
                    return true;
                }
            }
        }

        return false; // No win found
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Helpers
    public static void clearScreen() {
        // Try ANSI clear; may not work in some consoles but is widely supported
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }

    public static void waitMillis(long periodMillis) {
        try {
            // Thread.sleep() accepts the period in milliseconds (long type)
            Thread.sleep(periodMillis);
        } catch (InterruptedException e) {
            // Always reset the interrupt status when catching InterruptedException
            Thread.currentThread().interrupt();
        }
    }

    public static void waitBeforeProceed() {
        boolean proceed = false;

        while (!proceed) {
            System.out.println("Press enter when you want to proceed.");

            // The part that handles the Enter key press
            try {
                // System.in.read() waits for the next byte of input,
                // which is often the newline character ('\n') generated by Enter.
                System.in.read();
                proceed = true; // Set flag to exit the loop
            } catch (IOException e) {
                // Handle potential input/output errors
                System.out.println("An input error occurred: " + e.getMessage());
                // You might want to handle the loop exit differently here,
                // but setting proceed = true is a simple exit strategy.
                proceed = true;
            }
        }
    }
}
