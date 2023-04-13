import enums.Gender;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class Ejercicio8 {
    public static void main(String[] args) {
        ArrayList<Person> personList = GenerateData.getPersons();
        filterPeopleByGenderDateOfBirthCell(personList);
    }
    private static void filterPeopleByGenderDateOfBirthCell(ArrayList<Person> personList){
        Scanner scanner = new Scanner(System.in);
        int selection;
        do {
            System.out.println("Seleccione el género:");
            System.out.println("1 - Femenino");
            System.out.println("2 - Masculino");
            System.out.println("0 - Salir");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Ha seleccionado el género Femenino.");
                    break;
                case 2:
                    System.out.println("Ha seleccionado el género Masculino.");
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Selección inválida. Intente de nuevo.");
                    break;
            }
       Gender gender = (selection == 1) ? Gender.FEMALE : selection == 2 ? Gender.MALE : null;
       personList.stream()
                .distinct()
                .sorted(Comparator.comparing(Person::getBirthDate).reversed())
                .filter(p->p.getPhone()!=null)
                .filter(p->p.getGender()==gender)
                .limit(20)
                .forEach(System.out::println);
        } while (selection != 0);
        scanner.close();
    }
}
