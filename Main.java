import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how many cars do you want to test: ");
        int numberOfTestedCars = selectInteger(scanner, (value) -> value > 1 && value < 25000);
        System.out.println("You are testing " + numberOfTestedCars + " cars");
        CarController carController = new CarController(CarFactory.createCars(numberOfTestedCars));
        System.out.println("\nTask a");
        taskA(scanner, carController);
        System.out.println("\nTask b");
        taskB(scanner, carController);
        System.out.println("\nTask c");
        taskC(scanner, carController);
    }


    private static void taskC(Scanner scanner, CarController carController) {
        System.out.println("Please, write year of cars that you want to find:");
        int year = selectInteger(scanner, (selectedYear) -> selectedYear > 0 && LocalDate.now().getYear() >= selectedYear);
        System.out.println("Please, write minimum price of cars that you want to find:");
        double price = selectDouble(scanner, (selectedPrice) -> selectedPrice > 0);
        List<Car> foundCarsByYearAndPrice = carController.getCarsByYearAndPrice(year, price);
        printFoundCars(foundCarsByYearAndPrice);
    }


    private static void taskB(Scanner scanner, CarController carController) {
        System.out.println("Please, write minimum age of cars that you want to find:");
        int minAge = selectInteger(scanner, (age) -> age > 1);
        System.out.println("Please, also write which model of cars do you want to see");
        List<String> models = List.of(CarFactory.getModels());
        String selectedModel = selectStringFromList(models, scanner);
        System.out.println("You have selected " + minAge + " minimum age " +
                "and " + selectedModel + " model");
        List<Car> foundCarsByModelAndAge = carController.getCarsByModelAndYear(selectedModel, minAge);
        printFoundCars(foundCarsByModelAndAge);
    }

    private static void taskA(Scanner scanner, CarController carController) {
        List<String> brands = List.of(CarFactory.getBrands());
        System.out.println("Please, write which brand of cars do you want to see");
        String selectedBrand = selectStringFromList(brands, scanner);
        System.out.println("You have selected " + selectedBrand + " brand");
        List<Car> foundCarsByBrand = carController.getCarsByBrand(selectedBrand);
        printFoundCars(foundCarsByBrand);
    }

    private static void printFoundCars(List<Car> cars) {
        System.out.println("List of found cars:");
        if(cars == null || cars.size() == 0){
            System.out.println("Nothing is found");
            return;
        }
        cars.forEach(System.out::println);
    }

    static private String selectStringFromList(List<String> list, Scanner scanner) {
        System.out.println("Available choices: ");
        list.forEach(System.out::println);
        boolean isCorrectChoice = false;
        String selectedString = null;
        while (!isCorrectChoice) {
            System.out.println("Your choice: ");
            selectedString = scanner.nextLine();
            isCorrectChoice = list.contains(selectedString);
        }
        return selectedString;
    }

    static private int selectInteger(Scanner scanner, Predicate<Integer> filter) {
        int integer;
        do {
            System.out.println("Your choice: ");
            while (!scanner.hasNextInt()){
                scanner.nextLine();
                System.out.println("Your choice: ");
            }
            integer = scanner.nextInt();
        } while (!filter.test(integer));
        scanner.nextLine();
        return integer;
    }

    static private double selectDouble(Scanner scanner, Predicate<Double> filter) {
        double doubleValue;
        do {
            System.out.println("Your choice: ");
            while (!scanner.hasNextDouble()){
                scanner.nextLine();
                System.out.println("Your choice: ");
            }
            doubleValue = scanner.nextDouble();
        } while (!filter.test(doubleValue));
        scanner.nextLine();
        return doubleValue;
    }
}
