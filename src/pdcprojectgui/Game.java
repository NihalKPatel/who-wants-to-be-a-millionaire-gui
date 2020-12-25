/*
Author Nihal Patel
ID 17998542
Who wants to be a millionaire
*/
package pdcprojectgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Game {

    public ArrayList<ArrayList> questions;

    private int currentLevel;
    private int levelProgression; // how far through each level player is [1-5]
    private final Random rand;
    private boolean isPlaying;
    private LifeLine fiftyFifty;
    private final String[] prize; // corresponds to prizeNum
    private int prizeNum; // corresponds to current prize player is on
    // end conditions, use to determine game end state
    private boolean walkedAway;
    private boolean lost;
    private boolean won;
    private GUI window;
    public Question selectedQ;
    private int qNum; // number in list of currently being asked question
    private Connection conn;
    private Statement state;

    public Game() {
        conn = null;
        state = null;

        connToDB();
        questions = loadQuestions();

        currentLevel = 0; // start on base level & progression
        levelProgression = 1;
        rand = new Random();
        isPlaying = true;

        prizeNum = 0; // incremement for each correct question, correspond to prize amount
        prize = new String[]{"$100", "$200", "$500", "$1000", "$2,000", "$5,000","$10,000", "$20,000", "$50,000", "$70,000", "$100,000", "$250,000", "$500,000", "$750,000", "$1 MILLION"};
           
        fiftyFifty = new FiftyFifty();
        walkedAway = false;
        lost = false;
        won = false;

        window = new GUI();
        window.setVisible(true);
        window.setGame(this);

    }

    public void resetGame() {
        currentLevel = 0; // start on base level & progression
        qNum = 0;
        levelProgression = 1;
        isPlaying = true;
        fiftyFifty = new FiftyFifty();
        prizeNum = 0; // incremement for each correct question, correspond to prize amount
        walkedAway = false;
        lost = false;
        won = false;

        for (JButton btnLifeline : window.btnLifelines) {
            btnLifeline.setEnabled(true);
        }

        connToDB();

        questions = new ArrayList<ArrayList>();
        questions = loadQuestions();

        play();
    }

    public void play() {
        askQuestion();
    }

    public void askQuestion() {
        // select random question from current level

        if (questions.get(currentLevel).size() > 1) {
            qNum = rand.nextInt(questions.get(currentLevel).size());
        } else {
            qNum = 0;
            incrementProg();
        }

        selectedQ = (Question) questions.get(currentLevel).get(qNum);

        window.setQuestionText(selectedQ.getQuestion());

        for (int i = 0; i < window.qButtons.size(); i++) {
            window.qButtons.get(i).setText((i + 1) + ") " + selectedQ.getAnswers()[i]);
        }

        window.setPrize("For " + prize[prizeNum]);
    }

    
    public void askSpecificQuestion(int specQNum) {
        selectedQ = (Question) questions.get(currentLevel).get(specQNum);

        window.setQuestionText(selectedQ.getQuestion());

        for (int i = 0; i < window.qButtons.size(); i++) {
            window.qButtons.get(i).setText((i + 1) + ") " + selectedQ.getAnswers()[i]);
        }
    }
    
    public void checkAnswer(int pAns) {
        if (pAns == selectedQ.getCorrectAns()) // answer is CORRECT
        {
            incrementProg();
            questions.get(currentLevel).remove(qNum); // remove used question from list
            askQuestion();
        } else // answer is INCORRECT
        {
            lost = true;
            end();
        }
    }

    public void useLifeLine(char lifeline) {
        switch (lifeline) {
            case 'F':
                fiftyFifty.use(selectedQ);
                askSpecificQuestion(qNum);
                break;
            case 'W':
                String optionString = "Are you sure you want to walk away?";
                int reply = JOptionPane.showConfirmDialog(window, optionString, "Confirm Walk Away", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    walkedAway = true;
                    end();
                }
                break;
            default:
                break;
        }
    }

    private void end() {
        window.changeCard("card5");

        String winningMoney = "";
        String congrats = "";

        if (walkedAway) {
            if (prizeNum != 0) {
                congrats = "Congratulations! You walked away with ";
                winningMoney = prize[prizeNum - 1];
            } else {
                winningMoney = "$0";
                congrats = "You quit before it even started. You walked away with ";
            }
        }
        if (lost) {
            switch (currentLevel) {
                case 0:
                    winningMoney = "$0";
                    congrats = "That is incorrect! You lose, and unfortunately you walk away with ";
                    break;
                case 1:
                    winningMoney = prize[5]; // winnings checkpoint
                    congrats = "That is incorrect! You lose, but you still get to walk away with ";
                    break;
                case 2:
                    winningMoney = prize[10]; // 2nd winnings checkpoint
                    congrats = "That is incorrect! You lose, but you still get to walk away with ";
                    break;
                default:
                    break;
            }
        }
        if (won) {
            congrats = "CONGRATULATIONS! You have won $1 MILLION.";
        }

        congrats += winningMoney;
        window.lblEndMessage.setText(congrats);

        isPlaying = false;
    }

    private void incrementProg() // used to move progress OR move up a level
    {
        if (levelProgression < 5) // user cannot progress to next level
        {
            levelProgression++;
            prizeNum++; // increment prize num player is currently on
        } else if (levelProgression == 5 && prizeNum < 14) {
            currentLevel++; // move up a level
            levelProgression = 1; // reset progression of current level
            prizeNum++; // increment prize num player is currently on
        } else if (prizeNum == 14) {
            won = true;
            end();
        }
    }

    public int getLevel() {
        return currentLevel;
    }

    public void setLevel(int level) {
        currentLevel = level;
    }

    public boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean play) {
        isPlaying = play;
    }

    private void connToDB() {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";

        try {
            Class.forName(driver).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String url = "jdbc:derby:HighScores";
        
        try 
        {
           conn = DriverManager.getConnection(url);
        } catch (Throwable ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }
        
        
        try {
            state = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList loadQuestions() {
        ArrayList<Question> level0 = new ArrayList();
        ArrayList<Question> level1 = new ArrayList();
        ArrayList<Question> level2 = new ArrayList();

        ResultSet rs = null;

        if (conn != null && state != null) {
            try {
                rs = state.executeQuery("SELECT * FROM QUESTIONS");

                while (rs.next()) {
                    String[] answers = {rs.getString("ANS1"), rs.getString("ANS2"), rs.getString("ANS3"), rs.getString("ANS4")};
                    Question q = new Question(rs.getInt("QLEVEL"), rs.getString("QUESTION"), answers, rs.getInt("CORRANS"));

                    switch (q.getLevel()) {
                        case 0:
                            level0.add(q);
                            break;
                        case 1:
                            level1.add(q);
                            break;
                        case 2:
                            level2.add(q);
                            break;
                        default:
                            break;
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                connToDB();
            }
        } else {
            connToDB();

            if (conn != null && state != null) {
                loadQuestions();
            }
        }

        ArrayList lists = new ArrayList<>();
        lists.add(level0);
        lists.add(level1);
        lists.add(level2);

        return lists;
    }

}
