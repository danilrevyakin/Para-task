import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class CarController {
    private Car[] cars;

    public CarController(Car[] cars) {
        this.cars = cars;
    }

    public List<Car> getCarsByBrand(String brand){
        return Arrays.stream(cars)
                .filter(car -> car.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByModelAndYear(String model, int years){
        return Arrays.stream(cars)
                .filter(car -> car.getModel().equals(model))
                .filter(car -> LocalDate.now().getYear() - car.getReleaseYear() > years)
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByYearAndPrice(int year, double price){
        return Arrays.stream(cars)
                .filter(car -> car.getReleaseYear() == year)
                .filter(car -> car.getPrice() > price)
                .collect(Collectors.toList());
    }
}
