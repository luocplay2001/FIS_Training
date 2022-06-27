package fis.training.criminalsystemmanagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class ApplicationConfig {

    @Bean
    public static ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        System.out.println("password: " + new BCryptPasswordEncoder());
//        return new BCryptPasswordEncoder();
//    }
}
