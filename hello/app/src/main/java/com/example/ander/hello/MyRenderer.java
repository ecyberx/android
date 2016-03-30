package com.example.ander.hello;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLU;
import java.lang.Math;
/**
 * Created by ander on 2016/03/02.
 */

public class MyRenderer implements GLSurfaceView.Renderer {

    MyCube cube = new MyCube();
    float lightpos[] = {0.0f, 0.0f, -9.0f, 0.0f};
    float red[] = {1.0f, 0.0f, 0.0f, 1.0f};
    float green[] = {0.0f, 1.0f, 0.0f, 1.0f};
    float blue[] = {0.0f, 0.0f, 1.0f, 1.0f};
    float white[] = {1.0f, 1.0f, 1.0f, 1.0f};
    float gray[] = {0.5f, 0.5f, 0.5f, 1.0f};
    float yellow[] = {1.0f, 1.0f, 0.0f, 1.0f};

    float f ;
    @Override public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glLightfv(GL10.GL_LIGHT0,GL10.GL_POSITION,lightpos,0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, red, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, blue, 0);
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPECULAR, yellow, 0);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, gray, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, gray, 0);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, gray, 0);
        gl.glMaterialf(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, 100f);

        f=f+0.1f;
        float fSin=(float)Math.sin(f);
        float fCos=(float)Math.cos(f);
//        gl.glTranslatef(0.0f, -0.0f, -3f);
        gl.glTranslatef(0.0f, -0.0f, -3f*fCos-10.0f);
        gl.glRotatef(30f, fCos, fSin, 0);
        gl.glTranslatef(0.0f, -0.0f, -3f*fCos);
        cube.draw(gl);

    }
    @Override public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity(); GLU.gluPerspective(gl, 45f,(float) width / height, 1f, 50f);

    }
    @Override public void onSurfaceCreated(GL10 gl, EGLConfig config) {
//        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
//        gl.glEnable(GL10.GL_DEPTH_TEST);      /* 隠面消去 */
//        gl.glEnable(GL10.GL_CULL_FACE);       /* カリング */
 //       gl.glFrontFace(GL10.GL_CW);           /* 時計まわりを表に設定 */
//        gl.glCullFace(GL10.GL_BACK);          /* カリングする面の指定 */
//        gl.glEnable(GL10.GL_LIGHTING);    /* ライティング処理のオン */
//        gl.glEnable(GL10.GL_LIGHT0);      /* ０番目の光源点灯 */

        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(GL10.GL_LIGHT0);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);

    }
}
