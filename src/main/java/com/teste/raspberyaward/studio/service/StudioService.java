package com.teste.raspberyaward.studio.service;

import com.teste.raspberyaward.studio.Studio;

public interface StudioService {

    Studio create(Studio studio);

    Studio findByName(String name);

    Studio findByNameOrCreate(String name);
}
