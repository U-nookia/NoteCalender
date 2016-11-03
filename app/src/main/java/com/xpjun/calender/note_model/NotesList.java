package com.xpjun.calender.note_model;

import android.util.Log;

import com.xpjun.calender.note_view.NoteView;
import com.xpjun.calender.util.UtilMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nookia on 2016/11/2.
 */

public class NotesList implements INotesList{

    /*
    从网上获取数据的方法
     */
    @Override
    public void getList(CallBack callBack) {
        List<NoteBean> noteBeans = new ArrayList<>();
        NoteBean bean = new NoteBean();
        bean.setTitle("测试一");
        bean.setAlarm("");
        bean.setStartTime("2016.08.26");
        bean.setEndTime("2016.09.16");
        bean.setContent("这是测试用的 哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        noteBeans.add(bean);
        NoteBean bean1 = new NoteBean();
        bean1.setTitle("测试二");
        bean1.setAlarm("已设置");
        bean1.setStartTime("2016.09.26");
        bean1.setEndTime("2016.09.30");
        bean1.setContent("这是测试用二的 哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        noteBeans.add(bean1);
        callBack.getList(noteBeans);
    }

    /*
    向网络后台添加一条数据
     */
    @Override
    public void addNote(NoteBean noteBean){
        //向网上上传数据
        Log.e("xxxx","send message to internet"+noteBean.getContent());
    }

    /*
    在网络后台上删除一条数据
     */
    @Override
    public void deleteNote(int id) {
        //在网上删除数据
        Log.e("xxxx","delete message on internet"+id);
    }

    /*
    回调接口，通过接口中的方法拿到在本model中的集合
     */
    public interface CallBack{
        void getList(List<NoteBean> notes);
    }
}
