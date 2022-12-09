package com.example.springbootdocker.repository;

import com.example.springbootdocker.entity.RequestLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLogRepository extends CrudRepository<RequestLog, Long> {
}
