package com.bnp.empmanage.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeSeqGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String prefix = "e000";
        String suffix = "";
        try {
            Connection connection = sharedSessionContractImplementor.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(uid) from employee");
            if(resultSet.next()) {
                Integer id = resultSet.getInt(1) + 1;
                suffix = id.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prefix + suffix;
    }
}
