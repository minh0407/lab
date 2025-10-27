package com.mycompany.lab8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String input = sc.nextLine();
        String[] tokens = input.trim().split("\\s+");
        Map<String, Integer> wordCount = new LinkedHashMap<>();
       for (String t : tokens) {
    if (t.isEmpty()) continue;

    StringBuilder sb = new StringBuilder();
    char[] arr = t.toCharArray();

    for (int i = 0; i < arr.length; i++) {
        char c = arr[i];
        if (Character.isLetterOrDigit(c)) {
            sb.append(Character.toLowerCase(c));
        } else if (c == '-') {
            // Cho phép '-' nếu nằm giữa 2 ký tự chữ/số
            if (i > 0 && i < arr.length - 1 &&
                Character.isLetterOrDigit(arr[i - 1]) &&
                Character.isLetterOrDigit(arr[i + 1])) {
                sb.append('-');
            }
        }
    }

    String word = sb.toString();
    if (word.isEmpty()) continue;
    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
}


      
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                charCount.put(lower, charCount.getOrDefault(lower, 0) + 1);
            }
        }

      

        Map<Character, Integer> specialCount = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {

           
            int t = Character.getType(c);
            boolean isSymbol =
                    t == Character.MATH_SYMBOL
                 || t == Character.CURRENCY_SYMBOL
                 || t == Character.MODIFIER_SYMBOL
                 || t == Character.OTHER_SYMBOL;
            if (isSymbol) {
                specialCount.put(c, specialCount.getOrDefault(c, 0) + 1);
            }
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



