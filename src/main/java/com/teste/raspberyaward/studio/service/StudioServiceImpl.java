package com.teste.raspberyaward.studio.service;

import com.teste.raspberyaward.studio.Studio;
import com.teste.raspberyaward.studio.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudioServiceImpl implements StudioService {

    @Autowired
    StudioRepository repository;

    @Override
    public Studio create(Studio studio) {
        return repository.save(studio);
    }

    @Override
    public Studio findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Studio findByNameOrCreate(String name) {
        Studio studio = findByName(name);

        if (studio == null) {
            studio = new Studio();

            studio.setName(name);

            return create(studio);
        }

        return studio;
    }
}
