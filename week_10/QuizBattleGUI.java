import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuizBattleGUI extends JFrame {
    private int bossHP = 100;
    private int playerHP = 50;
    private int score = 0;
    private int currentQuestionIndex = 0;

    private JLabel bossHpLabel;
    private JLabel playerHpLabel;
    private JLabel scoreLabel;
    private JLabel questionLabel;
    private JButton[] optionButtons;

    private ArrayList<Questions> questionList;

    public QuizBattleGUI() {
        setTitle("Code Boss Battle");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // إعداد الأسئلة
        loadQuestions();

        // لوحة النتيجة والنقاط (Top Panel)
        JPanel statusPanel = new JPanel(new GridLayout(1, 3));
        bossHpLabel = new JLabel("Boss HP: " + bossHP, SwingConstants.CENTER);
        playerHpLabel = new JLabel("Player HP: " + playerHP, SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);

        statusPanel.add(bossHpLabel);
        statusPanel.add(playerHpLabel);
        statusPanel.add(scoreLabel);
        add(statusPanel, BorderLayout.NORTH);

        // لوحة السؤال (Center Panel)
        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(questionLabel, BorderLayout.CENTER);

        // لوحة خيارات الإجابة (South Panel)
        JPanel optionsPanel = new JPanel(new GridLayout(2, 2));
        optionButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            int optionIndex = i;
            optionButtons[i] = new JButton();
            optionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer(optionIndex);
                }
            });
            optionsPanel.add(optionButtons[i]);
        }
        add(optionsPanel, BorderLayout.SOUTH);

        displayQuestion();
    }

    private void loadQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Questions("What is the extension of Java code files?", new String[]{".js", ".java", ".txt", ".class"}, 1));
        questionList.add(new Questions("Which keyword is used to create an object in Java?", new String[]{"class", "void", "new", "import"}, 2));
        questionList.add(new Questions("Which data type is used for whole numbers?", new String[]{"double", "int", "boolean", "String"}, 1));
        questionList.add(new Questions("What is the entry point method of a Java program?", new String[]{"start()", "run()", "main()", "init()"}, 2));
        questionList.add(new Questions("Which symbol is used for single-line comments in Java?", new String[]{"//", "/*", "#", "--"}, 0));
    }

    private void displayQuestion() {
        if (currentQuestionIndex < questionList.size()) {
            Questions q = questionList.get(currentQuestionIndex);
            questionLabel.setText("Q: " + q.getQuestion());
            String[] options = q.getOptions();
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[i]);
            }
        } else {
            currentQuestionIndex = 0;
            displayQuestion();
        }
    }

    private void checkAnswer(int selectedIndex) {
        Questions currentQuestion = questionList.get(currentQuestionIndex);

        if (currentQuestion.isCorrect(selectedIndex)) {
            bossHP -= 20;
            score += 10;
            JOptionPane.showMessageDialog(this, "Correct! Boss HP -20, Score +10");
        } else {
            playerHP -= 10;
            JOptionPane.showMessageDialog(this, "Wrong! Player HP -10");
        }

        bossHpLabel.setText("Boss HP: " + bossHP);
        playerHpLabel.setText("Player HP: " + playerHP);
        scoreLabel.setText("Score: " + score);

        if (bossHP <= 0) {
            JOptionPane.showMessageDialog(this, "You Win! You defeated the Code Boss!\nFinal Score: " + score);
            System.exit(0);
        } else if (playerHP <= 0) {
            JOptionPane.showMessageDialog(this, "Game Over! You ran out of HP.");
            System.exit(0);
        }

        currentQuestionIndex++;
        displayQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizBattleGUI().setVisible(true);
        });
    }
}
