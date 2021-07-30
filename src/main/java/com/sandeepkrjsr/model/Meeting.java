package com.sandeepkrjsr.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Meeting")
public @Data class Meeting {
	
	@Id
	@GeneratedValue
	private Integer pkMeetingId;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Integer duration;
	
	public Meeting() {}
	
	public Meeting(LocalDateTime dateTime, int duration) {
		this.startTime = dateTime;
		this.endTime = dateTime.plusMinutes(duration);
		this.duration = duration;
	}

}
