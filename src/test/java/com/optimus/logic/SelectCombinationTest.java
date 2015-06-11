package com.optimus.logic;

import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.objects.annotations.Setter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.optimus.api.base.Criteria;
import com.optimus.api.base.SelectStrategy;

public class SelectCombinationTest {
	private List<Participant> list;
	
	@Test
	public void testRandomSelection() {

		SelectStrategy<Participant> selectStrategy = new SelectCombination<Participant>();
		List<Participant> out = selectStrategy.execute(list,
				new RandomSelector<Participant>(), 1);

		Assert.assertEquals("Two elements are selected.", 1, out.size());
		System.out.println(out);
	}
	
	@Test
	public void testTuples() {

		SelectStrategy<Participant> selectStrategy = new SelectCombination<Participant>();
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
				}, 2);

		Assert.assertEquals("Two elements are selected.", 2, out.size());
		System.out.println(out);

	}

	@Before
	public void setup() {
		int[][] data = { { 1, 30, 50 }, { 2, 40, 60 }, { 3, 35, 45 } };
		list = new ArrayList<Participant>();
		for (int i = 0; i < data.length; i++) {
			list.add(new Participant(data[i][0], data[i][1], data[i][2]));

		}
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