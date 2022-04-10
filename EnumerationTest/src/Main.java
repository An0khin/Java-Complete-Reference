import java.util.Arrays;

enum Car {
    Toyota(100), BMW(99), Nissan(98), Honda(97);
    private int price;
    Car(int p) {
        price = p;
    }
    public int getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = Car.Toyota;
        if(c == Car.Toyota)
            System.out.println("Iiiiit's TOOOOOYYOOOOOTTAAAA!!!");
        System.out.println(Arrays.toString(Car.values()));
        System.out.println(Car.valueOf("Nissan").getPrice());
    }
}
