

package com.company;

import com.company.CargoState.State;
import com.company.ColorStrategy.ColorBehavior;
import com.company.ColorStrategy.GreenBehavior;
import com.company.ColorStrategy.RedBehavior;

import java.awt.*;
import java.util.Random;

public class FruitObserver implements Observer,State {

    private double ApplePrice;
    private double GrapePrice;
    private double WaterMelonPrice;
    private State FruitState;

    private ColorBehavior st;




    private Subject fruitGrabber; //will hold reference to the StockGrabber object

    public FruitObserver(Subject fruitGrabber, ColorBehavior st) {
        this.fruitGrabber = fruitGrabber; //we need to call grabber's methods.

        this.st=st;



        fruitGrabber.register(this);
    }

    @Override
    public void update(double ApplePrice, double GrapePrice, double WaterMelonPrice) {
        this.ApplePrice = ApplePrice;
        this.GrapePrice = GrapePrice;
        this.WaterMelonPrice = WaterMelonPrice;

        printThePrices();


    }
    public void WaterMelonOperation(){


        if(WaterMelonPrice>100){
            st=GreenBehavior.getGreenColor();
            st.applyColor();
        }
        else{
            st.applyColor();
        }
    }
    public void AppleColorOperation(){
        if(ApplePrice>100){

            st= GreenBehavior.getGreenColor();
            st.applyColor();
        }
        else{
            st.applyColor();

        }
    }
    public void GrapeColorOperation(){
        if(GrapePrice>100){
            st=GreenBehavior.getGreenColor();
            st.applyColor();

        }

        else{
            st.applyColor();
        }
    }
    public void printThePrices(){

    System.out.println( "\nApple: " + ApplePrice + "\nGrape: " +
     GrapePrice + "\nWaterMelon: " + WaterMelonPrice + "\n");

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

    public State getFruitState() {
        return FruitState;
    }

    public void setFruitState(State fruitState) {
        FruitState = fruitState;
    }

    @Override
    public void Action() {
        this.FruitState.Action();
    }

    public int ServiceNo(){
        Random rand=new Random();
         int n= rand.nextInt(50);
         return n;
    }
}
