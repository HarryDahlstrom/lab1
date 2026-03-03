public class Maine {
    public static void main(String[] args) {
        LeModel model = new LeModel();

        model.addCar(new Volvo240());
        model.addCar(new Saab95());
        model.addCar(new Scania());

        model.initializeCarPosition();

        CarView view = new CarView("Carsim 1.0",  model);
        CarController controller = new CarController(model, view);
        controller.start();
    }
}