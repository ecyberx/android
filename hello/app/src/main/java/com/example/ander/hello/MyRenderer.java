package com.example.ander.hello;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLU;
/**
 * Created by ander on 2016/03/02.
 */

public class MyRenderer implements GLSurfaceView.Renderer {

    MyCube cube = new MyCube();

    float f ;
    @Override public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, -0.0f, -3f);

        f=f+0.1f;
        gl.glRotatef(30f, f, 1, 0);
        cube.draw(gl);

    }
    @Override public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity(); GLU.gluPerspective(gl, 45f,(float) width / height, 1f, 50f);

    }
    @Override public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_LIGHT0);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);

    }
}
