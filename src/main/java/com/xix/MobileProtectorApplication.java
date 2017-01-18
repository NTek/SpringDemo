package com.xix;

import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MobileProtectorApplication extends SpringBootServletInitializer {
    static Logger logger = Logger.getLogger(String.valueOf(MobileProtectorApplication.class));

    public static void main(String[] args) {
        SpringApplication.run(MobileProtectorApplication.class, args);

        logger.info(com.xix.util.Banner.mainBanner);
        logger.info("\n\n\n");
    }
}
