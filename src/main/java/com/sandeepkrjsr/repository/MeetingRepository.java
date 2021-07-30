package com.sandeepkrjsr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sandeepkrjsr.model.Meeting;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Integer>{

}
