package com.example.springbootdocker.service;

import com.example.springbootdocker.entity.RequestLog;
import com.example.springbootdocker.repository.RequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MainService {
    @Autowired
    private RequestLogRepository requestLogRepository;
    public RequestLog logRequest(Date requestDate, String userAgent, Integer count) {
        RequestLog requestLog = new RequestLog();
        requestLog.setDate(requestDate);
        requestLog.setCount(count);
        requestLog.setClientInfo(userAgent);
        return requestLogRepository.save(requestLog);
    }
}
