package g75;

import java.util.HashMap;

public class ransomnoteg75easy {
    public static void main(String [] args) {
        System.out.println(canConstruct("joe", "joe biden"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charset = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            charset.merge(ransomNote.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < magazine.length(); i++) {
            decrementMap(charset, magazine.charAt(i));
        }

        return charset.entrySet().stream().allMatch(entry ->
                entry.getValue() < 1);
    }

    public static void decrementMap(HashMap<Character, Integer> charset, Character key) {
        if (charset.get(key) == null) {
            charset.put(key, -1);
        } else {
            charset.put(key, charset.get(key) - 1);
        }
    }
}
