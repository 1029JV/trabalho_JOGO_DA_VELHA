package tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import jogodavelha.janelaDeJogo;

public class ServidorTCP {

    public void receber() {
        try {
            janelaDeJogo desativandoBtn = new janelaDeJogo();
            String jogada;
            ServerSocket welcomeSocket = new ServerSocket(3737);
            while (welcomeSocket.accept() == null) {
                Socket connectionSocket = welcomeSocket.accept();
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                jogada = inFromClient.readLine();
                desativandoBtn.desativaBtn(Integer.parseInt(jogada));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
