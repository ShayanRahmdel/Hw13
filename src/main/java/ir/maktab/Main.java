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

//        for (Person person : ageGreaterThan50) {
//            System.out.println(person);
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

        for (String map : mapTOIpv4) {
            System.out.println(map);
        }



    }
}