package com.example.demo2.dao;

import com.example.demo2.bean.TauxIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TauxIRDao extends JpaRepository<TauxIR, Long> {
    List<TauxIR> findByLibelle(String libelle);
   int deleteByLibelle(String libelle);

   @Query("SELECT t FROM TauxIR t WHERE t.salaireMax >= :salaireNet and t.salaireMin <= :salaireNet")
   TauxIR findBySalaireNet(@Param("salaireNet") double salaireNet);


}
