package com.example.sagar_cenation.mydiary;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by sagar_cenation on 4/13/2017.
 */

public class Note implements Serializable{
    private long mDateTime;
    private String mTitle;
    private String mContent;

    // constructor
    public Note(long dateTime , String title , String content) {
        dateTime = mDateTime;
        title = mTitle;
        content = mContent;
    }

    //setter
    public void setDateTime(long dateTime) {
        mDateTime = dateTime;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setContent(String content) {
        mContent = content;
    }

    //getter
    public long getDateTime() {
        return mDateTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    /**
     * Get date time as a formatted string
     * @param context The context is used to convert the string to user set locale
     * @return String containing the date and time of the creation of the note
     */
    public String getDateTimeFormatted(Context context) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"
                , context.getResources().getConfiguration().locale);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(mDateTime));
    }


}
