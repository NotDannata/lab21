package ru.guu.dz21.ui;

import com.google.inject.Inject;
import ru.guu.dz21.domain.Crypto;
import ru.guu.dz21.domain.GetCryptoUseCase;

import java.util.List;

public class CryptoViewModel {
    private final GetCryptoUseCase getCryptoUseCase;
    private List<Crypto> cryptoRates;

    @Inject
    public CryptoViewModel(GetCryptoUseCase getCryptoUseCase) {
        this.getCryptoUseCase = getCryptoUseCase;
        loadCryptoRates();
    }

    private void loadCryptoRates() {
        cryptoRates = getCryptoUseCase.getCryptoRates();
        System.out.println("Loaded crypto rates: " + cryptoRates);
    }

    public List<Crypto> getCryptoRates() {
        return cryptoRates;
    }
}
