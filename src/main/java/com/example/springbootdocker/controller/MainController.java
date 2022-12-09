package com.example.springbootdocker.controller;

import com.example.springbootdocker.entity.RequestLog;
import com.example.springbootdocker.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    private static Integer count = 0;

    @RequestMapping("/")
    public Integer getCount() {
        return count;
    }

    @RequestMapping("/stat")
    public Integer getStat() {
        return ++count;
    }

    @RequestMapping("/about")
    public String getAbout(@RequestHeader(value = "User-Agent") String userAgent) {
        Date requestDate = new Date();
        String html = "<h3>Hello!!</h3>" +
        "<b>Hostname:</b>%s<br/>";

        String hostName = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostName = inetAddress.getHostName();
        } catch (UnknownHostException ignored) {

        }

        RequestLog requestLog = mainService.logRequest(requestDate, userAgent, count);
        return String.format(html, hostName /*+ requestLog*/);
    }

}
