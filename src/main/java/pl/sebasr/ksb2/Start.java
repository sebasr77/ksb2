package pl.sebasr.ksb2;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    public Start(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
//        videoDao.saveVideo(2L,"Friends", "http://friends.com");
//        videoDao.saveVideo(3L,"Dexter", "http://dexter.com");

        videoDao.findAll().forEach(System.out::println);

    }


    private VideoDao videoDao;
}