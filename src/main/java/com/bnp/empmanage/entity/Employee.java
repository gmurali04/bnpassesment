package com.bnp.empmanage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @GenericGenerator(name = "uid_generator",strategy = "com.bnp.empmanage.entity.EmployeeSeqGenerator")
    @GeneratedValue(generator = "uid_generator")
    @Column(name = "uid")
    private String uid;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "status")
    private int status;
}
