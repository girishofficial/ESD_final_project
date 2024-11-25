package com.girish.esdminiproject.repo;
import com.girish.esdminiproject.dto.StudentDetails;
import com.girish.esdminiproject.entity.Student;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long>{

    @Query("SELECT new com.girish.esdminiproject.dto.StudentDetails(" +
            "s, d.program, sp.name) " +
            "FROM Student s " +
            "JOIN s.domain d " +
            "JOIN s.specialisation sp")
    List<StudentDetails> fetchStudentsWithDomainAndSpecialisation();

    @Query("SELECT new com.girish.esdminiproject.dto.StudentDetails(" +
            "s, d.program, sp.name) " +
            "FROM Student s " +
            "JOIN s.domain d " +
            "JOIN s.specialisation sp " +
            "WHERE sp.name = :specialisationName")
    List<StudentDetails> fetchStudentsWithGivenSpecialisation(@Param("specialisationName") String specialisationName);


    @Query("SELECT new com.girish.esdminiproject.dto.StudentDetails(" +
            "s, d.program, sp.name) " +
            "FROM Student s " +
            "JOIN s.domain d " +
            "JOIN s.specialisation sp " +
            "WHERE d.program = :domainName")
    List<StudentDetails> fetchStudentsWithGivenDomain(@Param("domainName") String domainName);

    @Modifying
    @Transactional
    @Query(value = "UPDATE students s " +
            "SET s.specialisation = (" +
            "    SELECT sc.specialisation_id " +
            "    FROM specialisation_course sc " +
            "    JOIN student_courses stc ON sc.course_id = stc.course_id " +
            "    JOIN courses c ON c.course_id = stc.course_id " +
            "    WHERE stc.student_id = s.student_id " +
            "    GROUP BY sc.specialisation_id " +
            "    HAVING SUM(c.credits) >= 20 " +
            "    LIMIT 1" +
            ") " +
            "WHERE s.student_id IN (" +
            "    SELECT stc.student_id " +
            "    FROM student_courses stc " +
            "    JOIN specialisation_course sc ON stc.course_id = sc.course_id " +
            "    JOIN courses c ON c.course_id = stc.course_id " +
            "    GROUP BY stc.student_id, sc.specialisation_id " +
            "    HAVING SUM(c.credits) >= 20" +
            ")", nativeQuery = true)
    void updateStudentSpecialisation();

}
