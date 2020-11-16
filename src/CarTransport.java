import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Scania {

    public ArrayList<Car> getLoadedCars() {
        return loadedCars;
    }

    public void setLoadedCars(ArrayList<Car> loadedCars) {
        this.loadedCars = loadedCars;
    }

    private ArrayList<Car> loadedCars= new ArrayList<>();

    public String getRamp() {
        return ramp;
    }

    public Boolean getRampUp(){
        if(getRamp().equals("up")){
            return true;
        }
        else{
            return false;
        }
    }

    public void setRampUp() {
        this.ramp = ramp;
        ramp = "up";
    }
    public void setRampDown() {
        if(getCurrentSpeed()==0) {
            this.ramp = ramp;
            ramp = "down";
        }
        else {
            throw new IllegalArgumentException("Make sure the Truck isn't moving, in order to pull the ramp down, stop the truck");
        }
    }


    private String ramp="down"; /** Kan vara uppe  eller nere */


    /**
     * En konstruktor för Scania biltransport generellt med undernämnda parametrar
     *
     * @param nrDoors
     * @param color
     * @param enginePower
     */
    protected CarTransport(int nrDoors, Color color, double enginePower) {
        super(nrDoors, color, enginePower);
    }
}
