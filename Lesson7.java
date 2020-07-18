package ru.geekbrains;

public class Lesson7 {
    public static void main(String[] args) {

        Cat[] catsArray = new Cat[3];
        catsArray[0] = new Cat("Boris", 19);
        catsArray[1] = new Cat("Darth Vader", 15);
        catsArray[2] = new Cat ("Zefir",20);

        Plate plate = new Plate();
        plate.setFood(50); // Убрал foodCount

        for (Cat cat : catsArray) {
            plate.info();
            System.out.println(cat.getName() + " голоден на " + cat.getAppetite());
            if ((plate.getFood() - cat.getAppetite()) >= 0) {
                cat.eat(plate);
                cat.setAppetite(0);
                System.out.println(cat.getName() + " сыт, еды хватило!");
                System.out.println();
            } else {
                cat.setAppetite(cat.getAppetite() - plate.getFood());
                plate.setFood(0);
                System.out.println(cat.getName() + " остался голоден на " + cat.getAppetite());
                plate.info();
            }
        }
    }
}
