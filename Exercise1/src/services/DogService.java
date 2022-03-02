package services;

import model.Dog;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class DogService {
    Scanner input = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n").useLocale(Locale.US);
    ArrayList<Dog> pets = new ArrayList<>();

    public Dog createDog(){
        System.out.println("Enter the name of the dog: ");
        String name = input.next();
        System.out.println("Enter the age: ");
        int age = input.nextInt();
        System.out.println("Enter the breed of dog: ");
        String breed = input.next();
        System.out.println("Enter the size: ");
        double size = input.nextDouble();

        return new Dog(name,breed,age,size);
    }

    public void addDog(){
        Dog d = createDog();
        pets.add(d);
        System.out.println("Successfully added");
    }

    public void showDogs(){

        if(!pets.isEmpty()){
            for (Dog d : pets) {
                System.out.println(d);
            }
        }else{
            System.out.println("No dogs registered");
        }
    }

    public Dog searchDog(String name){
        for (Dog d : pets) {
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;
    }

    public ArrayList<Dog> getDogs() {
        return pets;
    }
}
