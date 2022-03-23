module lord.sistema.login.sistemadelogin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires json.simple;


    opens lord.sistema.login.sistemadelogin to javafx.fxml;
    exports lord.sistema.login.sistemadelogin;
    exports lord.sistema.login.sistemadelogin.controlador;
    opens lord.sistema.login.sistemadelogin.controlador to javafx.fxml;
}