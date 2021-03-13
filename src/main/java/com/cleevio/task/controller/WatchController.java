package com.cleevio.task.controller;

import com.cleevio.task.model.Watch;
import com.cleevio.task.service.WatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/watch")
public class WatchController {

    private final WatchService watchService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Watch> createWatch(@RequestBody @Valid Watch watch) {

        return new ResponseEntity<>(watchService.saveWatch(watch), HttpStatus.CREATED);
    }
}