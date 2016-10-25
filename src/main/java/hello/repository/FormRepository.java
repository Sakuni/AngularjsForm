package hello.repository;

import hello.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sakuni.Manamendra on 10/21/2016.
 */
public interface FormRepository extends JpaRepository<Form, Integer> {

    public Form findById(Integer id);
}

