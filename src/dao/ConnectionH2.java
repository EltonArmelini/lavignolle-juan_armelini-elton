package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionH2 {

    private final static String DB_NAME = "jdbc:h2:~/clinica";
    private final static String DB_USER = "sa";
    private final static String DB_PASS = "";
    private final static String DB_DRIVER = "org.h2.Driver";
    private static final Logger LOGGER = Logger.getLogger(ConnectionH2.class);

    public static Connection getConnection() throws Exception {
        LOGGER.info("Iniciando conexion a BaseDatos");
        Connection conn = null;

        Class.forName(DB_DRIVER);
        conn = DriverManager.getConnection(DB_NAME,DB_USER,DB_PASS);

        return conn;
    }

    public static void initDataBase(){
        final String SQL_CREATE_TABLE="DROP TABLE IF EXISTS dentistas; CREATE TABLE dentistas (\n" +
                "    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,\n" +
                "    nombre varchar(225) NOT NULL,\n" +
                "    apellido varchar(255) NOT NULL,\n" +
                "    nro_matricula int NOT NULL\n" +
                ");";
        LOGGER.info("Creando tabla dentista");
        try {
            Connection connection = getConnection();
            Statement stm  =connection.createStatement();
            stm.execute(SQL_CREATE_TABLE);
            connection.close();
            LOGGER.info("Cerrando conexion. Tabla creada correctamente! ");
        }catch (Exception e){
            LOGGER.error("Error al crear la tabla dentista. ",e);
        }
    }

}
