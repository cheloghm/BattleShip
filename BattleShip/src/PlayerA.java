import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;

public class PlayerA{
    private PlayerB playerB;
    public int check = -1;
    public int shipSize = 5;
    public Random random;
    public float r;
    public float g;
    public float b;
    public Color randomColor;
    public int turn = 1;

    // swing instance variables;
    public JFrame frame;
    public JLabel infoLabel;
    public JPanel leftGrid;
    public JPanel rightGrid;
    public JPanel bottomInfo;
    public JPanel info;
    public JButton startAttack;

    public JButton[][] buttons;
    public JButton[][] opponent;

    private int[][] status;

    ShipPlacementHandler shipPlacementHandler;
    AttackOpponentHandler attackOpponentHandler;
    StartGameHandler startGameHandler;


    public void setPlayerB(PlayerB playerB) {
        this.playerB = playerB;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void initialize(){
        random = new Random();
        frame = new JFrame();
        infoLabel = new JLabel("Place ships below and click start game.");
        leftGrid = new JPanel();
        rightGrid = new JPanel();
        bottomInfo = new JPanel();
        info = new JPanel(new BorderLayout());
        startAttack = new JButton("Place Ships");

        buttons = new JButton[10][10];
        opponent = new JButton[10][10];
        status = new int[10][10];
        shipPlacementHandler = new ShipPlacementHandler();
        attackOpponentHandler = new AttackOpponentHandler();
        startGameHandler = new StartGameHandler();

        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[i].length; j++) {
                status[i][j] = 0;
            }
        }
    }

    public void enableAttackMode(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                opponent[i][j].setEnabled(true);
            }
        }
    }

    public void disableAttackMode(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                opponent[i][j].setEnabled(false);
            }
        }
    }

    public void attackOpponent(int i, int j){
        if(check == 0){
            playerB.hit(i, j);
        }else{
            JOptionPane.showMessageDialog(frame, "Waiting for other client to place there ships");
        }
    }

    public void placeShip(int i, int j){
        int count = 0;
        if(shipSize == 5){
            if(status[i][j] == 0){
                count++;
                if(status[i+1][j] == 0){
                    count++;
                }
                if(status[i-1][j] == 0){
                    count++;
                }
                if(status[i][j+1] == 0){
                    count++;
                }
                if(status[i][j-1] == 0){
                    count++;
                }
            }
        }else if(shipSize == 4){
            if(status[i][j] == 0){
                count++;
                if(status[i][j+1] == 0){
                    count++;
                }
                if(status[i][j+2] == 0){
                    count++;
                }
                if(status[i][j+3] == 0){
                    count++;
                }
            }
        }
        else if(shipSize == 3){
            if(status[i][j] == 0){
                count++;
                if(status[i][j+1] == 0){
                    count++;
                }
                if(status[i][j+2] == 0){
                    count++;
                }
            }
        }
        else if(shipSize == 2){
            if(status[i][j] == 0){
                count++;
                if(status[i][j+1] == 0){
                    count++;
                }
            }
        }
        else if(shipSize == 1){
            if(status[i][j] == 0){
                count++;
            }
        }



        r = random.nextFloat();
        g = random.nextFloat();
        b = random.nextFloat();
        randomColor = new Color(r, g, b);
        try{
            if(this.shipSize > 0){
                if(count == 5 && shipSize == 5){
                    status[i][j] = 5;
                    buttons[i][j].setOpaque(true);
                    buttons[i][j].setBackground(randomColor);

                    status[i+1][j] = 5;
                    buttons[i+1][j].setOpaque(true);
                    buttons[i+1][j].setBackground(randomColor);

                    status[i-1][j] = 5;
                    buttons[i-1][j].setOpaque(true);
                    buttons[i-1][j].setBackground(randomColor);

                    status[i][j+1] = 5;
                    buttons[i][j+1].setOpaque(true);
                    buttons[i][j+1].setBackground(randomColor);

                    status[i][j-1] = 5;
                    buttons[i][j-1].setOpaque(true);
                    buttons[i][j-1].setBackground(randomColor);
                    this.shipSize -= 1;

                }
                else if(count == 4 && shipSize == 4){
                    status[i][j] = 4;
                    buttons[i][j].setOpaque(true);
                    buttons[i][j].setBackground(randomColor);

                    status[i][j+1] = 4;
                    buttons[i][j+1].setOpaque(true);
                    buttons[i][j+1].setBackground(randomColor);

                    status[i][j+2] = 4;
                    buttons[i][j+2].setOpaque(true);
                    buttons[i][j+2].setBackground(randomColor);

                    status[i][j+3] = 4;
                    buttons[i][j+3].setOpaque(true);
                    buttons[i][j+3].setBackground(randomColor);
                    this.shipSize -= 1;

                }else if(count == 3 && shipSize == 3){
                    status[i][j] = 3;
                    buttons[i][j].setOpaque(true);
                    buttons[i][j].setBackground(randomColor);

                    status[i][j+1] = 3;
                    buttons[i][j+1].setOpaque(true);
                    buttons[i][j+1].setBackground(randomColor);

                    status[i][j+2] = 3;
                    buttons[i][j+2].setOpaque(true);
                    buttons[i][j+2].setBackground(randomColor);
                    this.shipSize -= 1;

                }else if(count == 2 && shipSize == 2){
                    status[i][j] = 2;
                    buttons[i][j].setOpaque(true);
                    buttons[i][j].setBackground(randomColor);

                    status[i][j+1] = 2;
                    buttons[i][j+1].setOpaque(true);
                    buttons[i][j+1].setBackground(randomColor);
                    this.shipSize -= 1;

                }else if(count == 1 && shipSize == 1){
                    status[i][j] = 1;
                    buttons[i][j].setOpaque(true);
                    buttons[i][j].setBackground(randomColor);
                    this.shipSize -= 1;

                    enableAttackMode();
                    startAttack.setText("Player 1 turn");


                }else{
                    JOptionPane.showMessageDialog(frame, "No appropriate location found to place ship!");
                }

                //buttons[i][j].setContentAreaFilled(false);
            }else {
                JOptionPane.showMessageDialog(frame, "All the ships are placed!");
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

    }

    private class ShipPlacementHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(source == buttons[i][j]){
                        placeShip(i, j);
                        return;
                    }
                }
            }
        }
    }

    private class AttackOpponentHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if(source == opponent[i][j]){
                        if(getShipSize() == 0 && playerB.getShipSize() == 0){
                            if(checkPoints() == 100){
                                startAttack.setText("Player 2 Won!");
                                playerB.startAttack.setText("Player 2 Won!");
                                disableAttackMode();
                                playerB.disableAttackMode();
                            }else if(playerB.checkPoints() == 100){
                                startAttack.setText("Player 1 Won!");
                                playerB.startAttack.setText("Player 1 Won!");
                                disableAttackMode();
                                playerB.disableAttackMode();
                            }
                            if(turn == 1){
                                attackOpponent(i, j);
                                setTurn(0);
                                playerB.setTurn(1);
                                playerB.startAttack.setText("Player 2 turn");
                                startAttack.setText("Player 2 turn");
                            }else {
                                JOptionPane.showMessageDialog(frame, "It's player 2 turn");
                            }
                        }else {
                            JOptionPane.showMessageDialog(frame, "Let your opponent place ships!");
                        }



                        return;
                    }
                }
            }
        }
    }

    public int getShipSize() {
        return shipSize;
    }

    public void hit(int i, int j){
        boolean check = false;
        if(status[i][j] != 0){
            buttons[i][j].setOpaque(true);
            buttons[i][j].setBackground(Color.RED);
            status[i][j] = 0;
            playerB.opponent[i][j].setOpaque(true);
            playerB.opponent[i][j].setBackground(Color.RED);
            check = true;
        }

        if(!check){
            playerB.opponent[i][j].setOpaque(true);
            playerB.opponent[i][j].setBackground(Color.WHITE);
        }

    }

    private class StartGameHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int checkPoints(){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(status[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
    public void makeDesign() {
        // top
        infoLabel = new JLabel("Place ships below and click start game.");
        info.add(infoLabel, BorderLayout.CENTER);

        // left
        leftGrid = new JPanel();
        leftGrid.setLayout(new GridLayout(10, 10));
        leftGrid.setBackground(Color.black);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton();
                leftGrid.add(buttons[i][j]);
                buttons[i][j].setPreferredSize(new Dimension(30, 10));
                buttons[i][j].addActionListener(shipPlacementHandler);
            }
        }
        // opponent
        rightGrid = new JPanel();
        rightGrid.setLayout(new GridLayout(10, 10));
        rightGrid.setBackground(Color.blue);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                opponent[i][j] = new JButton();
                opponent[i][j].setEnabled(false);
                opponent[i][j].setPreferredSize(new Dimension(30, 10));
                rightGrid.add(opponent[i][j]);
                opponent[i][j].addActionListener(attackOpponentHandler);
            }
        }

        // bottom info
        bottomInfo = new JPanel();
        bottomInfo.add(startAttack);
        startAttack.setEnabled(false);

        startAttack.addActionListener(startGameHandler);

        frame.setTitle("Player 1");
        frame.add(info, BorderLayout.NORTH);
        frame.add(leftGrid, BorderLayout.WEST);
        frame.add(rightGrid, BorderLayout.EAST);
        frame.add(bottomInfo, BorderLayout.SOUTH);
        frame.setSize(650, 600);
        frame.setResizable(false);
        frame.setLocation(new Point(50, 100));
//        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
