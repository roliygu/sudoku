package com.roliy.sudoku;

public class Game {
	private final String str = "360000000"+"004230800"+"000004200"
			+"070460003"+"820000014"+"500013020"
			+"001900000"+"007048300"+"000000045";
	private int sudoku [] = new int[9*9];
	private int used[][][] = new int[9][9][];
	
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
	public void calculateAllUsedTiles(){
		for(int x=0; x<9;x++){
			for(int y=0;y<9;y++){
				used[x][y]=calculateUsedTiles(x,y);
			}
		}
	}
	
	public int[] getUsedTilesByCoor(int x,int y){
		return used[x][y];
	}
	protected int[] fromPuzzleString(String src){
		int [] su = new int[src.length()];
		for(int i=0; i<su.length;i++){
			su[i] = src.charAt(i)-'0';
		}
		return su;
	}
	public int[] calculateUsedTiles(int x, int y){
		int c[] = new int[9];	
		for(int i=0;i<9;i++){
			if(i!=y){
				int t = getTile(x, i);
				if(t!=0){
					c[t-1]=t;
				}
			}
			int t = getTile(i, y);
			if(t!=0){
				c[t-1]=t;
			}
		}		
		int startx = (x/3)*3;
		int starty = (y/3)*3;
		for(int i=startx;i<startx+3;i++){
			for(int j=starty;j<starty+3;j++){
				if(i!=x || j!=y){
					int t = getTile(i, j);
					if(t!=0)
						c[t-1]=t;
				}
			}
		}
		int nused=0;
		// 含义同Python中的 for i in c ; t=i ; {xxx}
		for(int t:c){
			if(t!=0)
				nused++;
		}
		int c1[] = new int[nused];
		nused=0;
		for(int t:c){
			if(t!=0)
				c1[nused++]=t;
		}
		return c1;
	}
}
