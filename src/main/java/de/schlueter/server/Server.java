package de.schlueter.server;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello_world
 */
@RestController
public class Server {
    @GetMapping("/")
    ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/add")
    ResponseEntity<String> add(@RequestParam("firstNumber") int firstNumber,
                               @RequestParam("secondNumber") int secondNumber) {
        return new ResponseEntity<>(String.valueOf(firstNumber + secondNumber), HttpStatus.OK);
    }

    @GetMapping("/multiply")
    ResponseEntity<String> multiply(@RequestParam("firstNumber") int firstNumber,
                                    @RequestParam("secondNumber") int secondNumber) {
        return new ResponseEntity<>(String.valueOf(firstNumber * secondNumber), HttpStatus.OK);
    }

    @GetMapping("/parse")
    ResponseEntity<String> parse(@RequestParam("input") String input) {
        char[] inputArray = input.toCharArray();
        List<Character> inputList = new ArrayList<>();
        for (char c : inputArray) {
            inputList.add(c);
            inputList.add('-');
        }

        StringBuilder sb = new StringBuilder();
        for (char c : inputList) {
            sb.append(c);
        }

        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }
}
