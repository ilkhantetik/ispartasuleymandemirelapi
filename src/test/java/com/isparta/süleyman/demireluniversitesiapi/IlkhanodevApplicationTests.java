package com.isparta.süleyman.demireluniversitesiapi;

import com.isparta.süleyman.demireluniversitesiapi.controller.LessonController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IlkhanodevApplicationTests {

    @Autowired
    LessonController lessonController;

    @Test
    void addLessonTest() {
        lessonController.getLessonMap().put(10, "Bilgisayar Mühendisligi");
        String lesson = lessonController.getLessonMap().get(10);

        //id'si 10 olan dersi ekledigimiz zaman hashmapten id'si 10 olan dersi istedigimiz zaman eklenilen dersin gelmesini bekleriz.
        Assertions.assertEquals(lesson, "Bilgisayar Mühendisligi");
    }

    @Test
    void deleteLessonTest() {
        lessonController.getLessonMap().remove(10);
        String lesson = lessonController.getLessonMap().get(10);

        //dersi sildigimiz için hasmapten ilgili dersi istedigimiz zaman null gelmesi gerekiyor.
        Assertions.assertNull(lesson);
    }

}
