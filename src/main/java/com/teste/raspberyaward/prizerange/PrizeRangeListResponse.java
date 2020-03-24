package com.teste.raspberyaward.prizerange;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PrizeRangeListResponse {

    List<PrizeRangeResponse> min;
    List<PrizeRangeResponse> max;
}
