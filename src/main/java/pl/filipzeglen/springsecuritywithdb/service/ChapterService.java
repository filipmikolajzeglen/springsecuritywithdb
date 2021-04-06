package pl.filipzeglen.springsecuritywithdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.filipzeglen.springsecuritywithdb.model.elearning.Chapter;
import pl.filipzeglen.springsecuritywithdb.model.repository.ChapterRepository;

import java.util.Optional;

@Service
public class ChapterService {

    private ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository) { this.chapterRepository = chapterRepository; }

    public Optional<Chapter> findById(Long id) {
        return chapterRepository.findById(id);
    }

    public Iterable<Chapter> findAll() {
        return chapterRepository.findAll();
    }

    public Chapter save(Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    public void deleteById(Long id) {
        chapterRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Chapter("Wzorce projektowe", "Wzorce Kreacyjne", "Wielopoziomowy schemat rowiązywania jakiegoś problemu...", "Gabriel Rojek", "100%"));
        save(new Chapter("Wzorce projektowe", "Wzorce Behawioralne", "Wielopoziomowy schemat rowiązywania jakiegoś problemu...", "Gabriel Rojek", "100%"));
        save(new Chapter("Wzorce projektowe", "Wzorce Strukturalne", "Wielopoziomowy schemat rowiązywania jakiegoś problemu...", "Gabriel Rojek", "100%"));
    }
}
