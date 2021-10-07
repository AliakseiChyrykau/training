package ru.mail.L_chr93.service.serviceImpl;

import ru.mail.L_chr93.service.Transaction;

public class BaseService {

    private Transaction trsnsaction;

    public Transaction getTransaction() {
        return trsnsaction;
    }

    public void setTransaction(Transaction trsnsaction) {
        this.trsnsaction = trsnsaction;
    }
}
