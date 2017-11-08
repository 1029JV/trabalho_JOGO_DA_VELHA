package tcp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import jogodavelha.JanelaDeBusca;
import javax.swing.JFrame;
import jogodavelha.JanelaDeJogo;

public class MulticastReceiver implements Runnable {

    private JanelaDeJogo janelaJogo = JanelaDeJogo.getInstance();

    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 4040;

    public void run() {
        try {
            InetAddress address = InetAddress.getByName(INET_ADDR);
            byte[] buf = new byte[256];
            MulticastSocket receiverSocket = new MulticastSocket(PORT);
            receiverSocket.joinGroup(address);
            while (true) {
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                receiverSocket.receive(msgPacket);
                String msg = new String(buf, 0, buf.length);
                System.out.println("Mensagem recebida: " + msg);
                janelaJogo.pegouIp(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
