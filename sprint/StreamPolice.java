//package sprint;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class StreamPolice {
//
//    public List<Integer> processNumbers(List<Integer> numbers) {
//        return numbers.stream()
//                .filter(x -> x >= 0)
//                .filter(x -> !(x % 5 == 0 && x % 10 != 0))
//                .collect(Collectors.toList());
//    }
//}
