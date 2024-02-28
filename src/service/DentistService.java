package service;

import dao.IDAO;
import dao.implementation.DentinstDAOH2;
import model.Dentist;


import java.util.List;

public class DentistService {

    private IDAO<Dentist> dentistIDAO;

    public DentistService() {
        this.dentistIDAO = new DentinstDAOH2();
    }

    public Dentist saveDentist(Dentist d){
        return dentistIDAO.save(d);
    }

    public List<Dentist> searchAll(){
        return dentistIDAO.searchAll();
    }

    public IDAO<Dentist> getDentistIDAO() {
        return dentistIDAO;
    }

    public void setDentistIDAO(IDAO<Dentist> dentistIDAO) {
        this.dentistIDAO = dentistIDAO;
    }
}
