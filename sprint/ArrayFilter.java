//package sprint;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArrayFilter {
//
//    public int[][] filterBySum(int [][] array, int minSum){
//        List<int[]> list = new ArrayList<>();
//
//        for (int[] row : array) {
//            int sum = 0;
//            for (int num : row) {
//                sum += num;
//            }
//            if (sum >= minSum) {
//                list.add(row);
//            }
//        }
//        return list.toArray(new int[list.size()][]);
//    }
//}
