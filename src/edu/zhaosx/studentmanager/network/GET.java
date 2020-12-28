package edu.zhaosx.studentmanager.network;

import com.alibaba.fastjson.JSONObject;

import java.net.Socket;

public class GET implements Runnable{
    public int request;
    public String tables;
    public Object objects;
    public String key;
    public Socket s;

    public GET(int request,String tables,Object objects,String key){
        this.request = request;
        this.objects = objects;
        this.tables = tables;
        this.key = key;
    }

    public GET(JSONObject object){
        getSolve(object);
    }

    public JSONObject getCodeing(){
        JSONObject object = new JSONObject();
        object.put("Irequest",request);
        object.put("Stables",tables);
        object.put("Oobject",objects);
        object.put("Skey",key);
        return object;
    }

    public GET getSolve(JSONObject object){
        this.request = object.getIntValue("Irequest");
        this.tables = object.getString("Stables");
        this.objects = object.getObject("Oobject",Object.class);
        this.key = object.getString("Skey");
        return this;
    }

    @Override
    public void run() {

    }
}
