package lab8;
import java.util.*;

public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String input = sc.nextLine();

        // ===== Đếm từ (như bạn đã làm) =====
        String[] tokens = input.trim().split("\\s+");
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String t : tokens) {
            if (t.isEmpty()) continue;

            StringBuilder sb = new StringBuilder();
            for (char c : t.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }
            String word = sb.toString();
            if (word.isEmpty()) continue;
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // ===== Đếm chữ cái (letters) =====
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                charCount.put(lower, charCount.getOrDefault(lower, 0) + 1);
            }
        }

        // ===== Đếm KÝ TỰ ĐẶC BIỆT =====
        // Bạn CHỌN 1 trong 3 cách dưới đây (bỏ comment cách bạn muốn dùng):

        Map<Character, Integer> specialCount = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {

            // -------- CÁCH A: không phải chữ, không phải số, không phải khoảng trắng --------
            /*
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                specialCount.put(c, specialCount.getOrDefault(c, 0) + 1);
            }
            */

            // -------- CÁCH B: chỉ đếm SYMBOLS (loại dấu câu & khoảng trắng) --------
            /*
            int t = Character.getType(c);
            boolean isSymbol =
                    t == Character.MATH_SYMBOL
                 || t == Character.CURRENCY_SYMBOL
                 || t == Character.MODIFIER_SYMBOL
                 || t == Character.OTHER_SYMBOL;
            if (isSymbol) {
                specialCount.put(c, specialCount.getOrDefault(c, 0) + 1);
            }
            */

            // -------- CÁCH C: đếm ký tự đặc biệt nhưng BỎ "dấu" (combining mark) --------
            // Ở đây coi "dấu" là ký tự kết hợp (Mn) – dấu thanh/điểm trên chữ.
            // Ta đếm mọi thứ không phải chữ/số/khoảng trắng/combining mark
            int type = Character.getType(c);
            boolean isCombiningMark = (type == Character.NON_SPACING_MARK); // Mn
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c) && !isCombiningMark) {
                specialCount.put(c, specialCount.getOrDefault(c, 0) + 1);
            }
        }

        // ===== In kết quả =====
        System.out.println(wordCount);
        System.out.println(charCount);
        System.out.println(specialCount); // <- map ký tự đặc biệt

        int totalWords   = wordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalLetters = charCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalSpecial = specialCount.values().stream().mapToInt(Integer::intValue).sum();

        System.out.println("Total words: "   + totalWords);
        System.out.println("Total letters: " + totalLetters);
        System.out.println("Total specials: "+ totalSpecial);
    }
}
