package com.roliy.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View{

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	// 安卓绘制View的时候,调用onDraw()
	@Override
	protected void onDraw(Canvas canvas) {

		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		
		canvas.drawLine(50, 50, 100, 100, paint);
		super.onDraw(canvas);
	}
	
}
