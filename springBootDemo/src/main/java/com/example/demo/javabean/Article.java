package com.example.demo.javabean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author young
 * @since 2020-01-03
 */
@TableName("article")
public class Article extends Model<Article> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    /**
     * md文件源码
     */
    @TableField("mdContent")
    private String mdContent;

    /**
     * html源码
     */
    @TableField("htmlContent")
    private String htmlContent;

    private String summary;

    private Integer cid;

    private Integer uid;

    @TableField("publishDate")
    private LocalDateTime publishDate;

    @TableField("editTime")
    private LocalDateTime editTime;

    /**
     * 0表示草稿箱，1表示已发表，2表示已删除
     */
    private Integer state;

    @TableField("pageView")
    private Integer pageView;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdContent() {
        return mdContent;
    }

    public void setMdContent(String mdContent) {
        this.mdContent = mdContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDateTime getEditTime() {
        return editTime;
    }

    public void setEditTime(LocalDateTime editTime) {
        this.editTime = editTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", title=" + title +
        ", mdContent=" + mdContent +
        ", htmlContent=" + htmlContent +
        ", summary=" + summary +
        ", cid=" + cid +
        ", uid=" + uid +
        ", publishDate=" + publishDate +
        ", editTime=" + editTime +
        ", state=" + state +
        ", pageView=" + pageView +
        "}";
    }
}
