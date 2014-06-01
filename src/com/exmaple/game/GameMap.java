/*
 * 创建日期 2013-4-5
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.exmaple.game;
//游戏地图
public class GameMap {
	public boolean map[][]=new boolean [480][320];
	public GameMap(){
		setMapRectTrue(0,0,319,479);
	}
	public void Init(){
		setMapRectTrue(0,0,319,479);
	}
	public void setMap(int a[]){
		setMapRectTrue(0,0,319,479);
		setMapRectFalse(0,0,319,49);       
		setMapRectFalse(0,50,24,479);      //2
		setMapRectFalse(0,455,319,479);    //3
		setMapRectFalse(295,50,319,479);  //4
		
		for(int i=0;i<24;i++)
		{
			if(a[i]>0)
			setNumRectTrue(i);
		}
		for(int i=18;i<24;i++)
		{
			if(a[i]>0)
				setNumBottomRectTrue(i);
		}
	}
	
	public void setNumRectTrue(int i){
		int x=(i%2)*295;
		int y=50+(i/2)*45;
		int x2=x+24;
		int y2=y+44;	 
		setMapRectTrue(x,y,x2,y2);
	}
	public void setNumBottomRectTrue(int i){
		i=i-18;
		int x=25+i*45;
		int y=455;
		int x2=x+44;
		int y2=y+24;	 
		setMapRectTrue(x,y,x2,y2);
	}
	
	public void setMapRectTrue(int x1,int y1,int x2,int y2){
		for(int i=x1;i<=x2;i++){
			if(i<0)continue;
			if(i>=320)break;
			for(int j=y1;j<=y2;j++){
				if(j<0)continue;
				if(j>=480)break;
				map[j][i]=true;
			}
		}
	}
	
	public void setMapRectFalse(int x1,int y1,int x2,int y2){
		for(int i=x1;i<=x2;i++){
			if(i<0)continue;
			if(i>=320)break;
			for(int j=y1;j<=y2;j++){
				if(j<0)continue;
				if(j>=480)break;
				map[j][i]=false;
			}
		}
	}
	public static int XToPx(int column){
		return column*45+25;
	}
	public static int YToPy(int row){
		return row*45+50;
	}
}
