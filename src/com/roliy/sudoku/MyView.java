package com.roliy.sudoku;

import android.content.Context;
import android.graphics.BitmapFactory;
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
		
		paint.setTextSize(100);
		
		canvas.drawText("apple", 50, 200, paint);
		canvas.drawLine(0,  200, 500, 200, paint); 
		canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher), 0, 0, paint);
		super.onDraw(canvas);
	}
	
}
