package de.uftos.controller;

import de.uftos.dto.LessonResponseDto;
import de.uftos.dto.RoomRequestDto;
import de.uftos.entities.Room;
import de.uftos.services.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {
  private final RoomService roomService;

  @Autowired
  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @PostMapping()
  public Room createRoom(@RequestBody RoomRequestDto room) {
    return this.roomService.create(room);
  }

  @GetMapping()
  public Page<Room> getRooms(Pageable pageable) {
    return this.roomService.get(pageable);
  }

  @GetMapping("/{id}")
  public Room getRoom(@PathVariable String id) {
    return this.roomService.getById(id);
  }

  @GetMapping("/{id}/lessons")
  public List<LessonResponseDto> getLessons(@PathVariable String id) {
    return this.roomService.getLessonsById(id);
  }

  @PutMapping("/{id}")
  public Room updateRoom(@PathVariable String id, @RequestBody RoomRequestDto room) {
    return this.roomService.update(id, room);
  }

  @DeleteMapping("/{id}")
  public void deleteRoom(@PathVariable String id) {
    this.roomService.delete(id);
  }
}
