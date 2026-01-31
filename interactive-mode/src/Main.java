import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Character, Character> MAPPING = new HashMap<>();
    static BufferedReader in;
    static BufferedWriter out;
    static {
        String keys = "1234567890-qwertyuiopasdfghjkl;zxcvbnm,./";
        String bops = "ㄅㄉˇˋㄓˊ˙ㄚㄞㄢㄦㄆㄊㄍㄐㄔㄗㄧㄛㄟㄣㄇㄋㄎㄑㄕㄘㄨㄜㄠㄤㄈㄌㄏㄒㄖㄙㄩㄝㄡㄥ";
        for (int i = 0; i < keys.length(); i++) {
            MAPPING.put(keys.charAt(i), bops.charAt(i));
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("=== 英文鍵盤轉注音工具 ===");
        System.out.println("請輸入英文鍵盤序列（例如 1qaz），輸入 'exit' 退出：");

        in = new BufferedReader(new InputStreamReader(System.in));
        String input;

        // 修改這裡：先檢查是否為 null
        while ((input = in.readLine()) != null) {
            if (input.isEmpty()) continue; // 跳過空行
            if ("exit".equalsIgnoreCase(input)) break;

            StringBuilder sb = new StringBuilder();
            for (char c : input.toLowerCase().toCharArray()) {
                sb.append(MAPPING.getOrDefault(c, c));
            }
            System.out.println("注音結果: " + sb.toString());
            System.out.print("> ");
        }
    }
}
