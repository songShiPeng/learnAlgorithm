package action.TreeSetBiJiaoQi;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String [] args){
		Map<Integer,String> testMap=new HashMap<Integer,String>();
		testMap.put(1, "song");
		testMap.put(2, "yuan");
		for(Map.Entry<Integer, String> i:testMap.entrySet()){
			System.out.println(i);
		}
	}
}
