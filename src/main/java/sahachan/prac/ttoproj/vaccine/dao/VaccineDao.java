package sahachan.prac.ttoproj.vaccine.dao;

import sahachan.prac.ttoproj.vaccine.entity.Vaccine;

public interface VaccineDao {
    Vaccine addVaccine(Vaccine vaccine);

    Vaccine getVaccine(String codeName);
}
