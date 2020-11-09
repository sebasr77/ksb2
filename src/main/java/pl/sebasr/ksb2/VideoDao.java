package pl.sebasr.ksb2;

import java.util.List;

public interface VideoDao {

    public void saveVideo(long id, String title, String url);
    public List<Video> findAll();
    public void updateVideo(Video video);
    public void deleteVideo(long id);
}
