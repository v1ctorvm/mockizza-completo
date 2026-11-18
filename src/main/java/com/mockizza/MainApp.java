package com.mockizza;

import com.mockizza.controller.PizzariaController;
import com.mockizza.repository.PedidoRepository;
import com.mockizza.service.PedidoService;
import com.mockizza.view.PizzariaView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        PizzariaView view = new PizzariaView();
        PedidoService service = new PedidoService(new PedidoRepository());
        new PizzariaController(view, service);

        stage.setTitle("Mockizza");
        stage.setScene(new Scene(view, 640, 340));
        stage.setMinWidth(600);
        stage.setMinHeight(320);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
