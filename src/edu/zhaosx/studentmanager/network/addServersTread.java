package edu.zhaosx.studentmanager.network;

import com.alibaba.fastjson.JSONObject;
import edu.zhaosx.studentmanager.util.THREADUtils;

import java.io.*;
import java.net.Socket;

public class addServersTread implements Runnable{
    Socket s;
    @Override
    public void run() {
        JSONObject object = getJson();
        GET get = new GET(object);
        get.main();
        RESPONSE re = new RESPONSE(get.allow,get.list,1,get.key);
        pullJson(re.coding());
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public addServersTread(Socket s){
        this.s = s;
        THREADUtils.putThread(this);
    }

    public JSONObject getJson(){
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

    public void pullJson(JSONObject object){
        try {
            OutputStreamWriter osr = new OutputStreamWriter(s.getOutputStream());
            BufferedWriter br = new BufferedWriter(osr);
            br.write(object.toJSONString());
            osr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
