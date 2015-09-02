package com.demo.dropwizard.dao;

import com.demo.dropwizard.model.Staff;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by CongDanh on 8/27/15.
 */
public interface StaffDAO {

    @SqlUpdate("INSERT INTO staffs(first_name, last_name, middle_name, address, birthday, salary, currency) VALUES " +
            "(" +
            ":staff.firstName, :staff.lastName, :staff.middleName, :staff.address, :staff.birthday, :staff.salary, :staff.currency" +
            ")")
    @GetGeneratedKeys
    public long create(@BindBean("staff") Staff staff);

    @RegisterMapper(StaffMapper.class)
    @SqlQuery("SELECT * FROM staffs where id = :id")
    public Staff findById(@Bind("id") long id);

    // some classes to mapper the specific object
    public class StaffMapper implements ResultSetMapper<Staff> {
        @Override
        public Staff map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
            return new Staff(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("middle_name"),
                    rs.getString("address"), rs.getTimestamp("birthday"), rs.getInt("salary"), rs.getString("currency"));
        }
    }

}
