import java.nio.charset.StandardCharsets; //needed to scan for strings.
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException; //needed for the method waitForProceed().

public class Project1 {
    private static final Scanner SC = new Scanner(System.in, StandardCharsets.UTF_8);
    private static final Random RAND = new Random();
    private static final long delayAmount = 500;

    public static void main(String[] args) {
        menuMain();
        clearScreen();
    }

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

    public static void showMenuPrimarySchool()
    {
        clearScreen();
        System.out.println("Sub Menu - Primary School - Select an option:");
        System.out.println("[A] Age and Zodiac Sign Detection");
        System.out.println("[B] Reverse the Words");
        System.out.println("[C] Return to the Main Menu");
    }

    public static boolean selectMenuPrimarySchool()
    {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();
        switch (choice)
        {
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
        switch (choice)
        {
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
        switch (choice)
        {
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
        System.out.println("Welcome to the Connect Four Game! - Select the Board Size and then the Game Mode to Start:");
        System.out.println("Board Size Options:%n[A] 5x4%n[B] 6x5%n[C] 7x6");
        System.out.println("Game Mode Options:%n[A] single-player vs computer%n[B] two-players");
    }

    public static boolean selectMenuUniversity() {
        System.out.print("Choice: ");
        String choice = SC.nextLine().trim().toUpperCase();
        switch (choice)
        {
            case "A":
                connectFour();
                waitBeforeProceed();
                break;
            case "B":
                //something about case b
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
    // ----------------------------------------------------------------------------------------------------------------
    /*
    THE PARTS BELOW UNTIL THE NEXT CAPITALIZED COMMENT WILL BE HANDLED BY THE GROUP MEMBERS. THE ABOVE IS NOT IMPORTANT, AND ALREADY IS MOSTLY DONE.
    Group members don't have to think about how the menus work, and inside the methods below, you don't need to insert messages or anything related to the main menu and the submenus.
    Getting the arguments methods need to work is also to be handled within another methods to be declared below as you wish, because inside whatever above is only the logic of the menus, and calling these methods.
     */
    // ----------------------------------------------------------------------------------------------------------------
    // Hadi's Part
	public static void ageZodiac()
    {
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
        if (daysDifference < 0) 
        {
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
        if (monthsDifference < 0) 
        {
            yearsDifference = yearsDifference - 1;
            monthsDifference = monthsDifference + 12;
        }

        // Print the age
        System.out.println("You are " + yearsDifference + " years, " + monthsDifference + " months, and " + daysDifference + " days old.");

        // Get and print zodiac sign
        String zodiac = getZodiacSign(day, month);
        System.out.println("Your Zodiac sign is: " + zodiac + "\n");
    }
    
    private static int getYear() {
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        
        boolean validInput = false;
        int year = 0;
        
        while (validInput == false) {
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
        
        while (validInput == false) {
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
        
        while (validInput == false) {
            try {
                System.out.print("Enter day of birth: ");
                String input = SC.nextLine();
                day = Integer.parseInt(input);
                
                if (day < 1) {
                    System.out.println("Error: Day must be at least 1. Please try again.\n");
                } else if (day > maxDays) {
                    if (month == 2 && isLeapYear) {
                        System.out.println("Error: February has only 29 days in leap year " + year + ". Please try again.\n");
                    } else {
                        System.out.println("Error: Month " + month + " has only " + maxDays + " days. Please try again.\n");
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
    
    private static int daysInMonth(int month, int year)
    {
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
    
    private static String getZodiacSign(int day, int month) 
    {
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
    public static void reverseWords()
    {
        System.out.print("Enter a sentence: ");
        String text = SC.nextLine();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) 
        {
            char c = text.charAt(i);
            if (isTurkishLetter(c)) 
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
    private static String reverseRecursive(String s)
    {
        if (s.isEmpty()) return s;
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }
    // ----------------------------------------------------------------------------------------------------------------
    // Muhammed's Part:
    public static void primeNumbers()
    {
        
    }

    public static void evalExpression()
    {
        
    }
    // ----------------------------------------------------------------------------------------------------------------
    // Sena's Part:
   // ======================= SENA'S PART START =======================
    // High School > A) Array Statistics  &  B) Distance Between Two Arrays
    // Kötü girdiyi asla kabul etmez; kullanıcıyı uyarıp tekrar sorar. bu benim part C dimi

    public static void arrayStat(int arraySize, int[] elements) 
    {
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
            if (v <= 0.0) allPositive = false;
            if (v == 0.0) hasZero = true;
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
        for (double v : a) if (v < lowFence || v > highFence) outliers++;

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

        // küçük önizleme
        int k = Math.min(5, s.length);
        System.out.print("Sorted preview       : ");
        for (int i = 0; i < k; i++) System.out.print(fmt6(s[i]) + (i < k - 1 ? ", " : ""));
        if (s.length > 10) System.out.print(", ..., ");
        int startTail = Math.max(k, s.length - k);
        for (int i = startTail; i < s.length; i++) {
            System.out.print(fmt6(s[i]) + (i < s.length - 1 ? ", " : ""));
        }
        System.out.println();

        pressEnter();
    }

    public static void arraysDistance(int arrayDimension, int[] array1Elements, int[] array2Elements) {
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

        // Chebyshev
        int chebyshev = 0;
        for (int i = 0; i < n; i++) chebyshev = Math.max(chebyshev, Math.abs(A[i] - B[i]));

        // Hamming
        int hamming = 0;
        for (int i = 0; i < n; i++) if (A[i] != B[i]) hamming++;

        // Cosine
        long dot = 0, normA2 = 0, normB2 = 0;
        for (int i = 0; i < n; i++) {
            dot    += (long) A[i] * B[i];
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
        for (int i = 0; i < n; i++) mkSum += Math.pow(Math.abs(A[i] - B[i]), p);
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
    // ======================= SENA'S PART END =======================

    public static void arrayStat() 
    {
        
    }

    public static void arraysDistance() {
        
    }
    
    public static void connectFour(int rows, int columns, String gameMode) {
        
    }

    public static void clearScreen() {
        
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }

    //Robust input helpers (for Sena's Part) 
    private static int readPositiveInt(String prompt) {
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

    private static int readIntInRange(String prompt, int min, int max) {
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
            if (v >= min && v <= maxInclOrInf) return v;
            System.out.println("Out of range. Value must be >= " + min + (Double.isInfinite(maxInclOrInf) ? "" : (" and <= " + maxInclOrInf)));
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

    //  Statistics internals (for Sena's Part)
    private static String fmt6(double v) { return String.format("%.6f", v); }

    private static double medianSorted(double[] sorted) {
        int n = sorted.length;
        return (n % 2 == 1) ? sorted[n / 2] : (sorted[n / 2 - 1] + sorted[n / 2]) / 2.0;
    }

    private static double quantileSorted(double[] sorted, double q) {
        int n = sorted.length;
        if (n == 1) return sorted[0];
        double pos = q * (n - 1);
        int idx = (int) Math.floor(pos);
        double frac = pos - idx;
        if (idx >= n - 1) return sorted[n - 1];
        return sorted[idx] * (1 - frac) + sorted[idx + 1] * frac;
    }

    private static double variance(double[] a, double mean, boolean sample) {
        if (a.length <= (sample ? 1 : 0)) return 0.0;
        double ss = 0.0;
        for (double v : a) { double d = v - mean; ss += d * d; }
        return ss / (sample ? (a.length - 1) : a.length);
    }

    private static Double geometricMean(double[] a) {
        double logSum = 0.0;
        for (double v : a) {
            if (v <= 0.0) return null;
            logSum += Math.log(v);
        }
        return Math.exp(logSum / a.length);
    }

    private static Double harmonicMeanRecursive(double[] a) {
        for (double v : a) if (v == 0.0) return null;
        double recSum = reciprocalSum(a, 0);
        return a.length / recSum;
    }

    private static double reciprocalSum(double[] a, int i) {
        if (i == a.length) return 0.0;
        return (1.0 / a[i]) + reciprocalSum(a, i + 1);
    }
}
    // ----------------------------------------------------------------------------------------------------------------
    // THANK YOU GUYS.

    // Emre's Part:
    public static void connectFour() {
        
    }
    // ----------------------------------------------------------------------------------------------------------------
    // helpers
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
