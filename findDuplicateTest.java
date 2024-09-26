//import packages
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.Map;
import java.util.stream.Collectors;

public class findDuplicateTest {

	@Test
	public void testNoDuplicates() {
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		List<Integer> expected = Collections.emptyList();
		List<Integer> actual = findDuplicates(list);
		assertEquals(expected, actual);
	}

	@Test
	public void testMultipleDuplicates() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 4, 7, 8, 9, 10, 5);
		List<Integer> expected = List.of(4, 5);
		List<Integer> actual = findDuplicates(list);
		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyList() {
		List<Integer> list = Collections.emptyList();
		List<Integer> expected = Collections.emptyList();
		List<Integer> actual = findDuplicates(list);
		assertEquals(expected, actual);
	}

	@Test
	public void testAllSameElements() {
		List<Integer> list = List.of(1, 1, 1, 1, 1);
		List<Integer> expected = List.of(1);
		List<Integer> actual = findDuplicates(list);
		assertEquals(expected, actual);
	}

	private List<Integer> findDuplicates(List<Integer> list) {
		return list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
}