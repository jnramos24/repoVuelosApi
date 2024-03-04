package com.codoacodo.vuelosapi.repository;

import com.codoacodo.vuelosapi.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VuelosRepository extends JpaRepository<Flight, Long> {
}
