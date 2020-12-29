package edu.zhaosx.studentmanager.server;

public class Main {
    public static void main(String[] args) {
        netListener listener = new netListener();
        listener.run();
    }
}
