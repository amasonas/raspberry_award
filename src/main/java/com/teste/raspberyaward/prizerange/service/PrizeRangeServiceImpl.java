package com.teste.raspberyaward.prizerange.service;

import com.teste.raspberyaward.prizerange.PriceRangeRepository;
import com.teste.raspberyaward.prizerange.PrizeRangeFactory;
import com.teste.raspberyaward.prizerange.PrizeRangeListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class PrizeRangeServiceImpl implements PrizeRangeService {

    @Autowired
    PriceRangeRepository repository;

    @Autowired
    PrizeRangeFactory factory;

    @Autowired
    EntityManager entityManager;

    @Override
    public PrizeRangeListResponse getRanges() {
        PrizeRangeListResponse response = new PrizeRangeListResponse();
        int maxInterval = repository.getMaxInterval();
        int minInterval = repository.getMinInterval();

        response.setMax(factory.create(repository.findByInterval(maxInterval)));
        entityManager.clear();
        response.setMin(factory.create(repository.findByInterval(minInterval)));

        return response;
    }
}
