package product_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Configuration
public class LoggingConfig {

    @Bean
    public Logger fileLogger() throws IOException {
        Logger logger = Logger.getLogger("ApplicationLogger");

        // Create a FileHandler to log to a specific file

        FileHandler fileHandler = new FileHandler("product_service/src/logs/product_service.log", true); // Append to file
        fileHandler.setLevel(java.util.logging.Level.ALL); // Log all levels logging
        fileHandler.setFormatter(new SimpleFormatter()); // Set formatter, Use a simple text format

        logger.addHandler(fileHandler); // Attach FileHandler to Logger
        logger.setLevel(java.util.logging.Level.ALL); // Log all levels
        return logger;
    }
}
