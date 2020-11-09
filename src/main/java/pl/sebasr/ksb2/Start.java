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

//        videoDao.updateVideo(new Video(3L, "Dexter 2", "https:/dexter2.com"));
//        videoDao.deleteVideo(2L);
//        videoDao.findAll().forEach(System.out::println);

        System.out.println(videoDao.getOne(3L));
    }


    private VideoDao videoDao;
}
