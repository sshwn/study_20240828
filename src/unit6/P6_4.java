package unit6;


import java.util.*;

/**
 * 금지된 단어를 제외하고 가장 흔하게 등장하는 단어를 출력하라. 대소문자를 구분하지 않
 * 으며. 구두점(마침표. 쉼표 등) 또한 무시한다.
 */
public class P6_4 {
    public static void main(String[] args) {
        String paragraph = "Ross hit a ball, the hit BALL flew far away after it was hit";
        String[] banned = {"hit"};
        System.out.println(myTest(paragraph, banned));
        mostCommonWord(paragraph, banned);
    }

    private static String myTest(String paragraph, String[] banned) {
        // 문자열 정제: 구두점 제거 및 소문자 변환
        String cleanedStr = paragraph.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

        // 단어 배열로 변환
        String[] words = cleanedStr.split("\\s+");

        // 금지된 단어를 Set으로 변환
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // 단어 빈도 계산
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // 가장 빈도가 높은 단어 찾기
        return  wordCount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

























    private static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> counts = new HashMap<>();

        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        for(String w : words) {
            if(!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w,0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
