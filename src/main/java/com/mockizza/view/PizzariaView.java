package com.mockizza.view;

import com.mockizza.model.Pedido;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PizzariaView extends HBox {
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final ListView<Pedido> historico = new ListView<>();
    private final ToggleGroup pizzas = new ToggleGroup();
    private final Button fazerPedido = new Button("Fazer Pedido");
    private final Label confirmacao = new Label();

    public PizzariaView() {
        super(24);
        setPadding(new Insets(24));
        setStyle("-fx-background-color: white;");

        Label titulo = new Label("Mockizza");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        VBox formulario = new VBox(12, titulo, new Label("Escolha sua pizza"));
        formulario.setMinWidth(240);

        for (String sabor : new String[]{"Margherita", "Calabresa", "Quatro Queijos"}) {
            RadioButton opcao = new RadioButton(sabor);
            opcao.setToggleGroup(pizzas);
            opcao.setUserData(sabor);
            formulario.getChildren().add(opcao);
        }

        fazerPedido.disableProperty().bind(pizzas.selectedToggleProperty().isNull());
        formulario.getChildren().addAll(fazerPedido, confirmacao);

        Label tituloHistorico = new Label("Pedidos");
        tituloHistorico.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        historico.setPlaceholder(new Label("Nenhum pedido ainda"));
        historico.setCellFactory(lista -> new ListCell<>() {
            @Override
            protected void updateItem(Pedido pedido, boolean vazio) {
                super.updateItem(pedido, vazio);
                setText(vazio || pedido == null ? null
                        : pedido.feitoEm().format(FORMATO_HORA) + "  ·  " + pedido.pizza());
            }
        });

        VBox painelHistorico = new VBox(10, tituloHistorico, historico);
        painelHistorico.setMinWidth(220);
        VBox.setVgrow(historico, Priority.ALWAYS);
        HBox.setHgrow(painelHistorico, Priority.ALWAYS);
        getChildren().addAll(formulario, painelHistorico);
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        historico.getItems().setAll(pedidos.reversed());
        historico.scrollTo(0);
    }

    public void aoFazerPedido(Consumer<String> acao) {
        fazerPedido.setOnAction(evento ->
                acao.accept((String) pizzas.getSelectedToggle().getUserData()));
    }

    public void mostrarConfirmacao(String pizza) {
        confirmacao.setText("Pedido confirmado: " + pizza);
    }
}
