package com.company.CargoState;

public class Delivery  implements State{
    @Override
    public void Action() {
        System.out.println("The products are in the delivery process.");
    }
}
