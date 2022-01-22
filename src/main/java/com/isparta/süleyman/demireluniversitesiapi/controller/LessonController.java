package com.isparta.süleyman.demireluniversitesiapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;


@RestController
@RequestMapping("/lessons")
public class LessonController {

    private HashMap<Integer, String> lessonMap = new HashMap<>();

    @GetMapping("/all")
    public HashMap<Integer, String> getLessonMap() {
        return lessonMap;
    }

    @PostMapping("/add/{id}/{lesson}")
    public String createLesson(@PathVariable String id, @PathVariable String lesson){
        try {
            Integer parseId = Integer.valueOf(id);
            String put = lessonMap.put(parseId, lesson);
            return "ders başarılı bir şekilde eklendi";
        }
        catch (Exception exception) {
            return "Girilen id degeri numeric olmalıdır. Ders eklenemedi";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLesson(@PathVariable String id) {
        try {
            Integer parseId = Integer.valueOf(id);
            lessonMap.remove(parseId);
            return "ders başarılı bir şekilde silindi";
        }
        catch (Exception exception) {
            return "Girilen id degeri numeric olmalıdır. Ders silinemedi";
        }
    }

    @PostConstruct
    public void initLessons() {
        lessonMap.put(1, "Genel matematik");
        lessonMap.put(2, "Veritabanı programlama");
        lessonMap.put(3, "C programlama");
        lessonMap.put(4, "Programcılıga giriş");
        lessonMap.put(5, "Veri yapıları");
        lessonMap.put(6, "Web programlama");
        lessonMap.put(7, "İnkilap");
        lessonMap.put(8, "İngilizce");
        lessonMap.put(9, "Türk dili");
        lessonMap.put(10, "Nesne yönelimli java programlama");
        lessonMap.put(11, "Mobil yazılımlar");
        lessonMap.put(12, "Blockchain teknoloji temelleri");
        lessonMap.put(13, "Yazılım testi ve otomasyonu");
        lessonMap.put(14, "Yazılım geliştirme ortam ve araçları");
    }
}
