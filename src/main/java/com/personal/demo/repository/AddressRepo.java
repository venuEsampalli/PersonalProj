package com.personal.demo.repository;

import com.personal.demo.model.AdressObj;
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
public interface AddressRepo extends JpaRepository<AdressObj,Integer> {

    @Modifying
    @Query(value = "insert into address values(:id,:street,:city,:postalcode,:state)", nativeQuery = true)
    int saveAddress(@Param("id") String id, @Param("street") String street, @Param("city") String city,
                    @Param("state") String state, @Param("postalcode") String postalcode);

    @Modifying
    @Query(value = "update address set street=:street,city=:city,state=:state, postalcode=:postalcode where " +
            " id =:id ", nativeQuery = true)
    int updateAddress(@Param("id") String id, @Param("street") String street, @Param("city") String city,
                     @Param("state") String state,@Param("postalcode") String postalcode);

    @Modifying
    @Query(value = "delete from address where id =:id ", nativeQuery = true)
    int deleteAddress(@Param("id") String id);

}



