package pl.sebasr.ksb2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VideoDaoImpl implements VideoDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public VideoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveVideo(long id, String title, String url) {
        Video video = new Video(id, title, url);
        String sql = "insert into videos values (?,?,?)";
        jdbcTemplate.update(sql,video.getVideoId(), video.getTitle(), video.getUrl());

    }

    @Override
    public List<Video> findAll() {

        List<Video> videoList = new ArrayList<>();
        String sql = "select * from videos";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> videoList.add(
                new Video(
                        Long.parseLong(String.valueOf(element.get("video_id"))),
                        String.valueOf(element.get("title")),
                                String.valueOf(element.get("url"))
                        )));

        return videoList;
    }

    @Override
    public void updateVideo(Video video) {

    }

    @Override
    public void deleteVideo(long id) {

    }
}
