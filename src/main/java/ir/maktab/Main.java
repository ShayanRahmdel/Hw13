package ir.maktab;


import ir.maktab.mockdata.MockData;
import ir.maktab.model.Person;
import ir.maktab.model.PersonSummary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {

        System.out.println("Q1=============");

        List<Person> ageGreaterThan50 = Objects
                .requireNonNull(MockData.getPeople())
                .stream()
                .filter(a -> a.getAge() > 50)
                .toList();

//        int index = 1;
//        for (Person person : ageGreaterThan50) {
//            System.out.println(index + ":" + person + " ");
//            index++;
//        }


        System.out.println("Q2==============");

        List<Person> sortByUsername = MockData
                .getPeople()
                .stream()
                .sorted(Comparator.comparing(Person::getUsername))
                .toList();
//
//        for (Person person : sortByUsername) {
//            System.out.println(person);
//        }

        System.out.println("Q3==============");

        List<Person> sortByAgeAndLastname = MockData
                .getPeople()
                .stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getLastName)).toList();

//
//        for (Person person : sortByAgeAndLastname) {
//            System.out.println(person);
//        }


        System.out.println("Q4==============");

        Set<String> mapTOIpv4 = MockData.getPeople()
                .stream()
                .map(Person::getIpv4)
                .collect(Collectors.toSet());
//
//        for (String map : mapTOIpv4) {
//            System.out.println(map);
//        }


        System.out.println("Q5================");
        Map<String, Person> question5 = MockData
                .getPeople()
                .stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .filter(person -> person.getGender()
                        .equals("Female") && person.getAge() > 40)
                .dropWhile(name -> name.getFirstName().startsWith("A"))
                .skip(5).limit(100)
                .collect(Collectors.toMap(person -> person.getFirstName() + " " + person.getLastName(), person -> person, (existingPerson, newPerson) -> existingPerson));


//        for (Map.Entry<String, Person> p : question5.entrySet()) {
//            System.out.println(p.getKey() + ": " + p.getValue());
//        }


        System.out.println("Q6=================");

        List<Integer> ages = MockData.getPeople()
                .stream().filter(p -> p.getGender().equals("Male"))
                .map(person -> {
                    Date birthDate = null;
                    try {
                        birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(person.getBirthDate());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    assert birthDate != null;
                    return calculateAge(birthDate);
                })
                .toList();

//        for (Integer age : ages) {
//            System.out.print(age + " ");
//        }
//
//        OptionalDouble averageAge = ages.stream()
//                .mapToDouble(Integer::doubleValue)
//                .average();
//
//        System.out.println(averageAge);

        System.out.println("Q6======================");
        System.out.println(maleAgeFormater(MockData.getPeople()));

    }


    private static Integer calculateAge(Date birthDate) {
        Date currentDate = new Date();

        long diff = currentDate.getTime() - birthDate.getTime();
        long ageInMillis = 1000L * 60 * 60 * 24 * 365;

        return (int) (diff / ageInMillis);
    }
    public static OptionalDouble maleAgeFormater(List<Person> persons) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return persons.stream()
                .filter(person -> person.getGender().equals("Male"))
                .map(person -> {
                    try {
                        return new PersonSummary(person.getId(), person.getFirstName(), person.getLastName(),2023-( dateFormat.parse(person.getBirthDate()).getYear()+1900),  dateFormat.parse(person.getBirthDate()));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(PersonSummary::getAge)
                .mapToDouble(Integer::doubleValue).average();
    }
}
