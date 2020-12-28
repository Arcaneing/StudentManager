package edu.zhaosx.studentmanager.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class socketTest {
    public static void Server(){
        System.out.println("START");
        Socket s = null;
        try {
            ServerSocket ss = new ServerSocket(8888);
            s = ss.accept();
            InputStream is = s.getInputStream();
            System.out.println("GET");
            byte[] by = new byte[1024];
            int num = 0;
            while((num = is.read())!=-1){
                System.out.print((char)num);
            }
            //5:关闭套接字
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void Clinet(){
        Socket s = null;
        try {
            s = new Socket("127.0.0.1", 8888);
            OutputStream os = s.getOutputStream();
            os.write(97);
            os.write(98);
            os.write(99);
            System.out.println("OUT");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
