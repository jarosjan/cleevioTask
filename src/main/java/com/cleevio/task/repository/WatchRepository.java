package com.cleevio.task.repository;

import com.cleevio.task.model.Watch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepository extends CrudRepository<Watch, Long> {
}
