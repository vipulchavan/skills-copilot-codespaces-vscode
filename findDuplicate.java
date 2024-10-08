//import packages
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;



public class findDuplicate {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 4, 7, 8, 9, 10, 5);
        //find duplicate elements in list using stream and add into other list
        List<Integer> duplicateElements = findDuplicates(list);

        //print duplicate elements
        System.out.println("Duplicate elements in list are: " + duplicateElements);
    }

    private static List<Integer> findDuplicates(List<Integer> list) {
        // Add block comment here

        /*return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());*/

       //use Set datastructure to find duplicate elements

        Set<Integer> seen = new HashSet<>();
        return list.stream()
            .filter(n -> !seen.add(n))
            .collect(Collectors.toList());
    }
}