package com.gmail.vsyniakin.lines;

import java.time.LocalDate;

/* Line with identifier D:
 * input: D service_id[.variation_id] question_type_id[.category_id.[sub-category_id]] P/N date_from[-date_to]
 * inherited field String data - contains regular expression to matches with Line C, template:
 * 		C.* service_id[.variation_id].* question_type_id[.category_id.[sub-category_id]].* P/N.*
 * field LocalDate from - date_from
 * field LocalDate to - [-date_to] (if [-date_to] == null --> LocalDate.now())
 * */

public class QueryLine extends AbstractLine{
	public final static char IDENTIFIER = 'D';
	private LocalDate from;
	private LocalDate to;
	
	public QueryLine() {
		super();
	}
		
	@Override
	public char getIdentifier() {
		return IDENTIFIER;
	}

	@Override
	public int getTime(AbstractLine compositeLines) {
		return 0;
	}

	//@param date - parameter from WaitingTimeLine
	@Override
	public boolean isDate(LocalDate date) {
		if ((date.isEqual(from) || date.isAfter(from)) 
				&& (date.isBefore(to))) {
			return true;
		}
		return false;
	}
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public void setTo(LocalDate to) {
		this.to = to;
	}
	
	
	
}
