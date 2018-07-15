package com.gmail.vsyniakin.creators;

import com.gmail.vsyniakin.lines.AbstractLine;
import com.gmail.vsyniakin.lines.WaitingTimeLine;

public class WaitingTimeLineCreator extends Creator {

	@Override
	public AbstractLine factoryMethod(String line) {
		WaitingTimeLine wtl = new WaitingTimeLine();
		wtl.setData(line);
		return wtl;
	}
	
}
