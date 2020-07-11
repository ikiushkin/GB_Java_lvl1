package ru.geekbrains;

public class Person {

    String name;
    String position;
    String email;
    String tel;
    int salary;
    int age;

    public Person(String name, String position, String email, String tel, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    public void printPersonCart() {
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Эл. почта: " + email);
        System.out.println("Телефон: " + tel);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }
}
