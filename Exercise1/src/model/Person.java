package model;

public class Person implements Comparable<Person> {
    private long dni;
    private String name;
    private String lastname;
    private int age;
    private Dog dog;

    public Person(long dni, String name, String lastname, int age) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.dog = null;
    }

    public Person() {
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s, Age: %d, Dni: %d\n",name, lastname, age, dni);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return dni == person.dni;
    }

    @Override
    public int compareTo(Person o) {
        return lastname.compareTo(o.lastname);
    }
}
