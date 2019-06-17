package alek.app.symulator_ligi.repository;

import alek.app.symulator_ligi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);

    List<Player> findAllByTeam_Name(String name);

    @Transactional
    List<Player> deletePlayersByTeam_Id(Long id);

    @Transactional
    List<Player> deleteAllByTeam_Id(Long id);

}
