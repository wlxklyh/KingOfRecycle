/*
 * �������� 2013-4-1
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package com.exmaple.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.Rect.Image;



import android.graphics.Point;
import android.graphics.Rect;

public class OneShape3 extends shape {

	int shape;
	public OneShape3(Image Img, GameMap map, int x, int y,int shape) {
		super(Img, map, x, y);
		// TODO �Զ����ɹ��캯�����
		this.shape=shape;
		Shaping(shape);
	}


	public void Shaping(int i)
	{
		switch(i){
		case 0:
			Shaping0();
			break;
		case 1:
			Shaping1();
			break;
		case 2:
			Shaping2();
			break;
		case 3:
			Shaping3();
			break;
		case 4:
			Shaping4();
			break;
		case 5:
			Shaping5();
			break;
		case 6:
			Shaping6();
			break;
		case 7:
			Shaping7();
			break;
		}
	}
	// OK
	//0    1    2    3    4    5    6     7
	//L1   L2   L3   L4   --  ---  tup  tdown
	public void Shaping0() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		ImageMap[0][1] = true;
		ImageMap[1][0] = true;
		ImageMap[1][1] = true;

		// ���
		// 1��true
		// 2��������
		// 3����������
		// 4�� 0 1
		// 5�� ��ͼ

		LeftPointNum = 4;
		LeftPoint[0][0] = HelpShapingPoint[0][1][0][0];
		LeftPoint[0][1] = HelpShapingPoint[0][1][0][1];

		LeftPoint[1][0] = HelpShapingPoint[0][1][3][0];
		LeftPoint[1][1] = HelpShapingPoint[0][1][3][1];

		LeftPoint[2][0] = HelpShapingPoint[1][0][0][0];
		LeftPoint[2][1] = HelpShapingPoint[1][0][0][1];

		LeftPoint[3][0] = HelpShapingPoint[1][0][3][0];
		LeftPoint[3][1] = HelpShapingPoint[1][0][3][1];

		RightPointNum = 2;
		RightPoint[0][0] = HelpShapingPoint[0][1][1][0];
		RightPoint[0][1] = HelpShapingPoint[0][1][1][1];

		RightPoint[1][0] = HelpShapingPoint[1][1][2][0];
		RightPoint[1][1] = HelpShapingPoint[1][1][2][1];

		//
		DownPointNum = 2;
		DownPoint[0][0] = HelpShapingPoint[1][0][3][0];
		DownPoint[0][1] = HelpShapingPoint[1][0][3][1];

		DownPoint[1][0] = HelpShapingPoint[1][1][2][0];
		DownPoint[1][1] = HelpShapingPoint[1][1][2][1];

		//
		UpPointNum = 4;
		UpPoint[0][0] = HelpShapingPoint[1][0][0][0];
		UpPoint[0][1] = HelpShapingPoint[1][0][0][1];

		UpPoint[1][0] = HelpShapingPoint[1][0][1][0];
		UpPoint[1][1] = HelpShapingPoint[1][0][1][1];

		UpPoint[2][0] = HelpShapingPoint[0][1][0][0];
		UpPoint[2][1] = HelpShapingPoint[0][1][0][1];

		UpPoint[3][0] = HelpShapingPoint[0][1][1][0];
		UpPoint[3][1] = HelpShapingPoint[0][1][1][1];
	}

	public void Shaping1() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		// ���
		// 1��true
		// 2��������
		// 3����������
		// 4�� 0 1
		// 5�� ��ͼ
		ImageMap[0][0] = true;
		ImageMap[1][0] = true;
		ImageMap[1][1] = true;

		LeftPointNum = 2;
		LeftPoint[0][0] = HelpShapingPoint[0][0][0][0];
		LeftPoint[0][1] = HelpShapingPoint[0][0][0][1];

		LeftPoint[1][0] = HelpShapingPoint[1][0][3][0];
		LeftPoint[1][1] = HelpShapingPoint[1][0][3][1];

		RightPointNum = 4;
		RightPoint[0][0] = HelpShapingPoint[0][0][1][0];
		RightPoint[0][1] = HelpShapingPoint[0][0][1][1];

		RightPoint[1][0] = HelpShapingPoint[0][0][2][0];
		RightPoint[1][1] = HelpShapingPoint[0][0][2][1];

		RightPoint[2][0] = HelpShapingPoint[1][1][1][0];
		RightPoint[2][1] = HelpShapingPoint[1][1][1][1];

		RightPoint[3][0] = HelpShapingPoint[1][1][2][0];
		RightPoint[3][1] = HelpShapingPoint[1][1][2][1];

		//
		DownPointNum = 2;
		DownPoint[0][0] = HelpShapingPoint[1][0][3][0];
		DownPoint[0][1] = HelpShapingPoint[1][0][3][1];

		DownPoint[1][0] = HelpShapingPoint[1][1][2][0];
		DownPoint[1][1] = HelpShapingPoint[1][1][2][1];

		//
		UpPointNum = 4;
		UpPoint[0][0] = HelpShapingPoint[0][0][0][0];
		UpPoint[0][1] = HelpShapingPoint[0][0][0][1];

		UpPoint[1][0] = HelpShapingPoint[0][0][1][0];
		UpPoint[1][1] = HelpShapingPoint[0][0][1][1];

		UpPoint[2][0] = HelpShapingPoint[1][1][0][0];
		UpPoint[2][1] = HelpShapingPoint[1][1][0][1];

		UpPoint[3][0] = HelpShapingPoint[1][1][1][0];
		UpPoint[3][1] = HelpShapingPoint[1][1][1][1];
	}

	public void Shaping2() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		ImageMap[0][0] = true;
		ImageMap[0][1] = true;
		ImageMap[1][0] = true;

		LeftPointNum = 2;
		LeftPoint[0][0] = HelpShapingPoint[0][0][0][0];
		LeftPoint[0][1] = HelpShapingPoint[0][0][0][1];

		LeftPoint[1][0] = HelpShapingPoint[1][0][3][0];
		LeftPoint[1][1] = HelpShapingPoint[1][0][3][1];

		RightPointNum = 4;
		RightPoint[0][0] = HelpShapingPoint[0][1][1][0];
		RightPoint[0][1] = HelpShapingPoint[0][1][1][1];

		RightPoint[1][0] = HelpShapingPoint[0][1][2][0];
		RightPoint[1][1] = HelpShapingPoint[0][1][2][1];

		RightPoint[2][0] = HelpShapingPoint[1][0][1][0];
		RightPoint[2][1] = HelpShapingPoint[1][0][1][1];

		RightPoint[3][0] = HelpShapingPoint[1][0][2][0];
		RightPoint[3][1] = HelpShapingPoint[1][0][2][1];

		//
		DownPointNum = 4;
		DownPoint[0][0] = HelpShapingPoint[1][0][3][0];
		DownPoint[0][1] = HelpShapingPoint[1][0][3][1];

		DownPoint[1][0] = HelpShapingPoint[1][0][2][0];
		DownPoint[1][1] = HelpShapingPoint[1][0][2][1];

		DownPoint[2][0] = HelpShapingPoint[0][1][3][0];
		DownPoint[2][1] = HelpShapingPoint[0][1][3][1];

		DownPoint[3][0] = HelpShapingPoint[0][1][2][0];
		DownPoint[3][1] = HelpShapingPoint[0][1][2][1];

		//
		UpPointNum = 2;
		UpPoint[0][0] = HelpShapingPoint[0][0][0][0];
		UpPoint[0][1] = HelpShapingPoint[0][0][0][1];

		UpPoint[1][0] = HelpShapingPoint[0][1][1][0];
		UpPoint[1][1] = HelpShapingPoint[0][1][1][1];
	}

	public void Shaping3() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		ImageMap[0][0] = true;
		ImageMap[0][1] = true;
		ImageMap[1][1] = true;

		LeftPointNum = 4;
		LeftPoint[0][0] = HelpShapingPoint[0][0][0][0];
		LeftPoint[0][1] = HelpShapingPoint[0][0][0][1];

		LeftPoint[1][0] = HelpShapingPoint[0][0][3][0];
		LeftPoint[1][1] = HelpShapingPoint[0][0][3][1];

		LeftPoint[2][0] = HelpShapingPoint[1][1][0][0];
		LeftPoint[2][1] = HelpShapingPoint[1][1][0][1];

		LeftPoint[3][0] = HelpShapingPoint[1][1][3][0];
		LeftPoint[3][1] = HelpShapingPoint[1][1][3][1];

		RightPointNum = 2;
		RightPoint[0][0] = HelpShapingPoint[0][1][1][0];
		RightPoint[0][1] = HelpShapingPoint[0][1][1][1];

		RightPoint[1][0] = HelpShapingPoint[1][1][2][0];
		RightPoint[1][1] = HelpShapingPoint[1][1][2][1];

		//
		DownPointNum = 4;
		DownPoint[0][0] = HelpShapingPoint[0][0][3][0];
		DownPoint[0][1] = HelpShapingPoint[0][0][3][1];

		DownPoint[1][0] = HelpShapingPoint[0][0][2][0];
		DownPoint[1][1] = HelpShapingPoint[0][0][2][1];

		DownPoint[2][0] = HelpShapingPoint[1][1][3][0];
		DownPoint[2][1] = HelpShapingPoint[1][1][3][1];

		DownPoint[3][0] = HelpShapingPoint[1][1][2][0];
		DownPoint[3][1] = HelpShapingPoint[1][1][2][1];
		//
		UpPointNum = 2;
		UpPoint[0][0] = HelpShapingPoint[0][0][0][0];
		UpPoint[0][1] = HelpShapingPoint[0][0][0][1];

		UpPoint[1][0] = HelpShapingPoint[0][1][1][0];
		UpPoint[1][1] = HelpShapingPoint[0][1][1][1];
	}

	public void Shaping4() {
		// TODO �Զ����ɷ������
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		ImageMap[0][0] = true;
		ImageMap[0][1] = true;

		LeftPointNum = 2;
		LeftPoint[0][0] = HelpShapingPoint[0][0][0][0];
		LeftPoint[0][1] = HelpShapingPoint[0][0][0][1];

		LeftPoint[1][0] = HelpShapingPoint[0][0][3][0];
		LeftPoint[1][1] = HelpShapingPoint[0][0][3][1];

		RightPointNum = 2;
		RightPoint[0][0] = HelpShapingPoint[0][1][1][0];
		RightPoint[0][1] = HelpShapingPoint[0][1][1][1];

		RightPoint[1][0] = HelpShapingPoint[0][1][2][0];
		RightPoint[1][1] = HelpShapingPoint[0][1][2][1];

		DownPointNum = 2;
		DownPoint[0][0] = HelpShapingPoint[0][0][3][0];
		DownPoint[0][1] = HelpShapingPoint[0][0][3][1];
		
		DownPoint[1][0] = HelpShapingPoint[0][1][2][0];
		DownPoint[1][1] = HelpShapingPoint[0][1][2][1];

		UpPointNum = 2;
		UpPoint[0][0] = HelpShapingPoint[0][0][0][0];
		UpPoint[0][1] = HelpShapingPoint[0][0][0][1];
		
		UpPoint[1][0] = HelpShapingPoint[0][1][1][0];
		UpPoint[1][1] = HelpShapingPoint[0][1][1][1];
	}

	// OK
	public void Shaping5() {
		// TODO �Զ����ɷ������
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		ImageMap[0][0] = true;
		ImageMap[0][1] = true;
		ImageMap[0][2] = true;

		LeftPointNum = 2;
		LeftPoint[0][0] = 0;
		LeftPoint[0][1] = 0;
		LeftPoint[1][0] = 0;
		LeftPoint[1][1] = 44;

		RightPointNum = 2;
		RightPoint[0][0] = 134;
		RightPoint[0][1] = 0;
		RightPoint[1][0] = 134;
		RightPoint[1][1] = 44;

		DownPointNum = 2;
		DownPoint[0][0] = 0;
		DownPoint[0][1] = 44;
		DownPoint[1][0] = 134;
		DownPoint[1][1] = 44;

		UpPointNum = 2;
		UpPoint[0][0] = 0;
		UpPoint[0][1] = 0;
		UpPoint[1][0] = 134;
		UpPoint[1][1] = 0;
	}

	// Ok
	public void Shaping6() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		ImageMap[0][1] = true;
		ImageMap[1][0] = true;
		ImageMap[1][1] = true;
		ImageMap[1][2] = true;

		LeftPointNum = 4;
		LeftPoint[0][0] = 45;
		LeftPoint[0][1] = 0;
		LeftPoint[1][0] = 45;
		LeftPoint[1][1] = 44;
		LeftPoint[2][0] = 0;
		LeftPoint[2][1] = 45;
		LeftPoint[3][0] = 0;
		LeftPoint[3][1] = 89;

		RightPointNum = 4;
		RightPoint[0][0] = 89;
		RightPoint[0][1] = 0;
		RightPoint[1][0] = 89;
		RightPoint[1][1] = 44;
		RightPoint[2][0] = 134;
		RightPoint[2][1] = 45;
		RightPoint[3][0] = 134;
		RightPoint[3][1] = 89;

		DownPointNum = 2;
		DownPoint[0][0] = 0;
		DownPoint[0][1] = 89;
		DownPoint[1][0] = 134;
		DownPoint[1][1] = 89;

		UpPointNum = 6;
		UpPoint[0][0] = 0;
		UpPoint[0][1] = 45;
		UpPoint[1][0] = 44;
		UpPoint[1][1] = 45;
		UpPoint[2][0] = 45;
		UpPoint[2][1] = 0;
		UpPoint[3][0] = 89;
		UpPoint[3][1] = 0;
		UpPoint[4][0] = 90;
		UpPoint[4][1] = 45;
		UpPoint[5][0] = 134;
		UpPoint[5][1] = 45;
	}

	public void Shaping7() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ImageMap[i][j] = false;
			}
		}
		ImageMap[1][1] = true;
		ImageMap[0][0] = true;
		ImageMap[0][1] = true;
		ImageMap[0][2] = true;

		LeftPointNum = 4;
		LeftPoint[0][0] = HelpShapingPoint[0][0][0][0];
		LeftPoint[0][1] = HelpShapingPoint[0][0][0][1];
		LeftPoint[1][0] = HelpShapingPoint[0][0][3][0];
		LeftPoint[1][1] = HelpShapingPoint[0][0][3][1];
		LeftPoint[2][0] = HelpShapingPoint[1][1][0][0];
		LeftPoint[2][1] = HelpShapingPoint[1][1][0][1];
		LeftPoint[3][0] = HelpShapingPoint[1][1][3][0];
		LeftPoint[3][1] = HelpShapingPoint[1][1][3][1];

		RightPointNum = 4;
		RightPoint[0][0] = HelpShapingPoint[0][2][1][0];
		RightPoint[0][1] = HelpShapingPoint[0][2][1][1];
		RightPoint[1][0] = HelpShapingPoint[0][2][2][0];
		RightPoint[1][1] = HelpShapingPoint[0][2][2][1];
		RightPoint[2][0] = HelpShapingPoint[1][1][1][0];
		RightPoint[2][1] = HelpShapingPoint[1][1][1][1];
		RightPoint[3][0] = HelpShapingPoint[1][1][2][0];
		RightPoint[3][1] = HelpShapingPoint[1][1][2][1];

		DownPointNum = 6;
		DownPoint[0][0] = HelpShapingPoint[0][0][3][0];
		DownPoint[0][1] = HelpShapingPoint[0][0][3][1];
		DownPoint[1][0] = HelpShapingPoint[0][0][2][0];
		DownPoint[1][1] = HelpShapingPoint[0][0][2][1];

		DownPoint[2][0] = HelpShapingPoint[1][1][3][0];
		DownPoint[2][1] = HelpShapingPoint[1][1][3][1];
		DownPoint[3][0] = HelpShapingPoint[1][1][2][0];
		DownPoint[3][1] = HelpShapingPoint[1][1][2][1];

		DownPoint[4][0] = HelpShapingPoint[0][2][3][0];
		DownPoint[4][1] = HelpShapingPoint[0][2][3][1];
		DownPoint[5][0] = HelpShapingPoint[0][2][2][0];
		DownPoint[5][1] = HelpShapingPoint[0][2][2][1];

		UpPointNum = 2;
		UpPoint[0][0] = HelpShapingPoint[0][0][0][0];
		UpPoint[0][1] = HelpShapingPoint[0][0][0][1];
		UpPoint[1][0] = HelpShapingPoint[0][2][1][0];
		UpPoint[1][1] = HelpShapingPoint[0][2][1][1];
	}
}