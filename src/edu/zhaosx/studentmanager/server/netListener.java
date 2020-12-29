package edu.zhaosx.studentmanager.server;

import edu.zhaosx.studentmanager.network.addServersTread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class netListener implements Runnable{

    @Override
    public void run() {
        Server();
    }

    public static void Server(){
        Socket s = null;
        try {
            ServerSocket ss = new ServerSocket(8888);
            s = ss.accept();
            new addServersTread(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
