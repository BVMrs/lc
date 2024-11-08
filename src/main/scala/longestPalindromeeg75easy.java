import java.util.HashMap;
import java.util.Map;

public class longestPalindromeeg75easy {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            chars.merge(s.charAt(i), 1, Integer::sum);
        }

        int doubles = 0;

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() % 2 == 0)
                doubles++;
        }

        return doubles;
    }
}
