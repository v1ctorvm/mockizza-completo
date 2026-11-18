package com.mockizza.service;

import com.mockizza.model.Pedido;
import com.mockizza.repository.PedidoRepository;
import java.util.List;

public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public void fazerPedido(Pedido pedido) {
        repository.salvar(pedido);
    }

    public List<Pedido> listarPedidos() {
        return repository.listar();
    }
}
