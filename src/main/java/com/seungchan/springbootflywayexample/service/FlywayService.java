package com.seungchan.springbootflywayexample.service;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FlywayService {

    @PostConstruct
    public void init() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/dbdemo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                        , "root", "hellodb")
                .schemas("dbdemo")
                .baselineOnMigrate(true)
                .cleanDisabled(true)
                .load();
        flyway.migrate();
    }

}
