import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;

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
                case "C": //one of the below will be chosen or combined
                    // subMenuHighSchool();

                    // Scanner sc = new Scanner(System.in);
                    // handleCMenu(sc);
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

    public static void primarySchoolMenuLoop() 
    {
        boolean back = false;
        while (!back) 
        {
            subMenuPrimary();
            String subChoice = SC.nextLine().trim().toUpperCase();
            switch (subChoice) 
            {
                case "A":
                    try 
                        {
                            System.out.print("Enter day of birth: ");
                            int day = Integer.parseInt(SC.nextLine());
                            System.out.print("Enter month of birth: ");
                            int month = Integer.parseInt(SC.nextLine());
                            System.out.print("Enter year of birth: ");
                            int year = Integer.parseInt(SC.nextLine());
                            ageZodiac(day, month, year);
                        } 
                    catch (Exception e) 
                        {
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

    public static void subMenuPrimary() 
    {
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

    // one of the two below will be chosen or combined
    public static void subMenuHighSchool() {
        clearScreen();
        System.out.println("Sub Menu - High School - Select an option:");
        System.out.println("[A] Statistical Information About an Array");
        System.out.println("[B] Distance Between Two Arrays");
        System.out.println("[C] Return to Main Menu");
        System.out.print("Choice: ");
    }
    public static void handleCMenu(Scanner sc) {
        while (true) {
            clearScreen();
            printlnBold("===== [C] Lise Menüsü =====");
            System.out.println("[1] Dizi Hakkında İstatistiksel Bilgiler");
            System.out.println("[2] İki Dizi Arasındaki Uzaklıklar");
            System.out.println("[0] Çıkış");
            System.out.print("Seçiminiz: ");
            String in = sc.nextLine().trim();

            switch (in) {
                case "1":
                    clearScreen();
                    doArrayStatistics(sc);
                    pause(sc);
                    break;
                case "2":
                    clearScreen();
                    doArrayDistances(sc);
                    pause(sc);
                    break;
                case "0":
                    return;
                default:
                    warn("Geçersiz seçim! 0/1/2 giriniz.");
                    pause(sc);
            }
        }
    }

    public static void subMenuUniversity() {
        clearScreen();
        System.out.println("Welcome to the Connect Four Game! - Select the Board Size and then the Game Mode to Start:");
        System.out.println("Board Size Options:%n[A] 5x4%n[B] 6x5%n[C] 7x6");
        System.out.println("Game Mode Options:%n[A] single-player vs computer%n[B] two-players");
        System.out.print("Choice: ");
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------
    
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

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void primeNumbers(int number) 
    {
        
    }
    
    public static void evalExpression(String expression) 
    {
        
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------

    // for option 1 of option c, methods below will be combined into the first method
    public static void arrayStat(int arraySize, int[] elements) 
    {
        
    }

    private static void doArrayStatistics(Scanner sc) {
            printlnBold(">>> [C-1] Dizi Hakkında İstatistiksel Bilgiler");
            int n = readPositiveInt(sc, "Dizi boyutu (pozitif tamsayı): ");

            double[] arr = readDoubleArray(sc, n);

            double med = median(arr);
            double mean = arithmeticMean(arr);
            Double gmean = geometricMeanOrNull(arr);   // null  tanımsız
            Double hmean = harmonicMeanOrNull(arr);    // null  tanımsız (0 içerirse)

            System.out.println();
            printTable(
                    new String[]{"Özellik", "Değer"},
                    new String[][]{
                            {"Medyan", fmt(med)},
                            {"Aritmetik Ortalama", fmt(mean)},
                            {"Geometrik Ortalama", gmean == null ? "tanımsız (tüm elemanlar > 0 olmalı)" : fmt(gmean)},
                            {"Harmonik Ortalama", hmean == null ? "tanımsız (0 içeriyor)" : fmt(hmean)}
                    }
            );

            info("\nNot: Geometrik ortalama için tüm elemanlar > 0 olmalı; " +
                "Harmonik ortalama 0 içeren dizilerde tanımsızdır (1/0).");
        }

    private static double[] readDoubleArray(Scanner sc, int n) {
        System.out.println("\nGirdi yöntemi: [1] Tek tek  [2] Virgülle (örn: 1.2, -3, 0.5)");
        String m = askIn(sc, "Seçim (1/2): ", s -> s.equals("1") || s.equals("2"));

        double[] arr = new double[n];
        if (m.equals("1")) {
            for (int i = 0; i < n; i++) {
                arr[i] = readDouble(sc, (i + 1) + ". eleman (double): ");
            }
        } else {
            while (true) {
                System.out.print("Elemanları virgülle girin: ");
                String line = sc.nextLine().trim();
                String[] parts = line.split(",");
                if (parts.length != n) {
                    warn("Tam olarak " + n + " sayı giriniz.");
                    continue;
                }
                try {
                    for (int i = 0; i < n; i++) arr[i] = Double.parseDouble(parts[i].trim());
                    break;
                } catch (NumberFormatException e) {
                    warn("Sayısal biçim hatası. Lütfen tekrar deneyin.");
                }
            }
        }
        return arr;
    }

    private static double median(double[] arr) {
        double[] c = Arrays.copyOf(arr, arr.length);
        Arrays.sort(c);
        int n = c.length;
        if (n % 2 == 1) return c[n / 2];
        return (c[n / 2 - 1] + c[n / 2]) / 2.0;
    }

    private static double arithmeticMean(double[] arr) {
        double s = 0.0;
        for (double v : arr) s += v;
        return s / arr.length;
    }

    private static Double geometricMeanOrNull(double[] arr) {
        for (double v : arr) if (v <= 0.0) return null;
        double sumLog = 0.0;
        for (double v : arr) sumLog += Math.log(v);
        return Math.exp(sumLog / arr.length);
    }

    private static Double harmonicMeanOrNull(double[] arr) {
        for (double v : arr) if (v == 0.0) return null;
        double denom = reciprocalSumRec(arr, 0);
        if (denom == 0.0) return null;
        return arr.length / denom;
    }

    private static double reciprocalSumRec(double[] arr, int i) {
        if (i == arr.length) return 0.0;
        return (1.0 / arr[i]) + reciprocalSumRec(arr, i + 1);
    }

    // for option 2 of option c, methods below will be combined into the first method
    public static void arraysDistance(int arrayDimension, int[] array1Elements, int[] array2Elements) {
        
    }
    private static void doArrayDistances(Scanner sc) {
        printlnBold(">>> [C-2] İki Dizi Arasındaki Uzaklıklar");
        int n = readPositiveInt(sc, "Vektör boyutu (pozitif tamsayı): ");

        System.out.println("\n--- 1. dizi (tüm elemanlar 0–9) ---");
        int[] a = readIntArrayInRange(sc, n, 0, 9);

        System.out.println("\n--- 2. dizi (tüm elemanlar 0–9) ---");
        int[] b = readIntArrayInRange(sc, n, 0, 9);

        double manhattan = manhattanDistance(a, b);
        double euclid = euclideanDistance(a, b);
        Double cosine = cosineSimilarityOrNull(a, b); // sıfır vektör -> tanımsız

        System.out.println();
        printTable(
                new String[]{"Metrik", "Değer"},
                new String[][]{
                        {"Manhattan Uzaklığı", fmt(manhattan)},
                        {"Öklid Uzaklığı", fmt(euclid)},
                        {"Kosinüs Benzerliği", cosine == null ? "tanımsız (en az bir vektör sıfır)" : fmt(cosine)}
                }
        );
    }

    private static int[] readIntArrayInRange(Scanner sc, int n, int lo, int hi) {
        System.out.println("Girdi yöntemi: [1] Tek tek  [2] Virgülle");
        String m = askIn(sc, "Seçim (1/2): ", s -> s.equals("1") || s.equals("2"));

        int[] v = new int[n];
        if (m.equals("1")) {
            for (int i = 0; i < n; i++) {
                v[i] = readIntInRange(sc, (i + 1) + ". eleman [" + lo + "–" + hi + "]: ", lo, hi);
            }
        } else {
            while (true) {
                System.out.print("Elemanları virgülle girin: ");
                String line = sc.nextLine().trim();
                String[] parts = line.split(",");
                if (parts.length != n) {
                    warn("Tam olarak " + n + " sayı giriniz.");
                    continue;
                }
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    try {
                        int val = Integer.parseInt(parts[i].trim());
                        if (val < lo || val > hi) { ok = false; break; }
                        v[i] = val;
                    } catch (NumberFormatException e) {
                        ok = false; break;
                    }
                }
                if (ok) break;
                warn("Geçersiz giriş! Her eleman " + lo + "–" + hi + " aralığında tamsayı olmalı.");
            }
        }
        return v;
    }

    private static double manhattanDistance(int[] a, int[] b) {
        long s = 0L;
        for (int i = 0; i < a.length; i++) s += Math.abs(a[i] - b[i]);
        return s;
    }

    private static double euclideanDistance(int[] a, int[] b) {
        double s = 0.0;
        for (int i = 0; i < a.length; i++) {
            double d = a[i] - b[i];
            s += d * d;
        }
        return Math.sqrt(s);
    }

    private static Double cosineSimilarityOrNull(int[] a, int[] b) {
        long dot = 0L, na2 = 0L, nb2 = 0L;
        for (int i = 0; i < a.length; i++) {
            dot += (long) a[i] * b[i];
            na2 += (long) a[i] * a[i];
            nb2 += (long) b[i] * b[i];
        }
        if (na2 == 0L || nb2 == 0L) return null;
        return dot / (Math.sqrt(na2) * Math.sqrt(nb2));
    }

    

    private static int readPositiveInt(Scanner sc, String prompt) {
        return readIntByRule(sc, prompt, x -> x > 0, "Pozitif bir tamsayı giriniz.");
    }

    private static int readIntInRange(Scanner sc, String prompt, int lo, int hi) {
        return readIntByRule(sc, prompt, x -> (x >= lo && x <= hi),
                "Geçersiz! " + lo + "–" + hi + " aralığında tamsayı giriniz.");
    }

    private static int readIntByRule(Scanner sc, String prompt,
                                     java.util.function.IntPredicate rule, String err) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (rule.test(v)) return v;
            } catch (NumberFormatException ignored) {}
            warn(err);
        }
    }

    private static double readDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException ignored) {
                warn("Sayısal biçim hatası. Örn: 3.14");
            }
        }
    }

    private static String askIn(Scanner sc, String prompt, java.util.function.Predicate<String> ok) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (ok.test(s)) return s;
            warn("Geçersiz giriş.");
        }
    }

    private static void printTable(String[] headers, String[][] rows) {
        int[] w = new int[headers.length];
        for (int i = 0; i < headers.length; i++) w[i] = headers[i].length();
        for (String[] r : rows) for (int i = 0; i < r.length; i++) w[i] = Math.max(w[i], r[i].length());

        StringBuilder sb = new StringBuilder();
        // başlık
        for (int i = 0; i < headers.length; i++) {
            sb.append(pad(headers[i], w[i])).append(i == headers.length - 1 ? "" : " | ");
        }
        printlnBold(sb.toString());
        // çizgi
        sb.setLength(0);
        for (int i = 0; i < headers.length; i++) {
            sb.append(repeat("-", w[i])).append(i == headers.length - 1 ? "" : "-+-");
        }
        System.out.println(sb);

        // satırlar
        for (String[] r : rows) {
            sb.setLength(0);
            for (int i = 0; i < r.length; i++) {
                sb.append(pad(r[i], w[i])).append(i == r.length - 1 ? "" : " | ");
            }
            System.out.println(sb);
        }
    }

    private static void pause(Scanner sc) {
        System.out.print("\nDevam etmek için ENTER...");
        sc.nextLine();
    }

    private static void clearScreen() { System.out.print("\033[H\033[2J"); System.out.flush(); }
    private static void printlnBold(String s) { System.out.println("\033[1m" + s + "\033[0m"); }
    private static void warn(String s) { System.out.println("\033[31m" + s + "\033[0m"); }
    private static void info(String s) { System.out.println("\033[36m" + s + "\033[0m"); }
    private static String pad(String s, int w) { StringBuilder b=new StringBuilder(s); while(b.length()<w)b.append(' '); return b.toString(); }
    private static String repeat(String s, int n){ StringBuilder b=new StringBuilder(); for(int i=0;i<n;i++) b.append(s); return b.toString(); }
    private static String fmt(double v){ if (Double.isNaN(v)||Double.isInfinite(v)) return String.valueOf(v); return String.format(Locale.US,"%.10g",v); }   

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void connectFour(int rows, int columns, String gameMode) {
        
    }

    public static void clearScreen() {
        // Try ANSI clear; may not work in some consoles but is widely supported
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }
}


