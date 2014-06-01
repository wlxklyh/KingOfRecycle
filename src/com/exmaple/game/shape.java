/*
 * �������� 2013-4-1
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package com.exmaple.game;

import javax.microedition.khronos.opengles.GL10;

import com.example.Rect.Image;
import com.example.Texture.CONFIG;
//��ͼ��
public class shape implements CONFIG{
	public static GameMap Map;
	protected int HelpShapingPoint [][][][]=new int [3][3][4][2];
	protected boolean Touch;

	public int x;
	public int y;

	public Image img;

	protected int LeftPointNum;
	protected int LeftPoint[][] = new int[6][2];

	protected int RightPointNum;
	protected int RightPoint[][] = new int[6][2];

	protected int DownPointNum;
	protected int DownPoint[][] = new int[6][2];

	protected int UpPointNum;
	protected int UpPoint[][] = new int[6][2];
	protected boolean ImageMap[][] = new boolean[3][3];

	//ͼƬ  ����  
	public shape(Image Img,GameMap map, int x, int y) {
		this.img=Img;
		this.Map=map;
		this.Touch = false;
		this.x = x;
		this.y = y;
		int temp[][]=new int [4][2];
		temp[0][0]=0;
		temp[0][1]=0;
		temp[1][0]=44;
		temp[1][1]=0;
		temp[2][0]=44;
		temp[2][1]=44;
		temp[3][0]=0;
		temp[3][1]=44;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<4;k++)
				{
					HelpShapingPoint[i][j][k][0]=j*45+temp[k][0];
					HelpShapingPoint[i][j][k][1]=i*45+temp[k][1];
				}
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isTouch() {
		return Touch;
	}

	public void setTouch(boolean touch) {
		Touch = touch;
	}

	public void clearMap()
	{
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ImageMap[i][j]) {
					int x1, y1;
					x1 = x + j * 45;
					y1 = y + i * 45;
					int x2, y2;
					x2 = x1 + 44;
					y2 = y1 + 44;
					Map.setMapRectTrue(x1, y1, x2, y2);
				}
			}
		}
	}
	// �����ͨ��ÿһ���±ߵ������˵�ȥ�жϵģ������ǿ��Բ������صĺ���
	// �ж��Ƿ����䣺�ж��±ߵ�ÿһ�������һ�����Ƿ����
	// ÿ�ζ�������һ�񣡣�����������
	public boolean IsFall() {
		for (int i = 0; i < DownPointNum; i+=2) {
			int tempx1 = x + DownPoint[i][0];
			int tempy = y + DownPoint[i][1] + 1;
			int tempx2 = x + DownPoint[i+1][0];
			for(int tempx=tempx1;tempx<=tempx2;tempx++){
				if (0 <= tempx && tempx < 320) {
					if (0 <= tempy && tempy < 480) {
						if (Map.map[tempy][tempx] == false) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	// ��һ�μ�飨��

	// ������ƶ�Ҳ�����ÿһ���±ߵ�Ҳ�ǲ������ص�
	// �����ƶ�һ�����أ����ϱ߸�ֵΪ���ߣ��±߸�ֵΪ������
	public void MoveDown() {
		for (int i = 0; i < UpPointNum; i+=2) {
			int tempy = y + UpPoint[i][1];
			for (int tempx = x + UpPoint[i][0]; tempx <= x + UpPoint[i + 1][0]; tempx++) {
				if (0 <= tempx && tempx < 320)
					if (0 <= tempy && tempy < 480)
						Map.map[tempy][tempx] = true;
			}
		}
		
		setY(getY() + 1);
		
		for (int i = 0; i < DownPointNum; i += 2) {
			int tempy = y + DownPoint[i][1];
			for (int tempx = x + DownPoint[i][0]; tempx <= x + DownPoint[i + 1][0]; tempx++) {
				if (0 <= tempx && tempx < 320)
					if (0 <= tempy && tempy < 480)
						Map.map[tempy][tempx] = false;
			}
		}
	}

	// ���õ�ͼ����ʼ����ʱ��ʹ��
	public void setMap() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ImageMap[i][j]) {
					int x1, y1;
					x1 = x + j * 45;
					y1 = y + i * 45;
					int x2, y2;
					x2 = x1 + 44;
					y2 = y1 + 44;
					Map.setMapRectFalse(x1, y1, x2, y2);
				}
			}
		}
	}

	// �ж��Ƿ���ײ����ˮƽ���жϣ�
	public boolean IsNotHit_Vertical(int px, int py) {
		int tex = px - x;
		int tey = py - y;
		boolean flag = true;
		if (tex < 0) {
			for (int i = 0; i < LeftPointNum; i++) {
				int tempx = x + LeftPoint[i][0] + tex;
				int tempy = y + LeftPoint[i][1] + tey;
				if (0 <= tempx && tempx < 320) {
					if (0 <= tempy && tempy < 480) {
						if (Map.map[tempy][tempx] == false) {
							flag = false;
						}
					}
				}
			}
		} else if (tex > 0) {
			for (int i = 0; i < RightPointNum; i++) {
				int tempx = x + RightPoint[i][0] + tex;
				int tempy = y + RightPoint[i][1] + tey;
				if (0 <= tempx && tempx < 320) {
					if (0 <= tempy && tempy < 480) {
						if (Map.map[tempy][tempx] == false) {
							flag = false;
						}
					}
				}
			}
		}
		return flag;
	}

	// ˮƽ���ƶ���һ���� ��ֵΪ0����ֵΪ1
	public void MoveVertical(int cha) {
		if (Touch) {
			if (cha == -1) {
				for (int i = 0; i < RightPointNum; i += 2) {
					for (int ty = y + RightPoint[i][1]; ty <= y
							+ RightPoint[i + 1][1]; ty++) {
						int tempx = x + RightPoint[i][0];
						int tempy = ty;
						if (0 <= tempx && tempx < 320)
							if (0 <= tempy && tempy < 480)
								Map.map[tempy][tempx] = true;
					}
				}
				setX(getX() - 1);
				for (int i = 0; i < LeftPointNum; i += 2) {
					for (int ty = y + LeftPoint[i][1]; ty <= y
							+ LeftPoint[i + 1][1]; ty++) {
						int tempx = x + LeftPoint[i][0];
						int tempy = ty;
						if (0 <= tempx && tempx < 320)
							if (0 <= tempy && tempy < 480)
								Map.map[tempy][tempx] = false;
					}
				}
			} else if (cha == 1) {
				for (int i = 0; i < LeftPointNum; i += 2) {
					for (int ty = y + LeftPoint[i][1]; ty <= y
							+ LeftPoint[i + 1][1]; ty++) {
						int tempx = x + LeftPoint[i][0];
						int tempy = ty;
						if (0 <= tempx && tempx < 320)
							if (0 <= tempy && tempy < 480)
								Map.map[tempy][tempx] = true;
					}
				}
				setX(getX() + 1);
				for (int i = 0; i < RightPointNum; i += 2) {
					for (int ty = y + RightPoint[i][1]; ty <= y
							+ RightPoint[i + 1][1]; ty++) {
						int tempx = x + RightPoint[i][0];
						int tempy = ty;
						if (0 <= tempx && tempx < 320)
							if (0 <= tempy && tempy < 480)
								Map.map[tempy][tempx] = false;
					}
				}
			}
		}
	}

	public float changeX(int cx){
		return (float)(cx-25)/45.0f*109+33;
	}
	public float changeY(int cy){
		return (float)(cy-50)/45.0f*109+256;
	}
	
	public int Xchange(float x2){
		return (int)((x2-33)/109.0f*45.0f+25);
	}
	// ��ͼ����
	public void Draw() {
		int t=RECT_FALL_SPEED;
		while(t>0){t--;
			if(IsFall())MoveDown();
		}
		
		img.x=changeX(x+67);
		img.y=1280-changeY(y+67);
		img.draw();
		
	}
	
	
	public boolean isTouch( float Px, float Py ){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ImageMap[i][j]) {
					int x1, y1;
					x1 = x + j * 45;
					y1 = y + i * 45;
					int x2, y2;
					x2 = x1 + 44;
					y2 = y1 + 44;
					if (x1 <= Px && Px <= x2)
						if (y1 <= Py && Py <= y2)
							return true;
				}
			}
		}
		return false;
	}
	// �ж�һ���㣨Px��Py���Ƿ��ڶ������棬
	public boolean PointIsInSide(int Px, int Py) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ImageMap[i][j]) {
					int x1, y1;
					x1 = x + j * 45;
					y1 = y + i * 45;
					int x2, y2;
					x2 = x1 + 44;
					y2 = y1 + 44;
					if (x1 <= Px && Px <= x2)
						if (y1 <= Py && Py <= y2)
							return true;
				}
			}
		}
		return false;
	}

	public boolean IsDead() {
		for (int i = 0; i < UpPointNum; i++) {
			if (25 <= x + UpPoint[i][0] && x + UpPoint[i][0] < 295)
				if (50 <= y + UpPoint[i][1] && y + UpPoint[i][1] < 455)
					return false;
		}
		for (int i = 0; i < DownPointNum; i++) {
			if (25 <= x + DownPoint[i][0] && x + DownPoint[i][0] < 295)
				if (50 <= y + DownPoint[i][1] && y + DownPoint[i][1] < 455)
					return false;
		}
		for (int i = 0; i < LeftPointNum; i++) {
			if (25 <= x + LeftPoint[i][0] && x + LeftPoint[i][0] < 295)
				if (50 <= y + LeftPoint[i][1] && y + LeftPoint[i][1] < 455)
					return false;
		}
		for (int i = 0; i < RightPointNum; i++) {
			if (25 <= x + RightPoint[i][0] && x + RightPoint[i][0] < 295)
				if (50 <= y + RightPoint[i][1] && y + RightPoint[i][1] < 455)
					return false;
		}
		return true;
	}
}
