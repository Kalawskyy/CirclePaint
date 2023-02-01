package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class DrawField extends JPanel implements MouseListener {
    //Adnotacje
    // Całkowity obszar roboczy to X=700px  Y=500-60
    private Color circleColor;

    private int point_1_X, point_1_Y, point_2_X, point_2_Y;
    private ArrayList<Circle> circles = new ArrayList<>();

    public DrawField(int x, int y, int sizeX, int sizeY, Color circleColor) {
        super();
        this.setBounds(x, y, sizeX, sizeY);
        this.setBackground(Color.GRAY);
        addMouseListener(this);
        this.circleColor = circleColor;
        this.add(new JLabel() {
            @Override
            public void paintComponent(Graphics g) {

                super.paintComponent(g);
            }

        });
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        for (int i = 0; i < circles.size(); i++) {
            g.setColor(circles.get(i).getCircleColor());
            g.fillOval(circles.get(i).getCirclePosX(), circles.get(i).getCirclePosY(), circles.get(i).getCircleDiameter(), circles.get(i).getCircleDiameter());
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.print("Kliknięta ");
        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.print("Przytrzymana ");
        System.out.println(e.getX() + " " + e.getY());
        this.point_1_X = e.getX();
        this.point_1_Y = e.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.print("Puszczona ");
        System.out.println(e.getX() + " " + e.getY());
        this.point_2_X = e.getX();
        this.point_2_Y = e.getY();
        circleMath();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.print("IN ");
        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.print("OUT ");
        System.out.println(e.getX() + " " + e.getY());
    }

    private void circleMath() {
        int middleX, middleY, tempDiamA, tempDiamB;
        if (point_1_X > point_2_X) {
            middleX = point_1_X - ((point_1_X - point_2_X) / 2);
            tempDiamA = point_1_X - point_2_X;
        } else if (point_2_X > point_1_X) {
            middleX = point_2_X - ((point_2_X - point_1_X) / 2);
            tempDiamA = point_2_X - point_1_X;
        } else {
            middleX = point_1_X;
            tempDiamA = 0;
        }

        if (point_1_Y > point_2_Y) {
            middleY = point_1_Y - ((point_1_Y - point_2_Y) / 2);
            tempDiamB = point_1_Y - point_2_Y;
        } else if (point_2_Y > point_1_Y) {
            middleY = point_2_Y - ((point_2_Y - point_1_Y) / 2);
            tempDiamB = point_2_Y - point_1_Y;
        } else {
            middleY = point_1_Y;
            tempDiamB = 0;
        }
        int diameter = (int) sqrt((tempDiamA * tempDiamA) + (tempDiamB * tempDiamB));
        addCircleToList(middleX-(diameter/2), middleY-(diameter/2), diameter,circleColor);
    }

    private void addCircleToList(int posX, int posY, int diameter, Color color) {
        Circle temp = new Circle(posX, posY, diameter, color);
        circles.add(temp);
        for (int i = 0; i < circles.size(); i++) {
            circles.get(i).circeSimplyShow();
        }
    }
    public void setCircleColor(Color color){
        this.circleColor=color;
    }
}
