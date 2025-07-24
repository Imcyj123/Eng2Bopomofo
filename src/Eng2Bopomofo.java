import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
public class Eng2Bopomofo {
    private static final Map<Character, Character> BOPOMOFO_MAP = Map.ofEntries(
            Map.entry('1', 'ㄅ'), Map.entry('q', 'ㄆ'), Map.entry('a', 'ㄇ'), Map.entry('z', 'ㄈ'),
            Map.entry('2', 'ㄉ'), Map.entry('w', 'ㄊ'), Map.entry('s', 'ㄋ'), Map.entry('x', 'ㄌ'),
            Map.entry('e', 'ㄍ'), Map.entry('d', 'ㄎ'), Map.entry('c', 'ㄏ'), Map.entry('r', 'ㄐ'),
            Map.entry('f', 'ㄑ'), Map.entry('v', 'ㄒ'), Map.entry('5', 'ㄓ'), Map.entry('t', 'ㄔ'),
            Map.entry('g', 'ㄕ'), Map.entry('b', 'ㄖ'), Map.entry('y', 'ㄗ'), Map.entry('h', 'ㄘ'),
            Map.entry('n', 'ㄙ'), Map.entry('u', 'ㄧ'), Map.entry('j', 'ㄨ'), Map.entry('m', 'ㄩ'),
            Map.entry('i', 'ㄛ'), Map.entry('k', 'ㄜ'), Map.entry(',', 'ㄝ'), Map.entry('8', 'ㄚ'),
            Map.entry('9', 'ㄞ'), Map.entry('o', 'ㄟ'), Map.entry('l', 'ㄠ'), Map.entry('.', 'ㄡ'),
            Map.entry('0', 'ㄢ'), Map.entry('p', 'ㄣ'), Map.entry(';', 'ㄤ'), Map.entry('/', 'ㄥ'),
            Map.entry('-', 'ㄦ'), Map.entry('3', 'ˇ'), Map.entry('4', 'ˋ'), Map.entry('6', 'ˊ'),
            Map.entry('7', '˙'), Map.entry(' ', ' ')
    );

    /**
     * 核心轉換邏輯
     *
     * @param input 原始英數文字
     * @return 轉換後的注音文字
     */
    public String convert(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        return input.chars()
                .mapToObj(c -> (char) c)
                .map(c -> BOPOMOFO_MAP.getOrDefault(c, c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("用法: java Eng2Bopomofo <輸入檔名> <輸出檔名>");
            System.out.println("範例: java Eng2Bopomofo input.txt output.txt");
            return;
        }
        Path inputPath = Paths.get(args[0]);
        Path outputPath = Paths.get(args[1]);
        Eng2Bopomofo converter = new Eng2Bopomofo();
        try {
            String inputData = Files.readString(inputPath, StandardCharsets.UTF_8);
            String outputData = converter.convert(inputData);
            Files.writeString(outputPath, outputData, StandardCharsets.UTF_8);
            System.out.println("轉換成功！");
            System.out.println("輸入檔案: " + inputPath.toAbsolutePath());
            System.out.println("輸出檔案: " + outputPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("處理檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
    }
}