package com.girish.esdminiproject.service;


import com.girish.esdminiproject.dto.EmployeeRequest;
import com.girish.esdminiproject.dto.LoginRequest;
import com.girish.esdminiproject.entity.Department;
import com.girish.esdminiproject.entity.Employee;
import com.girish.esdminiproject.exception.ResourceNotFoundException;
import com.girish.esdminiproject.filter.JWTFilter;
import com.girish.esdminiproject.helper.CustomUserDetails;
import com.girish.esdminiproject.helper.JWTHelper;
import com.girish.esdminiproject.mapper.EmployeeMapper;
import com.girish.esdminiproject.repo.DepartmentRepo;
import com.girish.esdminiproject.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import static java.lang.String.format;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService{
    private final EmployeeRepo repo;
    private final DepartmentRepo departmentRepository;
    private final EmployeeMapper mapper;
    @Autowired
    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);
    private final JWTHelper jwtHelper;


    public String createEmployee(EmployeeRequest request) {
        String encryptedPassword = passwordEncoder.encode(request.password());
        Department department = departmentRepository.findByDepartmentId(request.departmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        Employee employee = mapper.toEntity(request,department,encryptedPassword);
        repo.save(employee);
        return "Created";
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Loading user details for username: {}", username);
        Employee employee = repo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + username));
        return new CustomUserDetails(employee); // Wrapping Customer in CustomUserDetails
    }

    public String login(LoginRequest request) {
        Employee Employee =repo.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found with email: " + request.email()));
        boolean matches = passwordEncoder.matches(request.password(), Employee.getPassword());

        if(!matches){
            return "Wrong Password or Email";
        }
        String token ="";

        if (Employee.getDepartment() != null && Employee.getDepartment().getDepartmentId() == 1) {
            token=jwtHelper.generateToken(request.email());
            return token;
        }
            return "employee";


       // return token;

    }
}
