package kai.study.dao;

import kai.study.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PaymentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaymentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Payment> readAll(){
        return jdbcTemplate.query("SELECT * FROM Payment", new BeanPropertyRowMapper<>(Payment.class));
    }

    public Payment read(String name){
        return jdbcTemplate.query("SELECT * FROM Payment WHERE pay_Method=?", new Object[]{name}, new BeanPropertyRowMapper<>(Payment.class))
                .stream().findAny().orElse(null);
    }

    public void update(String name){
        jdbcTemplate.update("UPDATE Payment SET pay_Method=? WHERE pay_Method=?", name, name);
    }

    public void save(String name){
        jdbcTemplate.update("INSERT INTO Payment VALUES (?)", name);
    }

    public void delete(String name){
        jdbcTemplate.update("DELETE FROM Payment WHERE pay_Method=?", name);
    }
}
