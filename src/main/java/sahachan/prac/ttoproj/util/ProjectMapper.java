package sahachan.prac.ttoproj.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import sahachan.prac.ttoproj.doctor.dto.DoctorDto;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.patient.dto.PatientDto;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.security.dto.UserDto;
import sahachan.prac.ttoproj.security.entity.User;
import sahachan.prac.ttoproj.vaccine.dto.VaccineDto;
import sahachan.prac.ttoproj.vaccine.entity.Vaccine;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mappings({
            @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))"),
            @Mapping(target = "doctorID", expression = "java(user.getDoctor() == null ? null : user.getDoctor().getId())"),
            @Mapping(target = "patientID", expression = "java(user.getPatient() == null ? null : user.getPatient().getId())"),
            @Mapping(target = "adminID", expression = "java(user.getAdmin() == null ? null : user.getAdmin().getId())"),
    })
    UserDto getUserDto(User user);
    List<UserDto> getUserDto(List<User> user);
    PatientDto getPatientDto(Patient patient);
    List<PatientDto> getPatientDto(List<Patient> patient);
    @Mappings({
            @Mapping(target = "fullName", expression = "java(doctor.getUser().getFirstname() + \" \" + doctor.getUser().getLastname())"),
            @Mapping(target = "imageUrls", expression = "java(doctor.getUser().getImageUrls())"),
            @Mapping(target = "UserId", expression = "java(doctor.getUser().getId())")
    })
    DoctorDto getDoctorDto(Doctor doctor);
    List<DoctorDto> getDoctorDto(List<Doctor> doctor);
    VaccineDto getVaccineDto(Vaccine vaccine);
    List<VaccineDto> getVaccineDto(List<Vaccine> vaccine);
}
