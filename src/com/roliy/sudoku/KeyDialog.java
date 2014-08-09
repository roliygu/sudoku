package com.roliy.sudoku;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class KeyDialog extends Dialog{
	private final View keys[] = new View[9];
	private final int used[];
	private SudokuView sView;
	
	public KeyDialog(Context context, int used[], SudokuView sv) {
		super(context);
		this.used = used;
		this.sView = sv;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置对话框标题
		setTitle("KeyDialog");
		// 为Dialog设置布局文件
		setContentView(R.layout.keypad);
		findViews();
		for(int i=0;i<used.length;i++){
			if(used[i]!=0){
				keys[used[i]-1].setVisibility(View.INVISIBLE);
			}
		}
		setListenners();
	} 
	
	private void findViews(){
		keys[0] = findViewById(R.id.keypad_1);
		keys[1] = findViewById(R.id.keypad_2);
		keys[2] = findViewById(R.id.keypad_3);
		keys[3] = findViewById(R.id.keypad_4);
		keys[4] = findViewById(R.id.keypad_5);
		keys[5] = findViewById(R.id.keypad_6);
		keys[6] = findViewById(R.id.keypad_7);
		keys[7] = findViewById(R.id.keypad_8);
		keys[8] = findViewById(R.id.keypad_9);
	}
	private void returnResult(int tile){
		sView.setSelectedTile(tile);
		dismiss();
	}
	private void setListenners(){
		for(int i=0;i<keys.length;i++){
			final int t = i+1;
			keys[i].setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					returnResult(t);
				}
			});
		}
	}
}
