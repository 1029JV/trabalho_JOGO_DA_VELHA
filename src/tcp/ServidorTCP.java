package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import jogodavelha.JanelaDeJogo;

public class ServidorTCP implements Runnable {

    private JanelaDeJogo janelaJogo;
    String jogada;

    public ServidorTCP(JanelaDeJogo janela) {
        this.janelaJogo = janela;
    }

    public void run() {
        try {
            ServerSocket welcomeSocket = new ServerSocket(3737);
            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                jogada = inFromClient.readLine();
                janelaJogo.desativaBtn(Integer.parseInt(jogada));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
