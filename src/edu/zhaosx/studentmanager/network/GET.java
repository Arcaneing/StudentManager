package edu.zhaosx.studentmanager.network;

import com.alibaba.fastjson.JSONObject;
import edu.zhaosx.studentmanager.Student;
import edu.zhaosx.studentmanager.Transaction;
import edu.zhaosx.studentmanager.util.JDBCUtils;

import java.net.Socket;
import java.util.List;

public class GET extends Transaction{
    public List<Object> list;
    public String tables;
    public Object objects;
    public Object tarobjects;
    public String key;

    public GET(int request,String tables,Object objects,String key){
        super();
        super.allow = request;
        this.objects = objects;
        this.tables = tables;
        super.key = key;
    }

    public GET(JSONObject object){
        super.object = object;
        getSolve(object);
    }

    public JSONObject getCodeing(){
        object.put("Irequest",allow);
        object.put("Stables",tables);
        object.put("Oobject",objects);
        object.put("Skey",key);
        object.put("Otarobject",tarobjects);
        return object;
    }

    public void getSolve(JSONObject object){
        super.allow = object.getIntValue("Irequest");
        this.tables = object.getString("Stables");
        this.objects = object.getObject("Oobject",objects.getClass());
        this.key = object.getString("Skey");
        this.tarobjects = object.getObject("Otarobject",tarobjects.getClass());
    }


    public void main(){
        if(allow == 1){
            insert();
        }
        if(allow == 2){
            delete();
        }
        if (allow == 3){
            edit();
        }
        if(allow == 4){
            search();
        }
    }

    private void insert(){
        JDBCUtils.insertDate(tables,(Student) objects);
    }

    private void edit(){
        JDBCUtils.editDate(tables,(Student) objects,(Student) tarobjects);
    }

    private void delete(){
        JDBCUtils.deleteDate(tables,(Student)objects);
    }

    private void search(){
        list = JDBCUtils.searchDate(tables,(Student) objects);
    }

}
