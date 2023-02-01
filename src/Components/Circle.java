package Components;

import java.awt.*;
public class Circle {
    private int x,y,diameter;
    private Color color;
    public Circle (int x, int y,int diameter ,Color color) {
        this.x = x;
        this.y = y;
        this.diameter=diameter;
        this.color = color;
    }
    public int getCirclePosX(){
        return x;
    }
    public int getCirclePosY(){
        return y;
    }
    public Color getCircleColor(){
        return color;
    }
    public int getCircleDiameter(){
        return diameter;
    }
    public void circeSimplyShow(){
        System.out.println("x: "+x+" y: "+y+" diametr: "+diameter+" color: "+color.toString());
    }
}