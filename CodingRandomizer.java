// libraries and packages
import javax.swing.*;
import java.awt.event.*;


// main class
public class CodingRandomizer extends JFrame {
    // variables for frame
    private JLayeredPane layeredPane;
    private JLabel titleLabel;
    private JRadioButton easyButton;
    private JRadioButton mediumButton;
    private JRadioButton hardButton;
    private JButton randomButton;
    private JTextArea questionArea;
    private JButton backButton;
    private JButton nextButton;
    private JRadioButton unmasButton;
    private JRadioButton masButton;
    private JButton resetMasteryButton;
    // other variables
    private String[][] unmas;
    private String[][] mas;
    private int difficultyNum;
    private int problemNum;
    private int temp;
    private int counter;


    // constructor for main frame and all swing elements
    public CodingRandomizer() {
        // 2d array for all coding problems
        unmas = new String[][] {
                {"Sum of 2 Numbers: Write a function called sumOf2 that takes in two integers as " +
                "arguments and returns the sum of the integers.", "Absolute Value of 2 Numbers: " +
                "Write a function called absValueSum that takes in two integers as arguments and returns the " +
                "absolute value of the two integers.", "Power of Number: Write a function called powOfNum that takes " +
                "in a double and an integer as an argument. The first argument will be the base and the second will " +
                "be the exponent. Make the function find the base raised to the power and return that value.", "Area " +
                "of a Rectangle: Write a function called rectangleArea that takes in two doubles as arguments for " +
                "the length and height and returns the total area of the rectangle.", "Even or Odd Number of " +
                "Letters: Write a function called evenNumLetters that takes in a string as an argument and then " +
                "returns true if the string has an even number of characters and false if the string contains an odd " +
                "number of letters."},
                {"Number of Solutions in a Quadratic Equation: Write a function called numQuadraticSolutions that " +
                "takes in three double arguments and returns the number of solutions the equation will have as an " +
                "integer.", "Largest Number: Write a function called largestNumber that takes in an array of " +
                "integers as an argument and returns the largest integer in the array.", "Average Number: Write a " +
                "function called avgNumber that takes in an array of integers as an argument and returns the average " +
                "of the array as a double.", "Sum of Digits: Write a function called digitsSum that takes an integer " +
                "as an argument and returns the sum of all the digits in the number.", "Reverse String: Write a " +
                "function called reverseString that takes a string as an argument and returns the string but in " +
                "reverse order."},
                {"Order Array of Integers: Write a function called orderIntArray that takes an array of integers as " +
                "an argument and returns the array sorted in ascending order.", "Order Array of Strings: Write a " +
                "function called orderStringArray that takes an array of Strings as an argument and returns the " +
                "array sorted in descending order.", "Find Mode of Array of Integers: Write a function called " +
                "findMode that takes an array of positive integers as an argument and returns the mode of the array. " +
                "If there are multiple modes, -1 will be returned.", "Remove Repeated Characters: Write a function " +
                "called removeRepeatedChar that takes in a string as an argument and returns the same string but " +
                "removes all repeating characters (not just exclusive to consecutive characters but all repeating " +
                "characters).", "Insert String in Array: Write a function called insertString that takes in an array " +
                "of strings, a string to be inserted, and an integer for the index where the string will be inserted " +
                "as arguments. The function returns a new array with the inserted string and the rest of the " +
                "adjusted array."}};
        mas = new String[unmas.length][unmas[0].length];

        // sets the title of the application window
        setTitle("Coding Problem Randomizer");
        // sets window size of the application window
        setSize(350, 250);
        // closes the application window when clicking the "x" button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // opens the application window in the middle of the screen
        setLocationRelativeTo(null);
        // makes it so the window cannot be resized
        setResizable(false);

        // setup for layered pane
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);

        // setup for title label
        titleLabel = new JLabel("Coding Problem Randomizer");
        titleLabel.setBounds(85, 10, 180, 30);
        titleLabel.setVisible(true);

        // setup for easy button
        // selects easy button and deselects other buttons
        easyButton = new JRadioButton("Easy");
        easyButton.setBounds(40, 90, 55, 20);
        easyButton.setVisible(true);
        easyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (easyButton.isSelected()) {
                    mediumButton.setSelected(false);
                    hardButton.setSelected(false);
                }
            }
        });

        // setup for medium button
        // selects medium button and deselects other buttons
        mediumButton = new JRadioButton("Medium");
        mediumButton.setBounds(130, 90, 70, 20);
        mediumButton.setVisible(true);
        mediumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mediumButton.isSelected()) {
                    easyButton.setSelected(false);
                    hardButton.setSelected(false);
                }
            }
        });

        // setup for hard button
        // selects hard button and deselects other buttons
        hardButton = new JRadioButton("Hard");
        hardButton.setBounds(235, 90, 55, 20);
        hardButton.setVisible(true);
        hardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (hardButton.isSelected()) {
                    easyButton.setSelected(false);
                    mediumButton.setSelected(false);
                }
            }
        });

        // setup for random button
        randomButton = new JButton("Randomize Problem");
        randomButton.setBounds(95, 170, 150, 30);
        randomButton.setVisible(true);
        randomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                randomizeProblem();
            }
        });

        // setup for question area
        questionArea = new JTextArea();
        questionArea.setBounds(5, 50, 325, 120);
        questionArea.setVisible(false);
        questionArea.setEditable(false);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);

        // setup for back button
        // goes back to the main screen
        backButton = new JButton("Back");
        backButton.setBounds(5, 5, 75, 30);
        backButton.setVisible(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setMainScreenElementsVisible();
            }
        });

        // setup for next button
        // calls a new problem that is in the unmastered 2d array
        nextButton = new JButton("Next");
        nextButton.setBounds(255, 5, 75, 30);
        nextButton.setVisible(false);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextRandomProblem();
            }
        });

        // setup for unmastered button
        unmasButton = new JRadioButton("Unmastered");
        unmasButton.setBounds(140, 182, 100, 20);
        unmasButton.setVisible(false);
        unmasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                masButton.setSelected(false);
            }
        });

        // setup for mastered button
        masButton = new JRadioButton("Mastered");
        masButton.setBounds(240, 182, 100, 20);
        masButton.setVisible(false);
        masButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unmasButton.setSelected(false);
            }
        });

        // setup for reset mastery button
        // resets all questions to an "unmastered" status
        resetMasteryButton = new JButton("Reset Mastery");
        resetMasteryButton.setBounds(5, 177, 120, 30);
        resetMasteryButton.setVisible(false);
        resetMasteryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetMastery();
            }
        });

        // add all the elements to the main layered pane
        layeredPane.add(titleLabel);
        layeredPane.add(easyButton);
        layeredPane.add(mediumButton);
        layeredPane.add(hardButton);
        layeredPane.add(randomButton);
        layeredPane.add(questionArea);
        layeredPane.add(backButton);
        layeredPane.add(nextButton);
        layeredPane.add(unmasButton);
        layeredPane.add(masButton);
        layeredPane.add(resetMasteryButton);
    }


    // returns the difficulty that the has chosen
    public String getDifficulty() {
        if (easyButton.isSelected())
            return "easy";
        else if (mediumButton.isSelected())
            return "medium";
        else if (hardButton.isSelected())
            return "hard";
        else
            return "unknown";
    }


    // converts and returns the corresponding difficulty number
    public int convertDifficultyToNum(String difficulty) {
        switch (difficulty) {
            case "easy":
                return 0;
            case "medium":
                return 1;
            case "hard":
                return 2;
        }
        return -1;
    }


    // chooses a random number between 0 and the number of columns in the 2d array
    public int randomProblemNumber(int length) {
        problemNum = (int) (Math.random() * length);
        while (problemNum == temp || unmas[difficultyNum][problemNum] == null) {
            problemNum = (int) (Math.random() * length);
        }
        temp = problemNum;
        return problemNum;
    }


    // displays the problem in a new window
    public void displayProblem(String problem) {
        setProblemScreenElementsVisible();
        questionArea.setText(problem);
    }


    // chooses and returns a random problem
    public void randomizeProblem() {
        // fixes bug that crashes program when clicking randomize button when there's only one unmastered problem in the difficulty
        if (counter == unmas[0].length - 1)
            resetMastery();

        String difficulty = getDifficulty();

        if (difficulty.equals("unknown")) {
            JOptionPane.showMessageDialog(null, "Please Select a Difficulty");
        } else {
            difficultyNum = convertDifficultyToNum(difficulty);
            problemNum = randomProblemNumber(unmas[0].length);
            String problem = String.valueOf(unmas[difficultyNum][problemNum]);
            displayProblem(problem);
        }
    }


    // displays a new random problem that hasn't been marked as mastered before
    public void nextRandomProblem() {
        if (unmasButton.isSelected() || masButton.isSelected()) {
            masteryStatusChange();
            randomizeProblem();
            unmasButton.setSelected(false);
            masButton.setSelected(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Mastery");
        }

        // checks if there is only one problem left in unmastered array and hides next button if so to prevent program from crashing
        counter = 0;
        for (int i = 0; i < unmas[0].length; i++) {
            if (unmas[difficultyNum][i] == null) {
                counter++;
            }
        }
        if (counter == unmas[0].length - 1) {
            nextButton.setVisible(false);
            JOptionPane.showMessageDialog(null, "You've Reached the Last Problem");
        }
    }


    // moves a problem from the unmastered array to the mastered array when user changes mastery status
    public void masteryStatusChange() {
        String tempProblem = unmas[difficultyNum][problemNum];

        if (unmasButton.isSelected()) {
            unmas[difficultyNum][problemNum] = tempProblem;
            mas[difficultyNum][problemNum] = null;
        }

        if (masButton.isSelected()) {
            mas[difficultyNum][problemNum] = tempProblem;
            unmas[difficultyNum][problemNum] = null;
        }
    }


    // resets all problems from the mastered array back to the unmastered array for the current difficulty
    public void resetMastery() {
        for (int i = 0; i < unmas[0].length; i++) {
            if (unmas[difficultyNum][i] == null) {
                unmas[difficultyNum][i] = mas[difficultyNum][i];
                mas[difficultyNum][i] = null;
            }
        }
        nextButton.setVisible(true);
    }


    // set main screen elements to visible and problem screen elements to invisible
    public void setMainScreenElementsVisible() {
        titleLabel.setVisible(true);
        easyButton.setVisible(true);
        mediumButton.setVisible(true);
        hardButton.setVisible(true);
        randomButton.setVisible(true);
        easyButton.setSelected(false);
        mediumButton.setSelected(false);
        hardButton.setSelected(false);
        questionArea.setVisible(false);
        backButton.setVisible(false);
        nextButton.setVisible(false);
        unmasButton.setVisible(false);
        masButton.setVisible(false);
        resetMasteryButton.setVisible(false);
    }


    // set problem screen elements to visible and main screen elements to invisible
    public void setProblemScreenElementsVisible() {
        titleLabel.setVisible(false);
        easyButton.setVisible(false);
        mediumButton.setVisible(false);
        hardButton.setVisible(false);
        randomButton.setVisible(false);
        questionArea.setVisible(true);
        backButton.setVisible(true);
        nextButton.setVisible(true);
        unmasButton.setVisible(true);
        masButton.setVisible(true);
        resetMasteryButton.setVisible(true);
    }


    // main function
    public static void main(String[] args) {
        CodingRandomizer frame = new CodingRandomizer();
        frame.setVisible(true);
    }
}