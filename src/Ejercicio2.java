import java.util.ArrayList;
import enums.Gender;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Ejercicio2 {
    public static void main(String[] args) {
    ArrayList<Person> personList = GenerateData.getPersons();
    countMenAndWomenWithoutRepeat(personList);
}
    private static void countMenAndWomenWithoutRepeat(ArrayList<Person> personList){
        Map<Gender, Long> totalCount = personList.stream()
                .filter(distinctByKey(Person::getEmail))
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        System.out.println(totalCount);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}

