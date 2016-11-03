package com.xpjun.calender.note_presenter;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.xpjun.calender.calender_use.BasicActivity;
import com.xpjun.calender.note_model.INotesList;
import com.xpjun.calender.note_model.NoteBean;
import com.xpjun.calender.note_model.NotesAdapter;
import com.xpjun.calender.note_model.NotesList;
import com.xpjun.calender.note_view.INoteView;
import com.xpjun.calender.util.UtilMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nookia on 2016/11/2.
 */
/*
负责对从model获取到的数据进行操作，以及连接到负责view的activity
 */
public class NotePresenter implements NotesList.CallBack{

    private INotesList notesList;
    private INoteView noteView;
    private List<NoteBean> notes = new ArrayList<>();
    private NotesAdapter adapter;

    public NotePresenter(INoteView noteView) {
        this.noteView = noteView;
        notesList = new NotesList();
    }

    /**
     * 通过回调拿到model中的list，
     * 连接好adapter和list集合，然后调用view中的方法将adapter设置到recyclerView中
     */
    public void setAdapterAndShowList(){
        notesList.getList(this);
        adapter = new NotesAdapter(notes);
        adapter.setItemClickListener(new NotesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(final View view, int position) {
                view.animate().translationZ(15f).setDuration(300)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                view.animate().translationZ(1f)
                                        .setDuration(500)
                                        .start();
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        }).start();

            }
        });
        noteView.showRecyclerList(adapter);
    }

    /*
   view中添加新note的按钮的点击事件
     */
    public void clickAddNewNote(Context context){
        UtilMethod.makeToast(context,"to new class");
        NoteBean noteBean = new NoteBean();
        noteBean.setContent("ccccccc");
        addNote(noteBean);
    }

    /*
    view中转换activity的按钮的点击事件
     */
    public void clickToCalender(Context context){
        Intent intent = new Intent(context,BasicActivity.class);
        context.startActivity(intent);
    }

    /*
    view中设置按钮的点击事件
     */
    public void clickSetting(Context context){
        UtilMethod.makeToast(context,"setting jhhh");
        deleteNote(2);
    }

    /*
    添加note的方法，调用了model中对应的方法
    其中getlist方法通过clear之前的list数据然后add新的list数据然后刷新adapter避免了再次重新给list赋值
     */
    public void addNote(NoteBean noteBean){
        notesList.addNote(noteBean);
        notesList.getList(this);
        adapter.notifyDataSetChanged();
    }

    /*
    删除一条note的方法，getlist方法的处理同上
     */
    public void deleteNote(int i){
        //通过position拿到对应的对象的id
        int id = i;
        //id传入delete方法中
        notesList.deleteNote(id);
        notesList.getList(this);
        adapter.notifyDataSetChanged();
    }
    /*
    回调拿到list数据
     */
    @Override
    public void getList(List<NoteBean> notes) {
        this.notes.clear();
        this.notes.addAll(notes);
    }
}
