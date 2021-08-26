package com.gerencia.reuniao.ProjetoGerenciaReuniao.controller;

import com.gerencia.reuniao.ProjetoGerenciaReuniao.exception.ResourceNotFoundException;
import com.gerencia.reuniao.ProjetoGerenciaReuniao.model.Room;
import com.gerencia.reuniao.ProjetoGerenciaReuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(name = "/api/v1")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping(value = "/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping(value = "/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Long roomId) throws ResourceNotFoundException {
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found:: " + roomId));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping(value = "/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }

    @PutMapping(value = "/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(name = "id") Long roomId, @Valid @RequestBody Room roomDetails) throws ResourceNotFoundException {
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:: " + roomId));
        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());
        final Room updateRoom = roomRepository.save(room);
        return ResponseEntity.ok(updateRoom);
    }

    @DeleteMapping(value = "/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId) throws ResourceNotFoundException {
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id:: " + roomId));
        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
