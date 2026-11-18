package com.mockizza;

import com.mockizza.model.Pedido;
import com.mockizza.repository.PedidoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidoRepositoryTest {

    @Test
    @DisplayName("Deve listar os pedidos na ordem em que foram salvos")
    void shouldListOrdersInInsertionOrder() {

        // Arrange
        PedidoRepository repository = new PedidoRepository();
        Pedido primeiroPedido = new Pedido("Margherita");
        Pedido segundoPedido = new Pedido("Calabresa");

        // Act
        repository.salvar(primeiroPedido);
        repository.salvar(segundoPedido);
        List<Pedido> resultado = repository.listar();

        // Assert
        assertEquals(List.of(primeiroPedido, segundoPedido), resultado);
    }
}
