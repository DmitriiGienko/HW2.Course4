package ru.skypro.hw2.course4.hw2course4.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeExceptionHandler;
import ru.skypro.hw2.course4.hw2course4.projections.EmployeeFullInfo;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeNotFoundException;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepository;
import ru.skypro.hw2.course4.hw2course4.repository.PagingEmployeeRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PagingEmployeeRepository pagingEmployeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PagingEmployeeRepository pagingEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.pagingEmployeeRepository = pagingEmployeeRepository;
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Вызван метод получения всех сотрудников");
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeList.add(employee);
        }
        logger.debug("Вызваны сотрудники {} ", employeeList);
        return employeeList.stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        logger.info("Вызван метод создания сотрудника");
        employeeRepository.save(EmployeeMapper.toEmployee(employee));
        logger.debug("Сотрудник создан {}", employee);
    }

    @Override
    public void updateEmployeeById(int id, String name, int salary) {
        logger.info("Вызван метод изменения сотрудника");
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setName(name);
        employee.setSalary(salary);
        employeeRepository.save(employee);
        logger.debug("Сотрудник изменен и теперь он {}", employee);
    }

    @Override
    public EmployeeDTO getInfoEmployeeById(int id) {
        logger.info("Вызван метод получения сотрудника по id = {}", id);
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDto)
                .orElseThrow(() -> {
                    logger.error("Нет сотрудника с id {}", id);
                    return new EmployeeNotFoundException();
                });
    }

    @Override
    public void deleteEmployeeById(int id) {
        logger.info("Вызван метод удаления сотрудника по id = {}", id);
        if (employeeRepository.findById(id).isEmpty()) {
            logger.error("Нет сотрудника с id {}", id);
            throw new EmployeeNotFoundException();
        }
        logger.debug("Сотрудник с id {} удален", id);
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithSalaryMoreThan(int higher) {
        logger.info("Вызван метод получения сотрудников с зарплатой выше {}", higher);
        return employeeRepository.findEmployeeBySalaryGreaterThan(higher).stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeeWithMaxSalary() {
        logger.info("Вызван метод получения сотрудника с максимальной зарплатой");
        return employeeRepository.getEmployeesWithMaxSalary();
    }

    @Override
    public List<EmployeeFullInfo> getEmployeeFullInfo() {
        logger.info("Вызван метод получения полной информации о сотрудниках");
        logger.debug("Сотрудники получены {}", employeeRepository.getFullInfo());
        return employeeRepository.getFullInfo();
    }

    @Override
    public EmployeeDTO getFullInfoById(int id) {
        logger.info("Вызван метод получения полной информации о сотруднике по id = {}", id);
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toDto)
                .orElseThrow(() -> {
                    logger.error("Нет сотрудника с id {}", id);
                    return new EmployeeNotFoundException();
                });
    }

    @Override
    public List<EmployeeDTO> getEmployeeByPage(int page) {
        logger.info("Вызван метод получения сотрудников постранично");
        Pageable employeeOfConcretePage = PageRequest.of(page, 10);
        Page<Employee> employeePage = pagingEmployeeRepository.findAll(employeeOfConcretePage);
        return employeePage.stream()
                .toList()
                .stream().map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesOnPosition(String positionName) {
        logger.info("Вызван метод получения сотрудников по отделу {}", positionName);
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

    @Override
    public void uploadEmployee(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<EmployeeDTO> employeeDTOS =
                objectMapper.readValue(file.getInputStream(),
                        new TypeReference<>() {
                        });
        employeeRepository.saveAll(employeeDTOS.stream().map(EmployeeMapper::toEmployee).toList());
    }
}



