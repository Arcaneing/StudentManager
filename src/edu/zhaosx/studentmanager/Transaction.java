package edu.zhaosx.studentmanager;

import com.alibaba.fastjson.JSONObject;
import edu.zhaosx.studentmanager.util.THREADUtils;

import java.net.Socket;

public class Transaction {
    /**
     * 1:insert
     * 2:delear
     * 3:edit
     * 4:search
     */
    public int allow;
    public Socket s;
    public JSONObject object;
    public String key;


    public void getSolve(JSONObject object){
        allow = object.getIntValue("Iallow");
        key = object.getString("Skey");
    }

    public JSONObject getCodeing(){
        return object;
    }

    public void main(){
        getSolve(object);
        if(allow == 1){

        }
        if(allow == 2){

        }
        if (allow == 3){

        }
        if(allow == 4){

        }

    }

    private void insert(){
        //add a new element
    }

    private void edit(){
        //make a element to a new element
    }

    private void delete(){
        //delete a element
    }

    private void search(){
        //search some element,,return a list<object>
    }

}
