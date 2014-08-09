package com.roliy.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.provider.Settings.System;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class SudokuView extends View{
	private float width;
	private float height;
	
	private Game game = new Game();
	
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
		// »æÖÆÊý×Ö
		Paint nPaint = new Paint();
		nPaint.setColor(getResources().getColor(R.color.sudoku_dark));
		nPaint.setStyle(Paint.Style.STROKE);
		nPaint.setTextSize(height*0.75f);
		nPaint.setTextAlign(Paint.Align.CENTER);
		
		FontMetrics fm = nPaint.getFontMetrics();
		float x = width/2;
		float y = height/2 - (fm.ascent+fm.descent)/2;
		
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				canvas.drawText(game.getTilesString(i, j), i*width+x, j*height+y, nPaint);
		}
		super.onDraw(canvas);
	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		this.width = w/9f;
		this.height = h/9f;
		super.onSizeChanged(w, h, oldw, oldh);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()!=MotionEvent.ACTION_DOWN){
			return super.onTouchEvent(event);
		}
		int selectedX = (int)(event.getX()/width);
		int selectedY = (int)(event.getY()/height);
		Log.d("Debug","break1");
		game.calculateAllUsedTiles();
		int used[] = game.getUsedTilesByCoor(selectedX, selectedY);
		Log.d("Debug","break2");
		for(int i=0;i<used.length;i++){	
			Log.d("Debug", String.valueOf(used[i]));
		}
		
		return true;
	}
	
	

}
