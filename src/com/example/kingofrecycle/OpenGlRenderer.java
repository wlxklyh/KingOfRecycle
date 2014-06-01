/*
 * 创建日期 2013-5-2
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.example.kingofrecycle;

import java.util.ArrayList;
import java.util.List;
import com.exmaple.game.*;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.example.Rect.Black;
import com.example.Rect.FlashButton;
import com.example.Rect.Image;
import com.example.Rect.Paper;
import com.example.Rect.RotateButton;
import com.example.Texture.FIXVALUE;
import com.example.Texture.Texture;



import android.content.Context;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class OpenGlRenderer implements Renderer,FIXVALUE {
	public GL10 maingl;
	public int guan=1;//关卡
	public boolean initGame=true;//是否要初始化游戏
	
	public OneShape3 rectarray[]=new OneShape3[20];
	public int NumOfRect=0;
	public GameMap Map = new GameMap();
	public OneShape3 test;
	
	public int scene=SCENE_TO_START;
	public int widthi, heighti, realHeight, left, bottom;
	public int ScreenW=720;//游戏屏幕坐标
	public int ScreenH=1280;//游戏屏幕坐标
	public Image black;
	public Image sceneaImg[]=new Image[15];
	public Image scenebImg[]=new Image[15];
	public Image scenecImg[]=new Image[15];
	public Image scenedImg[]=new Image[15];
	public Image sceneeImg[]=new Image[15];
	public Image scenefImg[]=new Image[30];
	public Image rect[]=new Image[30];
	int rectNum=1;
	private Context context;
	
	public OpenGlRenderer( Context context ){
		this.context = context;
	}

	int timer1=0;
	//程序主函数，单线程
	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO 自动生成方法存根
		timer1=(timer1+1)%40;
		
		int k=0;
		if((timer1/20)==0)k=3;
		else k=-3;
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT|GL10.GL_DEPTH_BUFFER_BIT);
		
		switch (scene)
		{
		/*********************开始界面*********************/
		case SCENE_TO_START://进入开始界面
			sceneaImg[2].seth(sceneaImg[2].h+k);
			sceneaImg[2].setw(sceneaImg[2].w+k);
			for(int i=0;i<=5;i++)
			sceneaImg[i].draw();
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				scene = SCENE_START;
			}
			break;
		case SCENE_START://开始界面
			sceneaImg[2].seth(sceneaImg[2].h+k);
			sceneaImg[2].setw(sceneaImg[2].w+k);
			for(int i=0;i<=5;i++)
			sceneaImg[i].draw();
			
			break;	
		case SCENE_START_TO_CHOICE://离开开始界面进入选择
			sceneaImg[2].seth(sceneaImg[2].h+k);
			sceneaImg[2].setw(sceneaImg[2].w+k);

			for(int i=0;i<=5;i++)
			sceneaImg[i].draw();
			
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_CHOICE;
			}
			break;
		case SCENE_START_TO_SET://离开开始界面进入设置
			sceneaImg[2].seth(sceneaImg[2].h+k);
			sceneaImg[2].setw(sceneaImg[2].w+k);
			for(int i=0;i<=5;i++)
			sceneaImg[i].draw();
			
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_SET;
			}
			
			break;	
		case SCENE_START_TO_HELP://离开开始界面进入帮助
			sceneaImg[2].seth(sceneaImg[2].h+k);
			sceneaImg[2].setw(sceneaImg[2].w+k);
			for(int i=0;i<=5;i++)
			sceneaImg[i].draw();
			
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_HELP;
			}
			break;	
		
			
			
		/*********************选择界面*********************/
		case SCENE_TO_CHOICE://进入选择界面
			
			for(int i=0;i<=9;i++){
			sceneeImg[i].draw();
			}
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				scene = SCENE_CHOICE;
			}
		break;
		
		case SCENE_CHOICE://选择界面
			
			for(int i=0;i<=9;i++){
			sceneeImg[i].draw();
			}
			
		break;
		case SCENE_CHOICE_TO_GAME:
			
			for(int i=0;i<=9;i++){
			sceneeImg[i].draw();
			}
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_GAME;
			}
		break;
		case SCENE_CHOICE_TO_START:
			
			for(int i=0;i<=9;i++){
			sceneeImg[i].draw();
			}
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_START;
			}
		break;
			
			
			
		/*********************游戏界面*********************/
		case SCENE_TO_GAME:
			if(initGame)
			{
				initGame=false;
				initgame();
			}
			scenefImg[0].draw();
			scenefImg[1].draw();
			scenefImg[2].draw();
			scenefImg[6].draw();
			scenefImg[7].draw();
			scenefImg[8].draw();

			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_GAME;
			}
			break;
		case SCENE_GAME:
			scenefImg[0].draw();
			scenefImg[1].draw();
			scenefImg[2].draw();
			scenefImg[6].draw();
			scenefImg[7].draw();
			scenefImg[8].draw();
			
			for (int n = 0; n < NumOfRect; n++) {
				rectarray[n].Draw();
			}
			
			
			break;
		case SCENE_GAME_TO_CHOICE:
			scenefImg[0].draw();
			scenefImg[1].draw();
			scenefImg[2].draw();
			scenefImg[6].draw();
			scenefImg[7].draw();
			scenefImg[8].draw();
			
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_CHOICE;
			}
			break;
		case SCENE_GAME_TO_STOP:
			scenefImg[0].draw();
			scenefImg[22].draw();
			scenefImg[2].draw();
			scenefImg[6].draw();
			scenefImg[7].draw();
			scenefImg[8].draw();
			
			scenefImg[10].draw();
			scenefImg[15].draw();
			scenefImg[9].draw();
			if( ( ( Paper )scenefImg[9] ).IsMoving() == false ){
				scene = SCENE_GAMESTOP;
			}
			break;
		

		case SCENE_GAMESTOP:
			scenefImg[0].draw();
			scenefImg[22].draw();
			scenefImg[2].draw();
			scenefImg[6].draw();
			scenefImg[7].draw();
			scenefImg[8].draw();
			
			
			scenefImg[10].draw();
			scenefImg[15].draw();
			scenefImg[9].draw();
			
			break;
		
			
		case SCENE_GAMESTOP_TO_CONTINUE:
			scenefImg[0].draw();
			scenefImg[1].draw();
			scenefImg[2].draw();
			scenefImg[6].draw();
			scenefImg[7].draw();
			scenefImg[8].draw();
			
			scenefImg[10].draw();
			scenefImg[15].draw();
			scenefImg[9].draw();
			if( ( ( Paper )scenefImg[9] ).IsMoving() == false ){
				scene = SCENE_GAME;
			}
			break;
			
		case SCENE_GAMESTOP_TO_NEWE:
			if(initGame){
				initGame=false;
				initgame();
			}
			break;
			
		/*********************设置界面*********************/	
		case SCENE_TO_SET://進入設置介面
			scenebImg[0].draw();
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_SET;
			}
			break;
			
		case SCENE_SET://设置界面
			scenebImg[0].draw();
			break;
			
		case SCENE_SET_TO_START://回到開始
			scenebImg[0].draw();
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_START;
			}
			break;
		
			
			
		/*********************关于界面*********************/			
		case SCENE_ABOUT://关于界面
			break;
			
		
		
		/*********************帮助界面*********************/			
		case SCENE_TO_HELP://進入帮助界面
			scenecImg[0].draw();
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_HELP;
			}
			break;
			
		case SCENE_HELP://帮助界面
			scenecImg[0].draw();
			break;
		
		case SCENE_HELP_TO_START://退出帮助界面到開始
			scenecImg[0].draw();
			black.draw();
			if( ( ( Black )black ).isChanging() == false ){
				( ( Black )black ).isToBlack = false;
				scene = SCENE_TO_START;
			}
			break;
			
		
		}
				
	}
	
	//
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO 自动生成方法存根
		widthi = width; 
realHeight = heighti = height;
		
		if( width * ScreenH > height * ScreenW ){
			widthi = ScreenW * height / ScreenH;
		}
		else{
			heighti = ScreenH * width / ScreenW;
		}
		this.left = width - widthi >> 1; this.bottom = height - heighti >> 1;
		gl.glViewport( this.left, this.bottom, widthi, heighti );
		
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU.gluOrtho2D(gl, 0.0f, ScreenW, 0.0f, ScreenH);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		
		gl.glLoadIdentity();
	}

	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO 自动生成方法存根
			maingl=gl;
			gl.glClearColor( 0, 0, 0, 1 );
			gl.glEnable( GL10.GL_DEPTH_TEST );
			gl.glClearDepthf( 1 );
			gl.glDepthFunc( GL10.GL_LEQUAL );
			gl.glShadeModel( GL10.GL_SMOOTH );
			
			
			new Texture( context, gl );
			Texture.init1();
			black = new Black(gl,Texture.textures[Texture.Black],ScreenW/2,ScreenH/2,-0.1f,ScreenW,ScreenH);
			( ( Black )black ).setBlack( true );
			( ( Black )black ).isToBlack = false;
			
			int a[][] = new int[15][4];
			a[0][0]=ScreenW/2; a[0][1]=ScreenH/2;a[0][2]=ScreenW;a[0][3]=ScreenH;
			//king of recycle
			a[1][0]=320; a[1][1]=ScreenH-605;a[1][2]=480;a[1][3]=396;
			//start
			a[2][0]=520; a[2][1]=ScreenH-770;a[2][2]=260;a[2][3]=260;
			//man
			a[3][0]=460; a[3][1]=ScreenH-520;a[3][2]=297;a[3][3]=264;
		
			a[4][0]=115; a[4][1]=ScreenH-1160;a[4][2]=100;a[4][3]=100;
			a[5][0]=215; a[5][1]=ScreenH-1160;a[5][2]=100;a[5][3]=100;
			
			
			sceneaImg[0] = new Image(gl,Texture.textures[Texture.ScreenA0],a[0][0],a[0][1],-0.99f,a[0][2],a[0][3]);
			sceneaImg[1] = new Image(gl,Texture.textures[Texture.ScreenA1],a[1][0],a[1][1],-0.98f,a[1][2],a[1][3]);
			sceneaImg[2] = new Image(gl,Texture.textures[Texture.ScreenA2],a[2][0],a[2][1],-0.97f,a[2][2],a[2][3]);
			sceneaImg[3] = new Image(gl,Texture.textures[Texture.ScreenA3],a[3][0],a[3][1],-0.96f,a[3][2],a[3][3]);
			
			
			//设置
			sceneaImg[4] = new RotateButton(gl,Texture.textures[Texture.ScreenA4],a[4][0],a[4][1],-0.96f,a[4][2],a[4][3]);
			((RotateButton)sceneaImg[4]).setSpeed(1.0f);
			//帮助
			sceneaImg[5] = new Image(gl,Texture.textures[Texture.ScreenA5],a[5][0],a[5][1],-0.96f,a[5][2],a[5][3]);
	
			
			
			
			
			
			scenebImg[0] = new Image(gl,Texture.textures[Texture.ScreenA0],ScreenW/2,ScreenH/2,-0.99f,ScreenW,ScreenH);
			scenecImg[0] = new Image(gl,Texture.textures[Texture.ScreenA0],ScreenW/2,ScreenH/2,-0.99f,ScreenW,ScreenH);
			scenedImg[0] = new Image(gl,Texture.textures[Texture.ScreenA0],ScreenW/2,ScreenH/2,-0.99f,ScreenW,ScreenH);
			
			/**********选择界面*******************/
			int e[][] = new int[15][4];
			e[0][0]=ScreenW/2; e[0][1]=ScreenH/2;e[0][2]=ScreenW;e[0][3]=ScreenH;
			e[1][0]=598; e[1][1]=ScreenH-780;e[1][2]=1165;e[1][3]=1535;
			
			e[2][0]=460; e[2][1]=ScreenH-1340;e[2][2]=128;e[2][3]=128;
			e[3][0]=960; e[3][1]=ScreenH-1130;e[3][2]=128;e[3][3]=128;
			e[4][0]=955; e[4][1]=ScreenH-640;e[4][2]=128;e[4][3]=128;
			e[5][0]=742; e[5][1]=ScreenH-721;e[5][2]=128;e[5][3]=128;
			e[6][0]=280; e[6][1]=ScreenH-925;e[6][2]=128;e[6][3]=128;
			e[7][0]=615; e[7][1]=ScreenH-437;e[7][2]=128;e[7][3]=128;
			e[8][0]=180; e[8][1]=ScreenH-180;e[8][2]=128;e[8][3]=128;
			e[9][0]=360; e[9][1]=ScreenH-200;e[9][2]=415;e[9][3]=230;
			//背景
			sceneeImg[0] = new Image(gl,Texture.textures[Texture.ScreenE0],e[0][0],e[0][1],-0.99f,e[0][2],e[0][3]);
			//地图
			sceneeImg[1] = new Image(gl,Texture.textures[Texture.ScreenE1],e[1][0],e[1][1],-1.00f,e[1][2],e[1][3]);
			
			//地标
			sceneeImg[2] = new FlashButton(gl,Texture.textures[Texture.ScreenE2],e[2][0],e[2][1],-0.995f,e[2][2],e[2][3]);
			((FlashButton)sceneeImg[2]).setFlash(true);
			sceneeImg[3] = new Image(gl,Texture.textures[Texture.ScreenE3],e[3][0],e[3][1],-0.995f,e[3][2],e[3][3]);
			sceneeImg[4] = new Image(gl,Texture.textures[Texture.ScreenE4],e[4][0],e[4][1],-0.995f,e[4][2],e[4][3]);
			sceneeImg[5] = new Image(gl,Texture.textures[Texture.ScreenE5],e[5][0],e[5][1],-0.995f,e[5][2],e[5][3]);
			sceneeImg[6] = new Image(gl,Texture.textures[Texture.ScreenE6],e[6][0],e[6][1],-0.995f,e[6][2],e[6][3]);
			sceneeImg[7] = new Image(gl,Texture.textures[Texture.ScreenE2],e[7][0],e[7][1],-0.995f,e[7][2],e[7][3]);
			sceneeImg[8] = new Image(gl,Texture.textures[Texture.ScreenE3],e[8][0],e[8][1],-0.995f,e[8][2],e[8][3]);
			//对话框
			sceneeImg[9] = new Image(gl,Texture.textures[Texture.ScreenE7],e[9][0],e[9][1],-0.994f,e[9][2],e[9][3]);
			sceneeImg[9].Isdraw=false;
			
			
			
			int f[][] = new int[30][4];
			f[0][0]=ScreenW/2; f[0][1]=ScreenH/2;f[0][2]=ScreenW;f[0][3]=ScreenH;
			//暂停
			f[1][0]=360; f[1][1]=ScreenH-90;f[1][2]=64;f[1][3]=64;
			f[22][0]=360; f[22][1]=ScreenH-90;f[22][2]=97;f[22][3]=56;
			//表情
			f[2][0]=600; f[2][1]=ScreenH-130;f[2][2]=256;f[2][3]=256;
			f[3][0]=600; f[3][1]=ScreenH-130;f[3][2]=256;f[3][3]=256;
			f[4][0]=600; f[4][1]=ScreenH-130;f[4][2]=256;f[4][3]=256;
			f[5][0]=600; f[5][1]=ScreenH-130;f[5][2]=256;f[5][3]=256;
			//边框
			f[6][0]=360; f[6][1]=25;f[6][2]=660;f[6][3]=50;
			f[7][0]=20; f[7][1]=ScreenH-640;f[7][2]=40;f[7][3]=1280;
			f[8][0]=700; f[8][1]=ScreenH-640;f[8][2]=40;f[8][3]=1280;
			
			//面板
			f[9][0]=-360; f[9][1]=ScreenH-600;f[9][2]=450;f[9][3]=450;
			
			//继续按钮
			f[10][0]=-720+281; f[10][1]=ScreenH-600;f[10][2]=80;f[10][3]=94;
			//继续按钮2
			f[11][0]=281; f[11][1]=ScreenH-600;f[11][2]=80;f[11][3]=94;
			//三个奖牌
			f[12][0]=460; f[12][1]=ScreenH-1340;f[12][2]=128;f[12][3]=128;
			f[13][0]=960; f[13][1]=ScreenH-1130;f[13][2]=128;f[13][3]=128;
			f[14][0]=955; f[14][1]=ScreenH-640;f[14][2]=128;f[14][3]=128;
			//new按钮
			f[15][0]=-720+427; f[15][1]=ScreenH-600;f[15][2]=73;f[15][3]=83;
			//5个字体
			f[16][0]=280; f[16][1]=ScreenH-925;f[16][2]=128;f[16][3]=128;
			f[17][0]=615; f[17][1]=ScreenH-437;f[17][2]=128;f[17][3]=128;
			f[18][0]=180; f[18][1]=ScreenH-180;f[18][2]=128;f[18][3]=128;
			f[19][0]=360; f[19][1]=ScreenH-200;f[19][2]=415;f[19][3]=230;
			f[20][0]=180; f[20][1]=ScreenH-180;f[20][2]=128;f[20][3]=128;
			//骷髅
			f[21][0]=360; f[21][1]=ScreenH-200;f[21][2]=415;f[21][3]=230;
			
			scenefImg[0] = sceneaImg[0];//0.99
			//暂停
			scenefImg[1] = new Image(gl,Texture.textures[Texture.ScreenF1],f[1][0],f[1][1],-0.90f,f[1][2],f[1][3]);
			scenefImg[22] = new Image(gl,Texture.textures[Texture.ScreenF22],f[22][0],f[22][1],-0.90f,f[22][2],f[22][3]);
			
			//四个表情
			scenefImg[2] = new Image(gl,Texture.textures[Texture.ScreenF2],f[2][0],f[2][1],-0.89f,f[2][2],f[2][3]);
			scenefImg[3] = new Image(gl,Texture.textures[Texture.ScreenF3],f[3][0],f[3][1],-0.89f,f[3][2],f[3][3]);
			scenefImg[4] = new Image(gl,Texture.textures[Texture.ScreenF4],f[4][0],f[4][1],-0.89f,f[4][2],f[4][3]);
			scenefImg[5] = new Image(gl,Texture.textures[Texture.ScreenF5],f[5][0],f[5][1],-0.89f,f[5][2],f[5][3]);
			
			//三个边框
			scenefImg[6] = new Image(gl,Texture.textures[Texture.ScreenF6],f[6][0],f[6][1],-0.90f,f[6][2],f[6][3]);
			scenefImg[7] = new Image(gl,Texture.textures[Texture.ScreenF7],f[7][0],f[7][1],-0.90f,f[7][2],f[7][3]);
			scenefImg[8] = new Image(gl,Texture.textures[Texture.ScreenF8],f[8][0],f[8][1],-0.90f,f[8][2],f[8][3]);
			
			//paper背景
			scenefImg[9] = new Paper(gl,Texture.textures[Texture.ScreenF9],f[9][0],f[9][1],-0.91f,f[9][2],f[9][3]);
			((Paper)scenefImg[9]).setMove();
			//两个继续
			scenefImg[10] = new Paper(gl,Texture.textures[Texture.ScreenF10],f[10][0],f[10][1],-0.90f,f[10][2],f[10][3]);
			scenefImg[11] = new Image(gl,Texture.textures[Texture.ScreenF11],f[11][0],f[11][1],-0.91f,f[11][2],f[11][3]);
			
	
			
			//三个奖牌
			scenefImg[12] = new Image(gl,Texture.textures[Texture.ScreenF12],f[12][0],f[12][1],-0.91f,f[12][2],f[12][3]);
			scenefImg[13] = new Image(gl,Texture.textures[Texture.ScreenF13],f[13][0],f[13][1],-0.91f,f[13][2],f[13][3]);
			scenefImg[14] = new Paper(gl,Texture.textures[Texture.ScreenF14],f[14][0],f[14][1],-0.91f,f[14][2],f[14][3]);
			
			
			//new按钮
			scenefImg[15] = new Paper(gl,Texture.textures[Texture.ScreenF15],f[15][0],f[15][1],-0.90f,f[15][2],f[15][3]);
			//5个字体
			//score
			scenefImg[16] = new Image(gl,Texture.textures[Texture.ScreenF16],f[16][0],f[16][1],-0.91f,f[16][2],f[16][3]);
			//lose
			scenefImg[17] = new Image(gl,Texture.textures[Texture.ScreenF17],f[17][0],f[17][1],-0.91f,f[17][2],f[17][3]);
			//win
			scenefImg[18] = new Image(gl,Texture.textures[Texture.ScreenF18],f[18][0],f[18][1],-0.91f,f[18][2],f[18][3]);
			//you
			scenefImg[19] = new Image(gl,Texture.textures[Texture.ScreenF19],f[19][0],f[19][1],-0.91f,f[19][2],f[19][3]);
			//you2
			scenefImg[20] = new Image(gl,Texture.textures[Texture.ScreenF20],f[20][0],f[20][1],-0.91f,f[20][2],f[20][3]);
			//骷髅骨
			scenefImg[21] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.89f,f[21][2],f[21][3]);
			/************方块***************************/
			int r[][] = new int[30][4];
			r[0][0]=0; 	r[0][1]=0;		r[0][2]=109*3;	r[0][3]=109*3;
			r[1][0]=360; 		r[1][1]=ScreenH-90;		r[1][2]=64;			r[1][3]=64;
			r[2][0]=600; 		r[2][1]=ScreenH-130;	r[2][2]=256;		r[2][3]=256;
			r[3][0]=600; 		r[3][1]=ScreenH-130;	r[3][2]=256;		r[3][3]=256;
			r[4][0]=600;		r[4][1]=ScreenH-130;	r[4][2]=256;		r[4][3]=256;
			r[5][0]=600; 		r[5][1]=ScreenH-130;	r[5][2]=256;		r[5][3]=256;
			r[6][0]=360;	 	r[6][1]=25;				r[6][2]=660;		r[6][3]=50;
			r[7][0]=360;	 	r[7][1]=25;				r[7][2]=660;		r[7][3]=50;
			
			rect[0] =  new Image(gl,Texture.textures[Texture.ScreenF30],r[0][0],r[0][1],-0.92f,r[0][2],r[0][3]);
			rect[1] =  new Image(gl,Texture.textures[Texture.ScreenF23],f[1][0],f[1][1],-0.92f,f[1][2],f[1][3]);
			rect[2] =  new Image(gl,Texture.textures[Texture.ScreenF24],f[2][0],f[2][1],-0.92f,f[2][2],f[2][3]);
			rect[3] =  new Image(gl,Texture.textures[Texture.ScreenF25],f[3][0],f[3][1],-0.92f,f[3][2],f[3][3]);
			rect[4] =  new Image(gl,Texture.textures[Texture.ScreenF26],f[4][0],f[4][1],-0.92f,f[4][2],f[4][3]);
			rect[5] =  new Image(gl,Texture.textures[Texture.ScreenF27],f[5][0],f[5][1],-0.92f,f[5][2],f[5][3]);
			rect[6] =  new Image(gl,Texture.textures[Texture.ScreenF28],f[6][0],f[6][1],-0.92f,f[6][2],f[6][3]);
			rect[7] =  new Image(gl,Texture.textures[Texture.ScreenF29],f[7][0],f[7][1],-0.92f,f[7][2],f[7][3]);
			//Map.setMapRectFalse(0, 400, 319, 400);
			
			
//			rect[7] =  new Image(gl,Texture.textures[Texture.ScreenF29],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[8] =  new Image(gl,Texture.textures[Texture.ScreenF30],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[9] =  new Image(gl,Texture.textures[Texture.ScreenF31],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[10] = new Image(gl,Texture.textures[Texture.ScreenF32],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[11] = new Image(gl,Texture.textures[Texture.ScreenF33],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[12] = new Image(gl,Texture.textures[Texture.ScreenF34],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[13] = new Image(gl,Texture.textures[Texture.ScreenF31],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[14] = new Image(gl,Texture.textures[Texture.ScreenF31],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[15] = new Image(gl,Texture.textures[Texture.ScreenF31],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[16] = new Image(gl,Texture.textures[Texture.ScreenF31],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[17] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[18] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[19] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[20] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[21] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[22] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
//			rect[23] = new Image(gl,Texture.textures[Texture.ScreenF21],f[21][0],f[21][1],-0.90f,f[21][2],f[21][3]);
	
	
	}
	
	private int a[] = new int[24];
	public void initgame(){
		int temp[][] =new int [24][4];
		Map.Init();
		switch (guan) {
		case 1:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[16] = 2;
			a[13] = 1;
			a[17] = 3;
			Map.setMap(a);
			
			test = new OneShape3(getImg(5), Map,GameMap.XToPx(0),
					GameMap.YToPy(2),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			
			test = new OneShape3(getImg(5), Map,GameMap.XToPx(0),
					GameMap.YToPy(3),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			
			test = new OneShape3(getImg(5),Map, GameMap.XToPx(0),
					GameMap.YToPy(4),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			test = new OneShape3(getImg(5),Map, GameMap.XToPx(0),
					GameMap.YToPy(5),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			
			test = new OneShape3(getImg(5),Map, GameMap.XToPx(0),
					GameMap.YToPy(6),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			
			test = new OneShape3(getImg(5),Map, GameMap.XToPx(0),
					GameMap.YToPy(7),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			test = new OneShape3(getImg(5),Map, GameMap.XToPx(0),
					GameMap.YToPy(8),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			

			test = new OneShape3(getImg(13),Map, GameMap.XToPx(3),
					GameMap.YToPy(2),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			test = new OneShape3(getImg(13),Map, GameMap.XToPx(3),
					GameMap.YToPy(3),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			
			test = new OneShape3(getImg(13),Map, GameMap.XToPx(3),
					GameMap.YToPy(4),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			
			test = new OneShape3(getImg(13),Map, GameMap.XToPx(3),
					GameMap.YToPy(5),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			test = new OneShape3(getImg(13),Map, GameMap.XToPx(3),
					GameMap.YToPy(6),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			test = new OneShape3(getImg(13),Map, GameMap.XToPx(3),
					GameMap.YToPy(7),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			test = new OneShape3(getImg(13),Map, GameMap.XToPx(3),
					GameMap.YToPy(8),5);
			rectarray[NumOfRect++]=test;
			test.setMap();
			
			
			break;/*
		case 2:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[10] = 3;
			a[6] = a[17] = 1;
			a[16] = a[7] = 2;
			
			Map.setMap(a);

			test = new OneShape3(5+8, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(2), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			
			test = new OneShape3(5+16, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(2), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			
			
			test = new OneShape3(4+8, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(3), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(2),
					GameMap.YToPy(3), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(4),
					GameMap.YToPy(3), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			
			
			
			test = new OneShape3(5+8, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(4), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			
			
			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(4), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();

			
			
			
			
			
			
			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(5), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			test = new OneShape3(4+8, scalex, scaley, GameMap.XToPx(2),
					GameMap.YToPy(5), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			test = new OneShape3(4+8, scalex, scaley, GameMap.XToPx(4),
					GameMap.YToPy(5), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			
			
			
			
			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(6), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			
			
			test = new OneShape3(5+8, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(6), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();

			
			
			
			
			
			
			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			test = new OneShape3(4+8, scalex, scaley, GameMap.XToPx(2),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			test = new OneShape3(4+8, scalex, scaley, GameMap.XToPx(4),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();
			
			
			
			
			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(8), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			
			
			test = new OneShape3(5+8, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(8), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			break;
		case 3:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[4] = a[6] = 3;
			a[10] = a[12] = a[16] = a[17] = 2;
			a[11] = a[13] = 1;
			Map.setMap(a);

			
			temp[0][0]=2;temp[0][1]=0;temp[0][2]=1;temp[0][3]=2;			
			temp[1][0]=0;temp[1][1]=1;temp[1][2]=1;temp[1][3]=0;			
			temp[2][0]=9;temp[2][1]=3;temp[2][2]=1;temp[2][3]=1;			
			temp[3][0]=19;temp[3][1]=4;temp[3][2]=1;temp[3][3]=3;			
			temp[4][0]=10;temp[4][1]=0;temp[4][2]=3;temp[4][3]=2;			
			temp[5][0]=10;temp[5][1]=2;temp[5][2]=3;temp[5][3]=2;
			temp[6][0]=8;temp[6][1]=3;temp[6][2]=3;temp[6][3]=0;
			temp[7][0]=9;temp[7][1]=1;temp[7][2]=4;temp[7][3]=1;
			temp[8][0]=1;temp[8][1]=0;temp[8][2]=5;temp[8][3]=1;
			temp[9][0]=0;temp[9][1]=2;temp[9][2]=5;temp[9][3]=0;
			temp[10][0]=12;temp[10][1]=4;temp[10][2]=5;temp[10][3]=4;
			temp[11][0]=12;temp[11][1]=4;temp[11][2]=6;temp[11][3]=4;
			temp[12][0]=5;temp[12][1]=0;temp[12][2]=7;temp[12][3]=5;
			temp[13][0]=13;temp[13][1]=3;temp[13][2]=7;temp[13][3]=5;
			temp[14][0]=12;temp[14][1]=0;temp[14][2]=8;temp[14][3]=4;
			temp[15][0]=12;temp[15][1]=2;temp[15][2]=8;temp[15][3]=4;
			temp[16][0]=12;temp[16][1]=4;temp[16][2]=8;temp[16][3]=4;
			
			for(int i=0;i<17;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 4:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[12] = a[10] = 2;
			a[5] = a[7] = a[16] = a[17] = 1;
			a[11] = a[13] = 3 ;
			Map.setMap(a);

			temp[0][0] = 2; 	temp[0][2]=1; 	temp[0][1]=0;	temp[0][3]=2;			
			temp[1][0] = 22; 	temp[1][2]=1;	temp[1][1]=1;	temp[1][3]=6;			
			temp[2][0] = 3;		temp[2][2]=1;	temp[2][1]=3;	temp[2][3]=3;			
			temp[3][0] = 9;		temp[3][2]=3;	temp[3][1]=0;	temp[3][3]=1;			
			temp[4][0] = 15;	temp[4][2]=3;	temp[4][1]=1;	temp[4][3]=7;			
			temp[5][0] = 8;		temp[5][2]=3;	temp[5][1]=3;	temp[5][3]=0;
			temp[6][0] = 12;	temp[6][2]=5;	temp[6][1]=0;	temp[6][3]=4;
			temp[7][0] = 22;	temp[7][2]=5;	temp[7][1]=1;	temp[7][3]=6;
			temp[8][0] = 13;	temp[8][2]=5;	temp[8][1]=3;	temp[8][3]=5;
			temp[9][0] = 20;	temp[9][2]=6;	temp[9][1]=4;	temp[9][3]=4;
			temp[10][0]= 4;		temp[10][2]=7;	temp[10][1]=0;	temp[10][3]=4;
			temp[11][0]= 4;		temp[11][2]=7;	temp[11][1]=2;	temp[11][3]=4;
			temp[12][0]= 12;	temp[12][2]=7;	temp[12][1]=4;	temp[12][3]=4;
			temp[13][0]= 5;		temp[13][2]=8;	temp[13][1]=0;	temp[13][3]=5;
			temp[14][0]= 5;		temp[14][2]=8;	temp[14][1]=3;	temp[14][3]=5;

			
			for(int i=0;i<15;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			
			break;
		case 5:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[15] = a[17] = 2;
			a[9] = a[7] = a[21] = a[20] = 1;
			Map.setMap(a);

			temp[0][0] = 15; 	temp[0][1]=0; 	temp[0][2]=3;	temp[0][3]=7;			
			temp[1][0] = 15; 	temp[1][1]=0;	temp[1][2]=5;	temp[1][3]=7;			
			temp[2][0] = 15;	temp[2][1]=0;	temp[2][2]=7;	temp[2][3]=7;			
			temp[3][0] = 10;	temp[3][1]=4;	temp[3][2]=3;	temp[3][3]=2;			
			temp[4][0] = 10;	temp[4][1]=4;	temp[4][2]=5;	temp[4][3]=2;			
			temp[5][0] = 10;	temp[5][1]=4;	temp[5][2]=7;	temp[5][3]=2;
			temp[6][0] = 5;		temp[6][1]=0;	temp[6][2]=2;	temp[6][3]=5;

			for(int i=0;i<7;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 6:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[4]=1;
			a[15] = a[17] = 2;
			a[9] = a[7] =3;
			a[21] = a[20] = 1;
			Map.setMap(a);

			temp[0][0] = 15+8; 	temp[0][1]=0; 	temp[0][2]=3;	temp[0][3]=7;			
			temp[1][0] = 15; 	temp[1][1]=0;	temp[1][2]=5;	temp[1][3]=7;			
			temp[2][0] = 15;	temp[2][1]=0;	temp[2][2]=7;	temp[2][3]=7;			
			temp[3][0] = 10;	temp[3][1]=4;	temp[3][2]=3;	temp[3][3]=2;			
			temp[4][0] = 10;	temp[4][1]=4;	temp[4][2]=5;	temp[4][3]=2;			
			temp[5][0] = 10;	temp[5][1]=4;	temp[5][2]=7;	temp[5][3]=2;
			temp[6][0] = 5;		temp[6][1]=0;	temp[6][2]=2;	temp[6][3]=5;
			
			temp[7][0] = 8; 	temp[7][1]=2; 	temp[7][2]=3;	temp[7][3]=0;			
			temp[8][0] = 0; 	temp[8][1]=2;	temp[8][2]=5;	temp[8][3]=0;	
			
			for(int i=0;i<9;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 7:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[21]=a[22]=a[13]=1;
			a[15]=a[16]=a[17]=2;
			Map.setMap(a);

			temp[0][0] = 11; 	temp[0][1]=1; 	temp[0][2]=5;	temp[0][3]=3;			
			temp[1][0] = 15; 	temp[1][1]=3;	temp[1][2]=5;	temp[1][3]=7;			
			temp[2][0] = 18;	temp[2][1]=0;	temp[2][2]=6;	temp[2][3]=2;			
			temp[3][0] = 15;	temp[3][1]=1;	temp[3][2]=7;	temp[3][3]=7;			
			temp[4][0] = 4;		temp[4][1]=4;	temp[4][2]=7;	temp[4][3]=4;			
			temp[5][0] = 4;		temp[5][1]=0;	temp[5][2]=8;	temp[5][3]=4;
			temp[6][0] = 5;		temp[6][1]=3;	temp[6][2]=8;	temp[6][3]=5;
			
			
			
			for(int i=0;i<7;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 8:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[21]=a[22]=a[13]=1;
			a[15]=a[17]=2;
			Map.setMap(a);

			temp[0][0] = 11; 	temp[0][1]=1; 	temp[0][2]=5;	temp[0][3]=3;			
			temp[1][0] = 13; 	temp[1][1]=3;	temp[1][2]=5;	temp[1][3]=5;			
			temp[2][0] = 18;	temp[2][1]=0;	temp[2][2]=6;	temp[2][3]=2;			
			temp[3][0] = 15;	temp[3][1]=1;	temp[3][2]=7;	temp[3][3]=7;			
			temp[4][0] = 1;		temp[4][1]=4;	temp[4][2]=6;	temp[4][3]=1;			
			temp[5][0] = 4;		temp[5][1]=0;	temp[5][2]=8;	temp[5][3]=4;
			temp[6][0] = 5;		temp[6][1]=3;	temp[6][2]=8;	temp[6][3]=5;
			
			
			
			for(int i=0;i<7;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 9:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[16] = 2;
			a[11] = a[13]=1;  
			a[17] = 3;
			
			Map.setMap(a);

			test = new OneShape3(9, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(3), 135, 135);
			test.Shaping1();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(15, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(3), 135, 135);
			test.Shaping7();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(8, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(3), 135, 135);
			test.Shaping0();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(2, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(5), 135, 135);
			test.Shaping2();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(6, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(5), 135, 135);
			test.Shaping6();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(3, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(5), 135, 135);
			test.Shaping3();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(7), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(8), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			break;
		case 10:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[16] = 2;
			a[11] = a[13]=1;  
			a[17] = 3;
			
			Map.setMap(a);

			test = new OneShape3(9, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(3), 135, 135);
			test.Shaping1();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(15, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(3), 135, 135);
			test.Shaping7();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(8, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(3), 135, 135);
			test.Shaping0();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(2, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(5), 135, 135);
			test.Shaping2();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(6, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(5), 135, 135);
			test.Shaping6();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(3, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(5), 135, 135);
			test.Shaping3();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(7), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(8), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			break;
		case 11:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[16] = 2;
			a[11] = a[13]=1;  
			a[17] = 3;
			
			Map.setMap(a);

			test = new OneShape3(9, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(3), 135, 135);
			test.Shaping1();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(15, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(3), 135, 135);
			test.Shaping7();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(8, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(3), 135, 135);
			test.Shaping0();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(2, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(5), 135, 135);
			test.Shaping2();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(6, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(5), 135, 135);
			test.Shaping6();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(3, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(5), 135, 135);
			test.Shaping3();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(7), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(8), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			break;
		case 12:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[16] = 2;
			a[11] = a[13]=1;  
			a[17] = 3;
			
			Map.setMap(a);

			test = new OneShape3(9, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(3), 135, 135);
			test.Shaping1();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(15, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(3), 135, 135);
			test.Shaping7();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(8, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(3), 135, 135);
			test.Shaping0();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(2, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(5), 135, 135);
			test.Shaping2();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(6, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(5), 135, 135);
			test.Shaping6();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(3, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(5), 135, 135);
			test.Shaping3();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(7), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(8), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			break;
		case 13:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[15] = a[17] = 2;
			a[9] = a[7] = a[21] = a[20] = 1;
			Map.setMap(a);

			temp[0][0] = 15; 	temp[0][1]=0; 	temp[0][2]=3;	temp[0][3]=7;			
			temp[1][0] = 15; 	temp[1][1]=0;	temp[1][2]=5;	temp[1][3]=7;			
			temp[2][0] = 15;	temp[2][1]=0;	temp[2][2]=7;	temp[2][3]=7;			
			

			for(int i=0;i<3;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 14:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[15] = a[17] = 2;
			a[9] = a[7] = a[21] = a[20] = 1;
			Map.setMap(a);

			temp[0][0] = 15; 	temp[0][1]=0; 	temp[0][2]=3;	temp[0][3]=7;			
			temp[1][0] = 15; 	temp[1][1]=0;	temp[1][2]=5;	temp[1][3]=7;			
			temp[2][0] = 15;	temp[2][1]=0;	temp[2][2]=7;	temp[2][3]=7;			
			

			for(int i=0;i<3;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 15:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[15] = a[17] = 2;
			a[9] = a[7] = a[21] = a[20] = 1;
			Map.setMap(a);

			temp[0][0] = 15; 	temp[0][1]=0; 	temp[0][2]=3;	temp[0][3]=7;			
			temp[1][0] = 15; 	temp[1][1]=0;	temp[1][2]=5;	temp[1][3]=7;			
			temp[2][0] = 15;	temp[2][1]=0;	temp[2][2]=7;	temp[2][3]=7;			
			

			for(int i=0;i<3;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		case 16:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[15] = a[17] = 2;
			a[9] = a[7] = a[21] = a[20] = 1;
			Map.setMap(a);

			temp[0][0] = 15; 	temp[0][1]=0; 	temp[0][2]=3;	temp[0][3]=7;			
			temp[1][0] = 15; 	temp[1][1]=0;	temp[1][2]=5;	temp[1][3]=7;			
			temp[2][0] = 15;	temp[2][1]=0;	temp[2][2]=7;	temp[2][3]=7;			
			

			for(int i=0;i<3;i++){
				test = new OneShape3(temp[i][0], scalex, scaley, GameMap.XToPx(temp[i][1]),
						GameMap.YToPy(temp[i][2]), 135, 135);
				test.Shaping(temp[i][3]);
				shapeList.add(test);
				test.setMap();
			}
			break;
		default:
			for (int i = 0; i < 24; i++)
				a[i] = 0;
			a[16] = 2;
			a[11] = a[13]=1;  
			a[17] = 3;
			
			Map.setMap(a);

			test = new OneShape3(9, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(3), 135, 135);
			test.Shaping1();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(15, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(3), 135, 135);
			test.Shaping7();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(8, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(3), 135, 135);
			test.Shaping0();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(2, scalex, scaley, GameMap.XToPx(0),
					GameMap.YToPy(5), 135, 135);
			test.Shaping2();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(6, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(5), 135, 135);
			test.Shaping6();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(3, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(5), 135, 135);
			test.Shaping3();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(4, scalex, scaley, GameMap.XToPx(1),
					GameMap.YToPy(7), 135, 135);
			test.Shaping4();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(7), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();

			test = new OneShape3(5, scalex, scaley, GameMap.XToPx(3),
					GameMap.YToPy(8), 135, 135);
			test.Shaping5();
			shapeList.add(test);
			test.setMap();
			break;
			*/
		}
	}
	

	public Image getImg(int k){
		//蓝色
		
		Image temp;
		switch(k){
		case 0:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF24],0,0,-0.92f,327,327);
		break;
		case 1:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF25],0,0,-0.92f,327,327);
		break;
		case 2:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF26],0,0,-0.92f,327,327);
		break;
		case 3:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF27],0,0,-0.92f,327,327);
		break;
		case 4:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF30],0,0,-0.92f,327,327);
		break;
		case 5:
			temp  =  new Image(maingl,Texture.textures[Texture.ScreenF23],0,0,-0.92f,327,327);
		break;
		case 6:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF28],0,0,-0.92f,327,327);
		break;
		case 7:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF29],0,0,-0.92f,327,327);
		break;
		
		//红色
		case 8:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF31],0,0,-0.92f,327,327);
			break;
		case 9:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF32],0,0,-0.92f,327,327);
			break;
		case 10:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF33],0,0,-0.92f,327,327);
			break;
		case 11:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF34],0,0,-0.92f,327,327);
			break;
		case 12:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF35],0,0,-0.92f,327,327);
			break;
		case 13:
			temp =   new Image(maingl,Texture.textures[Texture.ScreenF36],0,0,-0.92f,327,327);
			break;
		case 14:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF37],0,0,-0.92f,327,327);
			break;
		case 15:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF38],0,0,-0.92f,327,327);
			break;
		//绿色
		case 16:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF39],0,0,-0.92f,327,327);
			break;
		case 17:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF40],0,0,-0.92f,327,327);
			break;
		case 18:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF41],0,0,-0.92f,327,327);
			break;
		case 19:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF42],0,0,-0.92f,327,327);
			break;
		case 20:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF43],0,0,-0.92f,327,327);
			break;
		case 21:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF44],0,0,-0.92f,327,327);
			break;
		case 22:
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF45],0,0,-0.92f,327,327);
			break;
		default :
			temp =  new Image(maingl,Texture.textures[Texture.ScreenF46],0,0,-0.92f,327,327);
		}
		return temp;
	}
}
