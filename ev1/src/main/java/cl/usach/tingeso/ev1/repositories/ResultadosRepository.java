package cl.usach.tingeso.ev1.repositories;

import cl.usach.tingeso.ev1.entities.ResultadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadosRepository extends JpaRepository<ResultadosEntity, Integer> {

}
