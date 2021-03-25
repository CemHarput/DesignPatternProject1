package com.company;

import com.company.CargoState.Delivery;
import com.company.CargoState.Shipment;
import com.company.CargoState.State;
import com.company.ColorStrategy.ColorBehavior;
import com.company.ColorStrategy.RedBehavior;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// This program is written in Java 11.

        //Create the Subject object
        //It will handle updating all observers
        //as well as deleting and adding them
        int request;
        int ServiceNo;
        Scanner in=new Scanner(System.in);

        FruitGrabber fruitGrabber = new FruitGrabber();//subject object
        ColorBehavior color = RedBehavior.getRedColor();//default color(RED) but it will chance according to prices of fruits.For example green apples are more expensive than red ones.
        FruitObserver observer1 = new FruitObserver(fruitGrabber,color); // you need a subject object to create an observer object.IMPORTANT PART.



        System.out.println("Menu");
        System.out.println("1.Show Observers and Their Colors");
        System.out.println("2.Show the State of the Products");
        System.out.println("3.Exit");

        System.out.println("Enter your Request:");
        request=in.nextInt();

        switch (request){
            case 1:
                fruitGrabber.setApplePrice(60.0);
                fruitGrabber.setGrapePrice(160.0);
                fruitGrabber.setWaterMelonPrice(456.7);
                System.out.println("The colors of fruits can be seen in below.");
                observer1.AppleColorOperation();
                observer1.GrapeColorOperation();
                observer1.WaterMelonOperation();
            break;
            case 2:
                  ServiceNo=observer1.ServiceNo();
                  if(ServiceNo<25){
                    State FruitDeliveryState=new Delivery();
                    observer1.setFruitState(FruitDeliveryState);
                    observer1.Action();
                  }
                  else{
                      State FruitShipmentState=new Shipment();
                      observer1.setFruitState(FruitShipmentState);
                      observer1.Action();
                  }

                 break;
            case 3:
                System.out.println("Goodbye");
                break;

        }

        //you can unregister an observer with "stockGrabber.unregister(observer1)"

        //Also,when ı was using strategy pattern,ı combined with singleton pattern.I have never used new keyword.I used getRedColor() and getGreenColor() methods  like getInstance().
    }
}
