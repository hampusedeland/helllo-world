import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Map;

import static org.junit.Assert.*;

public class test1 {
    private Car saab;
    Saab95 saab123 = new Saab95(4, Color.black,124);
    Volvo240 volvon = new Volvo240(4,Color.BLUE,130);
    Scania lastbilen = new Scania(2,Color.CYAN,422);
    CarTransport transport = new CarTransport(2,Color.gray,500,4);

    @Before

    public void init(){
        saab = new Car(2, Color.red, 125);


    }
    @Test
    public void canWeLoadoff(){
        transport.addToloadedCars(1,saab123);
        transport.addToloadedCars(2,volvon);
        transport.addToloadedCars(3,transport);
        transport.setRampDown();
        System.out.println();
       // transport.lastaAvAllaBilar();
        transport.lastaAvAllaBilar();
        System.out.println(transport.toString(3));
       // System.out.println(transport.toString(2));

    }
    @Test
    public void areCarsNearby(){
        transport.setY(50);
        transport.setX(20);
        transport.addToloadedCars(1,saab123);
        transport.addToloadedCars(2,volvon);
        System.out.println(transport.toString(1));
        System.out.println(transport.toString(2));
    }
    @Test
    public void doesTruckInheritRightMethod(){
        lastbilen.setAngleTrBed(0);
        lastbilen.startEngine();
        lastbilen.setCurrentdirection("north");
        lastbilen.move();
        lastbilen.move();
        assertTrue(lastbilen.getY()>=0);


    }
   @Test
    public void addingCarstotransport(){
        transport.addToloadedCars(1,saab123);
        transport.addToloadedCars(2,volvon);
        transport.addToloadedCars(3,lastbilen);
        System.out.println(transport.toString(1));
        System.out.println(transport.toString(2));
       System.out.println(transport.toString(3));
    }


    @Test
    public  void moveTruckWhenAngNotzero(){
       lastbilen.setAngleTrBed(50);
       lastbilen.move();
    }
    @Test
    public  void changingTrBedAngWhileMoving(){
        lastbilen.setCurrentSpeed(5);
        lastbilen.setAngleTrBed(72);
        System.out.println(lastbilen.getAngleTrBed());
    }
    @Test
    public void volvospeedfactor() {
        assertTrue(volvon.speedFactor()==volvon.getEnginePower()*0.01*1.25);
    }
    @Test
    public void turboOnsaab(){
        saab123.setTurboOn();
        assertEquals(saab123.turboOn,true);

    }
    @Test
    public void turboOfSaab(){
        saab123.setTurboOff();
        assertEquals(saab123.turboOn,false);
    }

   @Test
   public void testSpeedfactorsaabok(){
        double noTurbo = saab123.speedFactor();
        saab123.setTurboOn();
        double withTurbo = saab123.speedFactor();
        int vad = Double.compare(noTurbo,withTurbo);
        assertTrue(vad<0);
   }

   @Test
   public void testTurboOff(){
        saab.setTurboOn();
        double noTurbo = saab.speedFactor();
        saab.setTurboOff();
        double withTurbo = saab.speedFactor();
        int vad = Double.compare(noTurbo,withTurbo);
        assertTrue(vad==0);
   }


    //ideer för tester
    @Test
    public void testcolor(){
        saab.setColor(Color.BLACK);
        assertEquals(saab.getColor(),Color.black);
    }
    @Test
    public void testenginepowernegative(){
        saab.setEnginePower(-100);
        assertTrue(saab.getEnginePower()>=0);
    }
    @Test
    public void testadorrar (){
        assertTrue(saab123.getNrDoors()==4);
    }
    @Test public void turnRightOk(){
        saab.setCurrentdirection("north");
        saab.turnRight();
        assertEquals(saab.getCurrentdirection(),"east");
    }
    @Test
    public void Testspeednegative(){

        assertThrows(IllegalArgumentException.class, () -> saab.setCurrentSpeed(-50)); /// hur man testar throws
    }
    @Test
    public void turboOn(){
        saab123.setTurboOn();
        assertEquals(saab123.turboOn,true);
    }
    @Test
    public void testTurnLeft(){
        saab.setCurrentdirection("west");
        saab.turnLeft();
        assertTrue(saab.getCurrentdirection()=="south");
    }

    @Test
    public void testTurnRight(){
        //start con, starts north
        saab.setCurrentdirection("north");
        //three right turns should result in the direction being west
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertTrue(saab.getCurrentdirection()=="west");

    }

    @Test
    public void testMove() {
        saab.setCurrentSpeed(1);
        saab.setCurrentdirection("north");
        saab.setX(0);
        saab.setY(0);
        for (int i = 0; i <= 10; i++) {
            saab.move();
            saab.move();
            saab.move();
        }
        //this should result in the car moving 10 steps
        //The car being directed north, and starting in (0,0)
        // should result in the car ending up in (0,10)
        assertTrue(saab.getY() >= 9);

    }
    @Test
    public void testPosition() {
        saab.setX(0);
        saab.setY(0);

        assertTrue(saab.getX()==0 && saab.getY()==0);
    }

    @Test
    public void testSetCurrentdirectionOK(){
        saab.setCurrentdirection("west");
        saab.move();
        saab.turnLeft();
        saab.turnRight();

    }

    @Test
    public void testGasOK(){

        for(int i= 0 ; i<=200 ; i++) {
            saab.gas(0.9);
        }
        assertTrue(saab.getCurrentSpeed()<=saab.getEnginePower());

    }

    @Test
    public void testBreakOK(){
        saab.setCurrentSpeed(100);
        for(int i= 0 ; i<=200 ; i++) {
            saab.brake(0.9);
        }
        //för man kan breaka med 1 som max
        assertTrue(saab.getCurrentSpeed()<=1);

    }

    @Test
    public void testIncrementSpeedOK(){
        saab.setCurrentSpeed(1);
        saab.incrementSpeed(20);
        //vi får inte öka hastigheten med mer än 1, så därav ska hastigheten
        //vara oförändrad
        assertTrue(saab.getCurrentSpeed()>=0.9);

    }

    @Test
    public void testDecremetSpeedOK(){
        saab.setCurrentSpeed(1);
        saab.decrementSpeed(20);
        //vi får inte öka hastigheten med mer än 1, så därav ska hastigheten
        //vara oförändrad
        assertTrue(saab.getCurrentSpeed()==1);
    }

    @Test
    public void testStopEngineOK(){
        saab.setCurrentSpeed(20);
        saab.stopEngine();
        assertTrue(saab.getCurrentSpeed()==0);
    }

    @Test
    public void testStartEngineOK(){
        saab.setCurrentSpeed(0);
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed()==0.1);

    }

    /*@Test
    public void testSpeedFactorSaabOK(){
        double noTurbo = saab.speedFactor();
        saab.setTurboOn();
        double withTurbo = saab.speedFactor();
        int vad = Double.compare(noTurbo, withTurbo);
        assertTrue(vad<0);
    }
    @Test
    public void testSpeedFactor(){
    }
    /*@Test
    public void testTurbOonOnOK(){
        saab.turboOn;
        assertTrue(saab.setTurboOn());
    }
    @Test
    public void testTurbOonOffOK(){}*/



}