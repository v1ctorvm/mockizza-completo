package com.mockizza;

import com.mockizza.model.Pedido;
import com.mockizza.repository.PedidoRepository;
import com.mockizza.service.PedidoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    @Test
    @DisplayName("Deve enviar o pedido ao repositório para salvar")
    void shouldSaveOrder() {
        // Arrange
        Pedido pedido = new Pedido("Margherita");

        // Act
        service.fazerPedido(pedido);

        // Assert
        verify(repository).salvar(pedido);
    }

    @Test
    @DisplayName("Deve retornar os pedidos do repositório")
    void shouldListOrders() {
        // Arrange
        List<Pedido> pedidos = List.of(new Pedido("Calabresa"));
        when(repository.listar()).thenReturn(pedidos);

        // Act
        List<Pedido> resultado = service.listarPedidos();

        // Assert
        verify(repository).listar();
        assertEquals(pedidos, resultado);
    }
}
