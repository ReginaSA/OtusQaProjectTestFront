package qa.stub;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.boot.SpringApplication.run;

@RestController
@SpringBootApplication
public class StubServer {
    public static void main(String[] args) {
        System.getProperties().put( "server.port", 8080 );
        run(StubServer.class, args);
    }
}