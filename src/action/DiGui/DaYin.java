package action.DiGui;

public class DaYin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printlNum(12485690);
	}
	public static void printlNum(int num){
		if(num>10){
			printlNum(num/10);
		}
		System.out.print(num%10);
	}
}
