package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T>{

    T save(T t);
    List<T> searchAll();

}
