package com.gerencia.reuniao.ProjetoGerenciaReuniao.repository;

import com.gerencia.reuniao.ProjetoGerenciaReuniao.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
