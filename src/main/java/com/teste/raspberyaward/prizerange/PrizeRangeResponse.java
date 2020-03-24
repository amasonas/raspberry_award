package com.teste.raspberyaward.prizerange;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrizeRangeResponse {
    private String producer;

    private int interval;
    private int previousWin;
    private int followingWin;
}
