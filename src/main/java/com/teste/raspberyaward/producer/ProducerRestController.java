package com.teste.raspberyaward.producer;

import com.teste.raspberyaward.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producer")
public class ProducerRestController {

    @Autowired
    private ProducerService service;

    @GetMapping()
    public List<Producer> getProducers() {

        return service.findAll();
    }

    @GetMapping("prize_range")
    public void prizeRange() {

    }

    @PostMapping()
    public Producer create(@RequestBody Producer producer) {

        return service.create(producer);
    }
}
