package com.example.ander.hello;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView.Renderer;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends /*AppCompat*/Activity {

    MyGLView myGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().addFlags(
               WindowManager.LayoutParams.FLAG_FULLSCREEN
       );

        myGLView = new MyGLView(this);
        setContentView(myGLView);
    }
    @Override protected void onResume(){ super.onResume(); myGLView.onResume(); }
    @Override protected void onPause(){ super.onPause(); myGLView.onPause(); }

}
