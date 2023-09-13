package com.sudo.dev.ComponentScanningDemo.MainContainer.Config;

import com.sudo.dev.ComponentScanningDemo.MainContainer.Common.Coach;
import com.sudo.dev.ComponentScanningDemo.MainContainer.Common.TrackCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrackConfig {
    @Bean("aquatic")
    public Coach trCoach(){
        return new TrackCoach();
    }
}
