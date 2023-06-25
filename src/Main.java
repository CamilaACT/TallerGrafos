import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GrafoInterfaz principalForm = new GrafoInterfaz();
                principalForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                principalForm.setBounds(200,200,800,500);
                principalForm.setContentPane(principalForm.getMainPanel());
                principalForm.setVisible(true);
            }
        });
    }
}