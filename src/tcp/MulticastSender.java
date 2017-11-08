package tcp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import jogodavelha.GetIP;

public class MulticastSender implements Runnable {

    final static String INET_ADDR = "224.0.0.3";
    final static int PORT = 4040;
    GetIP pegandoIP = new GetIP();

    public void run() {
        try {
            InetAddress addr = InetAddress.getByName(INET_ADDR);
            DatagramSocket senderSocket = new DatagramSocket();
            String msg = pegandoIP.retornaIP();
            while (true) {
                DatagramPacket msgPacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, PORT);
                senderSocket.send(msgPacket);
                System.out.println("Enviei um pacote com a seguinte mensagem: " + msg);
                Thread.sleep(350);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
