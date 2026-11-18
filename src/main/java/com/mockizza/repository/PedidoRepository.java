package com.mockizza.repository;

import com.mockizza.model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepository {
    private final ArrayList<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> listar() {
        return List.copyOf(pedidos);
    }
}
