// libraries and packages
import java.awt.event.*;
import javax.swing.*;


// main frame class
public class main extends JFrame {
    // private instance variables for frame
    private JLayeredPane layeredPane;
    private JPanel problemPanel;
    private JLabel title;
    private JRadioButton easyButton;
    private JRadioButton mediumButton;
    private JRadioButton hardButton;
    private JButton randomButton;
    private int temp;


    // constructor for main frame
    public main() {

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
        hardButton.setBounds(240, 90, 80, 20);
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
                String difficulty = getDifficulty();
                if(difficulty.equals("unknown")) {
                    JOptionPane.showMessageDialog(null, "Please Select a Difficulty");
                }
                if(difficulty.equals("easy") || difficulty.equals("medium") || difficulty.equals("hard")) {
                    int randomNumber = (int) (Math.random() * 5 + 1);
                    temp = randomNumber;
                    while(randomNumber == temp) {
                        randomNumber = (int) (Math.random() * 5 + 1);
                    }
                    temp = randomNumber;
                    String problem = randomizeProblem(difficulty, randomNumber);
                    displayProblem(problem);
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


    // returns the difficulty that the has chosen
    public String getDifficulty() {
        if(easyButton.isSelected())
            return "easy";
        else if(mediumButton.isSelected())
            return "medium";
        else if(hardButton.isSelected())
            return "hard";
        else
            return "unknown";
    }


    // chooses a random problem
    public String randomizeProblem(String diff, int problemNum) {
        int difficultyNum = 0;
        if(diff.equals("easy"))
            difficultyNum = 1;
        if(diff.equals("medium"))
            difficultyNum = 2;
        if(diff.equals("hard'"))
            difficultyNum = 3;

        // all the coding problems
        // first row is the difficulty (1 = easy, 2 = medium, 3 = hard)
        String[][] problems = {{"Sum of 2 Numbers: Write a function called sumOf2 that takes in two integers as arguments and returns the sum of the integers.", "Absolute Value of 2 Numbers: Write a function called absValueSum that takes in two integers as arguments and returns the absolute value of the two integers.", "Power of Number: Write a function called powOfNum that takes in a double and an integer as an argument. The first argument will be the base and the second will be the exponent. Make the function find the base raised to the power and return that value.", "Area of a Rectangle: Write a function called rectangleArea that takes in two doubles as arguments for the length and height and returns the total area of the rectangle.", "Even or Odd Number of Letters: Write a function called evenNumLetters that takes in a string as an argument and then returns true if the string has an even number of characters and false if the string contains an odd number of letters."},
                               {"Number of Solutions in a Quadratic Equation: Write a function called numQuadraticSolutions that takes in three double arguments and returns the number of solutions the equation will have as an integer.", "Largest Number: Write a function called largestNumber that takes in an array of integers as an argument and returns the largest integer in the array.", "Average Number: Write a function called avgNumber that takes in an array of integers as an argument and returns the average of the array as a double.", "Sum of Digits: Write a function called digitsSum that takes an integer as an argument and returns the sum of all the digits in the number.", "Reverse String: Write a function called reverseString that takes a string as an argument and returns the string but in reverse order."},
                               {"Order Array of Integers: Write a function called orderIntArray that takes an array of integers as an argument and returns the array sorted in ascending order.", "Order Array of Strings: Write a function called orderStringArray that takes an array of Strings as an argument and returns the array sorted in descending order.", "Find Mode of Array of Integers: Write a function called findMode that takes an array of positive integers as an argument and returns the mode of the array. If there are multiple modes, -1 will be returned.", "Remove Repeated Characters: Write a function called removeRepeatedChar that takes in a string as an argument and returns the same string but removes all repeating characters (not just exclusive to consecutive characters but all repeating characters).", "Insert String in Array: Write a function called insertString that takes in an array of strings, a string to be inserted, and an integer for the index where the string will be inserted as arguments. The function returns a new array with the inserted string and the rest of the adjusted array."}};
        return problems[difficultyNum][problemNum];
    }


    // displays the problem in a new window
    public void displayProblem(String problem) {
        JOptionPane.showMessageDialog(null, problem);
    }


    // main function
    public static void main(String[] args) {
        main frame = new main();
        frame.setVisible(true);
    }
}