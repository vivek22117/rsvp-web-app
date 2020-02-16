package com.doubledigit.solutions.rsvp.app.config;

import com.doubledigit.solutions.rsvp.app.model.HarvestForm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FarmUpBeanConfig {

    @Bean
    public String projectName() {
        return "FarmUp Harvester";
    }

    @Bean
    public LocalDate localDate(){
        return LocalDate.now();
    }

    @Lazy
    @Bean
    public String webmaster(){
        return "vivekmishra22117@gmail.com";
    }

    @Lazy
    @Bean
    public String tabName() {
        return "FarmUp";
    }

    @Bean
    public List<HarvestForm> dbHarvest() {
        return new ArrayList<HarvestForm>();
    }
}
