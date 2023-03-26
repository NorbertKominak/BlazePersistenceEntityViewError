//package com.example.demo.cat;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class LoadCat {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadCat.class);
//
//    @Bean
//    CommandLineRunner initDatabase(CatRepository repository) {
//
//        return args -> {
//            log.info("Initializing cat " + repository.save(new Cat(10)));
//            log.info("Loading cat " + );
//        };
//    }
//}
