package com.gmail.vsyniakin.lines;

import java.time.LocalDate;

import com.gmail.vsyniakin.DateAdapter;


/* Line with identifier C:
 * input: C service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date time
 * field String data - contains input line
 * Other fields initialized on request - method initDateAndValue();
 * */
public class WaitingTimeLine extends AbstractLine {
	
	public final static char IDENTIFIER = 'C';
	private LocalDate date;
	private int value;

	public WaitingTimeLine() {
		super();
	}
	
	@Override
	public char getIdentifier() {
		return IDENTIFIER;
	}
	
	// @return - value if field LocalDate date is between "from" and "to" - fields in QueryLine    
	@Override
	public int getTime(AbstractLine queryLine) {
		if (date == null) {
			initDateAndValue();
		}
		if (queryLine.isDate(this.date)){
			return this.value;
		}
		return 0;
	}
	
	@Override
	public boolean isDate(LocalDate date) {
		return false;
	}

	private void initDateAndValue () {
		int indexVal = this.data.lastIndexOf(" ");
		this.value = Integer.parseInt(this.data.substring(indexVal+1, this.data.length()));
		int indexDate = this.data.lastIndexOf(" ", indexVal-1);
		this.date = DateAdapter.stringToDate(this.data.substring(indexDate+1, indexVal));
	}

}
