package app.demo.musicmodule;

public interface Callbacks {

    void onFiles(String data);

    void countFiles(int count);

    void onFailure(Exception e);
}
