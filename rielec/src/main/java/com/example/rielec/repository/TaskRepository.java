package com.example.rielec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.rielec.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

	Task findByName(@Param("name") String name);

}