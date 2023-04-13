import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Ejercicio7 {
    public static void main(String[] args) {
        ArrayList<Person> personList = GenerateData.getPersons();
        countUniqueBirthsInYear(personList);
    }
    private static void countUniqueBirthsInYear(ArrayList<Person> personList){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese el año de nacimiento: ");
        int year = scanner.nextInt();
        long count = personList.stream()
                .distinct()
                .filter(p -> p.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == year)
                .count();
        System.out.println("Cantidad de personas que nacieron en el año " + year + ": " + count);
               personList.stream()
                .distinct()
                .filter(p -> p.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear() == year)
                .forEach(System.out::println);
    }
}
