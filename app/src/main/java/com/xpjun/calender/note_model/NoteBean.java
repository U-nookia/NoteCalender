package com.xpjun.calender.note_model;

/**
 * Created by nookia on 2016/10/31.
 */

public class NoteBean {
    private String title,alarm,startTime,endTime,content;

    public NoteBean() {
        title = "title";
        alarm = "alarm";
        startTime = "start";
        endTime = "end";
        content = "content";
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
