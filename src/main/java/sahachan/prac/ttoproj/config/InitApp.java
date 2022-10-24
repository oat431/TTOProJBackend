package sahachan.prac.ttoproj.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sahachan.prac.ttoproj.admin.entity.Admin;
import sahachan.prac.ttoproj.admin.repository.AdminRepository;
import sahachan.prac.ttoproj.comment.entity.Comment;
import sahachan.prac.ttoproj.comment.repository.CommentRepository;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.doctor.repository.DoctorRepository;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.patient.entity.VaccineHistory;
import sahachan.prac.ttoproj.patient.repository.PatientRepository;
import sahachan.prac.ttoproj.patient.repository.VaccineHistoryRepository;
import sahachan.prac.ttoproj.security.entity.Authority;
import sahachan.prac.ttoproj.security.entity.AuthorityName;
import sahachan.prac.ttoproj.security.entity.Gender;
import sahachan.prac.ttoproj.security.entity.User;
import sahachan.prac.ttoproj.security.repository.AuthorityRepository;
import sahachan.prac.ttoproj.security.repository.UserRepository;
import sahachan.prac.ttoproj.vaccine.entity.Vaccine;
import sahachan.prac.ttoproj.vaccine.repository.VaccineRepository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final VaccineRepository vaccineRepository;
    final UserRepository userRepository;
    final CommentRepository commentRepository;
    final PatientRepository patientRepository;
    final VaccineHistoryRepository vaccineHistoryRepository;
    final DoctorRepository doctorRepository;
    final AdminRepository adminRepository;
    final AuthorityRepository authorityRepository;

    Vaccine az,jj,pz,md,sv,nv;
    User[] users = new User[10];
    Patient[] patients = new Patient[6];
    Doctor[] doctors = new Doctor[2];
    Admin admin;
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        double startTime = System.currentTimeMillis();
        log.info("start adding mock data");
        addVaccine();
        addDoctor();
        addPatient();
        addAdmin();
        addNormalUser();
        addComment();
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
        log.info("vaccine added");
    }

    @Transactional
    void addPatient(){
        Authority patient = Authority.builder().name(AuthorityName.ROLE_PATIENT).build();
        authorityRepository.save(patient);
        for(int i = 0; i < 6; i++){
            patients[i] = Patient.builder()
                    .doctor(doctors[i % 2])
                    .build();
            patientRepository.save(patients[i]);
            users[i] = User.builder()
                            .username("patient" + i)
                            .password(encoder.encode("password" + i))
                            .firstname("firstname" + i)
                            .lastname("lastname" + i)
                            .email("patient" + i + "@patient.com")
                            .gender(i%2==0? Gender.MALE: Gender.FEMALE)
                            .homeTown("Patient town" + i)
                            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                            .birthDate(Timestamp.valueOf(LocalDateTime.of(2000, 1, 1, 0, 0)))
                            .enabled(true)
                            .build();
            users[i].getAuthorities().add(patient);
            users[i].setPatient(patients[i]);
            userRepository.save(users[i]);
        }

        addPatientVaccine();
        log.info("patient added");
    }

    @Transactional
    void addDoctor(){
        Authority doctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();
        authorityRepository.save(doctor);

        for (int i=0;i<2;i++) {
            doctors[i] = Doctor.builder()
                    .hospital("hospital" + i)
                    .build();
            doctorRepository.save(doctors[i]);
            users[i + 6] = User.builder()
                    .username("doctor" + i)
                    .password(encoder.encode("password" + i))
                    .firstname("firstname" + i)
                    .lastname("lastname" + i)
                    .gender(i%2==0? Gender.MALE: Gender.FEMALE)
                    .homeTown("Doctor town" + i)
                    .email("doctor" + i + "@doctor.com")
                    .birthDate(Timestamp.valueOf(LocalDateTime.of(2000, 1, 1, 0, 0)))
                    .enabled(true)
                    .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                    .build();
            users[i + 6].getAuthorities().add(doctor);
            users[i + 6].setDoctor(doctors[i]);
            userRepository.save(users[i + 6]);
        }
        log.info("doctor added");
    }

    @Transactional
    void addPatientVaccine() {
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int temp = rand.nextInt(6) + 1;
            for(int j=0;j<temp;j++) {
                VaccineHistory vaccineHistory = VaccineHistory.builder()
                        .patient(patients[i])
                        .vaccine(getRandomVaccine(rand.nextInt(6)))
                        .vaccineDate(new Timestamp(System.currentTimeMillis()))
                        .build();
                vaccineHistoryRepository.save(vaccineHistory);
            }
        }
        log.info("patient vaccine added");
    }

    private Vaccine getRandomVaccine(int num) {
        return switch (num) {
            case 1 -> jj;
            case 2 -> pz;
            case 3 -> md;
            case 4 -> sv;
            case 5 -> nv;
            default -> az;
        };
    }

    @Transactional
    void addAdmin() {
        Authority adminRole = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        authorityRepository.save(adminRole);

        admin = Admin.builder()
                .build();
        adminRepository.save(admin);

        users[8] = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin1")
                .lastname("admin1")
                .email("admin@admin.com")
                .gender(Gender.NON_BI)
                .homeTown("Admin town")
                .birthDate(Timestamp.valueOf(LocalDateTime.of(2000, 1, 1, 0, 0)))
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .enabled(true)
                .build();
        users[8].getAuthorities().add(adminRole);
        users[8].setAdmin(admin);
        userRepository.save(users[8]);
        log.info("admin added");
    }

    @Transactional
    void addNormalUser(){
        Authority normalUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        authorityRepository.save(normalUser);

        users[9] = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user1")
                .lastname("user1")
                .email("user@user.com")
                .gender(Gender.OTHER)
                .homeTown("user town")
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .birthDate(Timestamp.valueOf(LocalDateTime.of(2000, 1, 1, 0, 0)))
                .enabled(false)
                .build();
        users[9].getAuthorities().add(normalUser);
        userRepository.save(users[9]);
        log.info("normal user added");
    }

    private void addComment(){
        Random patientRand = new Random();
        for(int i=0;i<15;i++){
            Patient pat = patients[patientRand.nextInt(6)];
            Comment comment = Comment.builder()
                    .to(pat)
                    .by(pat.getDoctor())
                    .createWhen(Timestamp.valueOf(LocalDateTime.now()))
                    .updateAt(Timestamp.valueOf(LocalDateTime.now()))
                    .content("comment" + i)
                    .build();
            commentRepository.save(comment);
        }
        log.info("comment added");
    }

}
