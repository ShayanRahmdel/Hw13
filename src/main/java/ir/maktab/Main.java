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

        for (Person person : ageGreaterThan50) {
            System.out.println(person);
        }


    }
}