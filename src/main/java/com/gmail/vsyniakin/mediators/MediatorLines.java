package com.gmail.vsyniakin.mediators;

import com.gmail.vsyniakin.creators.QueryLineCreator;
import com.gmail.vsyniakin.creators.WaitingTimeLineCreator;
import com.gmail.vsyniakin.lines.AbstractLine;
import com.gmail.vsyniakin.lines.QueryLine;
import com.gmail.vsyniakin.lines.WaitingTimeLine;

public class MediatorLines implements Mediator {

	private int count;
	
	// Contains all line
	private AbstractLine[] lines;

	public MediatorLines(String input) {
		super();
		init(input);
	}
	
	// parsing input String to array of AbstractLine objects 
	private final void init(String str) {
		
		String[] inputLines = str.split("\r\n");
		this.count = Integer.parseInt(inputLines[0]);
		this.lines = new AbstractLine[count];
		
		QueryLineCreator queryCreator = new QueryLineCreator();
		WaitingTimeLineCreator wtlCreator = new WaitingTimeLineCreator();

		for (int i = 1; i < inputLines.length; i++) {
			char identifier = inputLines[i].charAt(0);
			switch (identifier) {
			case WaitingTimeLine.IDENTIFIER:
				this.lines[i - 1] = wtlCreator.factoryMethod(inputLines[i]);
				break;
			case QueryLine.IDENTIFIER:
				this.lines[i - 1] = queryCreator.factoryMethod(inputLines[i]);
				break;
			}
		}
	}

	/* verify WaitingTimeLine with regular expression @param - AbstractLine queryLine.getData()
	 * and try takes result time on WaitingTimeLine object - method getTime(AbstractLine queryLine);
	 * method getTime(AbstractLine queryLine); - return 0 if date is failed verification
	 *  */
	public int getTime(AbstractLine queryLine) {
		int sum = 0;
		int countLines = 0;
		for (int i = 0; i < lines.length; i++) {
			if ((lines[i].getIdentifier() == WaitingTimeLine.IDENTIFIER)
					&& (lines[i].getData().matches(queryLine.getData()))) {
				int resultLine = lines[i].getTime(queryLine);
				if (resultLine > 0) {
					sum += resultLine;
					countLines++;
				}
			}
		}
		if (countLines > 0) {
			return sum / countLines;
		}
		return 0;
	}
	
	@Override
	public String getResult() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].getIdentifier() == QueryLine.IDENTIFIER) {
				int resultQuery = getTime(lines[i]);
				if (resultQuery != 0) {
					result.append(resultQuery).append("\r\n");
				} else {
					result.append("-").append("\r\n");
				}
			}
		}
		return result.toString();
	}
}
