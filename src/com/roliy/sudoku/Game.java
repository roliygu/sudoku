package com.roliy.sudoku;

public class Game {
	private final String str = "360000000"+"004230800"+"000004200"
			+"070460003"+"820000014"+"500013020"
			+"001900000"+"007048300"+"000000045";
	private int sudoku [] = new int[9*9];
	
	public Game(){
		sudoku = fromPuzzleString(str);
	}
	private int getTile(int x, int y){
		return sudoku[y*9+x];
	}
	public String getTilesString(int x, int y){
		int v = getTile(x,y);
		if(v == 0){
			return "";
		}else
			return String.valueOf(v);
	}
	protected int[] fromPuzzleString(String src){
		int [] su = new int[src.length()];
		for(int i=0; i<su.length;i++){
			su[i] = src.charAt(i)-'0';
		}
		return su;
	}
}
