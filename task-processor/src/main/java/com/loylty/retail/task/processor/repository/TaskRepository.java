package com.loylty.retail.task.processor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.loylty.retail.task.processor.entities.Task;
import com.loylty.retail.task.processor.enums.Status;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
	public List<Task> findByStatusOrderByTaskOrderAsc(Status status);
}
