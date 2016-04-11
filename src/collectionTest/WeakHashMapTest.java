package collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {  
    static Map wMap = new WeakHashMap();  
    static Map hp = new HashMap();
   // static TestMap tm=new TestMap();
    public static void init(){  
       
    }  
//    public static void testWeakHashMap(){  
//    	
//        System.out.println("first get:"+wMap.get(tm));  
//        System.gc();
//        try {  
//            Thread.sleep(20000);  
//        } catch (InterruptedException e) {  
//            // TODO Auto-generated catch block  
//            e.printStackTrace();  
//            System.gc();
//        }  
//        System.gc();
//        System.out.println("next get:"+wMap.get(tm));  
//    }  
    public static void main(String[] args) {  
    	TestMap tm=new TestMap();
    	 wMap.put(tm,5);  
    	 hp.put(tm, 5);
       // testWeakHashMap();  
    	tm=null;
    	 System.out.println("first get:"+wMap.get(tm));  
    	
         System.gc();
         try {  
             Thread.sleep(2000);  
         } catch (InterruptedException e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
             System.gc();
         }  
         Iterator i = hp.entrySet().iterator();  
         while (i.hasNext()) {  
             Map.Entry en = (Map.Entry)i.next();  
             System.out.println("map:"+en.getKey()+":"+en.getValue());  
         }
         System.gc();
         System.out.println("next get:"+wMap.get(tm));  
    }  
}  
class TestMap{
	int a=5;
}