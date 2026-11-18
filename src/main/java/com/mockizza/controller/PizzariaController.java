package com.mockizza.controller;

import com.mockizza.model.Pedido;
import com.mockizza.service.PedidoService;
import com.mockizza.view.PizzariaView;

public class PizzariaController {
    public PizzariaController(PizzariaView view, PedidoService service) {
        view.aoFazerPedido(pizza -> {
            service.fazerPedido(new Pedido(pizza));
            view.mostrarPedidos(service.listarPedidos());
            view.mostrarConfirmacao(pizza);
        });
    }
}
