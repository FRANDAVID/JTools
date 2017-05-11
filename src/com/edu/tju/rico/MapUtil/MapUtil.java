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
 * ��ʹ��HashMapʵ�֣�����HashMap������ģ������ǲ��ȶ��ģ�
 * ��ʹ��LinkedHashMapʵ�֣�����LinkedHashMap�Ǳ�������˳��ģ��������ȶ��ġ�
 * ��ν�����ȶ���ָ����ͬ������������Ա��������˳�򣬲���ߵ���
 * 
 * 2. ����Key��Map�������򣬲���ÿ��Map.Entry��������������������ȶ��ģ���Map�ľ���ʵ���޹ء�
 * ��ΪKey��ͬ��Value����Ψһ�ġ�
 * 
 * 3. ʹMap���ֲ���˳�򣬲���ÿ��Map.Entry�����������ʱ����Ӧ��ѡ��LinkedHashMap��ʵ��Map��
 * ��ΪLinkedHashMap������Ǳ�������˳��ġ�
 * 
 * @author rico
 * @created 2017��5��11�� ����9:01:53
 */
public class MapUtil {

	/**
	 * @description ����Value��Map�������򣬲���ÿ��Map.Entry�������
	 * @author rico
	 * @created 2017��5��11�� ����9:14:10
	 * @param map
	 *            �������Map
	 * @param valueComparator
	 *            Value���������
	 */
	public static <K, V> void rankMapByValue(Map<K, V> map,
			final Comparator<V> valueComparator) {
		List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(
				map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return valueComparator.compare(o1.getValue(), o2.getValue());
			}
		});

		for (Map.Entry<K, V> entry : list) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}

	/**
	 * @description ����Key��Map�������򣬲���ÿ��Map.Entry�������
	 * @author rico
	 * @created 2017��5��11�� ����9:14:10
	 * @param map
	 *            �������Map
	 * @param valueComparator
	 *            Key���������
	 */
	public static <K, V> void rankMapByKey(Map<K, V> map,
			final Comparator<K> keyComparator) {
		List<Map.Entry<K, V>> list = new ArrayList<Map.Entry<K, V>>(
				map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return keyComparator.compare(o1.getKey(), o2.getKey());
			}
		});

		for (Map.Entry<K, V> entry : list) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}

	public static void main(String[] args) {

		// ʹ��HashMapʵ��
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("D", 1);
		hashMap.put("C", 2);
		hashMap.put("A", 3);
		hashMap.put("B", 2);
		hashMap.put("F", 1);
		hashMap.put("E", 0);

		System.out.println("��HashMapʵ�ֵ�Map����Value���򲢴�ӡ��");
		rankMapByValue(hashMap, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});

		System.out.println();

		// ʹ��LinkedHashMapʵ��
		Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
		linkedHashMap.put("D", 1);
		linkedHashMap.put("C", 2);
		linkedHashMap.put("A", 3);
		linkedHashMap.put("B", 2);
		linkedHashMap.put("F", 1);
		linkedHashMap.put("E", 0);

		System.out.println("��LinkedHashMapʵ�ֵ�Map����Value���򲢴�ӡ��");
		rankMapByValue(linkedHashMap, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
		});

		System.out.println("\n--------���Ƿָ���--------\n");

		System.out.println("��Map����Key���򲢴�ӡ��");
		rankMapByKey(hashMap, String.CASE_INSENSITIVE_ORDER); // String��һ����������

		System.out.println("\n--------���Ƿָ���--------\n");
		
		System.out.println("HashMap�ǲ����ֲ���˳��ģ�������ģ�");
		for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}

		System.out.println("\n--------���Ƿָ���--------\n");

		System.out.println("LinkedHashMap�Ǳ��ֲ���˳��ģ�");
		for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " , Value : "
					+ entry.getValue());
		}
	}
}
