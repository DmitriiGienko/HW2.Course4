package ru.skypro.hw2.course4.hw2course4.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.exceptions.EmployeeNotFoundException;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.repository.EmployeeRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeRepository.findAll()) {
            result.add(employee);
        }
        return result;
    }


    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployeeById(int id, String name, int salary) {
        return null;
    }

    @Override
    public Employee getInfoEmployeeById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        // Если сотрудник найден, возвращаем его
        // Иначе выбрасываем исключение с указанием некорректного id
        return employeeOptional.orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);

    }

    @Override

    public List<Employee> getEmployeeWithSalaryMoreThan(int salary) {
        return employeeRepository.getEmployeeBySalaryGreaterThan(salary);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByName(name).get(0);
    }

    @Override
    public int getCount() {
        return (int) employeeRepository.count();
    }

//    @Override
//    public List<Employee> getEmployeeWishPaging(int page, int size) {
//         Pageable employeeOfConcretePage = PageRequest.of(page, unitPerPage);
//         return  ;
}

//    @Override
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.getAllEmployees();
//
//
//    }
//
//    @Override
//    public List<Employee> addEmployee(Employee employee) {
//        List<Employee> newEmp = employeeRepository.getAllEmployees();
//        newEmp.add(employee);
//        return newEmp;
//
//
//    }
//
//    @Override
//    public Employee updateEmployeeById(int id, String name, int salary) {
//        Employee emp = null;
//        List<Employee> list = employeeRepository.getAllEmployees();
//        for (Employee employee : list) {
//            if (employee.getId() == id) {
//                emp = employee;
//                employee.setName(name);
//                employee.setSalary(salary);
//            } else throw new EmployeeNotFoundException();
//        }
//        return emp;
//    }
//
//    @Override
//    public Employee getInfoEmployeeById(int id) {
//
//        Employee emp = null;
//        List<Employee> list = employeeRepository.getAllEmployees();
//        for (Employee employee : list) {
//            if (employee.getId() == id) {
//                emp = employee;
//            } else throw new EmployeeNotFoundException();
//        }
//        return emp;
//    }
//
//    @Override
//    public void deleteEmployeeById(int id) {
//        List<Employee> list = employeeRepository.getAllEmployees();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                list.remove(list.get(i));
//            } else throw new EmployeeNotFoundException();
//        }
//    }
//
//    @Override
//    public List<Employee> getEmployeeWithSalaryMoreThan(int higher) {
//        List<Employee> employeeList = getAllEmployees();
//        int sum = 0;
//        for (Employee employee : employeeList) {
//            sum += employee.getSalary();
//        }
//        int average = sum / employeeList.size();
//        return employeeList.stream()
//                .filter(employee -> employee.getSalary() > higher)
//                .toList();
//    }



