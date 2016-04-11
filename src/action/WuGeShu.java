package action;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WuGeShu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a1=0,a2=0,a3=0,a5=0,a6=0;
		 double a4=0;
	        int a2biao=0;
	        int a4num=0;
	        int c=0,yu=0;
	        
	        Scanner sc=new Scanner(System.in);
	        int num=sc.nextInt();
	        for(int i=0;i<num;i++){
	        	c=sc.nextInt();
	        	yu=c%5;
	        	if(yu==0){
	        		if(c%2==0){
	        			a1+=c;
	        		}
	        	}
	        	else if(yu==1){
	        		if(a2biao==0){
	        			a2+=c;
	        			a2biao=1;
	        		}
	        		else{
	        			a2-=c;
	        			a2biao=0;
	        		}
	        	}
	        	else if(yu==2){
	        		a3++;
	        	}
	        	else if(yu==3){
	        		a4+=c;
	        		a4num++;
	        	}
	        	else if(c>a5){
	        		a5=c;
	        	}
	        }
	        DecimalFormat df=new DecimalFormat("#.0");
	        df.format(a4/a4num);
	        if(a1==0){
	        	System.out.print("N ");
	        }
	        else{
	        	System.out.print(a1+" ");
	        }
	        if(a2==0){
	        	System.out.print("N ");
	        }
	        else{
	        	System.out.print(a2+" ");
	        }
	        if(a3==0){
	        	System.out.print("N ");
	        }
	        else{
	        	System.out.print(a3+" ");
	        }
	        if(a4==0){
	        	System.out.print("N ");
	        }
	        else{
	        	System.out.print(df.format(a4/a4num)+" ");
	        }
	        if(a5==0){
	        	System.out.print("N ");
	        }
	        else{
	        	System.out.print(a5);
	        }
	}

}
