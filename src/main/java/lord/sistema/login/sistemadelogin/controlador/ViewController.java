package lord.sistema.login.sistemadelogin.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lord.sistema.login.sistemadelogin.gui.utilitarios.Alertas;
import org.json.simple.JSONObject;

import java.util.Objects;


public class ViewController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private int contagem = 1;

    @FXML
        public void onBtnLoginAction () {

        //Login e senha
        String loginn = "Lord@gmail.com";
        String senhaa = "1234";

            // Pegando o login e senha que o usuario digitar no textField
            JSONObject json = new JSONObject();

            String login = txtLogin.getText();
            String senha = txtSenha.getText();

            json.put("email",login);
            json.put("senha",senha);
            System.out.println(json);

            //contador para se a pessoa errar a senha 3x fechar a aplicação
            if(contagem == 3 ){
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.close();
            }

            try {
                //se a senha e login forem iguais a da variaveis senhaa e loginn login valido!
            if (Objects.equals(login, loginn) && Objects.equals(senha, senhaa)) {
                Alertas.showAlerta("Acesso", "Logado com sucesso!", null, Alert.AlertType.INFORMATION);
            } else {
                Alertas.showAlerta("Erro", "Login ou senha inválido", null, Alert.AlertType.ERROR);
                contagem++; //se ele errar a senha vai ter incrementada 1 numero a variavel contagem
            }
            } catch (NumberFormatException e) {
                Alertas.showAlerta("Erro", "Numero invalido", e.getMessage(), Alert.AlertType.ERROR);
            }
    }
}


