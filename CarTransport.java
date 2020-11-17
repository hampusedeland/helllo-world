import org.w3c.dom.events.EventException;

import java.awt.*;
import java.util.*;

public class CarTransport extends Scania {


    public CarTransport(int nrDoors, Color color, double enginePower, int maxCars) {
        super(nrDoors, color, enginePower);
        setX(1);
        setY(1);
    }



    private Map<Integer, Car> loadedcars = new HashMap<>();

    public void addToloadedCars(Integer plats,Car bil){
        if(Math.abs(getX()-bil.getX())<=3 && Math.abs(getY()-bil.getY())<=3) {//bilen rimligt nära biltransporten
           // if(!bil.getClass().isInstance(CarTransport.class)) { //kanske vi ska hitta ett sätt att inte ladda på en cartransport på en cartransport
                if (getRampUp() == false) { //rampen måste vara nere
                    loadedcars.put(plats, bil);
                }
          //  }
        }
        else{
            throw new IllegalArgumentException("Make sure you are nearby the car you're trying to load");
        }
    }
    public String toString(int plats)  {
        //Den här modellnamen vill vi ha till det specifika namnet på bilen.
        if(loadedcars.get(plats)==null){
            throw new RuntimeException("Platsen är tom");


        }
        return  loadedcars.get(plats).modelName + " är lastad på plats nummer: " + plats;
    }

    public void removeFromloadedcars(Integer plats){
       // System.out.println("Bilen: " +loadedcars.get(plats).modelName + "Var på plats: " +loadedcars.get(plats)+ " är avlastad");
        loadedcars.remove(plats);
    }
    public void lastaAvAllaBilar(){
        //GÖR DENNA SENARE
 //Bilar kan endast lossas i omvänd ordning från hur de lastades, dvs den sista bilen som lastades måste vara först att lossas (first-in-last-out).
    }



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
  //  protected CarTransport(int nrDoors, Color color, double enginePower) {
   //     super(nrDoors, color, enginePower);
    //}
}
