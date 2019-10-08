package project_up;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"project_up", "templates"})
public class Application {

    public static final void main(String[] args) {
    SpringApplication.run(Application.class, args);
    }
}
