package com.devsuperior.dslist.repositories;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(long listId, long gameId, Integer newPosition);
}
