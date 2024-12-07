package com.exemplu.repository;

import com.exemplu.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MasinaSpringDataJpaRepository extends JpaRepository<Masina, String> {
    Masina findByNrInmatriculare(String nrInmatriculare);
    void deleteByNrInmatriculare(String NrInmatriculare);
    int countByMarca(String marca);
    int countByNrKilometriiBefore(int kmBefore);

    @Query("from Masina m where m.anFabricatie>=:an")
    List<Masina> getMasiniNoi(@Param("an") int an);

}
