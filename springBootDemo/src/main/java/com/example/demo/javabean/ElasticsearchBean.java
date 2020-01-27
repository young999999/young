package com.example.demo.javabean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author young
 * @create 2020-01-14 11:25
 */

@Document(indexName = "example", type = "article")
public class ElasticsearchBean implements Serializable {
    //    @Field(type = FieldType.Text)
    @Id
//    @Field(type = FieldType.Auto)
    private String id;
    // index = true，是否索引，就是看该域是否能被搜索
    // 是否分词，就表示搜索的时候是整体匹配还是单词匹配
    // 是否存储，就是是否在页面显示
    @Field(index = true ,type = FieldType.Text ,analyzer= "ik_max_word", searchAnalyzer = "ik_max_word")
//    @Field(type = FieldType.Auto)
    private String title;

    @Field(index = true,type = FieldType.Text,analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    //@Field(type = FieldType.Keyword)
//    @Field(type = FieldType.Auto)
    private String content;

    //@Field(type = FieldType.Keyword)
    @Field(type = FieldType.Auto)
    // 审核状态
    private String state;


    public ElasticsearchBean() {
    }

    public ElasticsearchBean(String id, String title, String content, String state) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ElasticsearchBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                '}';
    }
}

