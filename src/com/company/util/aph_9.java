package com.company.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.company.bean.Bean;
import com.company.dao.impl.AHQImpl;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;


public class aph_9 {
	
public	static AHQImpl ahq = new AHQImpl();

public  static Bean bean = new Bean();

public  static final int n=9;

public final static double []RI={0,0,0.58,0.90,1.12,1.24,1.32,1.41,1.45,1.49,1.51};

public static double [][]B=new double[n][n];

public static String [][]C=new String[n][n];

public static double lambda=0;

public static double CI=0;

public static double CR=0;


public static double []weight=new double[n];


public static void getN(){
	Scanner scanner=new Scanner(System.in);
	String nString=scanner.nextLine();
	String nlineReader=scanner.nextLine();
//	n=Integer.valueOf(nString);
}


//String[][]-->double[][]
public static double arrayTrans(String data,int length){
	  
	double date[][] = new double[length][length];
    for(int i = 0; i < length; i++){
    	for(int j = 0; j < length; j++){
    		date[i][j] = Double.parseDouble(data);
    		return date[i][j];
    	}
    }
	return 0.0;
}  

//改成从文件读取，获取矩阵
//	@Test
	public static  void getC(){
		String pathname = "C:\\Users\\only--one\\Desktop\\AHQ_9.txt";   
        File filename = new File(pathname); 
        InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream(filename),"UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String line  = "";  
	        while (line != null) {  
	        	line = br.readLine();
	        	//获取文件
	            //判断是否为空，空跳出
	            if( line != null && line.equals("") ) {
	            	break;
	            }
	            //读取文件非空，进行数据分析
	            String[] token =line.split(";");
	            
	            //判断是几阶矩阵
	             int j = token.length; 

	            for(int m = 0 ; m < token.length; m++){

	            	String[] tmp = token[m].split(" ");
	            	
	            	for(int x = 0; x < j ; x++){
	            		//此时获取的是String的二维数组，而我们调用jama需将其转换成double二维数组
	            		C[m][x]=tmp[x];
	            		//调用转换数组的方法
	            		B[m][x] = arrayTrans(C[m][x],j);	
	            	}
	            }
	            //跳出循环，否则会保空指针异常
	           break;
	           //
	        }
	      //转换成标准矩阵数据格式
	        display(B);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	} 
	
public static void display(double[][] c2){
	for(int i=0;i<c2.length;i++){
		for(int j=0;j<c2[i].length;j++){
			System.out.print(c2[i][j]+" ");
		}
		System.out.println("\n");
	}
}

public static void display_one(double []a){
	for(int i=0;i<a.length;i++){
		
			System.out.print(a[i]+" ");
			
		}
		System.out.println("\n");
		bean.setW4(a[0]);
		bean.setW5(a[1]);
		bean.setW6(a[2]);
		bean.setW7(a[3]);
		bean.setW8(a[4]);
		bean.setW9(a[5]);
		bean.setW10(a[6]);
		bean.setW11(a[7]);
		bean.setW12(a[8]);
		getCR();
		bean.setCR(CR);
		ahq.insert(bean);
	
}

public static void getMaxLambda(){
	
	Matrix a=new Matrix(B);
	EigenvalueDecomposition b=a.eig();
	double real[]=b.getRealEigenvalues();

	int n;double max=0;

	max=real[0];
	for(n=1;n<real.length;n++){
		if(real[n]>=max){
			max=real[n];
		}
	}
	lambda=max;
}
public static void getCI(){

	CI=(lambda-n)/(n-1);
}
public static void getCR(){
	if(n<3){
		CR=0;
	}else{
		CR=CI/RI[n-1];
	}
	
}
public static boolean whetherSatisfied(){
	return CR>0.1?false:true;
}
public static void getWeight(){
	double sum1=0,sum2=0,sum3=0;
	double []wi=new double [n];
	double [][]wij=new double [n][n];
	//调整CR
	for(int i=0;i<n;i++){
		int j;
		for(j=0;j<n;j++){
			sum1=sum1+B[j][i]; //sum1=0+B[0][0]+B[1][0]+B[2][0]=  一列相加
	//		wij[i][j]=B[i][j]/sum1;
		}
		for(j=0; j < n; ++ j)
		{
			wij[j][i]=B[j][i]/sum1; //wij[0][0]=B[0][0]/sum1  wij[1][0]=B[1][0]/sum1	 wij[2][0]=B[2][0]/sum1
		}
		sum1 = 0;
	}
	
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			sum2=sum2+wij[i][j]; //sum2=wij[0][0]+wij[0][1]+wij[0][2]
		}
		wi[i]=sum2; 
		//wi[1]=sum2=wij[0][0]+wij[0][1]+wij[0][2]
		//wi[2]=sum2=wij[1][0]+wij[1][1]+wij[1][2] 
		//si[3]=sum2=wij[2][0]+wij[2][1]+wij[2][2]
		sum2 = 0;
	}
	
	for(int i=0;i<n;i++){
		//归一化处理
		sum3=sum3+wi[i];
	}
	for(int i=0;i<n;i++){
		//求权重
		weight[i]=wi[i]/sum3;
	}
	display_one(weight);
	
	
}

public static void main(String args[]){

	
	
	String lineString="";
	do {
		System.out.println("**********输入q外的任意字符开始**********");
		Scanner scanner=new Scanner(System.in);
		lineString=scanner.nextLine();
		if(lineString.equals("q")){
			 break;
		}
		getC();
		getMaxLambda();
		getCI();
		getCR();
		System.out.println("CR的值是："+CR);                          
		if(whetherSatisfied()){
		System.out.println("CR值小于0.1不需要调整-------the end---------");
 
	}else{
		System.out.println("CR值大于0.1需要调整-------the end---------");
	}
	} while (!whetherSatisfied());
	
	if(whetherSatisfied()){
	System.out.println("**********最终结果去权值为**********");
	getWeight();
	}
	
}
}                 
