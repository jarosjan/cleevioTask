package com.cleevio.task.controller;

import com.cleevio.task.model.Watch;
import com.cleevio.task.service.WatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/watch")
public class WatchController {

    private final WatchService watchService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Watch> createWatch(@RequestBody Watch watchDto) {

        return new ResponseEntity<>(watchService.saveWatch(watchDto), HttpStatus.CREATED);
    }
}