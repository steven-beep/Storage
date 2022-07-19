package com.al_tair.storage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import javax.persistence.*;

/**
 * @author Al_tair
 * @date 2022/7/18-10:34
 */

@Data
@Table(name = "userfile", uniqueConstraints = {
        @UniqueConstraint(name = "fileindex", columnNames = {"fileName", "filePath", "extendName"})})
@Entity
@TableName("userfile")
public class UserFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint(20) comment '用户文件id'")
    @TableId(type = IdType.AUTO)
    private Long userFileId;

    @Column(columnDefinition = "bigint(20) comment '用户id'")
    private Long userId;

    @Column(columnDefinition="bigint(20) comment '文件id'")
    private Long fileId;

    @Column(columnDefinition="varchar(100) comment '文件名'")
    private String fileName;

    @Column(columnDefinition="varchar(500) comment '文件路径'")
    private String filePath;

    @Column(columnDefinition="varchar(100) comment '扩展名'")
    private String extendName;

    @Column(columnDefinition="int(1) comment '是否是目录 0-否, 1-是'")
    private Integer isDir;

    @Column(columnDefinition="varchar(25) comment '上传时间'")
    private String uploadTime;

}