package com.company.CargoState;

public class Shipment implements State {
    @Override
    public void Action() {
        System.out.println("The products are in the shipment process");
    }
}
