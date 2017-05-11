package com.edu.tju.rico.MapUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**        
 * Title: Map�� ��ǿʵ��   
 * Description: 
 * 
 * 1. ����Value��Map�������򣬲���ÿ��Map.Entry������������������ǲ��ȶ��ģ���ȡ����Map�ľ���ʵ�֣�
 * 	     ��ʹ��HashMapʵ�֣�����HashMap������ģ������ǲ��ȶ��ģ�
 * 	     ��ʹ��LinkedHashMapʵ�֣�����LinkedHashMap�Ǳ�������˳��ģ��������ȶ��ġ�
 * 	     ��ν�����ȶ���ָ����ͬ������������Ա��������˳�򣬲���ߵ���
 * 
 * @author rico       
 * @created 2017��5��11�� ����9:01:53    
 */
public class MapUtil {
	
	/**     
	 * @description ����Value��Map�������򣬲���ÿ��Map.Entry�������
	 * @author rico       
	 * @created 2017��5��11�� ����9:14:10     
	 * @param map �������Map
	 * @param valueComparator Value���������
	 */
	public static <K,V> void rankMapByValue(Map<K, V> map, final Comparator<V> valueComparator) {
		List<Map.Entry<K,V>> list = new ArrayList<Map.Entry<K,V>>(
				map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<K,V>>() {
			@Override
			public int compare(Map.Entry<K,V> o1,
					Map.Entry<K,V> o2) {
				return valueComparator.compare(o1.getValue(), o2.getValue());
			}
		});

		for (Map.Entry<K,V> entry : list) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		
		// ʹ��HashMapʵ��
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("A", 1);
		hashMap.put("B", 2);
		hashMap.put("C", 3);
		hashMap.put("D", 2);
		hashMap.put("E", 1);
		hashMap.put("F", 0);
		
		System.out.println("��HashMapʵ�ֵ�Map���򲢴�ӡ��\n");
		rankMapByValue(hashMap, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
		
		System.out.println("\n--------���Ƿָ���--------\n");
		
		// ʹ��LinkedHashMapʵ��
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("A", 1);
		linkedHashMap.put("B", 2);
		linkedHashMap.put("C", 3);
		linkedHashMap.put("D", 2);
		linkedHashMap.put("E", 1);
		linkedHashMap.put("F", 0);
		
		System.out.println("LinkedHashMapʵ�ֵ�Map���򲢴�ӡ��\n");
		rankMapByValue(linkedHashMap,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});
	}
}
