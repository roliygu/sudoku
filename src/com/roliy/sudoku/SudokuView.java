package com.roliy.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.provider.Settings.System;
import android.util.Log;
import android.view.View;

public class SudokuView extends View{
	private float width;
	private float height;
	public SudokuView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		Paint bgPaint = new Paint();
		Paint dPaint = new Paint();
		Paint hPaint = new Paint();
		Paint lPaint = new Paint();
		
		bgPaint.setColor(getResources().getColor(R.color.sudoku_background));
		dPaint.setColor(getResources().getColor(R.color.sudoku_dark));
		hPaint.setColor(getResources().getColor(R.color.sudoku_hilite));
		lPaint.setColor(getResources().getColor(R.color.sudoku_light));
		
		canvas.drawRect(0, 0, getWidth(), getHeight(), bgPaint);
		for(int i=1;i<9;i++){
			if(i%3!=0){
				canvas.drawLine(0, i*height, getWidth(), i*height, lPaint);
				canvas.drawLine(i*width, 0, i*width, getHeight(), lPaint);
			}else{
				canvas.drawLine(0, i*height, getWidth(), i*height, dPaint);
				canvas.drawLine(i*width, 0, i*width, getHeight(), dPaint);
			}
			canvas.drawLine(0, i*height+1, getWidth(), i*height+1, hPaint);			
			canvas.drawLine(i*width+1, 0, i*width+1, getHeight(), hPaint);
		}
		// 绘制数字
		Paint nPaint = new Paint();
		nPaint.setColor(getResources().getColor(R.color.sudoku_dark));
		nPaint.setStyle(Paint.Style.STROKE);
		nPaint.setTextSize(height*0.75f);
		// 居中对齐
		nPaint.setTextAlign(Paint.Align.CENTER);
		
		float x = width/2f;
		canvas.drawText("1", 3*width+x, 61, nPaint);
		super.onDraw(canvas);
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		this.width = w/9f;
		this.height = h/9f;
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	

}
