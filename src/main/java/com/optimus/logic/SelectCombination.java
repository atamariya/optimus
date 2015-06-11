package com.optimus.logic;

import java.util.ArrayList;
import java.util.List;

import com.optimus.api.base.Criteria;
import com.optimus.api.base.SelectStrategy;

public class SelectCombination<T> implements SelectStrategy<T> {

	public List<T> execute(List<T> objects,
			Criteria<T> criteria) {
		return execute(objects, criteria, 1);
	}
	public List<T> execute(List<T> objects,
			Criteria<T> criteria, int returnSize) {
		List<T> tuple = new ArrayList<T>();
		for (int i = 0; i <= objects.size() - returnSize; i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				tuple.clear();
				tuple.add(objects.get(i));
				tuple.addAll(objects.subList(j, j + returnSize - 1));
				if (criteria.evaluate(tuple))
					return tuple;
			}
		}
		return tuple;
	}

}

