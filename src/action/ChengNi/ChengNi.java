package action.ChengNi;

public class ChengNi {
	private static long x;
	private static long y;
	/**乘法逆元素的求解
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n=13;
		fullGcd(3,n);
		System.out.println(x>0?x:x+n);
	}
	public static void fullGcd(long a,long b){
		long x1,y1;
		if(b==0){
			x=1;
			y=0;
		}
		else{
			fullGcd(b,a%b);
			x1=x;
			y1=y;
			x=y1;
			y=x1-(a/b)*y1;
		}
	}
}
