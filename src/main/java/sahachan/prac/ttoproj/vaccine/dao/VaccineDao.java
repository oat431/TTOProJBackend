package sahachan.prac.ttoproj.vaccine.dao;

import sahachan.prac.ttoproj.vaccine.entity.Vaccine;

import java.util.List;

public interface VaccineDao {
    Vaccine addVaccine(Vaccine vaccine);
    Vaccine getVaccine(String codeName);
    List<Vaccine> getAllVaccines();
}
