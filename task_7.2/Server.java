package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Socket> clients  = new ArrayList<>();
    static ArrayList<String> userNames= new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            while (true){
                Socket socket = serverSocket.accept();
                clients.add(socket);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("Пользователь подключился");
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String userName = null;
                        try {
                            out.writeUTF("Введите свое имя:");
                            userName = in.readUTF();
                            userNames.add(userName);
                            broadcastMsg("Пользователь "+userName+" подключился","Сервер");
                            while (true){
                                String str = in.readUTF();
                                broadcastMsg(str,userName);
                                System.out.println("Пользователь прислал сообщение: "+str);
                            }
                        }catch (IOException e){
                            System.out.println("Пользователь "+userNames+" отключился");
                        }finally {
                            try {
                                clients.remove(socket);
                                userNames.remove(userName);
                                socket.close();
                            } catch (IOException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void broadcastMsg(String str,String userName) throws IOException{
        DataOutputStream out;
        for (Socket socket : clients){
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(userNames+"##"+userName+": "+str);
        }
    }
}
