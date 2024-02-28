package dao.implementation;


import dao.ConnectionH2;
import dao.IDAO;
import model.Dentist;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DentinstDAOH2 implements IDAO<Dentist> {
    // SQL QUERIES FOR THIS CLASS IMPLEMENTATION
    String SQL_CREATE = "INSERT INTO dentistas(nombre,apellido,nro_matricula) VALUES(?,?,?);";
    String SQL_READ_ALL = "SELECT * FROM dentistas;";
    private static final Logger LOGGER = Logger.getLogger(DentinstDAOH2.class);

    @Override
    public Dentist save(Dentist dentist){
        Connection db_conn = null;
        LOGGER.info("Insertando nuevo registro....");
        try {
            db_conn = ConnectionH2.getConnection();
            PreparedStatement pst = db_conn.prepareStatement(SQL_CREATE);

            db_conn.setAutoCommit(false);
            pst.setString(1,dentist.getName());
            pst.setString(2, dentist.getSurname());
            pst.setInt(3,dentist.getRegNumber());


            pst.execute();
            db_conn.setAutoCommit(true);
            db_conn.close();
            LOGGER.info("Conexion cerrada. Registro insertado correctamente!");

        }catch (Exception e){
            LOGGER.error("Ocurrio un error al ejecutar la sentencia SQL",e);
            try {
                if (db_conn != null) {
                    db_conn.rollback(); // Hacer rollback en caso de excepción
                }
            } catch (SQLException rollbackException) {
                LOGGER.error("Error al hacer rollback", rollbackException);
            }
        }
        return dentist;
    }
    @Override
    public List<Dentist> searchAll() {
        Connection db_conn = null;
        List<Dentist> dentists = new ArrayList<>();
        LOGGER.info("Listando todos los registros....");
        try {
            db_conn = ConnectionH2.getConnection();
            PreparedStatement pst = db_conn.prepareStatement(SQL_READ_ALL);
            ResultSet result = pst.executeQuery();
            while (result.next()){
                int idDentist  = result.getInt("id");
                String nameDentist  = result.getString("nombre");
                String surnameDentist  = result.getString("apellido");
                int regNumberDentist  = result.getInt("nro_matricula");
                Dentist dent = new Dentist(idDentist,regNumberDentist,nameDentist,surnameDentist);
                dentists.add(dent);
            }
            db_conn.close();
            LOGGER.info("Conexion cerrada. Registro recuperados correctamente!");
        }catch (Exception e){
            LOGGER.error("Ocurrio un error al ejecutar la sentencia SQL",e);
        }
        return dentists;
    }
}
