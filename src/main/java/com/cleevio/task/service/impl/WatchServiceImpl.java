package com.cleevio.task.service.impl;

import com.cleevio.task.model.Watch;
import com.cleevio.task.repository.WatchRepository;
import com.cleevio.task.service.WatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WatchServiceImpl implements WatchService {

    private final WatchRepository watchRepository;

    @Override
    public Watch saveWatch(Watch watch) {
        return watchRepository.save(watch);
    }
}