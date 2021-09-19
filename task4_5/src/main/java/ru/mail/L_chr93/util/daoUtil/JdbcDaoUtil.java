package ru.mail.L_chr93.util.daoUtil;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.mail.L_chr93.connectionPool.ConnectionPool;

public class JdbcDaoUtil {
    private ConnectionPool pool;

    public Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public Long getId(String sql) {
        Long id = null;
        try (Connection con = getConnection();
                Statement stmnt = con.createStatement();
                ResultSet rs = stmnt.executeQuery(sql)) {
            if (rs.next()) {
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public <T> T selectOne(String sql, RowMap<T> rowMap, Object... args) {
        T obj = null;
        try (Connection con = getConnection(); PreparedStatement stmnt = con.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                stmnt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = stmnt.executeQuery()) {
                if (rs.next()) {
                    obj = rowMap.rowMap(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public <T> List<T> selectList(String sql, RowMap<T> rowMap, Object... args) {
        List<T> objs = new ArrayList<>();
        try (Connection con = getConnection(); PreparedStatement stmnt = con.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                stmnt.setObject(i + 1, args[i]);
            }
            try (ResultSet rs = stmnt.executeQuery()) {
                while (rs.next()) {
                    objs.add(rowMap.rowMap(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objs;
    }

    public <T> boolean update(String sql, Object... args) {
        boolean val = false;
        try (Connection con = getConnection(); PreparedStatement stmnt = con.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                stmnt.setObject(i + 1, args[i]);
            }
            val = stmnt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }
}
