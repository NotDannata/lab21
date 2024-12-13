package ru.guu.dz21.data;

import ru.guu.dz21.domain.Crypto;

import java.util.List;

public interface CryptoAPI {
    List<Crypto> fetchCryptoRates();
}
