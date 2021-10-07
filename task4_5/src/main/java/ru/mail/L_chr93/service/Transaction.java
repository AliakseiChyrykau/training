package ru.mail.L_chr93.service;

public interface Transaction {

    void start() throws TransactionException;

    void commit() throws TransactionException;

    void rollback() throws TransactionException;
}
