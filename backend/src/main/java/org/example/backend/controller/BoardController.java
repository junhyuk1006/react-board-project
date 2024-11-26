package org.example.backend.controller;

import org.example.backend.entity.Board;
import org.example.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable long id) {
        return boardService.getBoardById(id);
    }

    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable long id, @RequestBody Board boardDetails) {
        return boardService.updateBoard(id, boardDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable long id) {
        boardService.deleteBoard(id);
    }
}
