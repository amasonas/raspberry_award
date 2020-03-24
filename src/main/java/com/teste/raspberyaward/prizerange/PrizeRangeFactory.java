package com.teste.raspberyaward.prizerange;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrizeRangeFactory {

    public PrizeRangeResponse create(PrizeRange prizeRange) {
        PrizeRangeResponse response = new PrizeRangeResponse();

        response.setProducer(prizeRange.getProducer().getName());
        response.setFollowingWin(prizeRange.getFollowingWin());
        response.setPreviousWin(prizeRange.getPreviousWin());
        response.setInterval(prizeRange.getInterval());

        return response;
    }

    public List<PrizeRangeResponse> create(List<PrizeRange> prizeRangeList) {
        List<PrizeRangeResponse> responseList = new ArrayList<>();

        prizeRangeList.forEach(prizeRange -> {
            responseList.add(create(prizeRange));
        });

        return responseList;
    }


}
