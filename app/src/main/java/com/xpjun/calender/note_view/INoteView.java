package com.xpjun.calender.note_view;

import com.xpjun.calender.note_model.NotesAdapter;

/**
 * Created by nookia on 2016/11/2.
 */

public interface INoteView {
    /*
    展示loading
     */
    void showLoading();

    /*
    隐藏loading
     */
    void hideLoading();

    /*
    添加新备忘录,点击事件后跳到添加备忘录界面
     */
    void addNewNote();

    /*
    展示recyclerView的list
     */
    void showRecyclerList(NotesAdapter adapter);

    /*
    展示获取信息错误的提示
     */
    void showError();

    /*
    转换到日历界面
     */
    void toCalender();
}
