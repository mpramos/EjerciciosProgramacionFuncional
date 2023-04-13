import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        ArrayList<Person> personList = GenerateData.getPersons();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person to search for");
        String name = sc.nextLine().toLowerCase();
        searchPersonByName(name, personList);
    }

    private static void searchPersonByName(String name, ArrayList<Person> personsList) {
        String nameToLowerCase = name.toLowerCase();

        Person matchPersons = personsList.stream()
                .filter(person -> person.getName().toLowerCase().equals(nameToLowerCase))
                .findFirst().orElse(null);

        if (matchPersons != null) {
            System.out.println("The person registered with the name entered is:");
            System.out.println(matchPersons.toString());
        } else {
            System.out.println("There is no person registered with the name entered.");
        }
    }
}