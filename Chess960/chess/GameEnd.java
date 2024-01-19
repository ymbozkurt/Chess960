import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameEnd {
    public static JFrame frame = new JFrame();
    public static JTextField textField = new JTextField();

    private static JPanel mainPanel = new JPanel();
    private static JButton exitButton = new JButton("Exit");

    public static void main(String[] args) {

        
        
        exitButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }

        });
        textField.setEditable(false);
        textField.setBackground(new Color(150,150,150));
        Font newTextFieldFont = new Font(textField.getFont().getName(),textField.getFont().getStyle(),32);
        textField.setFont(newTextFieldFont);
        exitButton.setFont(newTextFieldFont);   
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.setLayout(new GridLayout(2,1));
        mainPanel.add(textField);
        mainPanel.add(exitButton);
        frame.setSize(new Dimension(500, 200));
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
