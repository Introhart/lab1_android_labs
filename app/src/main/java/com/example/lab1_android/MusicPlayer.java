package com.example.lab1_android;

import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MusicPlayer extends Service {

    MediaPlayer player;
    private static final int REQUEST_PERMISSION_WRITE = 1001;
    private boolean permissionGranted;
    TheSingletone single;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        single = TheSingletone.getInstance();
        //SharedPreferences settings = single.context.getSharedPreferences("SongId", MODE_PRIVATE);
        //String song = settings.getString("SongId","hof");
        String song = single.preferences.getSong();
        switch(song){
            case "hof":
                player = MediaPlayer.create(this, R.raw.hof );
                break;
            case "sol_invictus":
                player = MediaPlayer.create(this, R.raw.sol_invictus );
                break;
            case "dragonborn":
                player = MediaPlayer.create(this, R.raw.dragonborn );
                break;
        }


        player.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        player.start();
       // return START_STICKY; // START_NOT_STICKY
        return START_NOT_STICKY;
    }

    private File getExternalPath() {
        return(new File(Environment.getExternalStorageDirectory(), "data.txt"));
    }


    @Override
    public void onDestroy() {
        player.stop();
        saveFile();
        _openFile();
       // Toast.makeText(this, "File Done", Toast.LENGTH_SHORT).show();
    }

    public void saveFile(){
        FileOutputStream out = null;
        try{
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String data = dateFormat.format(date);
            out = openFileOutput("data.txt", MODE_PRIVATE);
            out.write(data.getBytes());
           // Toast.makeText(this, "File Done", Toast.LENGTH_SHORT).show();


        }
        catch(IOException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        try {
            if(out != null)
                out.close();
        }
        catch(IOException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public void _openFile(){
        Toast.makeText(this, "func", Toast.LENGTH_SHORT);
        FileInputStream fin = null;

        try{
            fin = openFileInput("data.txt");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String data = new String(bytes);
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        }catch(IOException ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fin != null)
                    fin.close();
            }
            catch(IOException ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


}
