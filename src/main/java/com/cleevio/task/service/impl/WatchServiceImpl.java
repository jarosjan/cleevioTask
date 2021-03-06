package com.cleevio.task.service.impl;

import com.cleevio.task.model.Watch;
import com.cleevio.task.repository.WatchRepository;
import com.cleevio.task.service.WatchService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WatchServiceImpl implements WatchService {
    private final WatchRepository watchRepository;


    @Override
    public Watch saveWatch(Watch watch) {
        validateWatchAttributes(watch);

        watchRepository.save(watch);

        return new Watch();
    }

    private void validateWatchAttributes(Watch watchDto) {
        if (StringUtils.isBlank(watchDto.getDescription()) || StringUtils.isBlank(watchDto.getTitle())) {
            throw new IllegalArgumentException("Some of attributes are not present or are invalid");
        }
    }
}