//package sprint;
//
//import java.time.LocalDate;
//import java.time.DayOfWeek;
//
//public class WeekendCalculator {
//
//    public long countWeekendDays(LocalDate startDate, LocalDate endDate) {
//        long count = 0;
//
//
//        LocalDate current = startDate;
//        while (!current.isAfter(endDate)) {
//            DayOfWeek day = current.getDayOfWeek();
//            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
//                count++;
//            }
//            current = current.plusDays(1);
//        }
//
//        return count;
//    }
//}
