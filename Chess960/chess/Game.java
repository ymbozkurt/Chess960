import javax.swing.*;
import java.awt.*;

public class Game{

    private static MakeMove mkMove = new MakeMove();
    private static String[] lineUp;
    private static JPanel boardPanel = new JPanel();
    private static JPanel[][] squares = new JPanel[8][8];
    private static JLabel piece;
    public static JFrame frame = new JFrame();
    


    public static void main(String[] args) {
        lineUp = Chess960.main(args);
        boardPanel.setLayout(new GridLayout(8,8));
        for(int i=0;i<8; i++){
            for(int j=0; j<8; j++){
                squares[i][j] = new JPanel();
                if((i+j)%2==1) squares[i][j].setBackground(new Color(118, 70, 28));
                else squares[i][j].setBackground(new Color(243, 204, 169));
                boardPanel.add(squares[i][j]);
                if(i==0){
                    piece = new JLabel(new ImageIcon("Java\\Chess960\\chess\\images\\black_"+lineUp[j]+".png"));
                    squares[i][j].add(piece);
                }
                else if(i==7){
                    piece = new JLabel(new ImageIcon("Java\\Chess960\\chess\\images\\white_"+lineUp[j]+".png"));
                    squares[i][j].add(piece);
                }
                else if(i==1){
                    piece = new JLabel(new ImageIcon("Java\\Chess960\\chess\\images\\black_pawn.png"));
                    squares[i][j].add(piece);
                }
                else if(i==6){
                    piece = new JLabel(new ImageIcon("Java\\Chess960\\chess\\images\\white_pawn.png"));
                    squares[i][j].add(piece);
                }

                squares[i][j].addMouseListener(mkMove.ml);
            }
        }
        // = new JLabel(new ImageIcon("white_bishopp.png"));
        
        //squares[0][0].add(piece);
        
        frame.setSize(800,800);
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
}
