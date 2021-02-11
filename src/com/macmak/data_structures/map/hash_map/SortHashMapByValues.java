package com.macmak.data_structures.map.hash_map;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHashMapByValues {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("abc", 5);
		map.put("pqr", 3);
		map.put("xyz", 2);
		map.put("mno", 4);
		map.put("def", 1);
		
		map = sortByValues(map);
		
		System.out.println(map);
	}

	private static Map<String, Integer> sortByValues(Map<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> item : list) {
			sortedMap.put(item.getKey(), item.getValue());
		}
		
		return sortedMap;
	}

}
