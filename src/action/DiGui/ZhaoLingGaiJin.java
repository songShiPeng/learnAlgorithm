package action.DiGui;

public class ZhaoLingGaiJin {

	/**自己写的,改进版，支持21
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int coins[]={1,5,10,21,25};
		int coinsNum[]=new int[coins.length];
		int coinsNumMin[]=new int[coins.length];
		int target=68,fu=68;
		int minNum=target;
		int b=0;
		for(int i=coins.length-1;i>=0;i--){
			coinsNum=new int[coins.length];
			b=0;
			fu=target;
			for(int j=i;j>=0;j--){
				if(fu<coins[j]){
					coinsNum[j]=0;
					continue;
				}
				else{
					coinsNum[j]=fu/coins[j];
					fu=fu%coins[j];
					b+=coinsNum[j];
				}
			}
			if(minNum>b&&b!=0){
				coinsNumMin=coinsNum;
				minNum=b;
			}
		}
		System.out.println(minNum+"个硬币");
		for(int o=0;o<coinsNumMin.length;o++){
			if(coinsNumMin[o]!=0){
				System.out.println(coinsNumMin[o]+"个"+coins[o]);
			}
		}
		
	}

}
