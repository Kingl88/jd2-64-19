package by.it.academy.service.Impl;

import by.it.academy.entity.Meeting;
import by.it.academy.repository.MeetingRepository;
import by.it.academy.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;

    @Override
    public Meeting create(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting update(Meeting meeting) {
        if (meeting.getMeetingId() != null && meetingRepository.existsById(meeting.getMeetingId())) {
            return meetingRepository.saveAndFlush(meeting);
        }
        return null;
    }

    @Override
    public Meeting read(Serializable id) {

        return meetingRepository.findById((Long) id).orElse(null);
    }

    @Override
    public void delete(Serializable id) {
        if (meetingRepository.existsById((Long) id))
            meetingRepository.deleteById((Long) id);
    }
}
