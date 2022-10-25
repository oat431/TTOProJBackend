package sahachan.prac.ttoproj.vaccine.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.vaccine.entity.Vaccine;
import sahachan.prac.ttoproj.vaccine.repository.VaccineRepository;

import java.util.List;

@Repository
public class VaccineDaoImpl implements VaccineDao {
    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public Vaccine addVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    @Override
    public Vaccine getVaccine(String codeName) {
        return vaccineRepository.findByCodeName(codeName);
    }

    @Override
    public List<Vaccine> getAllVaccines() {
        return vaccineRepository.findAll();
    }

}
