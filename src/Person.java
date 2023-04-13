import enums.Gender;

import java.util.Date;

public class Person implements Comparable<Person> {
  private String name;
  private String lastName;
  private Integer age;
  private String email;
  private Gender gender;
  private String phone;

  private Date birthDate;

  public Person() {
  }

  public Person(String firstName, String lastName, String email, Gender gender, String phone, Date birthDate) {
    this.name = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.phone = phone;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String firstName) {
    this.name = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    Person that = (Person) obj;
    return this.phone.equals(that.phone);

  }

  @Override
  public int compareTo(Person o) {
    return this.lastName.compareTo(o.lastName);
  }

  @Override
  public String toString() {
    return "Person{" +
            "Name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", gender=" + gender +
            ", age=" + age +
            ", phone='" + phone + '\'' +
            ", birthDate=" + birthDate +
            '}';
  }

}
