//package sprint;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Combinations {
//
//    public List<String> combN(int n) {
//        List<String> result = new ArrayList<>();
//
//
//        if (n <= 0) return result;
//
//
//        backtrack(result, new StringBuilder(), 0, n);
//
//        return result;
//    }
//
//    private void backtrack(List<String> result, StringBuilder current, int start, int n) {
//        if (current.length() == n) {
//            result.add(current.toString());
//            return;
//        }
//
//
//        for (int i = start; i <= 9; i++) {
//            current.append(i);
//            backtrack(result, current, i + 1, n);
//            current.deleteCharAt(current.length() - 1); // backtrack (відкат)
//        }
//    }
//}
