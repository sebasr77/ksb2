package pl.sebasr.ksb2;

import java.util.List;

public interface VideoDao {

    public void saveVideo(long id, String title, String url);
    public List<Video> findAll();
    public void updateVideo(Video newVideo);
    public void deleteVideo(long id);
    public Video getOne(long id);
}
