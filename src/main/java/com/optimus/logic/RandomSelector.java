package com.optimus.logic;

import java.util.List;

import com.optimus.api.base.Criteria;

public class RandomSelector<T> implements Criteria<T> {

	public boolean evaluate(List<T> list) {
		return Math.random() > 0.5;
	}

}
