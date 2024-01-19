import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;


//Resimlerin düzenlenmesi gerekiyor. Dosya adı yerine adres yazmak yeterli.

public class Main {
    private static JFrame frame = new JFrame("CHESS 960");
    private static JPanel mainPanel = new JPanel();
    private static JButton playButton = new JButton("PLAY");
    private static JButton exButton = new JButton("EXIT");
    private static JLabel bckLabel = new JLabel();

    public static void main(String[] args) throws IOException {
        mainPanel.setLayout(new GridLayout(2,1,10,0));
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Java\\Chess960\\chess\\images\\mainbackgroundd.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(img);
        bckLabel.setIcon(icon);
        
        exButton.setPreferredSize(new Dimension(300, 75));
        exButton.setFocusable(false);
        exButton.setBackground(new Color(160,160,160));
        exButton.setBorderPainted(false);
        exButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
            
        });
        exButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                exButton.setBackground(new Color(47,131,168));
                //playButton.
            }
            public void mouseExited(MouseEvent me) {
                exButton.setBackground(new Color(160,160,160));
            }
        });
        playButton.setBackground(new Color(153,204,255));
        playButton.setFocusable(false);

        playButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Game.main(args);
            }
        });

        playButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                playButton.setBackground(new Color(47,131,168));
                
            }
            public void mouseExited(MouseEvent me) {
                playButton.setBackground(new Color(153,204,255));
            }
        });
        Font newTextFieldFont = new Font(playButton.getFont().getName(),playButton.getFont().getStyle(),32);
        playButton.setFont(newTextFieldFont);
        frame.add(bckLabel);
        mainPanel.add(playButton);
        mainPanel.add(exButton);
        frame.setSize(new Dimension(400, 650));
        frame.setResizable(false);
        frame.add(mainPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
