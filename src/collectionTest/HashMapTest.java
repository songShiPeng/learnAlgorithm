package collectionTest;

import java.util.HashMap;
import java.util.Map;
/**
 * HashMap基本用法及性能测试
 * @author 宋世鹏
 *
 */
public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(4, 2);
		map.put(4, 8+map.get(4));
		System.out.println(map);
	}

}
