package ru.guu.dz21.app;

import com.google.inject.AbstractModule;
import ru.guu.dz21.data.CryptoAPI;
import ru.guu.dz21.data.CryptoAPIImpl;
import ru.guu.dz21.domain.GetCryptoUseCase;
import ru.guu.dz21.ui.CryptoView;
import ru.guu.dz21.ui.CryptoViewModel;

public class CryptoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(CryptoAPI.class).to(CryptoAPIImpl.class);
        bind(GetCryptoUseCase.class);
        bind(CryptoViewModel.class);
        bind(CryptoView.class);
    }
}
