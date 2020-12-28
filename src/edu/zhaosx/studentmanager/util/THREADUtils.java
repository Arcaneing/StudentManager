package edu.zhaosx.studentmanager.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class THREADUtils {
    //build a ThreadPoolExecutor
    private static ThreadPoolExecutor executor = null;
    static{
        //先填一下参数，回去再读配置
        executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
    }


    public static void putThread(Object o){

    }

}
