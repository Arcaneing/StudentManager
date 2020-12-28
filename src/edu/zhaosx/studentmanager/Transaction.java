package edu.zhaosx.studentmanager;

import edu.zhaosx.studentmanager.util.THREADUtils;

import java.net.Socket;

public class Transaction {
    public Socket s;
    public Transaction(Socket s){
        this.s = s;
    }

    private void addToexecutor(){
        THREADUtils.putThread(this);
    }

}
