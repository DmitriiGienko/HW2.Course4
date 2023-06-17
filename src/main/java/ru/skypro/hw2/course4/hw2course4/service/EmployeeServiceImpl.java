package ru.skypro.hw2.course4.hw2course4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.projections.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeNotFoundException;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepository;
import ru.skypro.hw2.course4.hw2course4.repository.PagingEmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PagingEmployeeRepository pagingEmployeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PagingEmployeeRepository pagingEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.pagingEmployeeRepository = pagingEmployeeRepository;
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeList.add(employee);
        }
        return employeeList.stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeeRepository.save(EmployeeMapper.toEmployee(employee));


    }

    @Override
    public void updateEmployeeById(int id, String name, int salary) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setName(name);
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO getInfoEmployeeById(int id) {

        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDto)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void deleteEmployeeById(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithSalaryMoreThan(int higher) {
        return employeeRepository.findEmployeeBySalaryGreaterThan(higher).stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithMaxSalary() {
        return employeeRepository.getEmployeesWithMaxSalary();
    }

    @Override
    public List<EmployeeFullInfo> getEmployeeFullInfo() {
        return employeeRepository.getFullInfo();
    }

    @Override
    public EmployeeDTO getFullInfoById(int id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDto)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<EmployeeDTO> getEmployeeByPage(int page) {
        Pageable employeeOfConcretePage = PageRequest.of(page, 10);
        Page<Employee> employeePage = pagingEmployeeRepository.findAll(employeeOfConcretePage);

        return employeePage.stream()
                .toList()
                .stream().map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesOnPosition(String positionName) {
        List<Employee> employeeList;
        if (positionName != null) {
            employeeList = employeeRepository.findByPositionName(positionName);
        } else {
            employeeList = (List<Employee>) employeeRepository.findAll();
        }
        return employeeList.stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }
}



