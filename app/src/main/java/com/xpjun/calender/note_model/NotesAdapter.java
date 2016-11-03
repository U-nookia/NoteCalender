package com.xpjun.calender.note_model;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xpjun.calender.R;

import java.util.List;

/**
 * Created by nookia on 2016/10/31.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<NoteBean> noteBeans;
    private ItemClickListener listener;

    public NotesAdapter(List<NoteBean> noteBeans) {
        this.noteBeans = noteBeans;
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }

    public interface ItemClickListener{
        void onItemClick(View view,int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView title,alarm,startTime,endTime,content;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            title = (TextView) cardView.findViewById(R.id.title);
            alarm = (TextView) cardView.findViewById(R.id.alarm);
            startTime = (TextView) cardView.findViewById(R.id.startTime);
            endTime = (TextView) cardView.findViewById(R.id.endTime);
            content = (TextView) cardView.findViewById(R.id.content);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onItemClick(v,getPosition());
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(noteBeans.get(position).getTitle());
        holder.alarm.setText(noteBeans.get(position).getAlarm());
        holder.startTime.setText(noteBeans.get(position).getStartTime());
        holder.endTime.setText(noteBeans.get(position).getEndTime());
        holder.content.setText(noteBeans.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return noteBeans.size();
    }
}
