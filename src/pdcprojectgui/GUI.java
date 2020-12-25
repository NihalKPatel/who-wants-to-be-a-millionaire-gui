/*
Author Nihal Patel
ID 17998542
Who wants to be a millionaire
*/
package pdcprojectgui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GUI extends java.awt.Frame {

    public CardLayout cards;
    public ArrayList<JButton> qButtons;
    public Game thisGame;
    public ArrayList<JButton> btnLifelines;

    /**
     * Creates new form GUI
     */
    public GUI() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int windowHeight = screenHeight / 2;
        int windowWidth = screenWidth / 2;

        this.setTitle("Who Wants to be a Millionaire!");
        this.setLocation(windowWidth / 2, windowHeight / 2);
        this.setResizable(false);

        initComponents();
        cards = (CardLayout) pnlCardHolder.getLayout();
        qButtons = new ArrayList<JButton>();
        qButtons.add(btnAnswer1);
        qButtons.add(btnAnswer2);
        qButtons.add(btnAnswer3);
        qButtons.add(btnAnswer4);

        btnLifelines = new ArrayList<JButton>();
        btnLifelines.add(btnFF);
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

    }

    public void setGame(Game current) {
        thisGame = current;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCardHolder = new javax.swing.JPanel();
        crdStartScreen = new javax.swing.JPanel();
        javax.swing.JLabel lblWelcome = new javax.swing.JLabel();
        btnStart1 = new javax.swing.JButton();
        btnStartScrnQuit = new javax.swing.JButton();
        pnlQuestionScreen = new javax.swing.JPanel();
        pnlAnswerButtons = new javax.swing.JPanel();
        btnAnswer1 = new javax.swing.JButton();
        btnAnswer2 = new javax.swing.JButton();
        btnAnswer3 = new javax.swing.JButton();
        btnAnswer4 = new javax.swing.JButton();
        pnlQuestionDisplay = new javax.swing.JPanel();
        pnlLLButtons = new javax.swing.JPanel();
        lblQuestion = new javax.swing.JLabel();
        lblForPrize = new javax.swing.JLabel();
        btnFF = new javax.swing.JButton();
        btnWalkAway = new javax.swing.JButton();
        pnlEndScreen = new javax.swing.JPanel();
        lblEndMessage = new javax.swing.JLabel();
        pnlScoreQuestion = new javax.swing.JPanel();
        btnQuitNoScore = new javax.swing.JButton();
        btnBacktoMenu = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        pnlCardHolder.setLayout(new java.awt.CardLayout());

        crdStartScreen.setBackground(new java.awt.Color(0, 153, 153));
        crdStartScreen.setMinimumSize(new java.awt.Dimension(883, 528));

        lblWelcome.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(204, 204, 204));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome to Who Wants to be a Millionaire!");

        btnStart1.setBackground(new java.awt.Color(0, 102, 102));
        btnStart1.setForeground(new java.awt.Color(204, 204, 204));
        btnStart1.setText("Start");
        btnStart1.setMaximumSize(new java.awt.Dimension(133, 32));
        btnStart1.setMinimumSize(new java.awt.Dimension(133, 32));
        btnStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart1ActionPerformed(evt);
            }
        });

        btnStartScrnQuit.setBackground(new java.awt.Color(0, 102, 102));
        btnStartScrnQuit.setForeground(new java.awt.Color(204, 204, 204));
        btnStartScrnQuit.setText("Quit");
        btnStartScrnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitNoScoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout crdStartScreenLayout = new javax.swing.GroupLayout(crdStartScreen);
        crdStartScreen.setLayout(crdStartScreenLayout);
        crdStartScreenLayout.setHorizontalGroup(
            crdStartScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(crdStartScreenLayout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addGroup(crdStartScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnStartScrnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        crdStartScreenLayout.setVerticalGroup(
            crdStartScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(crdStartScreenLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(lblWelcome)
                .addGap(30, 30, 30)
                .addComponent(btnStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnStartScrnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pnlCardHolder.add(crdStartScreen, "card2");

        pnlQuestionScreen.setBackground(new java.awt.Color(0, 153, 153));

        pnlAnswerButtons.setLayout(new java.awt.GridLayout(2, 2));

        btnAnswer1.setBackground(new java.awt.Color(0, 153, 153));
        btnAnswer1.setFont(new java.awt.Font("Corbel Light", 1, 18)); // NOI18N
        btnAnswer1.setText("Default Answer 1");
        btnAnswer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });
        pnlAnswerButtons.add(btnAnswer1);

        btnAnswer2.setBackground(new java.awt.Color(0, 153, 153));
        btnAnswer2.setFont(new java.awt.Font("Corbel Light", 1, 18)); // NOI18N
        btnAnswer2.setText("Default Answer 2");
        btnAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });
        pnlAnswerButtons.add(btnAnswer2);

        btnAnswer3.setBackground(new java.awt.Color(0, 153, 153));
        btnAnswer3.setFont(new java.awt.Font("Corbel Light", 1, 18)); // NOI18N
        btnAnswer3.setText("Default Answer 3");
        btnAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });
        pnlAnswerButtons.add(btnAnswer3);

        btnAnswer4.setBackground(new java.awt.Color(0, 153, 153));
        btnAnswer4.setFont(new java.awt.Font("Corbel Light", 1, 18)); // NOI18N
        btnAnswer4.setText("Default Answer 4");
        btnAnswer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });
        pnlAnswerButtons.add(btnAnswer4);

        pnlQuestionDisplay.setBackground(new java.awt.Color(0, 153, 153));
        pnlQuestionDisplay.setLayout(new java.awt.GridLayout(2, 1));

        pnlLLButtons.setBackground(new java.awt.Color(0, 153, 153));
        pnlLLButtons.setLayout(new java.awt.GridLayout(1, 0));

        lblQuestion.setBackground(new java.awt.Color(0, 153, 153));
        lblQuestion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("Default Question ONE?");
        pnlLLButtons.add(lblQuestion);
        lblQuestion.getAccessibleContext().setAccessibleParent(pnlAnswerButtons);

        pnlQuestionDisplay.add(pnlLLButtons);

        lblForPrize.setBackground(new java.awt.Color(0, 153, 153));
        lblForPrize.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        lblForPrize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForPrize.setText("Prize money");
        lblForPrize.setMaximumSize(new java.awt.Dimension(106, 11));
        pnlQuestionDisplay.add(lblForPrize);
        pnlQuestionDisplay.add(lblEndMessage);
        lblForPrize.getAccessibleContext().setAccessibleName("");

        btnFF.setBackground(new java.awt.Color(0, 102, 102));
        btnFF.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnFF.setForeground(new java.awt.Color(204, 204, 204));
        btnFF.setText("50/50");
        btnFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lifelineActionPerformed(evt);
            }
        });

        btnWalkAway.setBackground(new java.awt.Color(0, 102, 102));
        btnWalkAway.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnWalkAway.setForeground(new java.awt.Color(204, 204, 204));
        btnWalkAway.setText("Walk Away");
        btnWalkAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lifelineActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlQuestionScreenLayout = new javax.swing.GroupLayout(pnlQuestionScreen);
        pnlQuestionScreen.setLayout(pnlQuestionScreenLayout);
        pnlQuestionScreenLayout.setHorizontalGroup(
            pnlQuestionScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAnswerButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlQuestionScreenLayout.createSequentialGroup()
                .addComponent(pnlQuestionDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQuestionScreenLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnWalkAway, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        pnlQuestionScreenLayout.setVerticalGroup(
            pnlQuestionScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuestionScreenLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlQuestionScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWalkAway, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(pnlQuestionDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(pnlAnswerButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCardHolder.add(pnlQuestionScreen, "card3");

        pnlEndScreen.setBackground(new java.awt.Color(0, 153, 153));
        pnlEndScreen.setForeground(new java.awt.Color(204, 204, 204));

        lblEndMessage.setBackground(new java.awt.Color(0, 153, 153));
        lblEndMessage.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEndMessage.setForeground(new java.awt.Color(204, 204, 204));
        lblEndMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEndMessage.setText("end message here");

        pnlScoreQuestion.setBackground(new java.awt.Color(0, 153, 153));
        pnlScoreQuestion.setForeground(new java.awt.Color(204, 204, 204));

        btnQuitNoScore.setBackground(new java.awt.Color(0, 102, 102));
        btnQuitNoScore.setForeground(new java.awt.Color(204, 204, 204));
        btnQuitNoScore.setText("Quit");
        btnQuitNoScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitNoScoreActionPerformed(evt);
            }
        });

        btnBacktoMenu.setBackground(new java.awt.Color(0, 102, 102));
        btnBacktoMenu.setForeground(new java.awt.Color(204, 204, 204));
        btnBacktoMenu.setText("Back to Main Menu");
        btnBacktoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBacktoMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlScoreQuestionLayout = new javax.swing.GroupLayout(pnlScoreQuestion);
        pnlScoreQuestion.setLayout(pnlScoreQuestionLayout);
        pnlScoreQuestionLayout.setHorizontalGroup(
            pnlScoreQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlScoreQuestionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlScoreQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBacktoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitNoScore, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(352, 352, 352))
        );
        pnlScoreQuestionLayout.setVerticalGroup(
            pnlScoreQuestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlScoreQuestionLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnQuitNoScore, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnBacktoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlEndScreenLayout = new javax.swing.GroupLayout(pnlEndScreen);
        pnlEndScreen.setLayout(pnlEndScreenLayout);
        pnlEndScreenLayout.setHorizontalGroup(
            pnlEndScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEndScreenLayout.createSequentialGroup()
                .addGroup(pnlEndScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEndScreenLayout.createSequentialGroup()
                        .addComponent(lblEndMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlEndScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlScoreQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlEndScreenLayout.setVerticalGroup(
            pnlEndScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEndScreenLayout.createSequentialGroup()
                .addComponent(lblEndMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlScoreQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCardHolder.add(pnlEndScreen, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCardHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCardHolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btnAnswerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAnswerActionPerformed
    {//GEN-HEADEREND:event_btnAnswerActionPerformed
        int answer = -1;
        if (evt.getSource() == btnAnswer1) {
            answer = 1;
        } else if (evt.getSource() == btnAnswer2) {
            answer = 2;
        } else if (evt.getSource() == btnAnswer3) {
            answer = 3;
        } else if (evt.getSource() == btnAnswer4) {
            answer = 4;
        }

        thisGame.checkAnswer(answer);
    }//GEN-LAST:event_btnAnswerActionPerformed

    private void lifelineActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_lifelineActionPerformed
    {//GEN-HEADEREND:event_lifelineActionPerformed
        char lifelineType = '-';
        JButton source = (JButton) evt.getSource();
        if (source == btnFF) {
            lifelineType = 'F';
            source.setEnabled(false);
        } else if (source == btnWalkAway) {
            lifelineType = 'W';         
        }
        

        thisGame.useLifeLine(lifelineType);
    }//GEN-LAST:event_lifelineActionPerformed

    private void btnQuitNoScoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnQuitNoScoreActionPerformed
    {//GEN-HEADEREND:event_btnQuitNoScoreActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnQuitNoScoreActionPerformed

    private void btnStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart1ActionPerformed

        cards.show(pnlCardHolder, "card3");
    }//GEN-LAST:event_btnStart1ActionPerformed

    private void btnBacktoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBacktoMenuActionPerformed
        thisGame.resetGame();
        cards.show(pnlCardHolder, "card2");
    }//GEN-LAST:event_btnBacktoMenuActionPerformed

    public void changeCard(String cardName) {
        cards.show(pnlCardHolder, cardName);
    }

    public void setQuestionText(String text) {
        lblQuestion.setText(text);
    }

    public void setPrize(String prize) {
        lblForPrize.setText(prize);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswer1;
    private javax.swing.JButton btnAnswer2;
    private javax.swing.JButton btnAnswer3;
    private javax.swing.JButton btnAnswer4;
    private javax.swing.JButton btnBacktoMenu;
    private javax.swing.JButton btnFF;
    private javax.swing.JButton btnQuitNoScore;
    private javax.swing.JButton btnStart1;
    private javax.swing.JButton btnStartScrnQuit;
    private javax.swing.JButton btnWalkAway;
    private javax.swing.JPanel crdStartScreen;
    public javax.swing.JLabel lblEndMessage;
    private javax.swing.JLabel lblForPrize;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JPanel pnlAnswerButtons;
    private javax.swing.JPanel pnlCardHolder;
    private javax.swing.JPanel pnlEndScreen;
    private javax.swing.JPanel pnlLLButtons;
    private javax.swing.JPanel pnlQuestionDisplay;
    private javax.swing.JPanel pnlQuestionScreen;
    private javax.swing.JPanel pnlScoreQuestion;
    // End of variables declaration//GEN-END:variables
}
