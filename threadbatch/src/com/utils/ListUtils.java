package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @desciption: 集合工具类
 * @author: kexl
 * @date: 2020-08-21
 */
public class ListUtils {
	/**
	 * @desciption: list 集合分批切割
	 * @author: kexl
	 * @date: 2020-08-21
	 */
	public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
		int listSize = list.size();
		int page = (listSize + (pageSize - 1)) / pageSize;
		List<List<T>> listArray = new ArrayList<List<T>>();
		for (int i = 0; i < page; i++) {
			List<T> subList = new ArrayList<T>();
			for (int j = 0; j < listSize; j++) {
				int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
				if (pageIndex == (i + 1)) {
					subList.add(list.get(j));
				}
				if ((j + 1) == ((j + 1) * pageSize)) {
					break;
				}
			}
			listArray.add(subList);
		}
		return listArray;
	}

}
