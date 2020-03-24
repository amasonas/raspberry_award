package com.teste.raspberyaward.prizerange;

import com.teste.raspberyaward.producer.Producer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class PrizeRange {
    @Id
    long id;

    @OneToOne
    private Producer producer;

    private int interval;
    private int previousWin;
    private int followingWin;
}
