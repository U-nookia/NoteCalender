package com.xpjun.calender.note_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.xpjun.calender.R;
import com.xpjun.calender.note_model.NotesAdapter;
import com.xpjun.calender.note_presenter.NotePresenter;

public class NoteView extends AppCompatActivity implements View.OnClickListener
        ,AddView.AddViewClickListener,INoteView{

    private Button buttonBasic;
    private RecyclerView notesListView;
    private RecyclerView.LayoutManager layoutManager;
    private AddView addView;
    private NotePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setClickListener();
        presenter.setAdapterAndShowList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                presenter.clickSetting(NoteView.this);
                return true;
            default:

                return false;
        }
    }

    private void initView() {
        presenter = new NotePresenter(this);
        buttonBasic = (Button) findViewById(R.id.buttonBasic);
        addView = (AddView) findViewById(R.id.add);
        addView.setAddViewClickListener(this);

        notesListView = (RecyclerView) findViewById(R.id.recycler);
        layoutManager = new LinearLayoutManager(this);
        setNoteRecyclerView();
    }

    private void setNoteRecyclerView() {
        notesListView.setLayoutManager(layoutManager);
        notesListView.setHasFixedSize(true);
        notesListView.setItemAnimator(new DefaultItemAnimator());
    }

    private void setClickListener() {
        buttonBasic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonBasic:
                toCalender();
                break;
        }
    }

    @Override
    public void addViewOnClick() {
        presenter.clickAddNewNote(NoteView.this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void addNewNote() {
        presenter.clickAddNewNote(NoteView.this);
    }

    @Override
    public void showRecyclerList(NotesAdapter adapter) {
        notesListView.setAdapter(adapter);
    }

    @Override
    public void showError() {

    }

    @Override
    public void toCalender() {
        presenter.clickToCalender(NoteView.this);
    }
}
