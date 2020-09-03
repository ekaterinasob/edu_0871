package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class Server {
    static ArrayList<Socket> clients = new ArrayList<>();
    static ArrayList<String> userNames = new ArrayList<>();
    public static void main(String[] args) {
        Socket socket = null;

        try {
            

            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            while (true){

                socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("Клиент подключился");
                Thread thread = new Thread(new Runnable() {

                    @Override

                    public void run() {

                        try {
                            out.writeUTF("Ввведите свое имя:");
                            String userName = in.readUTF();
                            userNames.add(userName);
                            broadcastMsg("Клиент" +" " +userName + " " + "подключился");
                            while (true){
                                String str = in.readUTF();
                                broadcastMsg(str);
                                System.out.println("Клиент"+ " "+ userName + " "+"прислал(а) сообщение:" +str);

                            }

                        }catch (IOException e){

                            e.printStackTrace();

                        }

                    }

                });

                thread.start();

            }

        }catch (IOException ex){
            ex.printStackTrace();

        }

    }



    public static void broadcastMsg(String str) throws IOException{
        DataOutputStream out;
        for (Socket socket : clients){
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(str);

        }

    }

}

