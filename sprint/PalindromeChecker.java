//package sprint;
//
//public class PalindromeChecker {
//
//    public static boolean isPalindrome(String input) {
//        if (input == null) return false;
//
//
//        String cleaned = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//
//
//        int left = 0;
//        int right = cleaned.length() - 1;
//
//        while (left < right) {
//            if (cleaned.charAt(left) != cleaned.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//
//        return true;
//    }
//}
