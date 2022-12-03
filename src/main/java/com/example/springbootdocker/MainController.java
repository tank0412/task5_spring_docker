package com.example.springbootdocker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class MainController {

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
    public String getAbout() {
        String html = "<h3>Hello!</h3>" +
        "<b>Hostname:</b>%s<br/>";

        String hostName = "";
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostName = inetAddress.getHostName();
        } catch (UnknownHostException ignored) {

        }

        return String.format(html, hostName);
    }

}
