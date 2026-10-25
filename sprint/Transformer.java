//package sprint;
//
//import java.util.*;
//
//public class Transformer {
//    public static int[] transform(int[] array) {
//        if (array == null || array.length == 0) {
//            return new int[0];
//        }
//        Set<Integer> set = new LinkedHashSet<>();
//        for (int num : array) {
//            set.add(num);
//        }
//
//        List<Integer> list = new ArrayList<>(set);
//
//        list.sort(Collections.reverseOrder());
//
//        for (int i = 2; i < list.size(); i += 3) {
//            int newVal = list.get(i - 1) + list.get(i - 2);
//            list.set(i, newVal);
//        }
//
//        Collections.reverse(list);
//
//        // Перетворити у int[]
//        int[] result = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            result[i] = list.get(i);
//        }
//
//        return result;
//    }
//}