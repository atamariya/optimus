package com.optimus.api.base;

import java.util.List;

public interface SelectStrategy<T> {

	T execute(List<T> objects);
	
}