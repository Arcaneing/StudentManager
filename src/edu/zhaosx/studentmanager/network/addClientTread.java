package edu.zhaosx.studentmanager.network;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;

public class addClientTread extends GET  implements Runnable {

    public Socket s = null;
    public addClientTread(int request, String tables, Object objects, String key) {
        super(request, tables, objects, key);
        run();
    }


    @Override
    public void run() {

        getCodeing();
        sendJSON();
        object = getJSON();
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.list = object.getObject("Lobjects",list.getClass());
    }

    public void sendJSON(){
        try {
            s = new Socket("127.0.0.1", 8888);
            OutputStreamWriter osr = new OutputStreamWriter(s.getOutputStream());
            BufferedWriter br = new BufferedWriter(osr);
            br.write(object.toJSONString());
            osr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJSON(){
        InputStreamReader isr = null;
        BufferedReader br;
        JSONObject object = null;
        try {
            isr=new InputStreamReader(s.getInputStream());
            br=new BufferedReader(isr);
            String str=br.readLine();
            object=JSONObject.parseObject(str);
            isr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }


}
