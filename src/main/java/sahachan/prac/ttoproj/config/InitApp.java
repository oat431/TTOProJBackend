package sahachan.prac.ttoproj.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import sahachan.prac.ttoproj.vaccine.entity.Vaccine;
import sahachan.prac.ttoproj.vaccine.repository.VaccineRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final VaccineRepository vaccineRepository;


    Vaccine az,jj,pz,md,sv,nv;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        double startTime = System.currentTimeMillis();
        log.info("start adding mock data");
        addVaccine();
        log.info("mock data added in ({} seconds)", (System.currentTimeMillis() - startTime) / 1000);
    }

    private void addVaccine(){
        az = vaccineRepository.save(
                Vaccine.builder()
                        .fullName("AstraZeneca")
                        .codeName("AZ")
                        .build()
        );
        jj = vaccineRepository.save(
                Vaccine.builder()
                        .fullName("Johnson & Johnson's Janssen")
                        .codeName("JJ")
                        .build()
        );
        pz = vaccineRepository.save(
                Vaccine.builder()
                        .fullName("Pfizer")
                        .codeName("PZ")
                        .build()
        );
        md = vaccineRepository.save(
                Vaccine.builder()
                        .fullName("Modena")
                        .codeName("MD")
                        .build()
        );
        sv = vaccineRepository.save(
                Vaccine.builder()
                        .fullName("Sinovac")
                        .codeName("SV")
                        .build()
        );
        nv = vaccineRepository.save(
                Vaccine.builder()
                        .fullName("Novavax")
                        .codeName("NV")
                        .build()
        );
    }
}
