package com.sandeepkrjsr.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeepkrjsr.model.Meeting;
import com.sandeepkrjsr.repository.MeetingRepository;

@Service
public class MeetingService {
	
	@Autowired
	MeetingRepository repository;

	/**
	 * This method will check for slot availability 
	 * and book the slot based on time and duration.
	 * TODO 1. Check for slot availability
	 * 2. Book the slot
	 * @param dateTime
	 * @param duration
	 * @return isBooked
	 */
	public boolean bookMeeting(LocalDateTime dateTime, int duration) {
		// TODO : check for slot availability.
		
		Meeting meeting = new Meeting(dateTime, duration);
		repository.save(meeting);
		return true;
	}

	/**
	 * This method will find out all participants have meeting conflicts
	 * 1. Check for meeting conflict
	 * TODO 2. Return the participants
	 * @param dateTime
	 * @return List of participants
	 */
	public List<Integer> meetingConflicts(LocalDateTime time) {
		List<Meeting> meetings = new ArrayList<>();
		repository.findAll().forEach(m -> {
			meetings.add(m);
		});
		List<Integer> conflictMeetingIds = new ArrayList<>();
		meetings.forEach(m -> {
			if((time.isAfter(m.getStartTime()) && time.isBefore(m.getEndTime()))
					|| time.isEqual(m.getStartTime())
					|| time.isEqual(m.getEndTime())) {
				conflictMeetingIds.add(m.getPkMeetingId());
			}
		});
		// TODO 2. Return the participants
		return conflictMeetingIds;
	}


}
