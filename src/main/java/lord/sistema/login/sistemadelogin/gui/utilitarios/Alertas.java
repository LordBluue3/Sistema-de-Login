package lord.sistema.login.sistemadelogin.gui.utilitarios;

import javafx.scene.control.Alert;

public class Alertas {
    public static void showAlerta(String title, String header, String content, Alert.AlertType type){
        Alert alerta = new Alert(type);
        alerta.setTitle(title);
        alerta.setHeaderText(header);
        alerta.setContentText(content);
        alerta.show();
    }
}
