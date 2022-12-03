package kai.study.dao;

import kai.study.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Category> readAll(){
        return jdbcTemplate.query("SELECT * FROM Category", new BeanPropertyRowMapper<>(Category.class));
    }

    public Category read(int id){
        return jdbcTemplate.query("SELECT * FROM Category WHERE category_ID=?", new Object[]{id}, new BeanPropertyRowMapper<>(Category.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Category updatedCategory){
        jdbcTemplate.update("UPDATE Category SET descr=? WHERE category_ID=?", updatedCategory.getDescr(), id);
    }

    public void save(Category category){
        jdbcTemplate.update("INSERT INTO Category VALUES (DEFAULT, ?)", category.getDescr());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Category WHERE category_ID=?", id);
    }
}
