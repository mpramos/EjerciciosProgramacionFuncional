import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio3 {

  public static void main(String[] args) {
    ArrayList<Person> personList = GenerateData.getPersons();
    filterPersonsByEmptyNumberPhone(personList);
    filterPersonsByFormatEmail(personList);
  }

  private static void filterPersonsByEmptyNumberPhone(ArrayList<Person> personsList) {
    System.out.println("--------------- FILTER PERSONS BY EMPTY NUMBER AND DELETE REPEATS-----------------------");
    personsList.stream()
            .filter(person -> !person.getPhone().isEmpty())
            .distinct()
            .forEach(person -> System.out.println(person.toString()));
  }

  private static void filterPersonsByFormatEmail(ArrayList<Person> personsList) {
    System.out.println("\n--------------- FILTER PERSONS BY FORMAT EMAIL INCORRECT------------------------------");
    ArrayList<Person> personsFilterList = new ArrayList<>();
    for (int i = 0; i < personsList.size() - 1; i++) {
      if (!personsList.get(i).getEmail().isEmpty()) {
        String acronymOfName = personsList.get(i).getName().toLowerCase().charAt(0) + personsList.get(i).getLastName().toLowerCase().replace(" ", "");
        if (!isEmailValid(personsList.get(i).getEmail(), acronymOfName)) {
          personsFilterList.add(personsList.get(i));
        }
      }
    }
    personsFilterList.stream()
            .forEach(person -> System.out.println(person.toString()));
  }

  public static boolean isEmailValid(String email, String acronymName) {
    Pattern pattern = Pattern.compile(acronymName.concat("^*[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
    Matcher mather = pattern.matcher(email);
    return mather.find();
  }
}
