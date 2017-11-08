package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import jogodavelha.JanelaDeJogo;

public class ConfirmaConexao implements Runnable {

    String confirmaConexao = null;
    private JanelaDeJogo janelaJogo = JanelaDeJogo.getInstance();

    public void run() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(4040);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                confirmaConexao = inFromClient.readLine();
                if (confirmaConexao != null) {
                    janelaJogo.pegouIp(confirmaConexao);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
