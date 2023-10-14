package cl.usach.tingeso.ev1.repositories;

import cl.usach.tingeso.ev1.entities.CuotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuotaRepository extends JpaRepository<CuotaEntity, Integer> {
}
