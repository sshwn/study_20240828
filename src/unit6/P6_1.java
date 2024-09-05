package unit6;

/**
 * 주어진 문자열이 팰린드롬인지 확인하라. 대소문자를 구분하지 않으며. 영숫자(영문자와
 * 숫자)만을 대상으로 한다.
 * 앞뒤가 똑같은 단어나 문장으로, 뒤집어도 같은 말이 되는 단
 * 어 또는 문장을 팰린드롬(Palindrome)이라고 한다.
 */
public class P6_1 {
    public static void main(String[] args) {
        String s = "Do geese see God";
        myTest(s);
        isPalindrome(s);
        isPalindrome2(s);
    }

    private static boolean myTest(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private static boolean isPalindrome2(String s) {
        // 정규식으로 유효한 문자만 추출 후 모두 소문자로 변경
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // 문자열을 뒤집은 다음 String으로 변경
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();
        // 두 문자열이 동일한지 비교
        return s_filtered.equals(s_reversed);
    }

    private static boolean isPalindrome(String s) {
        s = s.replaceAll(" ", "");
        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if(!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if(!Character.isLetterOrDigit(s.charAt(end))) {
                end++;
            } else {
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
