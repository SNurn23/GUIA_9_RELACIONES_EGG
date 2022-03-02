package services;

import model.Dog;
import model.Person;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Adoption {
    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    PersonService pS = new PersonService();
    DogService dS = new DogService();

    public void registerAdoption(Dog d){
        System.out.println("Enter the dni of the person: ");
        long dni = input.nextLong();
        Person p = pS.searchPerson(dni);

        if(p != null){
            p.setDog(d);
            System.out.println("Adoption successfully registered");
        }else{
            System.out.println("Person not found");
        }
    }

    public void adoption(){
        System.out.println("Dogs: ");
        dS.showDogs();

        System.out.println("Enter the name of the dog you wish to adopt: ");
        String name = input.next();

        Dog d = dS.searchDog(name);

        if(d != null){
            registerAdoption(d);
        }else{
            System.out.println("Dog not found");
        }
    }

    public void menu(){
        String op;

        do{
            System.out.println("\t\tMENU");
            System.out.println("-------------------");
            System.out.println("1- Add person");
            System.out.println("2- Add dog");
            System.out.println("3- Show persons");
            System.out.println("4- Show dogs");
            System.out.println("5- Adoption");
            System.out.println("6- Show persons with dogs");
            System.out.println("7- Exit");
            System.out.println("-------------------");
            System.out.print("\nOption: "); op = input.next();

            switch (op) {
                case "1":
                    pS.addPerson();
                    break;
                case "2":
                    dS.addDog();
                    break;
                case "3":
                    pS.showPerson();
                    break;
                case "4":
                    dS.showDogs();
                    break;
                case "5":
                    adoption();
                    break;
                case "6":
                    pS.showPersonsWithDog();
                    break;
                case "7":
                    System.out.println("Closing menu. Bye!");
                    break;
                default:
                    System.out.println("Enter a correct option");
                    break;
            }
        }while(!op.equalsIgnoreCase("7"));
    }
}
