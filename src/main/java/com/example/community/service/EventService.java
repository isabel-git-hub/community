package com.example.community.service;

import com.example.community.com.Search;
import com.example.community.dto.EventDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EventService {
    List<EventDto> getAllEvents();

    EventDto getEventById(Long id);

    void saveEvent(EventDto event);

    void deleteEvent(Long id);

    void incrementHitCount(Long id);

    Page<EventDto> getEventsWithPaging(Search search);

    int getTotalEventCount();

}
