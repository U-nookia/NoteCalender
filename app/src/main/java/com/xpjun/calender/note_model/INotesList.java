package com.xpjun.calender.note_model;


/**
 * Created by nookia on 2016/11/2.
 */

public interface INotesList {
    void getList(NotesList.CallBack callBack);

    void addNote(NoteBean noteBean);

    void deleteNote(int id);
}
