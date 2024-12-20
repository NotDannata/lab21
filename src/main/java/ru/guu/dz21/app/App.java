package ru.guu.dz21.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.guu.dz21.ui.CryptoView;


public class App extends Application {
    @Override
    public void start(Stage stage) {
        Injector injector = Guice.createInjector(new CryptoModule());
        CryptoView cryptoView = injector.getInstance(CryptoView.class);

        Scene scene = new Scene(cryptoView, 650, 700);
        stage.setTitle("Crypro rates");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
