package ru.geekbrains;

public class Lesson4 {
    public static void main(String[] args) {

        Person[] persArray = new Person[5];

        persArray[0] = new Person(
                "Ivanov Ivan",
                "Engineer",
                "ivivan@mailbox.com",
                "892312312",
                30000,
                30
        );
        persArray[1] = new Person(
                "Petrov Petr",
                "Manager",
                "petrov@mailbox.com",
                "892316485",
                50000,
                43
        );
        persArray[2] = new Person(
                "Pupkin Pupa",
                "Designer",
                "pupkin@mailbox.com",
                "8923382054",
                40000,
                25
        );
        persArray[3] = new Person(
                "Popova Natalia",
                "Auditor",
                "popova@mailbox.com",
                "863055912",
                45000,
                53);
        persArray[4] = new Person(
                "Gromov Vladimir",
                "Head of department",
                "gromov@mailbox.com",
                "89093003030",
                100000,
                47);

        for (Person person : persArray) {
            if (person.age > 40) {
                person.printPersonCart();
                System.out.println();
            }
        }
    }
}
