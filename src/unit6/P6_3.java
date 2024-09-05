package unit6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 로그를 재 정 렬하라. 기준은 다음과 같다
 */
public class P6_3 {
    public static void main(String[] args) {

        String[] logs = {};

        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for(String log : logs) {
            if(Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        Collections.sort(letterList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1x = s1.split(" ", 2);
                String[] s2x = s2.split(" ", 2);

                int compared = s1x[1].compareTo(s2x[1]);
                if(compared == 0) {
                    return s1x[0].compareTo(s2x[0]);
                } else {
                    return compared;
                }
            }
        });

        Collections.sort(letterList, (s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if(compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });
    }
}
