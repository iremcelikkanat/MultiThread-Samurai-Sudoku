/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;


/**
 *
 * @author Eliz
 */
public class Main {

    public int sayac=0;
    static int top=0;
    private static int[][] mat1= new int[9][9];
    private static int[][] mat2= new int[9][9];
    private static int[][] mat3= new int[9][9];
    private static int[][] mat4= new int[9][9];
    private static int[][] mat5= new int[9][9];
    
    private static int[][] kmat1= new int[9][9];
    private static int[][] kmat2= new int[9][9];
    private static int[][] kmat3= new int[9][9];
    private static int[][] kmat4= new int[9][9];
    private static int[][] kmat5= new int[9][9];


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

        // TODO code application logic here

        File f= new File("C:\\Users\\Eliz\\OneDrive\\Masaüstü\\sudoku.txt");
        FileReader fr= new FileReader(f);
        BufferedReader br= new BufferedReader(fr);
        String line;
        
        int satsayac=0;
        
        while((line=br.readLine())!=null){
            
            
            if(satsayac>=0 && satsayac<6){ 
                String line1=line.substring(9,line.length()); //mat2  
                    for(int i=0;i<9;i++){
                        if(line.charAt(i)=='*'){
                          mat1[satsayac][i]=0; 
                          kmat1[satsayac][i]=0;
                        }else{
                          mat1[satsayac][i]=Character.getNumericValue(line.charAt(i));
                          kmat1[satsayac][i]=Character.getNumericValue(line.charAt(i));
                        }
                        
                        if(line1.charAt(i)=='*'){
                            mat2[satsayac][i]=0;
                            kmat2[satsayac][i]=0;
                        }else{
                            mat2[satsayac][i]=Character.getNumericValue(line1.charAt(i));
                            kmat2[satsayac][i]=Character.getNumericValue(line1.charAt(i));
                        }
                    }
            }
            
            if(satsayac>=6 && satsayac<9){
                String line1=line.substring(6, 15); //mat3
                String line2= line.substring(12,line.length());//mat2
                
                for(int i=0;i<9;i++){
                        if(line.charAt(i)=='*'){
                          mat1[satsayac][i]=0; 
                         kmat1[satsayac][i]=0;
                        }else{
                          mat1[satsayac][i]=Character.getNumericValue(line.charAt(i));
                          kmat1[satsayac][i]=Character.getNumericValue(line.charAt(i)); 
                        }
                        
                        if(line1.charAt(i)=='*'){
                            mat3[satsayac-6][i]=0;
                            kmat3[satsayac-6][i]=0;
                        }else{
                            mat3[satsayac-6][i]=Character.getNumericValue(line1.charAt(i));
                            kmat3[satsayac-6][i]=Character.getNumericValue(line1.charAt(i));
                        }
                        
                        if(line2.charAt(i)=='*'){
                            mat2[satsayac][i]=0;
                            kmat2[satsayac][i]=0;
                        }else{
                            mat2[satsayac][i]=Character.getNumericValue(line2.charAt(i));
                            kmat2[satsayac][i]=Character.getNumericValue(line2.charAt(i));
                        }                       
                    }           
            }
            
            if(satsayac>=9 && satsayac<12){ 
                for(int i=0;i<9;i++){
                        if(line.charAt(i)=='*'){
                          mat3[satsayac-6][i]=0; 
                          kmat3[satsayac-6][i]=0;
                        }else{
                          mat3[satsayac-6][i]=Character.getNumericValue(line.charAt(i));
                          kmat3[satsayac-6][i]=Character.getNumericValue(line.charAt(i));
                        }                      
                    }           
            }
            
            if(satsayac>=12 && satsayac<15){
                String line1=line.substring(6, 15); //mat3
                String line2= line.substring(12,line.length());//mat2
                
                for(int i=0;i<9;i++){
                        if(line.charAt(i)=='*'){
                          mat4[satsayac-12][i]=0;
                          kmat4[satsayac-12][i]=0;
                        }else{
                          mat4[satsayac-12][i]=Character.getNumericValue(line.charAt(i));
                          kmat4[satsayac-12][i]=Character.getNumericValue(line.charAt(i));
                        }
                        
                        if(line1.charAt(i)=='*'){
                            mat3[satsayac-6][i]=0;
                            kmat3[satsayac-6][i]=0;
                        }else{
                            mat3[satsayac-6][i]=Character.getNumericValue(line1.charAt(i));
                            kmat3[satsayac-6][i]=Character.getNumericValue(line1.charAt(i));
                        }
                        
                        if(line2.charAt(i)=='*'){
                            mat5[satsayac-12][i]=0;
                            kmat5[satsayac-12][i]=0;
                        }else{
                            mat5[satsayac-12][i]=Character.getNumericValue(line2.charAt(i));
                            kmat5[satsayac-12][i]=Character.getNumericValue(line2.charAt(i));
                        }                       
                    }           
            }
            
            if(satsayac>=15 && satsayac<21){ 
                String line1=line.substring(9,line.length()); //mat2  
                    for(int i=0;i<9;i++){
                        if(line.charAt(i)=='*'){
                          mat4[satsayac-12][i]=0;
                          kmat4[satsayac-12][i]=0;
                        }else{
                          mat4[satsayac-12][i]=Character.getNumericValue(line.charAt(i)); 
                          kmat4[satsayac-12][i]=Character.getNumericValue(line.charAt(i));
                        }
                        
                        if(line1.charAt(i)=='*'){
                            mat5[satsayac-12][i]=0;
                            kmat5[satsayac-12][i]=0;
                        }else{
                            mat5[satsayac-12][i]=Character.getNumericValue(line1.charAt(i));
                            kmat5[satsayac-12][i]=Character.getNumericValue(line1.charAt(i));
                        }
                    }
            }
            satsayac++;
        }
        fr.close();

        
        System.out.println("****************************");
        
    Thread t1 = new Thread (new Matris(mat1,mat3,1));
    Thread t2 = new Thread(new Matris(mat2,mat3,2));
    Thread t3 = new Thread(new Matris(mat3,mat4,mat5,3));
    Thread t4 = new Thread(new Matris(mat4));
    Thread t5 = new Thread(new Matris(mat5));
    
    long start=System.nanoTime();
    t1.start();
    t2.start();     //Instant start= Instant.now();
    t3.start();
    t4.start(); 
    t5.start();
    
t1.join();
t2.join();
t3.join();
t4.join();
t5.join();
   long bitis=System.nanoTime();
   long cozum= (bitis-start);
   String s=Long.toString(cozum);
   System.out.println("zaman: "+cozum);
     
    displaySudoku(mat1);
    displaySudoku(mat2);
    displaySudoku(mat3);
    displaySudoku(mat4);
    displaySudoku(mat5);
                   
         /* Instant finish= Instant.now();
        long timeElapsed= Duration.between(start,finish).toMillis();
        System.out.println(timeElapsed);*/
         
        Thread t6=new Thread(new Matris(kmat1,kmat3,1));
        Thread t11=new Thread(new Matris1(kmat1,kmat3,1));
        Thread t7=new Thread(new Matris(kmat2,kmat3,2));
        Thread t12=new Thread(new Matris1(kmat2,kmat3,2));
        Thread t8=new Thread(new Matris(kmat3,kmat4,kmat5,3));
        Thread t13=new Thread(new Matris1(kmat3,kmat4,kmat5,3));
        Thread t9=new Thread(new Matris(kmat4));
        Thread t14=new Thread(new Matris1(kmat4));
        Thread t10=new Thread(new Matris(kmat5));
        Thread t15=new Thread(new Matris1(kmat5));
        
        long start1=System.nanoTime();
        t6.start();
        t11.start();
        t7.start();
        t12.start();
        t8.start();
        t13.start();
        t9.start();
        t14.start();
        t10.start();
        t15.start();

        t6.join();
        t11.join();
        t7.join();
        t12.join();
        t8.join();
        t13.join();
        t9.join();
        t14.join();
        t10.join();
        //t15.join();
        
    long bitis1=System.nanoTime();
    long cozum1= (bitis1-start1);
    String s1=Long.toString(cozum1);
    System.out.println("zaman: "+cozum1);
        
        displaySudoku(kmat1);
        displaySudoku(kmat2);
        displaySudoku(kmat3);
        displaySudoku(kmat4);
        displaySudoku(kmat5);

       // System.out.println(toplam);
        Sudoku gui= new Sudoku(mat1,mat2,mat3,mat4,mat5,s,s1);
        gui.setVisible(true);
        Sudoku1 gui1 = new Sudoku1(kmat1,kmat2,kmat3,kmat4,kmat5,s,s1);
        gui1.setVisible(true);
        gui.setLocation(20, 20);
        gui1.setLocation(720,20);
    }


    public static void displaySudoku(int sudoku[][]) throws InterruptedException
	{
		for(int i=0;i<9;i++)
		{
			if(i%3==0 && i!=0)
			{
				System.out.println("----------------------------------\n");
			}
			for(int j=0;j<9;j++)
			{
				if(j%3==0 && j!=0)
				{
					System.out.print(" | ");
				}
				System.out.print(" " + sudoku[i][j] + " ");
                                //Thread.sleep(100);
				
			}
			
			System.out.println();
		}
		System.out.println("\n\n________________\n\n");
	}

    
}
