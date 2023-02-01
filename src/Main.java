import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(Frame::new);
        }catch (Exception e){
            e.printStackTrace();
        }


}
}