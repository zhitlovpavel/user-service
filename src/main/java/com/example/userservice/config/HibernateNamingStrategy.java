/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2019 VTB Group. All rights reserved.
 */

package com.example.userservice.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

/**
 * Test naming strategy.
 *
 * @author Dmitriy_Balakin
 */
public class HibernateNamingStrategy extends SpringPhysicalNamingStrategy {

    private static final String PREFIX = "dbo_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return super.toPhysicalTableName(addPrefix(name), jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return super.toPhysicalSequenceName(addPrefix(name), jdbcEnvironment);
    }

    private Identifier addPrefix(Identifier identifier) {
        String name = identifier.getText();
        return name.startsWith(PREFIX) ? identifier : Identifier.toIdentifier(PREFIX + name);
    }
}
