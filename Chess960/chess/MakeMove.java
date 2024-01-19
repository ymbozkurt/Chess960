import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;

public class MakeMove {
    
    private static int moveTurn = 0;
    private static JPanel panelOfPieceToMove = new JPanel();// = Main.panelOfPieceToMove;
    private static JLabel labelOfPieceToMove = new JLabel();// = Main.labelOfPieceToMove;
    private static int isSelected=0;
    private static Color whiteHoverColor = new Color(23,117,50);
    private static Color blackHoverColor = new Color(13,69,30);
    private static Color colorOfPrevSquare;

    
        
    public MouseListener ml = (MouseListener) new MouseAdapter()
                {
                    @Override
                    public void mousePressed(MouseEvent e)
                    {
                        JPanel panel = (JPanel)e.getSource();
                        //System.out.println(panel.getAccessibleContext());
                        
                        try {
                                if(isSelected==0){
                                    if(((JLabel) panel.getComponent(0)).getIcon().toString().startsWith("white") && moveTurn == 0){
                                        colorOfPrevSquare = panel.getBackground();
                                        labelOfPieceToMove = ((JLabel) panel.getComponent(0));
                                        panelOfPieceToMove = panel;
                                        panel.setBackground(whiteHoverColor);
                                        isSelected=1;
                                        panel.validate();
                                        panel.repaint();
                                        moveTurn=1;
                                    }
                                    else if(((JLabel) panel.getComponent(0)).getIcon().toString().startsWith("black") && moveTurn == 1){
                                        colorOfPrevSquare = panel.getBackground();
                                        labelOfPieceToMove = ((JLabel) panel.getComponent(0));
                                        panelOfPieceToMove = panel;
                                        panel.setBackground(blackHoverColor);
                                        isSelected=1;
                                        panel.validate();
                                        panel.repaint();
                                        moveTurn=0;
                                    }
                                }

                                else if(isSelected==1){

                                    if(panel!=panelOfPieceToMove){
                                        
                                        try {
                                            if(((JLabel) panel.getComponent(0)).getIcon().toString().equals("white_king.png")){
                                                Game.frame.dispose();
                                                Game.frame.setVisible(false);
                                                GameEnd.textField.setText("Black Wins!");
                                                GameEnd.main(null);
                                                
                                            }
                                        } catch (Exception ex) {
                                            // TODO: handle exception
                                        }
                                        try {
                                            if(((JLabel) panel.getComponent(0)).getIcon().toString().equals("black_king.png")){
                                                Game.frame.dispose();
                                                Game.frame.setVisible(false);
                                                GameEnd.textField.setText("White Wins!");
                                                GameEnd.main(null);
                                                
                                            }
                                        } catch (Exception ex) {
                                            // TODO: handle exception
                                        }
                                        try {
                                            panel.remove(panel.getComponent(0));
                                        } catch (Exception exc) {
                                            // TODO: handle exception
                                        }
                                        panel.add(labelOfPieceToMove);
                                        panel.validate();
                                        panel.repaint();
                                        isSelected=0;
                                        panelOfPieceToMove.setBackground(colorOfPrevSquare);
                                        panelOfPieceToMove.remove(panelOfPieceToMove.getComponent(0));
                                    }
                                    
                                            
                                            
                                    //panelOfPieceToMove.validate();
                                    //panelOfPieceToMove.repaint();
                                        
                                    
                                    //panel.remove(panel.getComponent(0));
                                    //panelOfPieceToMove.setBackground();
                                    //panelOfPieceToMove.validate();
                                }
                            //panelOfPieceToMove = panel;
                            //nameOfPieceToMove = ((JLabel) panel.getComponent(0)).getIcon().toString();
                            //System.out.println(((JLabel) panel.getComponent(0)).getIcon());
                            //System.out.println(panel.getY());

                            //System.out.println(pieceToMove.getComponent(0));
                        } catch (Exception exc) {
                            // TODO: handle exception
                        }
                        
                        /* panel.remove(panel.getComponent(0));
                        panel.validate();
                        panel.repaint(); */
                        

                    }
                };
    }

