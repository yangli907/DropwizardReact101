package com.yangli907.phome;

import java.sql.Connection;
import java.sql.DriverManager;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static com.yangli907.phome.model.Tables.PHOTOGRAPHER;

public class JooqTestApplication {
    public static void main(String[] args) throws Exception {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/phollow";
        String driver = "com.mysql.jdbc.Driver";

        Class.forName(driver).newInstance();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DSLContext dslContext = DSL.using(connection, SQLDialect.MYSQL);
            Result<Record> result = dslContext.select().from(PHOTOGRAPHER).fetch();

            for (Record r : result) {
                Integer id = r.getValue(PHOTOGRAPHER.ID);
                String name = r.getValue(PHOTOGRAPHER.NAME);
                String userId = r.getValue(PHOTOGRAPHER.USERID);

                System.out.println("ID: " + id + " name: " + name + " user id: " + userId);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
