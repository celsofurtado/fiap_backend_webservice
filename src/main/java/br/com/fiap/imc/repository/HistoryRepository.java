package br.com.fiap.imc.repository;

import br.com.fiap.imc.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    @Query("SELECT h FROM History h WHERE h.user.userId = ?1 ORDER BY h.historyId DESC")
    List<History> findByUserId(Long userId);

}
