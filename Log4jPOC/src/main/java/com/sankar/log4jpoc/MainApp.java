package com.sankar.log4jpoc;

import org.apache.log4j.Logger;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainApp {

    final static Logger logger = Logger.getLogger(MainApp.class);
    static Robot robot;
    static Random random;


    public static void main(String[] args) throws AWTException{
        robot = new Robot();
        random = new Random();
        final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(MainApp::verifyLogging,0, 4, TimeUnit.MINUTES);
    }

    public static void verifyLogging(){
        logger.error("Error Occured in MainApp at"+System.currentTimeMillis());
        robot.mouseMove(random.nextInt() % 640, random.nextInt() %480);
    }
}
