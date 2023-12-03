package com.java.springbootdemo.springBootApp.service.impl;

import com.java.springbootdemo.springBootApp.service.interfaces.Hobby;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class FootballHobbyImpl implements Hobby {
    Logger logger = LoggerFactory.getLogger(FootballHobbyImpl.class);
    @Override
    public String getHobby() {
        return "I love football. Its my hobby";
    }
    @PostConstruct
    public void HobbyClassCreated() {
        //2023-12-03T15:46:37.414+05:30  INFO 68464 --- [  restartedMain] c.j.s.s.service.impl.FootballHobbyImpl   : Hobby Bean has been created
        logger.info("Hobby Bean has been created");
    }
    @PreDestroy
    public void HobbyClassDestroyed() {
        //2023-12-03T15:47:17.709+05:30  INFO 68464 --- [ionShutdownHook] c.j.s.s.service.impl.FootballHobbyImpl   : Hobby Bean is about to be destroyed
        logger.info("Hobby Bean is about to be destroyed");
    }
}
