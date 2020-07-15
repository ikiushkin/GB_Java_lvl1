public class Cat extends Animal {

    @Override
    void run (int distance) {
        if (distance > limit()) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    @Override
    void jump (int height) {
        if (height > 2) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    @Override
    void swim () {
        System.out.println("Кошка не умеет плавать!");
    }
}
