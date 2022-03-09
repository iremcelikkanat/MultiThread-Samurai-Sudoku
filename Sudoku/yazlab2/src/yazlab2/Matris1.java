
package yazlab2;


import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yazlab2.Matris.textyaz;

public class Matris1 implements Runnable {
    private int[][] sudoku;
    private int[][] sudoku1;
    private int[][] sudoku2;
    private int sayi=0;
    private int sayi1=0;
    private static final int UNASSIGNED = 0;

    
	public Matris1()
	{
		sudoku = new int[9][9];
	}
	
	public Matris1(int sudoku[][])
	{
		this.sudoku= sudoku;
	}
        

        public Matris1(int sudoku[][],int sudoku1[][],int sayi)
	{
		this.sudoku= sudoku;
                this.sudoku1= sudoku1;
                this.sayi=sayi;
	}
        public Matris1(int sudoku[][],int sudoku1[][],int sudoku2[][],int sayi)
	{
		this.sudoku= sudoku;
                this.sudoku1= sudoku1;
                this.sudoku2=sudoku2;
                this.sayi=sayi;
	}
        public static void textyaz(int row,int col,int sayi) throws IOException{
            File f = new File("cozum1.txt"); 
             if (!f.exists()) { 
                 f.createNewFile(); 
            } 
            FileWriter fw = new FileWriter(f, true); 
            BufferedWriter bw = new BufferedWriter(fw); 
            bw.write("satır "+row+" sutun "+col+" "+sayi+" sayisi koyuldu.\n"); 
            bw.close();
        }

public boolean solveSudoku(int sudoku[][],int sudoku1[][],int sudoku2[][]) throws InterruptedException, IOException
	{
		for(int row=8;row>=0;row--)
		{
			for(int col=8;col>=0;col--)
			{
				if(sudoku[row][col]==UNASSIGNED)
				{
					for(int number=1;number<=9;number++)
					{
						if(isAllowed(sudoku,row, col, number))
						{
							sudoku[row][col] = number;
                                                        if(sayi==3){
                                                            if((row>=6 && row<9) && (col>=0 && col<3)){
                                                                sudoku1[row-6][col+6]=sudoku[row][col];
                                                            }else if((row>=6 && row<9) && (col>=6 && col<9)){
                                                                sudoku2[row-6][col-6]=sudoku[row][col];
                                                            }
                                                        }
                                                        //Thread.sleep(1);
							if(solveSudoku(sudoku,sudoku1,sudoku2))
							{
                                                                textyaz(row,col,number);
								return true;
							}
							else
							{
								sudoku[row][col] = UNASSIGNED;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
        public boolean solveSudoku(int sudoku[][],int sudoku1[][]) throws IOException
	{
		for(int row=8;row>=0;row--)
		{
			for(int col=8;col>=0;col--)
			{
				if(sudoku[row][col]==UNASSIGNED)
				{
					for(int number=1;number<=9;number++)
					{
						if(isAllowed(sudoku,row, col, number)){
						{       sudoku[row][col] = number;
							 if(sayi==1){
                                                            if((row>=6 && row<9) && (col>=6 && col<9)){
                                                                sudoku1[row-6][col-6]=sudoku[row][col];
                                                            }
                                                        }else if(sayi==2){
                                                            if((row>=6 && row<9) && (col>=0 && col<3)){
                                                                sudoku1[row-6][col+6]=sudoku[row][col];
                                                            }
                                                        }else if(sayi==4){
                                                            if((row>=0 && row<3) && (col>=6 && col<9)){
                                                                sudoku1[row+6][col-6]=sudoku[row][col];
                                                            }
                                                        }else if(sayi==5){
                                                            if((row>=0 && row<3) && (col>=0 && col<3)){
                                                                sudoku1[row+6][col+6]=sudoku[row][col];
                                                            }
                                                        }
							if(solveSudoku(sudoku,sudoku1))
							{
                                                            textyaz(row,col,number);
								return true;
							}
							else
							{
								sudoku[row][col] = UNASSIGNED;
							}
						}
					}
					return false;
				}
			}
		}
		
	}
                return true;
    }   

    public boolean solveSudoku(int[][] sudoku) throws IOException
	{
		for(int row=8;row>=0;row--)
		{
			for(int col=8;col>=0;col--)
			{
				if(sudoku[row][col]==UNASSIGNED)
				{
					for(int number=1;number<=9;number++)
					{
						if(isAllowed(sudoku,row, col, number))
						{
							sudoku[row][col] = number;
							if(solveSudoku(sudoku))
							{
                                                            textyaz(row,col,number);
								return true;
							}
							else
							{
								sudoku[row][col] = UNASSIGNED;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	} 
	private boolean containsInRow(int sudoku[][],int row,int number)
	{
		for(int i=0;i<9;i++)
		{
			if(sudoku[row][i]==number)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean containsInCol(int sudoku[][],int col,int number)
	{
		for(int i=0;i<9;i++)
		{
			if(sudoku[i][col]==number)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean containsInBox(int sudoku[][],int row, int col,int number)
	{
		int r = row - row%3;
		int c = col - col%3;
		for(int i=r;i<r+3;i++)
		{
			for(int j=c;j<c+3;j++)
			{
				if(sudoku[i][j]==number)
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
	private boolean isAllowed(int sudoku[][],int row, int col,int number)
	{
		return !(containsInRow(sudoku,row, number) || containsInCol(sudoku,col, number) || containsInBox(sudoku,row, col, number));
	}
	

    @Override
    public void run() {
        if(sayi==3){
            try {
                solveSudoku(sudoku,sudoku1,sudoku2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Matris1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Matris1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(sayi==1 || sayi==2){
            try {
                solveSudoku(sudoku,sudoku1);
            } catch (IOException ex) {
                Logger.getLogger(Matris1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                solveSudoku(sudoku);
            } catch (IOException ex) {
                Logger.getLogger(Matris1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
