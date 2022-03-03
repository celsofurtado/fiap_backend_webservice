package br.com.fiap.imc.controller;

import br.com.fiap.imc.model.History;
import br.com.fiap.imc.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/histories")
    public ResponseEntity<List<History>> getAll() {

        List<History> histories = historyService.getAll();

        if (histories.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(histories);

    }

    @GetMapping("/histories/{id}")
    public ResponseEntity<History> getById(@PathVariable Long id) {

        History history = historyService.getById(id);

        if (history != null) {
            return ResponseEntity.ok(history);
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping("/histories/user/{id}")
    public ResponseEntity<List<History>> getByUserId(@PathVariable Long id){

        List<History> userHistory = historyService.getByUserId(id);

        if (userHistory.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userHistory);

    }

    @PostMapping("/histories")
    @ResponseStatus(HttpStatus.CREATED)
    public History save(@RequestBody History history) {

        History newHistory = historyService.save(history);

        return newHistory;

    }

    @PutMapping("/histories/{historyId}")
    public ResponseEntity<History> update(@RequestBody History history, @PathVariable Long historyId) {

        History actualHistory = historyService.update(history, historyId);

        if (actualHistory != null) {
            return ResponseEntity.ok(actualHistory);
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/histories/{id}")
    public ResponseEntity<?> deleteHistory(@PathVariable Long id) {
        boolean deleted = historyService.delete(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();

    }


}
