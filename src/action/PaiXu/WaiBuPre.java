package action.PaiXu;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WaiBuPre {

	/**产生外部排序的数据
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:/largedata.dat")));
		for(int i=0;i<800004;i++){
			out.writeInt((int)(Math.random()*1000000));
		}
		out.close();
		DataInputStream input=new DataInputStream(new FileInputStream("D:/largedata.dat"));
		for(int i=0;i<100;i++){
			System.out.print(input.readInt()+" ");
		}
	}

}
