package net.alexis.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.alexis.springboot.model.entity.Phone;

@Repository
public interface PhoneRepository extends CrudRepository <Phone, Long>  {

}
