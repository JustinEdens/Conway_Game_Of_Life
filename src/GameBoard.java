import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.util.ArrayList;

public class GameBoard {

    public static int screenSize = 800;
    public static Color white = new Color(255,255,255);
    public static Color black = new Color(0,0,0);
    public static ArrayList<Integer> currentGeneration = new ArrayList<>();
    public static ArrayList<Integer> successorGeneration = new ArrayList<>();
    public static ArrayList<JButton> gameBoard = new ArrayList<>();

    public static ArrayList<Integer> getGameBoard(ArrayList<JButton> gameBoard){
        ArrayList<Integer> response = new ArrayList<>();

        for (JButton button: gameBoard) {
            if(button.getBackground().getRGB() == white.getRGB()){
                //1 represents white
                response.add(1);
            }
            else{
                //0 represents black
                response.add(0);
                System.out.println(gameBoard.indexOf(button));
            }
        }

        return response;
    }

    public static void main(String args[]){
        //inserts algo
        NaturalSelectionAlgorithm ns = new NaturalSelectionAlgorithm();

        //sets Jframe
        JFrame frame = new JFrame("Game Of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize,screenSize);

        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(25,25));

        for(int i=0; i<625; i++) {
            JButton temp = new JButton();
            temp.setBackground(white);
            temp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(temp.getBackground().getRGB() == white.getRGB()){
                        temp.setBackground(black);
                    }
                    else{
                        temp.setBackground(white);
                    }
                }
            });
            //adds to gameBoard arraylist
            gameBoard.add(temp);
            //adds to screen
            buttonPanel.add(temp);
        }

        JButton startBtn = new JButton("Next");
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentGeneration = getGameBoard(gameBoard);
                System.out.println(currentGeneration);
                successorGeneration = ns.getNextGeneration(currentGeneration);
                updateGameBoard(successorGeneration);
            }
        });

        JButton stopBtn = new JButton("Clear");
        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton button: gameBoard) {
                    button.setBackground(white);
                }
            }
        });

        containerPanel.add(startBtn);
        containerPanel.add(stopBtn);

        buttonPanel.setPreferredSize(new Dimension(screenSize, screenSize));
        containerPanel.add(buttonPanel);

        frame.getContentPane().add(containerPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void updateGameBoard(ArrayList<Integer> successorGeneration){
        ArrayList<Integer> response = new ArrayList<>();

        int successorIndex = 0;
        for (JButton button: gameBoard) {
            if(successorGeneration.get(successorIndex) == 0){
                //set alive
                button.setBackground(black);
            }
            else{
                button.setBackground(white);
            }
            successorIndex++;
        }
    }

}
