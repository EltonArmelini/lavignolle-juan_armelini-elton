import model.Dentist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.DentistService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDentistDAO {
    @Test
    public void casoGeneral(){
        //CREACION E INSERCCION DE REGISTROS EN LA BD.

        //Objetos
        Dentist dentist1 = new Dentist(1,123,"Juan","Pere");
        Dentist dentist2 = new Dentist(2, 1234, "Pedro", "Fernandez");
        Dentist dentist3 = new Dentist(3, 1235, "Jorge","Carlos");

        //Inserccion a la BD
        DentistService dentistService = new DentistService();
        dentistService.saveDentist(dentist1);
        dentistService.saveDentist(dentist2);
        dentistService.saveDentist(dentist3);
        dentistService.saveDentist(dentist3);

        //REALIZAMOS LOS ASSERTS con los
        List<Dentist> resulDentist = dentistService.searchAll();
        Assertions.assertEquals(dentist1.getRegNumber(),resulDentist.get(1).getRegNumber());
        Assertions.assertEquals(dentist2.getRegNumber(),resulDentist.get(2).getRegNumber());
        Assertions.assertEquals(dentist3.getRegNumber(),resulDentist.get(3).getRegNumber());

    }

}
