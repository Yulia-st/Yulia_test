package lesson34_home_task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class Main {
	public static void main(String[] args) {

		String str = "Да эх раз да ещё раз " 
				+ "да ещё много много много много раз " 
				+ "да ещё раз ещё много много раз";
		System.out.println("Дана строка:\n" + str);
		System.out.println();
		System.out.println("Определено, сколько раз встречается каждое слово:");

		String[] words_arr = str.split(" ");

		List<String> words_list = new ArrayList<>(Arrays.asList(words_arr));
		Map<String, Long> countWords = words_list.stream()
				.map((value) -> value.toLowerCase())
				.collect(groupingBy(s -> s, counting()));

		for (String key : countWords.keySet()) {
			System.out.println(key + ": " + countWords.get(key));
		}
		System.out.println();
		System.out.println("Отсортировано по частоте вхождения слова в строку:");
		countWords.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.forEach(s -> System.out.println(s));
		System.out.println();

		
	}
}
