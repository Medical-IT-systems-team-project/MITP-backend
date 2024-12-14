package MITP.team.backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public Map<String, String> welcomePage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Witaj w CareTrack API");
        response.put("status", "aktywny");
        response.put("version", "1.0.0");
        return response;
    }
}
