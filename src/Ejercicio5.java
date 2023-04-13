import enums.Gender;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Person> personList = GenerateData.getPersons();
        Scanner scanner = new Scanner(System.in);
        int gender;
        do {
            System.out.println("Por favor, ingrese 1 para genero FEMALE o 2 para MALE");
            gender = scanner.nextInt();
            if (gender != 1 && gender != 2) {
                System.out.println("Entrada inválida.");
            }else {
                filterPersonsByAgeAndShort(personList, gender);
            }
        } while (gender != 1 && gender != 2);
    }

    private static void filterPersonsByAgeAndShort(ArrayList<Person> personList, int gender){
        personList.stream()
                .filter(person -> person.getAge() >= 18 && person.getGender() == (gender==1?Gender.FEMALE:Gender.MALE))
                .sorted((personLeft, personRight) -> {
                    String lastNamePersonLeft = personLeft.getLastName();
                    String lastNamePersonRight = personRight.getLastName();
                    return lastNamePersonRight.compareTo(lastNamePersonLeft) ;
                })
                .forEach(System.out::println);
    }
}