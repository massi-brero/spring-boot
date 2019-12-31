package de.massisoft.trainingsadmin.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.massisoft.trainingsadmin.TrainingsadminApplication;
import de.massisoft.trainingsadmin.entities.Training;

@SpringBootTest(classes = TrainingsadminApplication.class)
class NativeQueriesTest {

    @Autowired
    EntityManager em;
    
    @Test
    void native_query_basic() {
        int expected = 3;
        Query query = em.createNativeQuery("select * from training", Training.class);
        List<Training> result = query.getResultList();
        
        assertEquals(expected, result.size());
    }
    
    @Test
    void native_query_with_param() {
        int expected = 1;
        Query query = em.createNativeQuery("select * from training where id = ?", Training.class);
        query.setParameter(1, 10001L);
        List<Training> result = query.getResultList();
        
        assertEquals(expected, result.size());
    }
    
    @Test
    void native_query_with_named_param() {
        int expected = 1;
        Query query = em.createNativeQuery("select * from training where id = :id", Training.class);
        query.setParameter("id", 10001L);
        List<Training> result = query.getResultList();
        
        assertEquals(expected, result.size());
    }
    
    @Test
    @Transactional
    void native_query_update_all_rows() {
        int expected = 3;
        String testTitleString = "###";
        Query query = em.createNativeQuery("update training set title = :title", Training.class);
        query.setParameter("title", testTitleString);
        int actual = query.executeUpdate();

        assertEquals(expected, actual);
        
    }
    
    

}
