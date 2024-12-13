package ru.guu.dz21.domain;

import com.google.errorprone.annotations.IncompatibleModifiers;
import com.google.inject.Inject;
import ru.guu.dz21.data.CryptoAPI;

import java.util.List;

public class GetCryptoUseCase {
    private final CryptoAPI cryptoAPI;

    @Inject
    public GetCryptoUseCase(CryptoAPI cryptoAPI){
        this.cryptoAPI = cryptoAPI;
    }

    public List<Crypto> getCryptoRates(){
        return cryptoAPI.fetchCryptoRates();
    }
}
