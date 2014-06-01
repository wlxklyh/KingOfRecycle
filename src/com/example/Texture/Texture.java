/*
 * 创建日期 2013-5-2
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.example.Texture;

import javax.microedition.khronos.opengles.GL10;

import com.example.kingofrecycle.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Texture {
	private static Context context;
	private static GL10 gl;
	private static Bitmap bitmap;
	public static boolean isInitial1, isInitial2, isInitial3, isInitial4, isInitial5;
	public static int[] textures;
	public static final int nTextures = 100;
	public static int ScreenA0=0,ScreenA1=1,ScreenA2=2,ScreenA3=3,ScreenA4=4;
	public static int ScreenA5=35,ScreenA6=36,ScreenA7=37,ScreenA8=38,ScreenA9=39;
	
	
	public static int ScreenB0=5,ScreenB1=6,ScreenB2=7,ScreenB3=8,ScreenB4=9;
	public static int ScreenC0=10,ScreenC1=11,ScreenC2=12,ScreenC3=13,ScreenC4=14;
	public static int ScreenD0=15,ScreenD1=16,ScreenD2=17,ScreenD3=18,ScreenD4=19;
	public static int ScreenE0=20,ScreenE1=21,ScreenE2=22,ScreenE3=23,ScreenE4=24;
	public static int ScreenE5=25,ScreenE6=26,ScreenE7=27,ScreenE8=28,ScreenE9=29;
	
	public static int ScreenF0=30,ScreenF1=31,ScreenF2=32,ScreenF3=33,ScreenF4=34;
	public static int ScreenF5=45,ScreenF6=46,ScreenF7=47,ScreenF8=48,ScreenF9=49;
	public static int ScreenF10=40,ScreenF11=41,ScreenF12=42,ScreenF13=43,ScreenF14=44;
	public static int ScreenF15=55,ScreenF16=56,ScreenF17=57,ScreenF18=58,ScreenF19=59;
	public static int ScreenF20=60,ScreenF21=61,ScreenF22=62,ScreenF23=63,ScreenF24=64;
	public static int ScreenF25=65,ScreenF26=66,ScreenF27=67,ScreenF28=68,ScreenF29=69;
	public static int ScreenF30=70,ScreenF31=71,ScreenF32=72,ScreenF33=73,ScreenF34=74;
	public static int ScreenF35=75,ScreenF36=76,ScreenF37=77,ScreenF38=78,ScreenF39=79;
	public static int ScreenF40=80,ScreenF41=81,ScreenF42=82,ScreenF43=83,ScreenF44=84;
	public static int ScreenF45=85,ScreenF46=86,ScreenF47=87,ScreenF48=88,ScreenF49=89;
	
	
	
	public static int Black=99;
	
	public Texture( Context context, GL10 gl ){
		Texture.context = context;
		Texture.gl = gl;
		isInitial1 = isInitial2 = isInitial3 = isInitial4 = isInitial5 = false;
		
		textures = new int[ nTextures ];
		gl.glGenTextures( nTextures, textures, 0 );
	}
	
	public static void init1(){
		if( isInitial1 ) return; else isInitial1 = true;
		/**************s首页资源********************/
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.black );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ Black ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
	
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sa0 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenA0 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sa1 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenA1 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sa2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenA2 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sa3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenA3 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		//2处
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sa4 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenA4 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sa5 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenA5 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/**************选择页资源********************/
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se0 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE0 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se1 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE1 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE2 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE3 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se4 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE4 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se5 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE5 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		//2处
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se6 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE6 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		//2处
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.se8 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenE7 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		
		
		/**************游戏场景加载资源********************/
		//暂停
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf1 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF1 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf1return );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF22 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		//四个表情
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF2 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF3 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf4 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF4 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf5 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF5 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		//三个边框
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf5d );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF6 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf5l );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF7 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf5r );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF8 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		//paper背景
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6back );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF9 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		//两个继续
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6continue );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF10 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6continue2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF11 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		//三个奖牌
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6gold );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF12 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6silver );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF13 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6bronze );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF14 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		//按钮
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6new );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF15 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		//字体
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6score );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF16 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6lose );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF17 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6win );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF18 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6you );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF19 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6you2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF20 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.sf6 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF21 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		
		
		/**********************************蓝色方块*****************************/
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.b2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF30 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.b3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF23 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.bl1 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF24 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.bl2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF25 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.bl3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF26 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.bl4 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF27 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.btup );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF28 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.btdown );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF29 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		
		
		/**********************************紅色方块*****************************/
		
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.rl1 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF31 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.rl2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF32 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.rl3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF33 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.rl4 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF34 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.r2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF35 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.r3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF36 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.rtdown );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF37 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.rtup );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF38 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		
		
		/**********************************綠色方块*****************************/
		
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.gl1 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF39 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.gl2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF40 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.gl3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF41 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.gl4 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF42 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.g2 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF43 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.g3 );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF44 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.gtdown );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF45 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		bitmap = BitmapFactory.decodeResource( context.getResources(), R.drawable.gtup );//把资源转化为位图
		gl.glBindTexture( GL10.GL_TEXTURE_2D, textures[ ScreenF46 ] );
		gl.glTexParameterx( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR );
		GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
		
		
		
		//2处fffff Game
		
		
	}
	
	public static void init2(){
		if( isInitial2 ) return; else isInitial2 = true;

		
	}
	
	
	public static void init4(){
		if( isInitial4 ) return; else isInitial4 = true;
		
		
	}
	
	public static void init5(){
		if( isInitial5 ) return; else isInitial5 = true;
		
		
	}
	
}