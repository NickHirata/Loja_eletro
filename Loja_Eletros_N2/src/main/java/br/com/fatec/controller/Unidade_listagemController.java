/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.UnidadeDAO;
import br.com.fatec.model.Unidade;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author nicol
 */
public class Unidade_listagemController {

    
    @FXML
    private Button btn_voltar;
    
    @FXML
    private TableColumn<Unidade, Integer> tb_codigo;
    @FXML
    private TableColumn<Unidade, String> tb_unidade;
    @FXML
    private TableColumn<Unidade, Void> tb_moreInfo;
    @FXML
    private TableView<Unidade> tb_unidade_lista;

    @FXML
    private void btn_voltar_Click(ActionEvent event) {
    }
    
    

    public void initialize() {
        configureTableColumns();
        exibirDados();
    }

    private void configureTableColumns() {
        tb_codigo.setCellValueFactory(cellData -> cellData.getValue().lojaIDProperty().asObject());

        tb_unidade.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        // Configurar a coluna "Mais Informações" para mostrar um botão em cada linha
        tb_moreInfo.setCellFactory(new Callback<>() {
            @Override
            public TableCell<Unidade, Void> call(TableColumn<Unidade, Void> param) {
                return new TableCell<>() {
                    private final Button btnMoreInfo = new Button("Mais Informações");

                    {
                        btnMoreInfo.setOnAction((event) -> {
                            Unidade unidade = getTableView().getItems().get(getIndex());
                            mostrarMaisInformacoes(unidade);
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnMoreInfo);
                        }
                    }
                };
            }
        });
    }

    private void exibirDados() {

        UnidadeDAO unidadeDAO = new UnidadeDAO(); // Crie uma instância de UnidadeDAO
        List<Unidade> unidadesEncontradas = unidadeDAO.pesquisarLoja("Unidade São Caetano 1");
        tb_unidade_lista.getItems().addAll(unidadesEncontradas);

    }

    private void mostrarMaisInformacoes(Unidade unidade) {
        // Aqui você pode criar um novo Stage ou janela para mostrar mais informações sobre a unidade
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        VBox vbox = new VBox(new Label("Mais Informações: " + unidade.getNome()));
        Scene scene = new Scene(vbox, 200, 100);

        stage.setScene(scene);
        stage.showAndWait();
    }

        
}
    

