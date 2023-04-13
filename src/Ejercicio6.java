import enums.Gender;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Ejercicio6 {

    public static void main(String[] args) {
        ArrayList<Person> personList = GenerateData.getPersons();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese el año que desea filtrar");
        int year = scanner.nextInt();
        filterPersonsByAgeAndShort(personList, year);
    }
    private static void filterPersonsByAgeAndShort(ArrayList<Person> personList, int year){
        personList.stream()
                .sorted((personLeft, personRight) -> {
                    String lastNamePersonLeft = personLeft.getLastName();
                    String lastNamePersonRight = personRight.getLastName();
                    return lastNamePersonLeft.compareTo(lastNamePersonRight) ;
                })
                .distinct()
                .filter(person ->  person.getBirthDate().getYear() + 1900 == year)

                .forEach(person -> {
                    String fullName = person.getLastName() + " " + person.getName();
                    String birthDate = new SimpleDateFormat("MM/dd/yyyy").format(person.getBirthDate());
                    String phone = person.getPhone();
                    String gender = person.getGender().toString();

                    System.out.println(fullName + ", " + birthDate + ", " + phone + ", " + gender);
                });
    }
}