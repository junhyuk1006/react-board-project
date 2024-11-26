package org.example.backend.service;

import org.example.backend.entity.Board;
import org.example.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board getBoardById(long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }

    public Board updateBoard(long id, Board boardDetails) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        board.setTitle(boardDetails.getTitle());
        board.setContent(boardDetails.getContent());
        board.setAuthor(boardDetails.getAuthor());
        return boardRepository.save(board);
    }

    public void deleteBoard(long id) {
        boardRepository.deleteById(id);
    }
}
