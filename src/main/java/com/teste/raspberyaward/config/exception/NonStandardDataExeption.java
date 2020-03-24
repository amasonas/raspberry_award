package com.teste.raspberyaward.config.exception;

public class NonStandardDataExeption extends Exception {
    public NonStandardDataExeption() {
        super("The data provided in the startup list is different from the parameterized");
    }
}
