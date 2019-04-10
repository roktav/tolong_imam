package com.propensi.winscore;

import com.propensi.winscore.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        FileStorageProperties.class
})
@SpringBootApplication
public class WinscoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinscoreApplication.class, args);
    }

}
