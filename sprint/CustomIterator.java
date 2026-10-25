//package sprint;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//public class CustomIterator implements Iterator<Integer> {
//    private final List<Integer> list;
//    private int currentIndex;
//
//    public CustomIterator(List<Integer> list) {
//        if (list == null) {
//            throw new IllegalArgumentException("List cannot be null");
//        }
//        this.list = list;
//        this.currentIndex = 0;
//    }
//
//    @Override
//    public boolean hasNext() {
//        return currentIndex < list.size();
//    }
//
//    @Override
//    public Integer next() {
//        if (!hasNext()) {
//            throw new NoSuchElementException("No more elements in the iterator");
//        }
//        return list.get(currentIndex++);
//    }
//}
