package sahachan.prac.ttoproj.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sahachan.prac.ttoproj.doctor.dto.DoctorDto;
import sahachan.prac.ttoproj.doctor.entity.Doctor;
import sahachan.prac.ttoproj.patient.dto.PatientDto;
import sahachan.prac.ttoproj.patient.entity.Patient;
import sahachan.prac.ttoproj.security.dto.UserDto;
import sahachan.prac.ttoproj.security.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    UserDto getUserDto(User user);
    List<UserDto> getUserDto(List<User> user);

    PatientDto getPatientDto(Patient patient);
    List<PatientDto> getPatientDto(List<Patient> patient);

    @Mapping(target = "fullName", expression = "java(doctor.getUser().getFirstname() + \" \" + doctor.getUser().getLastname())")
    DoctorDto getDoctorDto(Doctor doctor);
    List<DoctorDto> getDoctorDto(List<Doctor> doctor);
}
