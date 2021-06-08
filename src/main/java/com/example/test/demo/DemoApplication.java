package com.example.test.demo;

import com.example.test.demo.service.NotificationService;
import com.example.test.demo.service.PriceComparisonService;
import com.example.test.demo.service.PriceRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Timer;
import java.util.TimerTask;


@SpringBootApplication
public class DemoApplication {
    @Autowired
    static PriceComparisonService priceComparisonService;
    @Autowired
    static PriceRetrieveService priceRetrieveService;
    @Autowired
    static NotificationService notificationService;

    static String priceDifferenceMessage;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        try {

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    try {
                        priceDifferenceMessage = priceComparisonService.comparePrice(priceRetrieveService.getPrice());
                        notificationService.sendNotification(priceDifferenceMessage);
                        notificationService.sendEmail(priceDifferenceMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            Timer timer = new Timer();
            long delay = 3000;
            long intervalPeriod = 10 * 60 * 1000;
            // schedules the task to be run in an interval
            timer.scheduleAtFixedRate(task, delay, intervalPeriod);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
