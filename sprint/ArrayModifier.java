//package sprint;
//
//import java.util.ArrayList;
//
//public class ArrayModifier {
//
//    public static ArrayList<Double> removeElementsBetween(ArrayList<Double> list, int index1, int index2) {
//
//        if (list == null || list.isEmpty()) {
//            return list;
//        }
//
//
//        if (index1 > index2) {
//            int temp = index1;
//            index1 = index2;
//            index2 = temp;
//        }
//
//
//        index1 = Math.max(0, index1);
//        index2 = Math.min(list.size(), index2);
//
//
//        if (index1 < index2) {
//            list.subList(index1, index2).clear();
//        }
//
//        return list;
//    }
//}
