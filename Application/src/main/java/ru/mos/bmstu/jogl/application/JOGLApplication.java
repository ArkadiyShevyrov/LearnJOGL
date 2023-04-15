package ru.mos.bmstu.jogl.application;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.mos.bmstu.jogl.view.viewcontrol.service.InitService;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@ComponentScan({"ru.mos.bmstu.jogl"})
public class JOGLApplication implements CommandLineRunner {

    @NonNull
    private InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(JOGLApplication.class, args);
    }

    @Override
    public void run(String... args) {
        initService.start();
    }
}
