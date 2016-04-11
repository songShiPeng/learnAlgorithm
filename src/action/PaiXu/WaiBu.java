package action.PaiXu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WaiBu {
	public static final int MAX_ARRAY_SIZE=100000;
	public static final int BUFFER_SIZE=100000;
	
	/**外部排序
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int numverOfSegments=initializeSegments(MAX_ARRAY_SIZE,"D:/largedata.dat","D:/f1.dat");
		merge(numverOfSegments,MAX_ARRAY_SIZE,"D:/f1.dat","D:/f2.dat","D:/f3.dat","D:/sortedfile.dat");
		
		DataInputStream input=new DataInputStream(new FileInputStream("D:/sortedfile.dat"));
		for(int i=0;i<100;i++){
			System.out.print(input.readInt()+" ");
		}
	}
	//创建初始的有序分段
	public static int initializeSegments(int segmentSize,String originalFile,String f1) throws Exception{
		int [] list=new int[segmentSize];
		DataInputStream input =new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
		DataOutputStream output =new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));
		
		int numberOfSegments=0;
		while(input.available()>0){
			numberOfSegments++;
			int i=0;
			for(;input.available()>0&&i<segmentSize;i++){
				list[i]=input.readInt();
			}
			//排序
			java.util.Arrays.sort(list,0,i);
			//写入
			for(int j=0;j<i;j++){
				output.writeInt(list[j]);
			}
		}
		input.close();
		output.close();
		return numberOfSegments;
	}
	
	//归并
	public static void merge(int numberOfSegments,int segmentSize,String f1,String f2,String f3,String targetFile) throws Exception{
		
		if(numberOfSegments>1){
			mergeOneStep(numberOfSegments,segmentSize,f1,f2,f3);
			merge((numberOfSegments+1)/2,MAX_ARRAY_SIZE,f3,f1,f2,"D:/sortedfile.dat");
		}
		else{
			File sortedFile=new File(targetFile);
			if(sortedFile.exists())sortedFile.delete();
			new File(f1).renameTo(sortedFile);
		}
	}
	
	public static void mergeOneStep(int numberOfSegments,int segmentSize,String f1,String f2,String f3) throws Exception{
		DataInputStream f1input =new DataInputStream(new BufferedInputStream(new FileInputStream(f1),BUFFER_SIZE));
		DataOutputStream f2output =new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2),BUFFER_SIZE));
		//复制f1的一半给f2
		for(int i=0;i<(numberOfSegments/2)*segmentSize;i++){
			f2output.writeInt(f1input.readInt());
		}
		f2output.close();
		//把f1和f2归并到f3
		DataInputStream f2input =new DataInputStream(new BufferedInputStream(new FileInputStream(f2),BUFFER_SIZE));
		DataOutputStream f3output =new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f3),BUFFER_SIZE));
		
		mergeSegments(numberOfSegments/2,segmentSize,f1input,f2input,f3output);
		f1input.close();
		f2input.close();
		f3output.close();
	}
	//归并所有分段
	public static void mergeSegments(int numberOfSegments,int segmentSize,DataInputStream f1input,DataInputStream f2input,DataOutputStream f3output) throws Exception{
		for(int i=0;i<numberOfSegments;i++){
			mergeTwoSegments(segmentSize,f1input,f2input,f3output);
		}
		//f1可能比f2多一个分段
		while(f1input.available()>0){
			f3output.writeInt(f1input.readInt());
		}
	}
	
	
	//归并两个分段
	public static void mergeTwoSegments(int segmentSize,DataInputStream f1input,DataInputStream f2input,DataOutputStream f3output) throws Exception{
		int intFromF1=f1input.readInt();
		int intFromF2=f2input.readInt();
		int f1Count=1;
		int f2Count=2;
		while(true){
			if(intFromF1<intFromF2){
				f3output.writeInt(intFromF1);
				if(f1input.available()==0||f1Count++>=segmentSize){
					f3output.writeInt(intFromF2);
					break;
				}
				else{
					intFromF1=f1input.readInt();
				}
			}
			else{
				f3output.writeInt(intFromF2);
				if(f2input.available()==0||f2Count++>=segmentSize){
					f3output.writeInt(intFromF2);
					break;
				}
				else{
					intFromF2=f2input.readInt();
				}
			}
		}
		while(f1input.available()>0&&f1Count++<segmentSize){
			f3output.writeInt(f1input.readInt());
		}
		while(f2input.available()>0&&f2Count++<segmentSize){
			f3output.writeInt(f2input.readInt());
		}
	}
	

}
