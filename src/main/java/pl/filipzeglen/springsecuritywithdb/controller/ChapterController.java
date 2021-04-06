package pl.filipzeglen.springsecuritywithdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.filipzeglen.springsecuritywithdb.model.elearning.Chapter;
import pl.filipzeglen.springsecuritywithdb.service.ChapterService;

import java.util.Optional;

@RestController
@RequestMapping("/chapters")
public class ChapterController {

    private ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) { this.chapterService = chapterService; }

    @GetMapping("/all")
    public Iterable<Chapter> getAllChapters() {
        return chapterService.findAll();
    }

    @GetMapping
    public Optional<Chapter> getChapterById(@RequestParam Long index) {
        return chapterService.findById(index);
    }

    @PostMapping
    public Chapter addChapter(@RequestBody Chapter chapter) {
        return chapterService.save(chapter);
    }

    @PutMapping
    public Chapter updateChapter(@RequestBody Chapter chapter) {
        return chapterService.save(chapter);
    }

    @DeleteMapping
    public void deleteChapter(@RequestParam Long index) { chapterService.deleteById(index); }
}
