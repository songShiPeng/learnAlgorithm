package action.DiGui;

public class ZhaoLingBiaoZhun {

	/**标准答案
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeChange(new int[]{1,5,10,21,25},63);
	}
	public static void makeChange(int [] coins,int maxChange){
		int differentCoins=coins.length;
		int [] coinsUsed=new int[maxChange+1];
		int []lastCoin=new int[maxChange+1];
		coinsUsed[0]=0;//coinUsed[i]就是i元需要硬币的数量
		//int minCoins=0;
		for(int cents=1;cents<=maxChange;cents++){
			int minCoins=cents;
			int newCoin=1;
			for(int j=0;j<differentCoins;j++){
				if(coins[j]>cents)
					continue;
				if(coinsUsed[cents-coins[j]]+1<minCoins){
					minCoins=coinsUsed[cents-coins[j]]+1;
					newCoin=coins[j];
				}
			}
			coinsUsed[cents]=minCoins;
			lastCoin[cents]=newCoin;
			
		}
		System.out.println(coinsUsed[maxChange]);
	}
}
