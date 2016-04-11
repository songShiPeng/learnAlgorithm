package action.DiGui;

public class ZhaoLing {

	/**自己写的,所谓的贪心算法
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[]={1,5,10,21,25};
		int coinsNum[]=new int[coins.length];
		int target=63;
		for(int i=coins.length-1;i>=0;i--){
			if(target<coins[i])
				continue;
			else{
				coinsNum[i]=target/coins[i];
				target=target%coins[i];
				System.out.println(coinsNum[i]+"个"+coins[i]);
			}
		}
		
	}

}
