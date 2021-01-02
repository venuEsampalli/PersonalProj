package com.personal.demo.repository;

import com.personal.demo.model.PersonObj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PersonRepo extends JpaRepository<PersonObj,Integer> {

    @Modifying
    @Query(value = "insert into person values(:id,:fname,:lname)", nativeQuery = true)
    int savePerson(@Param("id") String id, @Param("lname") String lname, @Param("fname") String fname);

    @Modifying
    @Query(value = "update person set firstname=:fname,lastname=:lname where " +
            " id =:id ", nativeQuery = true)
    int updatePerson(@Param("id") String id, @Param("lname") String lname, @Param("fname") String fname);

    @Modifying
    @Query(value = "delete from person where id =:id ", nativeQuery = true)
    int deletePerson(@Param("id") String id);

    @Query(value = "select count(id) from person ", nativeQuery = true)
    int countPerson();

    @Query(value = "select id,firstname,lastname from person ", nativeQuery = true)
    List<PersonObj> listPerson();

}



