import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    private PlayerB playerB;
    private PlayerA playerA;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public void startClient() throws IOException{
        playerA = new PlayerA();
        playerB = new PlayerB();

        //Create socket connection
        try {
            socket = new Socket("localhost", 12345);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            play();
        }catch (ConnectException ex){
            JOptionPane.showMessageDialog(playerB.frame, "Server not started yet!");
        }
    }

    public void play() throws IOException {
        String check = input.readUTF();
        if(check.equals("start")){
            playerA.initialize();
            playerA.makeDesign();

            playerB.initialize();
            playerB.makeDesign();
        }

        playerA.setCheck(0);
        playerB.setCheck(0);
        playerA.setPlayerB(playerB);
        playerB.setPlayerA(playerA);
    }


    public static void main(String args[]){
        Client client = new Client();
        try {
            client.startClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
