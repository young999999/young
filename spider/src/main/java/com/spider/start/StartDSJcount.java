package com.spider.start;

import com.spider.entity.Movie;
import com.spider.entity.Page;
import com.spider.mapper.MovieMapper;
import com.spider.service.IDownLoadService;
import com.spider.service.IProcessService;
import com.spider.service.impl.HttpClientDownloadService;
import com.spider.service.impl.MovieListProcessServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author young
 * @create 2020-01-18 18:33
 * @blame Android Team
 */
@Data
@RestController
public class StartDSJcount {

    @Autowired
    MovieMapper movieMapper;

    private IDownLoadService downLoadService;
    private IProcessService processService;
    private IProcessService judgmentMovieListPageService;
    private IProcessService processMovie;


    public static void main(String[] args) {
        StartDSJcount dsj = new StartDSJcount();
        dsj.setDownLoadService(new HttpClientDownloadService());
        dsj.setProcessService(new MovieListProcessServiceImpl());
        dsj.setJudgmentMovieListPageService(new MovieListProcessServiceImpl());
        dsj.setProcessMovie(new MovieListProcessServiceImpl());

        /*此处之后放进一个while（1）的循环内，将页数以步长1依次增加*/
//        String url ="https://api.123zx.net/?m=vod-index-pg-"+1+".html";

//        Page movieListPage = dsj.downloadMovieListPage(url);//得到某页电影集合页面

        /*增加一个方法判断body/div[5]/ul[2]/li/span[2]/a这个xpath路径(每页第一步电影名称)是否存在，存在继续解析，不存在则跳出循环*/
//        System.err.println("该页是否有电影："+dsj.judgmentMovieListPage(movieListPage));

//        List<String> movieList =dsj.processMovieList(movieListPage);
//        for (String movieUrl : movieList) {
//            System.err.println(movieUrl);
        Page moviePage = dsj.downloadMovieListPage("https://api.123zx.net/?m=vod-detail-id-42532.html");
        Movie movie = dsj.processMovie(moviePage);
        movie.setId(1L);
        System.err.println(movie);
//            break;
//        }
    }

    @GetMapping("climb")
    public void saveMovie() {
        StartDSJcount dsj = new StartDSJcount();
        dsj.setDownLoadService(new HttpClientDownloadService());
        dsj.setProcessService(new MovieListProcessServiceImpl());
        dsj.setJudgmentMovieListPageService(new MovieListProcessServiceImpl());
        dsj.setProcessMovie(new MovieListProcessServiceImpl());
        long id = 0L;

        /*此处之后放进一个while（1）的循环内，将页数以步长1依次增加*/
        String url = "https://api.123zx.net/?m=vod-index-pg-" + 1 + ".html";

        Page movieListPage = dsj.downloadMovieListPage(url);//得到某页电影集合页面

        /*增加一个方法判断body/div[5]/ul[2]/li/span[2]/a这个xpath路径(每页第一步电影名称)是否存在，存在继续解析，不存在则跳出循环*/
        System.err.println("该页是否有电影：" + dsj.judgmentMovieListPage(movieListPage));

        List<String> movieList = dsj.processMovieList(movieListPage);

        for (String movieUrl : movieList) {
//            System.err.println(movieUrl);
            Page moviePage = dsj.downloadMovieListPage(movieUrl);
//        Page moviePage = dsj.downloadMovieListPage("https://api.123zx.net/?m=vod-detail-id-41217.html");
            Movie movie = dsj.processMovie(moviePage);
            System.err.println("id="+(id++));

            movieMapper.insert(movie);
//            break;
        }
        System.err.println("第"+1+"页完成");
    }

    //判断某一页的是否存在电影集合
    private boolean judgmentMovieListPage(Page page) {
        return this.judgmentMovieListPageService.judgmentMovieListPage(page);
    }

    //下载某一页电影集合的页面
    private Page downloadMovieListPage(String url) {
        return this.downLoadService.download(url);
    }

    //解析某一页电影集合的页面
    private List processMovieList(Page page) {
        return this.processService.processMovieList(page);
    }

    //解析某一部电影的页面
    private Movie processMovie(Page page) {
        return this.processMovie.processMovie(page);
    }


}
