package com.moinb.mouseandkeyboard.networkutil;

import android.util.Log;

import java.io.IOException;
import java.net.Socket;

public class NetUtils {

    public static final String SERVER_IP = "192.168.1.101";
    public static final int SERVER_PORT = 9898;
    public static boolean pingServer(String server_ip){
        Socket socket = null;
        try {
            Log.i("fuck", "" + server_ip);
            socket = new Socket(server_ip==null?SERVER_IP:server_ip, SERVER_PORT);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {

        }

    }
}
