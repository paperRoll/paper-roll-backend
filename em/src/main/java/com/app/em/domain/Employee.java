package com.app.em.domain;

import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@QueryEntity
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;

    private int employeeId;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String address;

    private List<EmergencyContact> emergencyContacts;
}
