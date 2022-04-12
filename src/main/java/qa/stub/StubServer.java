package qa.stub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.boot.SpringApplication.run;

@RestController
@SpringBootApplication
public class StubServer {
    public static void main(String[] args) {
        System.getProperties().put( "server.port", 8081 );
        run(StubServer.class, args);
    }
}