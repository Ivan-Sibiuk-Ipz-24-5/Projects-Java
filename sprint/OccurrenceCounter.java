//package sprint;
//
//public class OccurrenceCounter {
//
//    public int countOccurrences(int[] arr, int element, int index) {
//
//        if (arr == null || arr.length == 0 || index < 0 || index >= arr.length) {
//            return 0;
//        }
//
//
//        if (arr[index] == element) {
//            return 1 + countOccurrences(arr, element, index + 1);
//        } else {
//            return countOccurrences(arr, element, index + 1);
//        }
//    }
//}
