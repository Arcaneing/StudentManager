package edu.zhaosx.studentmanager.network;

import com.alibaba.fastjson.JSONObject;
import edu.zhaosx.studentmanager.Transaction;

import java.net.Socket;

public class GET extends Transaction implements Runnable{
    public int request;
    public String tables;
    public Object objects;
    public String key;

    public GET(int request,String tables,Object objects,String key){
        super();
        this.request = request;
        this.objects = objects;
        this.tables = tables;
        this.key = key;
    }

    public GET(JSONObject object){
        super.object = object;
        getSolve(object);

    }

    public JSONObject getCodeing(){
        object.put("Irequest",request);
        object.put("Stables",tables);
        object.put("Oobject",objects);
        object.put("Skey",key);
        return object;
    }

    public void getSolve(JSONObject object){
        this.request = object.getIntValue("Irequest");
        this.tables = object.getString("Stables");
        this.objects = object.getObject("Oobject",Object.class);
        this.key = object.getString("Skey");
    }

    @Override
    public void run() {

    }
}
