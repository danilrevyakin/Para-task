public class Car {
    private long id;
    private String brand;
    private String model;
    private int releaseYear;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(long id, String brand, String model, int releaseYear, String color, double price, String registrationNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id + "\t" +
                ", brand='" + brand + '\'' + "\t" +
                ", model='" + model + '\'' + "\t" +
                ", releaseYear=" + releaseYear + "\t" +
                ", color=" + color + "\t" +
                ", price=" + price + '$' + "\t" +
                ", registrationNumber='" + registrationNumber + '\'' + "\t" +
                '}';
    }
}
