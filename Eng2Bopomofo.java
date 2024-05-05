import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Eng2Bopomofo {
    public static void main(String[] args) {
        Map<Character, Character> map = new HashMap<>();
        map.put('1', 'ㄅ');
        map.put('2', 'ㄉ');
        map.put('3', 'ˇ');
        map.put('4', 'ˋ');
        map.put('5', 'ㄓ');
        map.put('6', 'ˊ');
        map.put('7', '˙');
        map.put('8', 'ㄚ');
        map.put('9', 'ㄞ');
        map.put('0', 'ㄢ');
        map.put('-', 'ㄦ');
        map.put('q', 'ㄆ');
        map.put('w', 'ㄊ');
        map.put('e', 'ㄍ');
        map.put('r', 'ㄐ');
        map.put('t', 'ㄔ');
        map.put('y', 'ㄗ');
        map.put('u', 'ㄧ');
        map.put('i', 'ㄛ');
        map.put('o', 'ㄟ');
        map.put('p', 'ㄣ');
        map.put('a', 'ㄇ');
        map.put('s', 'ㄋ');
        map.put('d', 'ㄎ');
        map.put('f', 'ㄑ');
        map.put('g', 'ㄕ');
        map.put('h', 'ㄘ');
        map.put('j', 'ㄨ');
        map.put('k', 'ㄜ');
        map.put('l', 'ㄠ');
        map.put(';', 'ㄤ');
        map.put('z', 'ㄈ');
        map.put('x', 'ㄌ');
        map.put('c', 'ㄏ');
        map.put('v', 'ㄒ');
        map.put('b', 'ㄖ');
        map.put('n', 'ㄙ');
        map.put('m', 'ㄩ');
        map.put(',', 'ㄝ');
        map.put('.', 'ㄡ');
        map.put('/', 'ㄥ');
        map.put(' ', ' ');
        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("output.txt");
        try {
            String inputData = Files.readString(inputPath, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            for (char c : inputData.toCharArray()) {
                sb.append(map.getOrDefault(c, c));
            }
            String outputData = sb.toString();
            Files.writeString(outputPath, outputData, StandardCharsets.UTF_8);
            System.out.println("Input: " + inputData);
            System.out.println("Output: " + outputData);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println(e);
        }
    }
}