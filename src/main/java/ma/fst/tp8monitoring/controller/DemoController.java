package ma.fst.tp8monitoring.controller;

import ma.fst.tp8monitoring.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "Application TP8 Monitoring démarrée";
    }

    @GetMapping("/process")
    public String process() {
        return service.processData();
    }
}