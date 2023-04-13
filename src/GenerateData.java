import enums.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GenerateData {
  private static final String PATH_FILE = "G:\\SintaxSquad\\EjerciciosProgramacionFuncional\\src\\datos_ejercicios.csv";
  private static final String DELIMITER = ",";
  private static final String FORMAT_DATE = "dd/mm/yyyy";
  private static final int AMOUNT_DATA = 500;

  public static ArrayList<Person> getPersons() {
    ArrayList<Person> personArray = new ArrayList<>(AMOUNT_DATA +1);
    try (Scanner scanner = new Scanner(new File(PATH_FILE))) {
//      int index = 0;
      while (scanner.hasNextLine()) {
        String dataString = scanner.nextLine();
        Person person = GenerateData.extractInformation(dataString);
//        person.setId(index);
        GenerateData.setAgeToPerson(person);
        personArray.add(person);
//        personArray[index] = person;
//        index++;
      }
    } catch (FileNotFoundException ex) {
      System.out.println("ERROR WHEN READING FILE " + ex.getMessage());
    }
    return personArray;
  }

  private static void setAgeToPerson(Person person) {
    LocalDate birthDate = person.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate now = LocalDate.now();
    Period period = Period.between(birthDate, now);
    person.setAge(period.getYears());
  }

  private static Person extractInformation(String line) {
    String[] data = line.split(DELIMITER);
    Person person = new Person();
    person.setName(data[0]);
    person.setLastName(data[1]);
    person.setEmail(data[2]);
    person.setGender(GenerateData.getGender(data[3]));
    person.setPhone(data[4]);
    person.setBirthDate(GenerateData.getDate(data[5]));
    return person;
  }

  private static Date getDate(String dateString) {
    try {
      return new SimpleDateFormat(FORMAT_DATE).parse(dateString);
    } catch (ParseException e) {
      return null;
    }
  }

  private static Gender getGender(String genderString) {
    return Gender.valueOf(genderString);
  }
}
