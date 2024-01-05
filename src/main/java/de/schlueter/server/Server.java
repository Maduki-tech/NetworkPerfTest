package de.schlueter.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello_world
 */
@RestController
public class Server {
    @GetMapping("/")
    public String hello() {
        return "Hello David!";
    }
}
