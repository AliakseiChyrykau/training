package ru.mail.L_chr93.util.daoUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMap<T> {

    T rowMap(ResultSet rs) throws SQLException;
}
