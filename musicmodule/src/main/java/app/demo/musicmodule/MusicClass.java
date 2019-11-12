package app.demo.musicmodule;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class MusicClass {
    private Callbacks callbacks;


    public MusicClass(Callbacks callbacks) {
        this.callbacks = callbacks;
    }


    public void getMusicFiles(Activity activity) {
        ContentResolver cr = (activity.getContentResolver());

        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
        Cursor cur = cr.query(uri, null, selection, null, sortOrder);
        int count = 0;

        if (cur != null) {
            count = cur.getCount();
            if (count > 0) {
                while (cur.moveToNext()) {
                    String data = cur.getString(cur.getColumnIndex(MediaStore.Audio.Media.DATA));
                    // Add code to get more column here
                    callbacks.countFiles(count);
                    callbacks.onFiles(data);
                    // Save to your list here
                }

            } else {
                callbacks.onFailure(new Exception("You don't have any Music file in device"));
            }
        } else {
            callbacks.onFailure(new NullPointerException("Somehting went wrong"));
        }

        assert cur != null;
        cur.close();
    }
}
