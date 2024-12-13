package ru.guu.dz21.ui;

import com.google.inject.Inject;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import ru.guu.dz21.domain.Crypto;

import java.util.List;

public class CryptoView extends ScrollPane {
    public final VBox root;

    @Inject
    public CryptoView(CryptoViewModel viewModel) {

        root = new VBox(10);
        root.setPadding(new Insets(20));

        List<Crypto> cryptoRates = viewModel.getCryptoRates();
        if (cryptoRates != null && !cryptoRates.isEmpty()) {
            for (Crypto crypto : cryptoRates) {
                root.getChildren().add(createCryptoCard(crypto));
            }
        } else {
            root.getChildren().add(new Text("No data available"));
        }
        this.setContent(root);
        this.setFitToWidth(true);
        this.setMaxWidth(600);
        this.setMaxHeight(600);
        this.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        this.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    private HBox createCryptoCard(Crypto crypto) {
        HBox card = new HBox(20);
        card.setPadding(new Insets(15));
        card.setSpacing(10);

        card.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
        card.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        dropShadow.setRadius(5);
        card.setEffect(dropShadow);

        Text name = new Text(crypto.getName());
        name.setFont(Font.font("Arial", 18));
        name.setFill(Color.DARKGREEN);

        Text price = new Text(String.format("%.2f USD", crypto.getPriceUsd()));
        price.setFont(Font.font("Arial", 16));
        price.setFill(Color.DARKGREEN);
        card.getChildren().addAll(name, price);
        return card;
    }

}
