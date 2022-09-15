import java.util.Locale;
import java.util.Random;

public class CarFactory {
    private static final Random random = new Random();

    public static Car[] createCars(){
        Car[] cars = new Car[100];
        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car(i+1,getRandBrandName(),getRandModel(),getRandYear(),getRandColor(),getRandPrice(),getRandRegNum());
        }
        return cars;
    }

    private static String getRandBrandName() {
        String[] brands = {"Tesla","BMW","Ford","Seat","Audi","Honda","Jaguar"};
        return brands[random.nextInt(brands.length)];
    }

    private static String getRandModel() {
        String[] models = {"Hatchback","Sedan","MPV","SUV","Crossover","Coupe","Convertible"};
        return models[random.nextInt(models.length)];
    }

    private static int getRandYear(){
        return random.nextInt(1990,2023);
    }

    private static String getRandRegNum() {
        String regNum = ""
                + (char) (random.nextInt(26) + 'a')
                + (char) (random.nextInt(26) + 'a')
                + random.nextInt(1000, 10000)
                + (char) (random.nextInt(26) + 'a')
                + (char) (random.nextInt(26) + 'a');
        return regNum.toUpperCase(Locale.ROOT);
    }

    private static double getRandPrice(){
        return Math.floor(random.nextDouble(3000.00,100000.00) * 100) / 100;
    }

    private static String getRandColor(){
        String[] colors = {"Blue", "Green", "Magenta", "Red", "Cyan", "Black", "White"};
        return colors[random.nextInt(colors.length)];
    }
}
