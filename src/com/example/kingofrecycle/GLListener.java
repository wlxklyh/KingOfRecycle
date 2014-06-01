/*
 * 创建日期 2013-5-3
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.example.kingofrecycle;

import com.example.Rect.Black;
import com.example.Rect.Paper;
import com.example.Texture.CONFIG;
import com.example.Texture.FIXVALUE;
import com.exmaple.game.OneShape3;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;


public class GLListener extends SimpleOnGestureListener implements FIXVALUE ,CONFIG{
	private Context context;
	private OpenGlRenderer renderer;
	private Vibrator vib;
	private MediaPlayer mp;

	public GLListener(OpenGlRenderer renderer, Vibrator vib, Context context,
			MediaPlayer mp) {
		this.renderer = renderer;
		this.vib = vib;
		this.context = context;
		this.mp = mp;
	}

	@Override
	// 双击触发：双击的第二下Touch down时触
	public boolean onDoubleTap(MotionEvent e) {
		// TODO 自动生成方法存根
		// System.out.println("onDoubleTap Test");
		return super.onDoubleTap(e);
	}

	@Override
	// 双击的第二下Touch down和up都会触发
	public boolean onDoubleTapEvent(MotionEvent e) {
		// TODO 自动生成方法存根
		// System.out.println("onDoubleTapEvent Test");
		return super.onDoubleTapEvent(e);
	}

	@Override
	// 按下去
	public boolean onDown(MotionEvent event) {
		// TODO 自动生成方法存根
		// System.out.println("onDown Test");
		float x = (event.getX() - renderer.left) / renderer.widthi
				* renderer.ScreenW;
		float y = (renderer.realHeight - event.getY() - renderer.bottom)
				/ renderer.heighti * renderer.ScreenH;
		switch (renderer.scene) {
		case SCENE_START:
			if (renderer.sceneaImg[2].isTouch(x, y)){
				(( Black )renderer.black ).isToBlack=true;
				renderer.scene = SCENE_START_TO_CHOICE;
			}
			if (renderer.sceneaImg[4].isTouch(x, y)){
				(( Black )renderer.black ).isToBlack=true;
				renderer.scene = SCENE_START_TO_SET;
			}
			if (renderer.sceneaImg[5].isTouch(x, y)){
				(( Black )renderer.black ).isToBlack=true;
				renderer.scene = SCENE_START_TO_HELP;
			}
			
			break;
		case SCENE_CHOICE:
			for(int i=2;i<=8;i++){
				if (renderer.sceneeImg[i].isTouch(x, y)){
					renderer.sceneeImg[9].x=renderer.sceneeImg[i].x;
					renderer.sceneeImg[9].y=renderer.sceneeImg[i].y+160;
					renderer.sceneeImg[9].Isdraw=true;
				}
			}
		break;
		case SCENE_GAME:
			if(renderer.scenefImg[1].isTouch(x, y)){
				(( Paper )renderer.scenefImg[9] ).x=-360;
				(( Paper )renderer.scenefImg[9] ).setMove();
				(( Paper )renderer.scenefImg[10] ).x=-720+281;
				(( Paper )renderer.scenefImg[10] ).setMove();
				(( Paper )renderer.scenefImg[15] ).x=-720+427;
				(( Paper )renderer.scenefImg[15] ).setMove();
				renderer.scene = SCENE_GAME_TO_STOP;
			}
			break;
		case SCENE_GAMESTOP:
			if(renderer.scenefImg[1].isTouch(x, y)){
				(( Paper )renderer.scenefImg[9] ).setMove();
				(( Paper )renderer.scenefImg[10] ).setMove();
				(( Paper )renderer.scenefImg[15] ).setMove();
				renderer.scene=SCENE_GAMESTOP_TO_CONTINUE;
			}
			break;
			
		}
		return super.onDown(event);
	}

	@Override
	// Touch了滑动一点距离后，up时触
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO 自动生成方法存根
		// System.out.println("onFling Test");
		int t=(int)(FLINGNUM*velocityX/6000.0f);
		System.out.println("99Fling");
		int k;
		if(velocityX>0)k=1;
		else k=-1;
		
		float px = (e2.getX() - renderer.left) / renderer.widthi
				* 320;
		float py = 480-(renderer.realHeight - e2.getY() - renderer.bottom)
				/ renderer.heighti * 480;
		switch (renderer.scene) {
		case SCENE_GAME:
		OneShape3 test;
		System.out.println(px+":"+py);
		for (int n = 0; n < renderer.NumOfRect; n++) {
			test = renderer.rectarray[n];
			if(test.isTouch(px, py))
			{
				System.out.println("Fling");
				while(t>0){
					t--;test.x+=k;
				}
			}
		}
		break;
		}
		return super.onFling(e1, e2, velocityX, velocityY);
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO 自动生成方法存根
		// System.out.println("Long Press Test");
		super.onLongPress(e);
	}
	
	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO 自动生成方法存根
		// System.out.println("onScroll Test");
		float px = (e2.getX() - renderer.left) / renderer.widthi
				* 320;
		float py = 480-(renderer.realHeight - e2.getY() - renderer.bottom)
				/ renderer.heighti * 480;
		float x = distanceX / renderer.widthi * renderer.ScreenW;
		float y = distanceY / renderer.heighti * renderer.ScreenH;
		
		float Gx = distanceX / renderer.widthi * 320;
		float Gy = distanceY / renderer.heighti * 480;
		switch (renderer.scene) {
		case SCENE_CHOICE:
			if (renderer.sceneeImg[1].x - x < 590
					&& renderer.sceneeImg[1].x - x > 150) {
				renderer.sceneeImg[1].x -= x;
				for (int i = 2; i <= 9; i++) {
					renderer.sceneeImg[i].x-= x;
				}
			}
			if (renderer.sceneeImg[1].y + y < 770
					&& renderer.sceneeImg[1].y + y > 500) {
				renderer.sceneeImg[1].y += y;
				for (int i = 2; i <= 9; i++) {
					renderer.sceneeImg[i].y += y;
				}
			}

			break;
		case SCENE_GAME:
			OneShape3 test;
			for (int n = 0; n < renderer.NumOfRect; n++) {
				test = renderer.rectarray[n];
				if(test.isTouch(px, py))
				{
					test.x-=Gx;
				}
			}
			break;
		}
		return super.onScroll(e1, e2, distanceX, distanceY);
	}

	@Override
	// 没有滚动之前的
	public void onShowPress(MotionEvent e) {
		// TODO 自动生成方法存根

		super.onShowPress(e);
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		// TODO 自动生成方法存根
		//System.out.println("onSingleTapConfirmed");
		return super.onSingleTapConfirmed(e);
	}

	@Override
	public boolean onSingleTapUp(MotionEvent event) {
		// TODO 自动生成方法存根
		float x = (event.getX() - renderer.left) / renderer.widthi
				* renderer.ScreenW;
		float y = (renderer.realHeight - event.getY() - renderer.bottom)
				/ renderer.heighti * renderer.ScreenH;
		switch (renderer.scene) {
		case SCENE_CHOICE:
			if(renderer.sceneeImg[9].isTouch(x, y)){
				((Black)renderer.black).isToBlack=true;
				renderer.scene=SCENE_CHOICE_TO_GAME;
			}
		break;
		
		}
		return super.onSingleTapUp(event);
	}

}
