package services;

import model.Person;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class PersonService {
    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    ArrayList<Person> persons = new ArrayList<>();

    public Person createDog(){
        System.out.println("Enter the name of the person: ");
        String name = input.next();
        System.out.println("Enter the last name: ");
        String lastname = input.next();
        System.out.println("Enter the age: ");
        int age = input.nextInt();
        System.out.println("Enter the dni: ");
        long dni = input.nextLong();

        return new Person(dni,name,lastname,age);
    }

    public void addPerson(){
        Person p = createDog();
        if(!persons.contains(p)) {
            persons.add(p);
            System.out.println("Successfully added");
        }else{
            System.out.println("Person is already registered");
        }
    }

    public void showPerson(){
        if(!persons.isEmpty()){
            for (Person p : persons) {
                System.out.println(p);
            }
        }else{
            System.out.println("No persons registered");
        }
    }

    public Person searchPerson(Long dni){
        for (Person p : persons) {
            if (p.getDni() == dni){
                return p;
            }
        }
        return null;
    }

    public void showPersonsWithDog(){
        for (Person p : persons) {
            if(p.getDog() != null){
                System.out.println(p);
                System.out.println(p.getDog().toString());
            }
        }
    }
    public ArrayList<Person> getPersons() {
        return persons;
    }
}
