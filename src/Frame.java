import Components.DrawField;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
        int position_y=1080;
        int position_x=1920;
        int y=500;
        int x=700;
        private DrawField field=null;
    Frame(){
        this.setBounds((position_x/2)-(x/2),(position_y/2)-(y/2),x,y);
        this.setTitle("Circle paint");
        this.setResizable(false);
        this.setLayout(null);
        field=new DrawField(0,0,x,y-60);
        addComponents();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);

    }
    void addComponents(){
        JMenuBar menuBar = new JMenuBar();
        JMenu color=new JMenu("Kolor");
        color.add(menuColor(Color.GREEN,"Zielony"));
        color.add(menuColor(Color.BLUE,"Niebieski"));
        color.add(menuColor(Color.red,"Czerwony"));
        color.add(menuColor(Color.PINK,"Różowy"));
        color.add(menuColor(Color.WHITE,"Biały"));
        color.add(menuColor(Color.YELLOW,"Żółty"));
        menuBar.add(color);
        this.setJMenuBar(menuBar);
       this.getContentPane().add(field);

    }
    JMenuItem menuColor(Color color,String nameMenu){

        JMenuItem tempColor = new JMenuItem(nameMenu);
        tempColor.setBackground(color);
        tempColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd=e.getActionCommand();
                if(cmd.equalsIgnoreCase(nameMenu)){
                    field.setbgcolor(color);
                }
            }
        });

        return tempColor ;
    }
}
