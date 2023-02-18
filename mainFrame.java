// libraries and packages
import java.awt.event.*;
import javax.swing.*;


// main frame class
public class mainFrame extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel problemPanel;
    private JLabel title;
    private JRadioButton easyButton;
    private JRadioButton mediumButton;
    private JRadioButton hardButton;
    private JButton randomButton;
    private String difficulty;


    // constructor for main frame
    public mainFrame() {

        // sets the title of the application window
        setTitle("Coding Problem Randomizer");
        // sets window size of the application window
        setSize(350, 250);
        // closes the application window when clicking the "x" button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // opens the application window in the middle of the screen
        setLocationRelativeTo(null);

        // setup for layered panel
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);

        // setup for problem panel
        problemPanel = new JPanel();
        problemPanel.setBounds(0, 0, 350, 250);
        problemPanel.setVisible(false);

        // setup for title label
        title = new JLabel("Coding Problem Randomizer");
        title.setBounds(85, 10, 180, 30);

        // setup for easy button
        // selects easy button and deselects other buttons
        easyButton = new JRadioButton("Easy");
        easyButton.setBounds(28, 90, 60, 20);
        easyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(easyButton.isSelected()) {
                    mediumButton.setSelected(false);
                    hardButton.setSelected(false);
                }
            }
        });

        // setup for medium button
        // selects medium button and deselects other buttons
        mediumButton = new JRadioButton("Medium");
        mediumButton.setBounds(125, 90, 100, 20);
        mediumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(mediumButton.isSelected()) {
                    easyButton.setSelected(false);
                    hardButton.setSelected(false);
                }
            }
        });

        // setup for hard button
        // selects hard button and deselects other buttons
        hardButton = new JRadioButton("Hard");
        hardButton.setBounds(250, 90, 80, 20);
        hardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(hardButton.isSelected()) {
                    easyButton.setSelected(false);
                    mediumButton.setSelected(false);
                }
            }
        });

        // setup for random button
        randomButton = new JButton("Randomize Problem");
        randomButton.setBounds(100, 170, 150, 30);
        randomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getDifficulty();
                if(difficulty.equals("easy") || difficulty.equals("medium") || difficulty.equals("hard")) {
                    randomizeProblem(difficulty);
                    displayProblem();
                }
            }
        });

        // add all the elements to the main panel
        layeredPane.add(problemPanel);
        layeredPane.add(title);
        layeredPane.add(easyButton);
        layeredPane.add(mediumButton);
        layeredPane.add(hardButton);
        layeredPane.add(randomButton);
    }


    // chooses a random problem
    public void randomizeProblem(String dif) {

    }


    // displays the problem in application
    public void displayProblem() {
        problemPanel.setVisible(true);
    }

    // returns the difficulty that the has chosen
    public void getDifficulty() {
        if(easyButton.isSelected()) {
            difficulty = "easy";
        } else if(mediumButton.isSelected()) {
            difficulty = "medium";
        } else if(hardButton.isSelected()) {
            difficulty = "hard";
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Difficulty");
        }
    }


    // main function
    public static void main(String[] args) {
        mainFrame frame = new mainFrame();
        frame.setVisible(true);
    }
}
