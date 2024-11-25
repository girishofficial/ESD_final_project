package com.girish.esdminiproject.service;
import com.girish.esdminiproject.dto.StudentDetails;
import com.girish.esdminiproject.filter.JWTFilter;
import com.girish.esdminiproject.repo.DomainRepo;
import com.girish.esdminiproject.repo.SpecilisationRepo;
import com.girish.esdminiproject.repo.StudentRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;
    private final DomainRepo domainRepo;
    private final SpecilisationRepo specilisationRepo;
    private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    public List<StudentDetails> getAllStudents() {
        return studentRepo.fetchStudentsWithDomainAndSpecialisation();
    }

    public List<StudentDetails> getStudents(String specialisation) {
        return studentRepo.fetchStudentsWithGivenSpecialisation(specialisation);
    }
    public List<StudentDetails> getStudentsWithDomainName(String domain) {
        return studentRepo.fetchStudentsWithGivenDomain(domain);
    }
    public String CalculateStudentSpecialization() {
        studentRepo.updateStudentSpecialisation();
        logger.debug("Updated Details");
    return "done";
    }
// UPDATE Students SET specialisation = NULL;


}
