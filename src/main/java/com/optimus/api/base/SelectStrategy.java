package com.optimus.api.base;

import java.util.List;

public interface SelectStrategy<T> {

	List<T> execute(List<T> objects, Criteria<T> criteria, int returnSize);
	
}