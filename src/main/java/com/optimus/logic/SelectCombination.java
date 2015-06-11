package com.optimus.logic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.optimus.api.base.Criteria;
import com.optimus.api.base.SelectStrategy;

public class SelectCombination implements SelectStrategy<Participant> {

	/** Number of elements in the tuple */
	private int returnSize = 2;

	public static void main(String[] args) {
		int[][] data = { { 1, 30, 50 }, { 2, 40, 60 }, { 3, 35, 45 } };
		List<Participant> list = new ArrayList<Participant>();
		for (int i = 0; i < data.length; i++) {
			list.add(new Participant(data[i][0], data[i][1], data[i][2]));

		}

		SelectStrategy<Participant> selectStrategy = new SelectCombination();
		List<Participant> out = selectStrategy.execute(list,
				new Criteria<Participant>() {

					public boolean evaluate(List<Participant> participants) {
						if ((participants.get(0).age + participants.get(1).age >= 75)
								&& (participants.get(0).weight
										+ participants.get(1).weight >= 100))
							return true;
						else
							return false;
					}
				});

		Assert.assertEquals("Two elements are selected.", 2, out.size());
		System.out.println(out);

	}

	public List<Participant> execute(List<Participant> objects,
			Criteria<Participant> criteria) {
		List<Participant> list = new ArrayList<Participant>();
		List<Participant> tuple = new ArrayList<Participant>();
		for (int i = 0; i <= objects.size() - returnSize; i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				tuple.clear();
				tuple.add(objects.get(i));
				tuple.addAll(objects.subList(j, j + returnSize - 1));
				if (criteria.evaluate(tuple))
					return tuple;
			}
		}
		return list;
	}

}

class Participant {
	int id, age, weight;

	public Participant(int id, int age, int weight) {
		this.id = id;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("id=%d, age=%d, weight=%d", id, age, weight);
	}
}