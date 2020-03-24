package com.teste.raspberyaward.prizerange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRangeRepository extends JpaRepository<PrizeRange, Long> {

    @Query("select max(e.interval) from PrizeRange e")
    int getMaxInterval();

    @Query("select min(x.interval) from PrizeRange x where x.interval <> 0")
    int getMinInterval();

    List<PrizeRange> findByInterval(int interval);
}
