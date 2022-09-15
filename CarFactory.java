import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class CarFactory {
    private static final Random random = new Random();
    private static final String[] models = {"Hatchback","Sedan","MPV","SUV","Crossover","Coupe","Convertible"};
    private static final String[] brands = {"Tesla","BMW","Ford","Seat","Audi","Honda","Jaguar"};
    private static final String[] colors = {"Blue", "Green", "Magenta", "Red", "Cyan", "Black", "White"};

    public static Car[] createCars(int numberOfCars){
        Car[] cars = new Car[numberOfCars];
        for (int i = 0; i < cars.length; i++){
            cars[i] = new Car(i+1,getRandBrandName(),getRandModel(),getRandYear(),getRandColor(),getRandPrice(),getRandRegNum());
        }
        return cars;
    }

    private static String getRandBrandName() {
        return brands[random.nextInt(brands.length)];
    }

    private static String getRandModel() {
        return models[random.nextInt(models.length)];
    }

    private static int getRandYear(){
        return random.nextInt(1990, LocalDate.now().getYear());
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
        return colors[random.nextInt(colors.length)];
    }

    static public String[] getModels() {
        return models.clone();
    }

    static public String[] getBrands() {
        return brands.clone();
    }

}
