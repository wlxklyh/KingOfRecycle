/*
 * 创建日期 2013-5-4
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.example.Rect;

import javax.microedition.khronos.opengles.GL10;

public class FlashButton extends Image{
	public int time=60;
	public int temp=0;
	public int alpha;
	public boolean isFlash;
	public FlashButton(GL10 gl, int textureId, float x, float y, float z, float w,
			float h) {
		super(gl, textureId, x, y, z, w, h);
		// TODO Auto-generated constructor stub
		alpha = 0;
		isFlash = false;
	}

	public void setTime(int t){
		time=t;
	}
	public void setFlash(boolean isFlash){
		this.isFlash=isFlash;
	}
	public void draw(){
		
		if( isFlash  ){
			temp++;
			temp%=time;
			alpha-=2*(temp/(time/2))-1;
		}else alpha=25;
	
//		if( alpha < 1 ) return;
		gl.glPushMatrix();
		gl.glTranslatef( x, y, z );
		gl.glEnable( GL10.GL_TEXTURE_2D );
		gl.glDisable( GL10.GL_ALPHA_TEST );//启动透明度测试
		gl.glEnable( GL10.GL_BLEND );//启动颜色混合  即半透明效果
		gl.glBlendFunc( GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA );
		gl.glColor4f( 1, 1, 1, (alpha+15) / 40.1f );
		gl.glEnable( GL10.GL_CULL_FACE );
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textureId );
		gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
		gl.glEnableClientState( GL10.GL_TEXTURE_COORD_ARRAY );
		gl.glVertexPointer( 2, GL10.GL_FLOAT, 0, vb );
		gl.glTexCoordPointer( 2, GL10.GL_FLOAT, 0, tb );
		gl.glDrawArrays( GL10.GL_TRIANGLE_STRIP, 0, 4 );
		gl.glDisableClientState( GL10.GL_VERTEX_ARRAY );
		gl.glDisableClientState( GL10.GL_TEXTURE_COORD_ARRAY );
		gl.glDisable( GL10.GL_BLEND );
		gl.glColor4f( 1, 1, 1, 1 );
		gl.glPopMatrix();
	}
}
