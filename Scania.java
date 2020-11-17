import java.awt.*;

public class Scania extends Car{
    public double getAngleTrBed() {
        return angleTrBed;
    }

    public void setAngleTrBed(double angleTrBed) {
        if(getAngleTrBed()>=0 && getAngleTrBed()<=70 && getCurrentSpeed()==0) { //maxvinkeln och om lastbilen är still
            this.angleTrBed = angleTrBed;
        }
        else {
            throw new IllegalArgumentException("Make sure the Truck isn't moving, and the designated angle for the truck bed is between 0-70 degrees");
        }
    }

    @Override
    public void move(){
        if(getAngleTrBed()==0){
            super.move();
        }
        else{
            throw new IllegalArgumentException("For the truck to move, the truck bed must have a zero angle, the angle (was:"+ getAngleTrBed() + ")");
        }
    }

    private double angleTrBed=0; /** default vinkeln*/


    /**
     * En konstruktor för Scania lastbil generellt med undernämnda parametrar
     *
     * @param nrDoors
     * @param color
     * @param enginePower
     */
    protected Scania(int nrDoors, Color color, double enginePower) {
        super(nrDoors, color, enginePower);
        modelName = "Scania340";
    }

}
