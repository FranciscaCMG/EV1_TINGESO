package cl.usach.tingeso.ev1.repositories;

import cl.usach.tingeso.ev1.entities.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer>{

}
