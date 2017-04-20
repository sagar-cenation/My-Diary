package com.example.sagar_cenation.mydiary;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by sagar_cenation on 4/20/2017.
 */

public class Utilities {

    public static final String FILE_EXTENSION = ".bin";

    public static boolean saveNote(Context context, Note note) {
        String filename = String.valueOf(note.getDateTime()) + FILE_EXTENSION;
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = context.openFileOutput(filename, context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(note);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false; //tell the user something went wrong(mainly when not enough space on device)
        }

        return true;
    }
}
