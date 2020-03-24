package com.teste.raspberyaward.prizerange;

import com.teste.raspberyaward.prizerange.service.PrizeRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("range_prize")
public class PrizeRangeRestController {

    @Autowired
    PrizeRangeService service;

    @GetMapping
    public PrizeRangeListResponse getPrizeRange() {
        return service.getRanges();
    }
}
