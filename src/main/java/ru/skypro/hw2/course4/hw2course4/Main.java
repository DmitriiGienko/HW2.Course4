package ru.skypro.hw2.course4.hw2course4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.skypro.hw2.course4.hw2course4.model.Employee;
import ru.skypro.hw2.course4.hw2course4.model.Position;

import java.io.IOException;

public class Main {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
 //      Employee employee = new Employee()
 //              .setId(1)
 //              .setName("Aniston")
 //              .setSalary(550)
 //              .setPosition(new Position(3, "Star"));

 //      String json = OBJECT_MAPPER.writeValueAsString(employee);
 //      System.out.println(json);

        String json = "{\"id\":1,\"name\":\"Aniston\",\"salary\":550,\"position\":{\"id\":3,\"positionName\":\"Star\"}}";
        Employee employee = OBJECT_MAPPER.readValue(json.getBytes(), Employee.class);
        System.out.println(employee );

    }


}
