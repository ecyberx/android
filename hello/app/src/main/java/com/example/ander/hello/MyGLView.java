package com.example.ander.hello;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by ander on 2016/03/02.
 */

public class MyGLView extends GLSurfaceView {
    MyRenderer myRenderer;
    public MyGLView(Context context) {
        super(context);
        myRenderer = new MyRenderer();
        setRenderer(myRenderer);
    }
}