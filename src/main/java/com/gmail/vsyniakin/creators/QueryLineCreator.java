package com.gmail.vsyniakin.creators;

import java.time.LocalDate;

import com.gmail.vsyniakin.DateAdapter;
import com.gmail.vsyniakin.lines.AbstractLine;
import com.gmail.vsyniakin.lines.QueryLine;

public class QueryLineCreator extends Creator {

	@Override
	public AbstractLine factoryMethod(String line) {
		QueryLine query = new QueryLine();

		StringBuilder regex = new StringBuilder("C\\s");
		String[] array = line.split(" ");
		for (int i = 1; i < array.length; i++) {
			switch (i) {
			case 1:
				regex.append(array[i]).append(".*\\s");
				break;
			case 2:
				if (!array[i].contains("*")) {
					regex.append(array[i]).append(".*\\s");
				}
				break;
			case 3:
				regex.append(array[i]).append(".*");
				break;
			case 4:
				if (array[i].contains("-")) {
					String[] dateArray = array[i].split("-");
					query.setFrom(DateAdapter.stringToDate(dateArray[0]));
					query.setTo(DateAdapter.stringToDate(dateArray[1]));
				} else {
					query.setFrom(DateAdapter.stringToDate(array[i]));
					query.setTo(LocalDate.now());
				}
			}
		}
		query.setData(regex.toString());

		return query;
	}
	
}
