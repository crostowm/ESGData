package com.esg.esgdata.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    public CommandLineReader commandLineReader;

    @Override
    public void run(String... args) throws Exception {
        commandLineReader.run();
    }
}
