package com.sandeepkrjsr.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandeepkrjsr.service.MeetingService;
import com.sandeepkrjsr.utils.DateTimeUtils;
import com.sandeepkrjsr.utils.InputValidation;

@RestController
@RequestMapping("meeting")
public class MeetingController {
	
	@Autowired
	MeetingService service;
	
	/**
	 * This api will book the slot based on time and duration.
	 * 1. Check for input validations
	 * 2. Check for slot availability
	 * 3. Book the slot
	 * @param meetingTime
	 * @param duration
	 * @return String
	 */
	@GetMapping("/book")
	public String bookMeeting(@RequestParam String meetingTime, @RequestParam int duration) {
		LocalDateTime dateTime = DateTimeUtils.getDateTime(meetingTime);
		if(!InputValidation.validateDuration(duration)
				|| !InputValidation.validateDateTime(dateTime))
			return "Invalid Input";
		boolean isBooked = service.bookMeeting(dateTime, duration);
		return isBooked ? "Meeting Scheduled" : "Slot is not available";
	}
	
	/**
	 * Given a meeting request, this api will find out all participants have meeting conflicts
	 * 1. Check for input validations
	 * 2. Check for meeting conflict
	 * 3. Return the participants
	 * @param time
	 * @return String
	 */
	@GetMapping("/conflicts")
	public String meetingConflict(@RequestParam String time) {
		LocalDateTime startTime = DateTimeUtils.getDateTime(time);
		if(!InputValidation.validateDateTime(startTime)) return "Invalid Input";
		List<Integer> participants = service.meetingConflicts(startTime);
		return participants.toString();
	}

}
