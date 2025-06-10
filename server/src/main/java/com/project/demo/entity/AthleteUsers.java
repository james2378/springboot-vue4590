package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 运动员用户：(AthleteUsers)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AthleteUsers")
public class AthleteUsers implements Serializable {

    // AthleteUsers编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "athlete_users_id")
    private Integer athlete_users_id;

    // 运动员
    @Basic
    private String athletes;
    // 性别
    @Basic
    private String gender;
    // 年龄
    @Basic
    private Integer age;












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
