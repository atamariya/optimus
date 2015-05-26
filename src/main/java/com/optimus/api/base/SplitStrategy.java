package com.optimus.api.base;

import java.util.List;

public interface SplitStrategy<T> {

	List<T> execute(T object);
	
	void setFactory(Factory<T> factory);
}