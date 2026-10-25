//package sprint;
//
//public class ParenthesesBalanceChecker {
//
//    public boolean isBalanced(String str) {
//        if (str == null) {
//            return false;
//        }
//        return checkBalance(str, 0, 0);
//    }
//
//    private boolean checkBalance(String str, int index, int balance) {
//        // Якщо баланс < 0, значить закрили дужку без відкритої
//        if (balance < 0) {
//            return false;
//        }
//
//        if (index == str.length()) {
//            return balance == 0;
//        }
//
//        char c = str.charAt(index);
//        if (c == '(') {
//            return checkBalance(str, index + 1, balance + 1);
//        } else if (c == ')') {
//            return checkBalance(str, index + 1, balance - 1);
//        } else {
//            return checkBalance(str, index + 1, balance);
//        }
//    }
//}
