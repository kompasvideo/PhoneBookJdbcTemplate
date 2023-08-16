package ru.andreybaryshnikov.models;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneBookMapper implements RowMapper {
    @Override
    public PhoneBook mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setPhoneBookID(resultSet.getInt("phonebook_id"));
        phoneBook.setFirstName(resultSet.getString("first_name"));
        phoneBook.setLastName(resultSet.getString("last_name"));
        phoneBook.setThreeName(resultSet.getString("three_name"));
        phoneBook.setNumberPhone(resultSet.getString("number_phone"));
        phoneBook.setAddress(resultSet.getString("address"));
        phoneBook.setDescription(resultSet.getString("description"));
        return phoneBook;
    }
}
