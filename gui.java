// packages and libraries
import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;


public class gui {
    // swing gui elements
    private JPanel mainPanel;
    private JButton randomButton;
    private JLabel title;
    private JRadioButton easyButton;
    private JRadioButton mediumButton;
    private JRadioButton hardButton;
    private String difficulty;


    public gui() {
        // calls the display problem method when clicking the random problem button
        randomButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               displayProblem();
           }
       });

        // selects easy button and deselects other buttons
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(easyButton.isSelected()) {
                    mediumButton.setSelected(false);
                    hardButton.setSelected(false);
                }
            }
        });

        // selects medium button and deselects other buttons
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mediumButton.isSelected()) {
                    easyButton.setSelected(false);
                    hardButton.setSelected(false);
                }
            }
        });

        // selects hard button and deselects other buttons
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hardButton.isSelected()) {
                    easyButton.setSelected(false);
                    mediumButton.setSelected(false);
                }
            }
        });
    }


    // computes and displays the random problem
    public void displayProblem() {
        // sets difficulty variable to user's selected difficulty
        difficulty = chooseDifficulty();
        if(difficulty.equals("unknown")) {
            JOptionPane.showMessageDialog(null, "Please Select a Difficulty");
            return;
        }

        // will select a random problem based on the user's selected difficulty
        //chooseRandomProblem(difficulty);

        // displays the problem in a popup window
        JOptionPane.showMessageDialog(null, "Hello World");

    }


    // chooses the difficulty
    public String chooseDifficulty() {
        if(easyButton.isSelected()) {
            return "easy";
        } else if(mediumButton.isSelected()) {
            return "medium";
        } else if(hardButton.isSelected()) {
            return "hard";
        } else {
            return "unknown";
        }
    }

    // main function - displays the main GUI window
   public static void main(String[] args) {
        JFrame frame = new JFrame("Coding Problem Randomizer");
        frame.setContentPane(new gui().mainPanel);
        frame.setPreferredSize(new Dimension(350, 250));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
   }
}