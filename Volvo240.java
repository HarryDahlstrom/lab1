import java.awt.*;
// I HATE THIS PROGRAMI HATE THIS PROGRAMI HATE THIS PROGRAMI HATE THIS PROGRAM AHHH
public class Volvo240 extends LeCar {

    public  final double trimFactor = 1.25;
    // DONE public int nrDoors; // Number of doors on the car
    // DONE public double enginePower; // Engine power of the car
    // DONE public double currentSpeed; // The current speed of the car
    // DONE public Color color; // Color of the car
    // DONE public String modelName; // The car model name
    
    public Volvo240() {
/*        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";*/
        super(4,Color.black,100,"Volvo240");
        stopEngine();
    }
    
     /*private  int getNrDoors(){
        return nrDoors;
    }

     private  double getEnginePower(){
        return enginePower;
    }

     private  double getCurrentSpeed(){
        return currentSpeed;
    }

     private  Color getColor(){
        return color;
    }

     private  void setColor(Color clr){
	    color = clr;
    }

     private  void startEngine(){
	    currentSpeed = 0.1;
    }

     private  void stopEngine(){
	    currentSpeed = 0;
    }*/

    // Nedanför är unika
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}

