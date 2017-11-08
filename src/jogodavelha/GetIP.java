/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 *
 * @author lab05
 */
public class GetIP {

    public static String retornaIP() {
        String ipAddress = null;
        Enumeration<NetworkInterface> net = null;
        try {
            net = NetworkInterface.getNetworkInterfaces();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        while (net.hasMoreElements()) {
            NetworkInterface element = net.nextElement();
            Enumeration<InetAddress> addresses = element.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress ip = addresses.nextElement();

                if (ip.isSiteLocalAddress()) {
                    ipAddress = ip.getHostAddress();
                }
            }
        }
        return ipAddress;
    }
}
