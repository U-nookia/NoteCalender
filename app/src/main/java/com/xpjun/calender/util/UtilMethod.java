package com.xpjun.calender.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by nookia on 2016/10/31.
 */

public class UtilMethod {
    public static void makeToast(Context context,String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
