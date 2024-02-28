import dao.ConnectionH2;
import model.Dentist;
import service.DentistService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //INICIAR TAREAS DE CONTRUCCION DE BASE DE DATOS
        ConnectionH2.initDataBase();

        //PROBAMOS QUE PERSISTA BIEN ;)
        Dentist dentist = new Dentist(1,123,"Juan","Perez");
        DentistService dentistPersist = new DentistService();
        dentistPersist.saveDentist(dentist);

    }
}
