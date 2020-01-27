package com.spider.service.impl;

import com.spider.entity.Movie;
import com.spider.entity.Page;
import com.spider.service.IProcessService;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author young
 * @create 2020-01-18 18:42
 */
public class MovieListProcessServiceImpl implements IProcessService {

    @Override
    public List processMovieList(Page page) {

        List movieList = new ArrayList();//存放某页电影集合中每部电影的链接

        String content = page.getContent();//得到下载的页面

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNoade = htmlCleaner.clean(content);
        try {
            /*即/html/body/div[5]*/
            Object[] evaluateXPath = rootNoade.evaluateXPath("/body/div[5]");

            if (evaluateXPath.length > 0 && evaluateXPath != null) {
                TagNode node = (TagNode) evaluateXPath[0];

                /*node.getChildTagList() => ul的集合*/
                for (int i = 1; i < node.getChildTagList().size() - 2; i++) {

//                    System.out.println();

                    /*node.getChildTagList().get(i) => ul*/
                    TagNode tagNode = node.getChildTagList().get(i);
//                    System.err.println(tagNode.getName() + ": " + tagNode.getChildTagList().size());

                    /*tagNode.getChildTagList() => li的集合*/
                    for (TagNode tagNode1 : tagNode.getChildTagList()) {


//                        System.out.println(tagNode1.getName() + ": " + tagNode1.getChildTagList().size());

                        for (int j = 1; j < tagNode1.getChildTagList().size() - 1; j++) {

                            if (j == 1) {
//                                System.out.print("电影名称：");
//                                System.err.print(tagNode1.getChildTagList().get(j).getText()+" ");

                                TagNode tagNode2 = tagNode1.getChildTagList().get(j).getChildTagList().get(0);
//                                System.out.print("链接：");
//                                System.err.print("https://api.123zx.net"+tagNode2.getAttributeByName("href")+" ");
                                String movieUrl = "https://api.123zx.net" + tagNode2.getAttributeByName("href");
                                movieList.add(movieUrl);
                            }
                            if (j == 2) {
//                                System.out.print("电影类别：");
//                                System.err.print(tagNode1.getChildTagList().get(j).getText()+" ");
                            }
                        }
                    }
                }
            }

        } catch (XPatherException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public Movie processMovie(Page page) {
        Movie movie = new Movie();
        List list = new ArrayList();//存放某电影集合
        String movieCollection = new String();//存放某电影集合

        String content = page.getContent();//得到下载的页面
//        System.err.println(content);

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNoade = htmlCleaner.clean(content);
        try {
            //电影每集的链接和集数
            Object[] evaluateXPathMovieCollection = rootNoade.evaluateXPath("/body/div[5]/div[4]/div/div/ul[2]");
            if (evaluateXPathMovieCollection.length > 0 && evaluateXPathMovieCollection != null) {
                TagNode node = (TagNode) evaluateXPathMovieCollection[0];

                for (int i = 0; i < node.getChildTagList().size(); i++) {
                    TagNode tagNode = node.getChildTagList().get(i);

                    String value = tagNode.getChildTagList().get(0).getAttributeByName("value");
                    if (i==node.getChildTagList().size()-1){
                        movieCollection =movieCollection.concat("第"+(i+1)+"集"+"$"+value);
                    }else {
                        movieCollection =movieCollection.concat("第"+(i+1)+"集"+"$"+value+",");
                    }
                }
//                for (TagNode tagNode : node.getChildTagList()) {
////                    list.add(tagNode.getText());
//                    movieCollection =movieCollection.concat(node.getText()+",");
//                    break;
//                }
                movie.setMovieCollection( movieCollection);
            }
            //电影名称
            Object[] evaluateXPathMovieName = rootNoade.evaluateXPath("/body/div[5]/div[1]/div/div/div[2]/div[1]/h2");

            if (evaluateXPathMovieName.length > 0 && evaluateXPathMovieName != null) {
                TagNode node = (TagNode) evaluateXPathMovieName[0];
                movie.setMovieName(node.getText().toString());
            }


            //电影类别
            Object[] evaluateXPathMovieCategory = rootNoade.evaluateXPath("/body/div[5]/div[1]/div/div/div[2]/div[2]/ul/li[4]/span");

            if (evaluateXPathMovieCategory.length > 0 && evaluateXPathMovieCategory != null) {
                TagNode node = (TagNode) evaluateXPathMovieCategory[0];
                movie.setMovieCategory(node.getText().toString());
            }

        } catch (XPatherException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public boolean judgmentMovieListPage(Page page) {


        String content = page.getContent();//得到下载的页面

        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNoade = htmlCleaner.clean(content);
        try {
            Object[] evaluateXPath = rootNoade.evaluateXPath("body/div[5]/ul[2]/li/span[2]/a");

            if (evaluateXPath.length > 0) {
                return true;
            }

        } catch (XPatherException e) {
            e.printStackTrace();
        }
        return false;

    }
}
