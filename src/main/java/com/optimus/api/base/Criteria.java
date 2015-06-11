package com.optimus.api.base;

import java.util.List;

public interface Criteria<T> {
	boolean evaluate(List<T> list);
}