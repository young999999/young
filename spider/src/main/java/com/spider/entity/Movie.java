package com.spider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author young
 * @create 2020-01-25 20:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor //生成无参的构造方法。
@TableName("movie")
public class Movie {

    //    @TableId(value = "id", type = IdType.AUTO)
    @TableField("id")
    private long id=0L;

    @TableField("movieName")
    private String movieName;//电影名

    @TableField("movieCategory")
    private String movieCategory;//电影类别

    @TableField("movieCollection")
    private String movieCollection;//电影集


}
