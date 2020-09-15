package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    public Socket socket;
    public DataInputStream in;
    public DataOutputStream out;
    @FXML
    TextArea messageWindow;

    @FXML
    TextArea userList;

    @FXML
    TextField textField;

    @FXML
    private void send(){
        String str = textField.getText();
        try {
            out.writeUTF(str);
            textField.clear();
            textField.requestFocus();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void startClient(){
        try {
            socket = new Socket("localhost",8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String response = in.readUTF();
            messageWindow.appendText("\n"+response);
            Thread responseThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String response = null;
                        try {
                            response = in.readUTF();
                            System.out.println("пользователь = " + response);
                            String[] responseArray = response.split("]##");
                            System.out.println(responseArray[0]+"/"+responseArray[1]);
                            responseArray[0]=responseArray[0].replace(",","\n");
                            responseArray[0]=responseArray[0].replace("[","");
                            responseArray[0]=responseArray[0].replace("]","");

                            userList.setText("");
                            userList.setText(responseArray[0]);
                            messageWindow.appendText("\n"+responseArray[1]);
                        } catch (IOException exception) {
                            System.out.println("ERROR");
                        }
                    }
                }
            });
            responseThread.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
