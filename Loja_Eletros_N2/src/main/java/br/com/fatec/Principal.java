package br.com.fatec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.com.fatec.DAO.ConexaoBanco;
import java.sql.Connection;

import java.io.IOException;

/**
 * JavaFX Principal
 */
public class Principal extends Application {

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Principal.scene = scene;
    }

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("view/MenuView"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
       // launch();
        
         // Testando a conexão com o banco de dados
        Connection conexao = ConexaoBanco.conectar();
        
        // Verificando se a conexão foi bem-sucedida
        if (conexao != null) {
            System.out.println("Conexão bem-sucedida. Você está conectado ao banco de dados!");
            
            // operaçoes com o banco
            // ...
            
            // Fechando a conexão após a conclusão das operações
            ConexaoBanco.desconectar(conexao);
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }
        
        
    }

}