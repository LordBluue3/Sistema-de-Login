package lord.sistema.login.sistemadelogin.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lord.sistema.login.sistemadelogin.gui.utilitarios.Alertas;

import java.util.Objects;


public class ViewController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnLogin;



    @FXML
        public void onBtnLoginAction () {

        String loginn = "Lord@gmail.com";
        String senhaa = "1234";

        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        try {


            if (Objects.equals(login, loginn) && Objects.equals(senha, senhaa)) {
                Alertas.showAlerta("Acesso", "Logado com sucesso!", null, Alert.AlertType.INFORMATION);


            } else {
                Alertas.showAlerta("Erro", "Login ou senha inválido", null, Alert.AlertType.ERROR);

            }

        } catch (NumberFormatException e) {
            Alertas.showAlerta("Erro", "Numero invalido", e.getMessage(), Alert.AlertType.ERROR);
        }
        Stage stage = (Stage) Stage.getWindows();
        stage.close();

    }
}


