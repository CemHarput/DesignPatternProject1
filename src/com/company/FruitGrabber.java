package com.company;

import java.util.ArrayList;

public class FruitGrabber implements Subject {

   private ArrayList<Observer> observers; //one subject can have many observer.One-to-Many relationship
   private double ApplePrice;
   private double GrapePrice;
   private double WaterMelonPrice;

    public FruitGrabber() {
        observers=new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
         observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex=observers.indexOf(deleteObserver);

        System.out.println("Observer "+(observerIndex+1)+" has been deleted");

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer:observers){
            observer.update(ApplePrice,GrapePrice,WaterMelonPrice);
        }
    }

    public void setApplePrice(double applePrice) {
        this.ApplePrice = applePrice;
        notifyObserver();
    }

    public void setGrapePrice(double grapePrice) {
        this.GrapePrice = grapePrice;
        notifyObserver();
    }

    public void setWaterMelonPrice(double waterMelonPrice) {
        this.WaterMelonPrice = waterMelonPrice;
        notifyObserver();

    }

    public double getApplePrice() {
        return ApplePrice;
    }

    public double getGrapePrice() {
        return GrapePrice;
    }

    public double getWaterMelonPrice() {
        return WaterMelonPrice;
    }
}
