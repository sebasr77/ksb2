package pl.sebasr.ksb2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        String sql = "CREATE TABLE videos(video_id int, title varchar(255), url varchar(255), PRIMARY KEY (video_id))";
        getJdbcTemplate().update(sql);
    }

    //    @Bean
//    public DataSource getDataSource(){
//
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://remotemysql.com:3306/sL9M40BVQ4");
//        dataSourceBuilder.username("sL9M40BVQ4");
//        dataSourceBuilder.password("X2ryWofvJw");
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        return dataSourceBuilder.build();
//
//    }


//    public JdbcTemplate getJdbcTemplate(){
//
//        return new JdbcTemplate(getDataSource());
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//
//        String sql="CREATE TABLE videos(video_id int, title varchar(255), url varchar(255), PRIMARY KEY (video_id))";
//        getJdbcTemplate().update(sql);
//    }


}
