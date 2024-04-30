package fr.massi.models;

public enum Symbol {
    X("X"),O("O");

    public final String stringValue;

    Symbol(String stringValue) {
        this.stringValue = stringValue;
    }
}
