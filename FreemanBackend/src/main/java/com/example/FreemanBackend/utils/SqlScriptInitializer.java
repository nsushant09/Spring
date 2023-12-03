package com.example.FreemanBackend.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class SqlScriptInitializer {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initData() throws Exception{
        prepopulateData();
    }

    private void prepopulateData() throws SQLException {
        Resource sqlResource = new ClassPathResource("data.sql");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), sqlResource);
    }
}
