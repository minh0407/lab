package lab8;
import java.util.*;
public class Lab8 {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your content: ");
        String input = sc.nextLine();
        
        // Đếm số từ
        String[] tokens = input.trim().split("\\s+");
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String t : tokens) {
            if (t.isEmpty()) continue; // t rỗng thì bỏ qua

            // bỏ ký tự không phải chữ/số
            StringBuilder sb = new StringBuilder();
            for (char c : t.toCharArray()) { //với mỗi kí tự trong t, chỉ giữ lại chữ cái hoặc số
                if (Character.isLetterOrDigit(c)) {
                    sb.append(Character.toLowerCase(c)); //không phân biệt chữ hoa chữ thường 
                }
            }

            String word = sb.toString();
            if (word.isEmpty()) continue; // loại bỏ nếu token toàn dấu câu, khi lọc sẽ rỗng-> bỏ qua

            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            //cập nhật giá trị, lấy giá trị hiện tại, chưa có mặc định = 0, +1 để đếm 
        }

        // Đếm số lần xuất hiện của chữ cái (letters)
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) { // chỉ tính chữ cái
                char lower = Character.toLowerCase(c);
                charCount.put(lower, charCount.getOrDefault(lower, 0) + 1);
            }
        }

        // In kết quả
        System.out.println(wordCount);
        System.out.println(charCount);
        
        //check khi nhap nhieu tu
        //.value: lấy ra tất cả giá trị
        //.stream: biến danh sách thành 1 luồng dữ liệu Stream<Integer>
        //để thao tác kiểu hàm
        //.mapToInt(Integer::intValue)
        //mỗi phần tử trông stream là 1 Integer
        //chuyển Integer thành int, tạo hàm IntStream
        //.sum: cộng tất cả giá trị trong IntStream
        int totalWords = wordCount.values().stream().mapToInt(Integer::intValue).sum();
        int totalLetters = charCount.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words: " + totalWords);
        System.out.println("Total letters: " + totalLetters);
    }
    
}

//"hello world"  ra đúng như hình
//
//"he?llo??" ra {hello=1} và {h=1, e=1, l=2, o=1}.
//
//" " → ra {} và {}.
//
//"Hello hello HELLO" → word {hello=3}, letters {h=3, e=3, l=6, o=3}.
//
//"xin chào thế giới" → word {xin=1, chào=1, thế=1, giới=1}, letters tính cả chữ có dấu.
//
//"java 123 java" → word {java=2, 123=1}, letters {j=2, a=4, v=2}.
//
//"!!!" → word {}, letters {}.
