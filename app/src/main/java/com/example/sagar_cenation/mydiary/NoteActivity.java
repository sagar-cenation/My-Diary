package com.example.sagar_cenation.mydiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    private EditText mEtTitle;
    private EditText mEtContent;

    private String mNoteFileName;
    private Note mLoadedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mEtTitle = (EditText) findViewById(R.id.note_et_title);
        mEtContent = (EditText) findViewById(R.id.note_et_content);

        mNoteFileName = getIntent().getStringExtra("NOTE_FILE");
        if(mNoteFileName != null && !mNoteFileName.isEmpty()) {
            mLoadedNote = Utilities.getNoteByName(this, mNoteFileName);
            if(mLoadedNote != null) {
                mEtTitle.setText(mLoadedNote.getTitle());
                mEtTitle.setText(mLoadedNote.getContent());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_main_save:
                saveNote();
            break;
        }
        return true;
    }

    private void saveNote() {
        Note note;
        if(mLoadedNote == null) {
            note = new Note(System.currentTimeMillis(), mEtTitle.getText().toString(), mEtContent.getText().toString());
        } else {
            note = new Note(mLoadedNote.getDateTime(), mEtTitle.getText().toString(), mEtContent.getText().toString());
        }
            if(Utilities.saveNote(this, note)) {
            Toast.makeText(this, "your note is saved!", Toast.LENGTH_SHORT).show();
            finish(); // exit activity and go to main activity

        } else {
            Toast.makeText(this, "can not save the note, please make sure you have enough space on your device"
                    , Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
