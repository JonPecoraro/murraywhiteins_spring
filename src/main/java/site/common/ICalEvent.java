package site.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * A class for iCal events that can be used in email attachments
 */
public class ICalEvent {
	private String title;
	private String description;
	private Date start;
	private Date end;
	
	public ICalEvent(String title, String description, Date start, Date end) {
		this.title = title;
		this.description = description;
		this.start = start;
		this.end = end;
	}
	
	public String getTitle() { return title; }
	public String getDescription() { return description; }
	public Date getStart() { return start; }
	public Date getEnd() { return end; }

	public void setTitle(String newValue) { this.title = newValue; }
	public void setDescription(String newValue) { this.description = newValue; }
	public void setStart(Date newValue) { this.start = newValue; }
	public void setEnd(Date newValue) { this.end = newValue; }
	
	/*
	 * Creates string in the iCal format from RFC-5545 https://tools.ietf.org/html/rfc5545
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
		String startDateString = dateFormat.format(start);
		String endDateString = dateFormat.format(end);
		String currentDateString = dateFormat.format(new Date());
		String crlf = "\r\n"; // carriage return and line feed
		
		builder.append("BEGIN:VCALENDAR").append(crlf);
		builder.append("VERSION:2.0").append(crlf);
		builder.append("METHOD:REQUEST").append(crlf);
		builder.append("PRODID:~//Murray White Insurance Agency/ICAL file/" + currentDateString).append(crlf);
		builder.append("BEGIN:VEVENT").append(crlf);
		builder.append("UID:" + currentDateString + "@murraywhiteins.com").append(crlf);
		builder.append("DTSTAMP:" + currentDateString).append(crlf);
		builder.append("ORGANIZER;CN=\"Murray White Insurance Agency\":MAILTO:murraywhite@murraymwhiteinc.com").append(crlf);
		builder.append("DTSTART:" + startDateString).append(crlf);
		builder.append("DTEND:" + endDateString).append(crlf);
		builder.append("LOCATION:" + "1911 N Main St, High Point, NC 27262").append(crlf);
		builder.append("SUMMARY:" + this.title).append(crlf);
		builder.append("DESCRIPTION:" + this.description).append(crlf);
		builder.append("BEGIN:VALARM").append(crlf);
		builder.append("TRIGGER:-PT30M").append(crlf);
		builder.append("ACTION:DISPLAY").append(crlf);
		builder.append("DESCRIPTION:" + this.description).append(crlf);
		builder.append("END:VALARM").append(crlf);
		builder.append("END:VEVENT").append(crlf);
		builder.append("END:VCALENDAR").append(crlf);

		return builder.toString();
	}
}