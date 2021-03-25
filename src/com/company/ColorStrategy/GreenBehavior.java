package com.company.ColorStrategy;

public class GreenBehavior implements ColorBehavior{
   private static ColorBehavior GreenColor;

    public GreenBehavior() {
    }

    public static ColorBehavior getGreenColor() {
       if(GreenColor == null)
          GreenColor=new GreenBehavior();
       return GreenColor;
    }//Lazy singleton initialization

    @Override
    public void applyColor() {
        System.out.println("Green");
    }
}
