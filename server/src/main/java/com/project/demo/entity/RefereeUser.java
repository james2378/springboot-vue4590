package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 裁判员用户：(RefereeUser)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "RefereeUser")
public class RefereeUser implements Serializable {

    // RefereeUser编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referee_user_id")
    private Integer referee_user_id;

    // 裁判姓名
    @Basic
    private String referee_name;
    // 裁判性别
    @Basic
    private String gender_of_referee;
    // 裁判年龄
    @Basic
    private Integer age_of_referee;



    // 审核状态
    @Basic
    private String examine_state;









    // 用户编号
    @Id
    @Column(name = "user_id")
    private Integer userId;


    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
