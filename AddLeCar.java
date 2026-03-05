import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class AddLeCar {

    private static Random rand = new Random();

    private static List<Supplier<Move>> cars = List.of(
            Volvo240::new,
            Saab95::new
        );

    public static Move createRandomCar() {
        return cars.get(rand.nextInt(cars.size())).get();
    }
}