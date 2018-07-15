package com.gmail.vsyniakin.lines;

import java.time.LocalDate;

public abstract class AbstractLine {
	
	protected String data;
	
	public abstract char getIdentifier ();
	public abstract int getTime (AbstractLine line);
	public abstract boolean isDate (LocalDate date);
	
	public String getData() {
		return data;
	}
	public void setData(String lineData) {
		this.data = lineData;
	}
	
}
