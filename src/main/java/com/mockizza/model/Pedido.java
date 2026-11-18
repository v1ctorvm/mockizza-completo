package com.mockizza.model;

import java.time.LocalDateTime;

public record Pedido(String pizza, LocalDateTime feitoEm) {
    public Pedido(String pizza) {
        this(pizza, LocalDateTime.now());
    }
}
