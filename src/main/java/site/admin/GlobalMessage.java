package site.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class GlobalMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String message;
	@DateTimeFormat(pattern = "MM/dd/YYYY")
	private Date startShowingDate;
	@DateTimeFormat(pattern = "MM/dd/YYYY")
	private Date stopShowingDate;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * @return the startShowingDate
	 */
	public Date getStartShowingDate() {
		return startShowingDate;
	}
	
	/**
	 * @param startShowingDate the startShowingDate to set
	 */
	public void setStartShowingDate(Date startShowingDate) {
		this.startShowingDate = startShowingDate;
	}
	
	/**
	 * @return the stopShowingDate
	 */
	public Date getStopShowingDate() {
		return stopShowingDate;
	}
	
	/**
	 * @param stopShowingDate the stopShowingDate to set
	 */
	public void setStopShowingDate(Date stopShowingDate) {
		this.stopShowingDate = stopShowingDate;
	}
	
	public LocalDateTime getStartShowingDateAtMidnight() {
		LocalTime midnight = LocalTime.MIDNIGHT;
		LocalDate startDate = this.startShowingDate.toInstant().atZone(ZoneId.of("America/New_York")).toLocalDate();
		return LocalDateTime.of(startDate, midnight);
	}
	
	public LocalDateTime getStopShowingDateAtEndOfDay() {
		LocalTime midnight = LocalTime.MIDNIGHT;
		LocalDate stopDate = this.stopShowingDate.toInstant().atZone(ZoneId.of("America/New_York")).toLocalDate();
		return LocalDateTime.of(stopDate, midnight).plusDays(1);
	}
	
	public boolean shouldShowMessage() {
		LocalDateTime start = getStartShowingDateAtMidnight();
		LocalDateTime stop =  getStopShowingDateAtEndOfDay();		
		LocalTime midnight = LocalTime.MIDNIGHT;
		LocalDate today = LocalDate.now(ZoneId.of("America/New_York"));
		LocalDateTime todayMidnight = LocalDateTime.of(today, midnight).plusSeconds(1);
		LocalDateTime endOfToday = LocalDateTime.of(today, midnight).plusDays(1).minusSeconds(1);
		return todayMidnight.isAfter(start) && endOfToday.isBefore(stop);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GlobalMessage [id=" + id + ", message=" + message
				+ ", startShowingDate=" + startShowingDate
				+ ", stopShowingDate=" + stopShowingDate + "]";
	}
}
