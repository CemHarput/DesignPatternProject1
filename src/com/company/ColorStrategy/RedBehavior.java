package com.company.ColorStrategy;

public class RedBehavior implements  ColorBehavior{
   private static ColorBehavior RedColor;

    public RedBehavior() {
    }

    public static ColorBehavior getRedColor() {
       if(RedColor==null)
          RedColor=new RedBehavior();
       return RedColor;
    } //Lazy singleton initialization

    @Override
    public void applyColor() {
        System.out.println("Red");
    }
}
