package com.hailintang.client.local;

/**
 * @ClassName LocalUserData
 * @Description TODO
 * @Author DELL
 * @Date 2019/8/8 16:07
 * @Version 1.0
 */
public class LocalUserData {
    public static int USERID = 0;


    public static void setUserId(int userId){
        USERID = userId;
    }

    public static int getUserId(){
        return USERID;
    }
}
