public class Dog extends Animal{


    void run (int distance) {
        if (distance > limit()) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    @Override
    void jump (int height) {
        if (height > 0.5) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    void swim (int distance) {
        if (distance > 10 || distance < 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
