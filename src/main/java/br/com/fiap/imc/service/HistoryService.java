package br.com.fiap.imc.service;

import br.com.fiap.imc.model.History;
import br.com.fiap.imc.repository.HistoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getAll() {
        return historyRepository.findAll();
    }

    public History getById(Long id) {
        Optional<History> history = historyRepository.findById(id);

        if (history.isPresent()) {
            return history.get();
        }

        return null;
    }

    public History save(History history) {
        return historyRepository.save(history);
    }

    public List<History> getByUserId(Long userId) {
        return historyRepository.findByUserId(userId);
    }

    public History update(History history, Long historyId) {

        History actualHistory = historyRepository.findById(historyId).get();

        if (actualHistory != null) {
            BeanUtils.copyProperties(history, actualHistory, "historyId");
            historyRepository.save(actualHistory);
            return actualHistory;
        }

        return null;

    }

    public boolean delete(Long historyId) {

        History history = historyRepository.findById(historyId).get();

        if (history != null) {
            historyRepository.deleteById(historyId);
            return true;
        }

        return false;

    }

}
