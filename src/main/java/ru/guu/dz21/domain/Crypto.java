package ru.guu.dz21.domain;

public class Crypto {
    public String name;
    public double priceUsd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    @Override
    public String toString() {
        return name + ": " + priceUsd + " UDS";
    }
}
