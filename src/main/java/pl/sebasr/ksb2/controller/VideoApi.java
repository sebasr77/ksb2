package pl.sebasr.ksb2.controller;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sebasr.ksb2.aop.VideoMail;
import pl.sebasr.ksb2.model.Video;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoApi {

    private List<Video> videoList;

    public VideoApi() {
        this.videoList = new ArrayList<>();
        videoList.add(new Video(1L, "WPROWADZENIE DO ARCHITEKTURY MIKROSERWISÓW - WYKŁAD", "https://youtu.be/ImKvgCMJ_ro"));
        videoList.add(new Video(2L, "KOŃCZYMY APLIKACJE CHATU W SPRINGU I WDRAŻAMY JĄ NA SERWER VPS", "https://youtu.be/vKtFeOXCkHM"));
    }

    @GetMapping
    public List<Video> getVideos() {
        return videoList;
    }

    @EventListener(ApplicationReadyEvent.class)
    @VideoMail
    @PostMapping
    public void addVideo(){
        Video dodane_video = new Video(3L, "Dodane video", "https://");
        videoList.add(dodane_video);
        System.out.println("Added video");
    }
}
