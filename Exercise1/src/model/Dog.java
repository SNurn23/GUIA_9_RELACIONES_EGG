package model;

public class Dog implements Comparable<Dog> {
    private String name;
    private String breed;
    private int age;
    private double size;

    public Dog(String name, String breed, int age, double size) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.size = size;
    }

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("Dog: %s, Breed of dog: %s, Size: %.2f, Age: %d\n",name, breed, size, age);
    }

    @Override
    public int compareTo(Dog o) {
        return breed.compareTo(o.breed);
    }


}
