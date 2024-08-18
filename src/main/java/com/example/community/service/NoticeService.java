package com.example.community.service;

import com.example.community.com.Search;
import com.example.community.dto.NoticeDto;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NoticeService {
    List<NoticeDto> getAllNotices() throws DataAccessException;

    NoticeDto getNoticeById(Long id);

    void writeNotice(NoticeDto noticeDto);

    void updateNotice(NoticeDto noticeDto);

    void deleteNotice(Long id);

    void incrementHitCount(Long id);

    Page<NoticeDto> getNoticesWithPaging(Search search);

    int getTotalNoticeCount();

}
