package com.example.demo.javabean;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author BaoZhou
 * @since 2020-01-03
 */
@TableName("pvview")
public class Pvview extends Model<Pvview> {

    private static final long serialVersionUID=1L;

    private BigDecimal pv;

    private Integer uid;


    public BigDecimal getPv() {
        return pv;
    }

    public void setPv(BigDecimal pv) {
        this.pv = pv;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Pvview{" +
        "pv=" + pv +
        ", uid=" + uid +
        "}";
    }
}
