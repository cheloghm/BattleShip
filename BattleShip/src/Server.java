import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private PlayerA playerA;
    private ServerSocket serversocket;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public void start() throws IOException{

        System.out.println("Connection Starting on port: 12345");
        //make connection to client on port specified
        serversocket = new ServerSocket(12345);
        socket = serversocket.accept();

        //open buffered reader for reading data from client
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());


        play();
    }


    public void play() throws IOException {
        output.writeUTF("start");

//        playerA.setCheck(0);
//
//        output.writeUTF("turn");
//
//        while (true){
//            output.writeUTF(String.valueOf(playerA.hitRow));
//            output.writeUTF(String.valueOf(playerA.hitColumn));
//
//            playerA.disableAttackMode();
//
//            int hitRow = Integer.parseInt(input.readUTF());
//            int hitCol = Integer.parseInt(input.readUTF());
//
//            System.out.println(hitRow+" "+hitCol);
//        }

    }

    public static void main(String[] args){
        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
