package ru.mail.L_chr93.connectionPool;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool implements Closeable {

    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool connectionPool = null;

    private int maxConnection;
    private String jdbcUrl;
    private String login;
    private String password;

    private List<PooledConnection> free = new ArrayList<>();
    private List<PooledConnection> used = new ArrayList<>();

    private ConnectionPool() {
        ResourceBundle mappingProps = ResourceBundle.getBundle("configConnect");
        int minConnection = Integer.parseInt(mappingProps.getString("minConnection"));
        maxConnection = Integer.parseInt(mappingProps.getString("maxConnection"));
        jdbcUrl = mappingProps.getString("jdbcUrl");
        login = mappingProps.getString("login");
        password = mappingProps.getString("password");
        for (int i = 0; i < minConnection; i++) {
            free.add(getPooledConnection());
        }
    }

    public synchronized static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
            return connectionPool;
        } else {
            return connectionPool;
        }
    }

    private PooledConnection getPooledConnection() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection con = DriverManager.getConnection(jdbcUrl, login, password);
            PooledConnection pcon = new PooledConnection(this, con);
            return pcon;
        } catch (SQLException e) {
            logger.error("Не удалось подключится к базе данных");
            throw new RuntimeException(e);
        }
    }

    public synchronized Connection getConnection() {
        PooledConnection pcon;
        if (!free.isEmpty()) {
            pcon = free.remove(free.size() - 1);
        } else if (used.size() < maxConnection) {
            pcon = getPooledConnection();
        } else {
            logger.warn("Достигнуто максимальное количество подключений к базе данных");
            throw new RuntimeException("Достигнуто максимальное количество подключений к базе данных");
        }
        return pcon;
    }

    public void freeConnection(PooledConnection pcon) {
        used.remove(pcon);
        free.add(pcon);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override
    public void close() throws IOException {
        try {
            for (PooledConnection pooledConnection : free) {
                pooledConnection.getConnection().close();
            }
            for (PooledConnection pooledConnection : used) {
                pooledConnection.getConnection().close();
            }
        } catch (Exception e) {
            logger.warn("Не удалось закрыть все подключения к базе данных");
            System.out.println(e.getMessage());
        }
    }
}
