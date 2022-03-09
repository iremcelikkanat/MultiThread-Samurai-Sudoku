/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yazlab2;

/**
 *
 * @author Eliz
 */
public class Solve {
    private static int sudoku[][];
    
    private boolean containsInRow(int row,int number)
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
	
	private boolean containsInCol(int col,int number)
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
	
	private boolean containsInBox(int row, int col,int number)
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
        
        private boolean isAllowed(int row, int col,int number)
	{
		return !(containsInRow(row, number) || containsInCol(col, number) || containsInBox(row, col, number));
	}
        
        public void solve(){
            for(int satir=0;satir<9;satir++){
                for(int sutun=0; sutun<9;sutun++){
                    
                }
            }
        }
}
