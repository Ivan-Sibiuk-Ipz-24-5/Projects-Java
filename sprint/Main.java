import sprint.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.Map;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//import sprint.DayChecker;
//import sprint.PalindromeChecker;
//import sprint.WeekendCalculator;
//import sprint.AnagramChecker;
//import sprint.Fibonacci;
//import sprint.GCDRecursive;
//import  sprint.RecursivePalindrome;
//import sprint.OccurrenceCounter;
//import sprint.ParenthesesBalanceChecker;
import sprint.WeatherStation;

public class Main {
      public static void main(String[] args) {
        // List<Double> list = new ArrayList<>();
        // list.add(1.5);
        // list.add(2.5);
        // list.add(3.5);
        // list.add(4.5);
        //list.add(5.5);

        //List<Double> result = ArrayModifier.removeElementsBetween(new ArrayList<>(list), 1, 3);

        // for (double num : result) {
        //  System.out.print(num + " ");
        // }


        // String Conventator
        // StringConcatenator stringConcatenator = new StringConcatenator();
        // String result = stringConcatenator.concatenate("Hello", ", ", "varArgs", "!");
        //System.out.println(result);

//int [][] array = {
        //   {1, 2, 3},
        //  {4, 5, 6},
        //  {7, 8, 9},
        //  {1, 1, 1},
//};


        // ArrayInitializer
//ArrayFilter arrayFilter = new ArrayFilter();
//int [][] filteredArray = arrayFilter.filterBySum(array, 10);

//for (int[] row : filteredArray) {
        //System.out.println(Arrays.toString(row));
//}


        // Combination N
        //Combinations comb = new Combinations();
        //System.out.println(comb.combN(3));


// Transformer
        // int[] arr = {5, 3, 5, 2, 8, 3, 9, 2};
        //   int[] result = Transformer.transform(arr);

        //System.out.println(Arrays.toString(result));


        // PoliceStreams
        // StreamPolice processor = new StreamPolice();
        //  List<Integer> numbers = Arrays.asList(-10, 15, 20, 30, 8, -3, 5, 10, 50, 12);
        //List<Integer> result = processor.processNumbers(numbers);
        // System.out.println(result);


        //StringToIntConverter
        // StringToIntConverter converter = new StringToIntConverter();
        //List<String> input = Arrays.asList("23", "45", "-15");
        //List<Integer> result = converter.convertStringListToIntList(input);
        //System.out.println(result);


        //UsernameProcessor
        // UsernameProcessor processor = new UsernameProcessor();
        // List<String> usernames = Arrays.asList("usr", "user12", "test", "validUser", "12345");
        // String firstUsername = processor.findFirstUsername(usernames);
        // System.out.println(firstUsername);


// EmailDomainExtractor
        //  EmailDomainExtractor extractor = new EmailDomainExtractor();
        // List<String> emails = Arrays.asList(
        //    "USER1@EXAMPLE.COM",
        //    "user2@Example.com",
        //    "user1@EXAMPLE.COM",
        //    "user3@SAMPLE.ORG",
        //   "INVALIDEMAIL@",
        //   "user4@SAMPLE.ORG"
        // );
        // List<String> domains = extractor.extractDomains(emails);
        // domains.forEach(System.out::println);

        //NumberProcessor
        //     NumberProcessor processor = new NumberProcessor();
        //   List<Integer> numbers = Arrays.asList(3, 5, 12, 20, 7, 10);

        //  Optional<Integer> result = processor.processNumbers(numbers);
        //  System.out.println(result);


        //WordLengthAnalyzer analyzer = new WordLengthAnalyzer();
        //  Map<Integer, Integer> result = analyzer.analyzeWordLengths(
        //         Arrays.asList("apple", "banana", "cherry", "date", "fig")
        // );

        //System.out.println(result);

//CustomIterator

        //List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // CustomIterator iterator = new CustomIterator(numbers);

        // while (iterator.hasNext()) {
        //  System.out.println(iterator.next());
        //  }


        //Method Overloading

        //AreaCalculator calculator = new AreaCalculator();
        // double squareArea = AreaCalculator.calculateArea(5);
        // System.out.println("Area of square: " + squareArea);

        //double rectangleArea = AreaCalculator.calculateArea(5, 10);
        //System.out.println("Area of rectangle: " + rectangleArea);

        //double circleArea = AreaCalculator.calculateArea(7, true);
        // System.out.println("Area of circle: " + circleArea);

        // double invalidCircleArea = AreaCalculator.calculateArea(7, false);
        // System.out.println("Area of circle boolean=false: " + invalidCircleArea);

        // PrimeFinder


    //    int limit = 30;
      //  List<Integer> primes = PrimeFinder.findPrimesUpTo(limit);
        //System.out.println(primes);


      //  LocalDate weekdayDate = LocalDate.of(2024, 8, 26);
       // LocalDate weekendDate = LocalDate.of(2024, 8, 31);
      //  LocalDate wednesdayDate = LocalDate.of(2024, 8, 28);

      //  System.out.println(DayChecker.checkDayType(weekdayDate));
     //   System.out.println(DayChecker.checkDayType(weekendDate));
      //  System.out.println(DayChecker.checkDayType(wednesdayDate));


         // LocalDate startDate = LocalDate.of(2024, 8, 1);
        //  LocalDate endDate = LocalDate.of(2024, 8, 31);
        //  WeekendCalculator calculator = new WeekendCalculator();
        //  long weekendDayCount = calculator.countWeekendDays(startDate, endDate);
        //  System.out.println(weekendDayCount);




//          String testString1 = "A man, a plan, a canal, Panama";
//          String testString2 = "Hello, World!";
//          System.out.println(PalindromeChecker.isPalindrome(testString1));
//          System.out.println(PalindromeChecker.isPalindrome(testString2));




//
//          String string1 = "Listen";
//          String string2 = "Silent";
//          String string3 = "Hello";
//          System.out.println(AnagramChecker.areAnagrams(string1, string2));
//          System.out.println(AnagramChecker.areAnagrams(string1, string3));



//          Factorial calculator = new Factorial();
//          System.out.println(calculator.calculateFactorial(5));
//          System.out.println(calculator.calculateFactorial(-3));

//
//          Fibonacci calculator = new Fibonacci();
//          System.out.println(calculator.calculateFibonacci(6));
//          System.out.println(calculator.calculateFibonacci(-3));




//          GCDRecursive calculator = new GCDRecursive();
//          System.out.println(calculator.gcd(48, 18));
//          System.out.println(calculator.gcd(100, 75));


//          RecursivePalindrome checker = new RecursivePalindrome();
//          System.out.println(checker.isPalindrome("A man, a plan, a canal: Panama"));
//          System.out.println(checker.isPalindrome("race a car"));
//          System.out.println(checker.isPalindrome(""));
//          System.out.println(checker.isPalindrome("a"));
//          System.out.println(checker.isPalindrome("   "));
//          System.out.println(checker.isPalindrome(null));


//          OccurrenceCounter counter = new OccurrenceCounter();
//          int[] arr = {1, 2, 3, 2, 4, 2, 5};
//          System.out.println(counter.countOccurrences(arr, 2, 0));
//          System.out.println(counter.countOccurrences(arr, 6, 0));
//          System.out.println(counter.countOccurrences(null, 1, 0));
//          System.out.println(counter.countOccurrences(new int[]{}, 1, 0));


//          ParenthesesBalanceChecker checker = new ParenthesesBalanceChecker();
//          System.out.println(checker.isBalanced("(())"));
//          System.out.println(checker.isBalanced("(a()b()c)"));
//          System.out.println(checker.isBalanced("(()"));
//          System.out.println(checker.isBalanced(")("));
//          System.out.println(checker.isBalanced(""));
//          System.out.println(checker.isBalanced(null));



            WeatherStation ws = new WeatherStation();
            System.out.println(ws.getState());
            ws.updateState("11,15.5");
            ws.updateState("13,32.3");
            System.out.println(ws.getState());
            ws.updateState("11,15.7\n13,33.1");
            System.out.println(ws.getState());
            ws.clearState();
            System.out.println(ws.getState());
      }
}


