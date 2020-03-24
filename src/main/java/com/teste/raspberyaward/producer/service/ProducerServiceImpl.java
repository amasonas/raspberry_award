package com.teste.raspberyaward.producer.service;

import com.teste.raspberyaward.producer.Producer;
import com.teste.raspberyaward.producer.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository repository;


    @Override
    public Producer create(@Valid Producer producer) {
        producer = repository.save(producer);

        return producer;
    }

    @Override
    public Producer findProducerByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Producer findByNameOrCreate(String name) {
        Producer producer = findProducerByName(name);

        if (producer == null) {
            producer = new Producer();

            producer.setName(name);

            return create(producer);
        }

        return producer;
    }

    @Override
    public List<Producer> findAll() {
        return repository.findAll();
    }

}
