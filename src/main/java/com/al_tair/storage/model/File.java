package com.al_tair.storage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import javax.persistence.*;

/**
 * @author Al_tair
 * @date 2022/7/18-10:33
 */

@Data
@Table(name = "file")
@Entity
@TableName("file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition="bigint(20) comment '文件id'")
    @TableId(type = IdType.AUTO)
    private Long fileId;

    @Column(columnDefinition="varchar(500) comment '时间戳名称'")
    private String timeStampName;

    @Column(columnDefinition="varchar(500) comment '文件url'")
    private String fileUrl;

    @Column(columnDefinition="bigint(10) comment '文件大小'")
    private Long fileSize;

    @Column(columnDefinition="int(1) comment '存储类型 0-本地存储, 1-阿里云存储, 2-FastDFS存储'")
    private Integer storageType;

    @Column(columnDefinition="varchar(32) comment 'md5唯一标识'")
    private String identifier;

    @Column(columnDefinition="int(1) comment '引用数量'")
    private Integer pointCount;
}
