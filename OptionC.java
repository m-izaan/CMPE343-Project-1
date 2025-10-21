import java.util.*;

public class OptionC {


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

    /* ================= [C-2] İKİ DİZİ ARASINDA UZAKLIKLAR ================= */

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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        handleCMenu(sc);   
    }
}

