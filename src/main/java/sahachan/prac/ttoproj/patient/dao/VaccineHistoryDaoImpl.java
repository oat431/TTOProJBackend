package sahachan.prac.ttoproj.patient.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sahachan.prac.ttoproj.patient.entity.VaccineHistory;
import sahachan.prac.ttoproj.patient.repository.VaccineHistoryRepository;

@Repository
public class VaccineHistoryDaoImpl implements VaccineHistoryDao {

    @Autowired
    VaccineHistoryRepository vaccineHistoryRepository;

    @Override
    public VaccineHistory addVaccineHistory(VaccineHistory vaccineHistory) {
        return vaccineHistoryRepository.save(vaccineHistory);
    }
}
