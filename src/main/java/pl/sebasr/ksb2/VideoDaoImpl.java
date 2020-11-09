package pl.sebasr.ksb2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void updateVideo(Video newVideo) {
        String sql = "update videos set videos.title=?, videos.url=? where videos.video_id=?";
        jdbcTemplate.update(sql, newVideo.getTitle(), newVideo.getUrl(), newVideo.getVideoId());
    }

    @Override
    public void deleteVideo(long id) {
        String sql = "delete from videos where videos.video_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Video getOne(long id) {
        String sql = "select * from videos where videos.video_id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, i) -> new Video(rs.getLong("video_id"),rs.getString("title"),rs.getString("url")), id);
    }
}
