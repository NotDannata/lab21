module ru.guu.dz21 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires com.google.guice;
    requires javafx.base;
    requires javafx.graphics;
    requires com.google.errorprone.annotations;
    requires java.desktop;


    exports ru.guu.dz21.app;
    exports ru.guu.dz21.data;
    exports ru.guu.dz21.domain;
    exports ru.guu.dz21.ui;
    exports ru.guu.dz21.utils;

    opens ru.guu.dz21.app to com.google.guice;
    opens ru.guu.dz21.data to com.google.gson, com.google.guice;
    opens ru.guu.dz21.domain to com.google.guice;
    opens ru.guu.dz21.ui to javafx.fxml, com.google.guice;
}