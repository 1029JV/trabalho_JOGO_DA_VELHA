package tcp;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClienteTCP {

    public void enviar(String ipParaConectar, String jogada) {
        try {
            Socket clientSocket = new Socket(ipParaConectar, 3737);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(jogada);
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
