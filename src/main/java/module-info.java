module spacenews.messb4 {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;


    // FasterXML JSON library
        requires com.fasterxml.jackson.core;
        requires com.fasterxml.jackson.databind;
        requires org.apache.httpcomponents.httpclient;
        requires org.apache.httpcomponents.httpcore;
        opens spacenews.gui to javafx.graphics, javafx.fxml, javafx.controls;
        opens spacenews.domain to com.fasterxml.jackson.databind;
        opens spacenews.api to org.apache.httpcomponents.heepclient,javafx.fxml ;

    exports spacenews.gui;


}