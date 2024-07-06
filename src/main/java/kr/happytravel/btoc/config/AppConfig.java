package kr.happytravel.btoc.config;

import kr.happytravel.btoc.common.GlobalExceptionHandler;
//import kr.happytravel.btoc.config.FirebaseInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

//    @Bean
//    public FirebaseInitializer firebaseInitializer() {
//        return new FirebaseInitializer();
//    }
}
