package edu.zhaosx.studentmanager.network;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class RESPONSE{
    public int allow;
    public List<Object> objects;
    public int okCount;
    public String key;

    public RESPONSE(int allow,List<Object>objects,int okCount,String key){
        this.allow = allow;
        this.objects = objects;
        this.okCount = okCount;
        this.key = key;
    }

    public RESPONSE(JSONObject object){
        solve(object);
    }

    public RESPONSE solve(JSONObject object){
        this.allow = object.getIntValue("Iallow");
        this.objects = object.getObject("Lobjects",objects.getClass());
        this.okCount = object.getIntValue("IokCount");
        this.key = object.getString("Skey");
        return this;
    }

    public JSONObject coding(RESPONSE r){
        JSONObject object = new JSONObject();
        object.put("Iallow",this.allow);
        object.put("Lobjects",this.objects);
        object.put("IokCount",this.objects);
        object.put("Skey",this.key);
        return object;
    }
}