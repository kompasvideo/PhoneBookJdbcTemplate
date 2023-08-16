package ru.andreybaryshnikov.dao;

import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.stereotype.Repository;
import ru.andreybaryshnikov.models.PhoneBook;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.andreybaryshnikov.models.PhoneBookMapper;
import java.util.*;

@Repository
public class PhonebookDAOImpl implements PhonebookDAO {
    private final JdbcTemplate jdbcTemplate;

    public PhonebookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PhoneBook getPhoneBook(int id) {
        List<PhoneBook> phoneBooks = jdbcTemplate.query("SELECT * FROM phonebook WHERE phonebook_id = ?",
            new ArgumentPreparedStatementSetter(new Object[]{id}), new PhoneBookMapper());
        return phoneBooks.stream().findAny().orElse(new PhoneBook());
    }

    @Override
    public List<PhoneBook> getPhoneBooks() {
        return jdbcTemplate.query("SELECT * FROM phonebook ORDER BY phonebook_id", new PhoneBookMapper());
    }

    @Override
    public void editRecordToPhoneBooks(PhoneBook newPhoneBook) {
        jdbcTemplate.update("UPDATE phonebook SET first_name=?, last_name=?, three_name=?, number_phone=?," +
                " address=?, description=? WHERE phonebook_id=?", newPhoneBook.getFirstName(),
            newPhoneBook.getLastName(), newPhoneBook.getThreeName(), newPhoneBook.getNumberPhone(),
            newPhoneBook.getAddress(), newPhoneBook.getDescription(), newPhoneBook.getPhoneBookID());
    }

    @Override
    public void deleteRecordToPhoneBooks(int id) {
        jdbcTemplate.update("DELETE FROM phonebook WHERE phonebook_id = ?", id);
    }

    @Override
    public PhoneBook getNewPhoneBook() {
        return new PhoneBook();
    }

    @Override
    public void addRecordToPhoneBooks(PhoneBook newPhoneBook) {
        jdbcTemplate.update("INSERT INTO phonebook (first_name, last_name, three_name, number_phone, address, " +
            "description) VALUES (?,?,?,?,?,?)", newPhoneBook.getFirstName(),
            newPhoneBook.getLastName(), newPhoneBook.getThreeName(), newPhoneBook.getNumberPhone(),
            newPhoneBook.getAddress(), newPhoneBook.getDescription());
    }

}

