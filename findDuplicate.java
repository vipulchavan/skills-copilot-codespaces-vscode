//import packages
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class findDuplicate {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 4, 7, 8, 9, 10, 5);
        //find duplicate elements in list using stream and add into other list
        List<Integer> duplicateElements = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        //print duplicate elements
        System.out.println("Duplicate elements in list are: " + duplicateElements);
    }
}