package com.teste.raspberyaward.producer.service;

import com.teste.raspberyaward.producer.Producer;

import java.util.List;

public interface ProducerService {

    Producer create(Producer producer);

    Producer findProducerByName(String name);

    Producer findByNameOrCreate(String name);

    List<Producer> findAll();
}
