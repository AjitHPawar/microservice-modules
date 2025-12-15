package com.function.config;


import com.function.dto.NotificationDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class FunctionConfig {


    @Bean
    public Function<NotificationDto,NotificationDto> function(){
        return notificationDto -> notificationDto;
    }

    @Bean
    public Supplier<NotificationDto> supplier(){
        return () -> new NotificationDto("Supplier-Heading","Description");
    }

    @Bean
    public Consumer<NotificationDto> consumer(){
        return notificationDto -> System.out.println(notificationDto);
    }

}
