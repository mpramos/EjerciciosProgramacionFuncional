import java.util.ArrayList;

public class Ejercicio1 {

  public static void main(String[] args) {
    ArrayList<Person> personList = GenerateData.getPersons();
    filterPersonsByAgeAndShort(personList);
  }

  private static void filterPersonsByAgeAndShort(ArrayList<Person> personList){
      personList.stream()
              .filter(person -> person.getAge() >= 18 && person.getAge() <= 54)
              .map( person -> {
                String nameToCapitalCase = Character.toUpperCase( person.getName().charAt(0)) +  person.getName().substring(1);
                String lastNameToCapitalCase = Character.toUpperCase( person.getLastName().charAt(0)) +  person.getLastName().substring(1);
                person.setName(nameToCapitalCase);
                person.setLastName(lastNameToCapitalCase);
                return person;
              })
              .sorted((personLeft, personRight) -> {
                String namePersonLeft = personLeft.getLastName();
                String namePersonRight = personRight.getLastName();
                return namePersonLeft.compareTo(namePersonRight) ;
              })
              .forEach(System.out::println);
  }
}
