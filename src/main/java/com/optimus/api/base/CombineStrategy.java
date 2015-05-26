package com.optimus.api.base;

import java.util.List;

public interface CombineStrategy<T> {

	T execute(List<T> objects);
	
	void setFactory(Factory<T> factory);
}