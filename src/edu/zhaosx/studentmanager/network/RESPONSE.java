package edu.zhaosx.studentmanager.network;
import com.alibaba.fastjson.JSONObject;
import edu.zhaosx.studentmanager.Transaction;

import java.net.Socket;
import java.util.List;

public class RESPONSE extends Transaction{
    public List<Object> objects;
    public int okCount;

    public RESPONSE(int allow,List<Object>objects,int okCount,String key){
        super.allow = allow;
        this.objects = objects;
        this.okCount = okCount;
        super.key = key;
    }

    public RESPONSE(int allow,int okCount){
        super.allow = allow;
        this.okCount = okCount;
    }

    public RESPONSE(JSONObject object){
        super.object = object;
        solve(object);
    }

    public RESPONSE solve(JSONObject object){
        this.allow = object.getIntValue("Iallow");
        this.objects = object.getObject("Lobjects",objects.getClass());
        this.okCount = object.getIntValue("IokCount");
        super.key = object.getString("Skey");
        return this;
    }

    public JSONObject coding(){
        object.put("Iallow",this.allow);
        object.put("Lobjects",this.objects);
        object.put("IokCount",1);
        object.put("Skey",this.key);
        return object;
    }

}
