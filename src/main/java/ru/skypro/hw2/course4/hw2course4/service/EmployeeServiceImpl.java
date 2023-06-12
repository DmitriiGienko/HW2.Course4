package ru.skypro.hw2.course4.hw2course4.service;

import io.micrometer.common.lang.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeNotFoundException;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private  EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeList.add(employee);
        }
        return employeeList.stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public int getCount() {
        return (int) employeeRepository.count();
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        employeeRepository.save(employee.toEmployee(employee));
    }


    @Override
    public void updateEmployeeById(int id, String name, int salary) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        employeeRepository.updateEmployeeById(name, salary, id);
    }

    @Override
    public EmployeeDTO getInfoEmployeeById(int id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new EmployeeNotFoundException();
        }
        return employeeRepository.findById(id)
                .map(EmployeeDTO::fromEmployee)
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

        return employeeRepository.findEmployeeBySalaryGreaterThan(higher)
                .stream().map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());

    }

    @Override
    public List<EmployeeDTO> getEmployeeWithHighestSalary() {
        return employeeRepository.getEmployeeWithMaxSalary();
    }

    @Override
    public List<EmployeeFullInfo> getEmployeesInfo() {
        return employeeRepository.findAllEmployeeFullInfo();
    }

    @Override
    public EmployeeDTO getEmployeeFullInfo(int id) {
        return employeeRepository.findById(id)
                .map(EmployeeDTO::fromEmployee)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<EmployeeDTO> getEmployeeByPage(int page) {
        return employeeRepository.findAll(PageRequest.of(page,10))
                .stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<EmployeeDTO> getEmployeeByPosition(@Nullable String position) {
//
//        return Optional.ofNullable(position)
//                .map(employeeRepository::findEmployeeByPosition_Position)
//                .orElseGet(employeeRepository::findAll)
//                .stream()
//                .map(EmployeeDTO::fromEmployee)
//                .collect(Collectors.toList());
//    }
}
