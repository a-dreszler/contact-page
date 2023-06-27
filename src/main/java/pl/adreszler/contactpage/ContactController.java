package pl.adreszler.contactpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ContactController {

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/kontakt")
    String contact() {
        return "contact";
    }
}
