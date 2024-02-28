package dao.implementation;

import dao.IDAO;
import model.Dentist;

import java.util.ArrayList;
import java.util.List;



public class DentistDAOList implements IDAO<Dentist>{
    List<Dentist> listDentist = new ArrayList<>();

    @Override
    public Dentist save(Dentist dentist){
        listDentist.add(dentist);
        return dentist;
    }

    @Override
    public List<Dentist> searchAll() {
        return listDentist;
    }
}
