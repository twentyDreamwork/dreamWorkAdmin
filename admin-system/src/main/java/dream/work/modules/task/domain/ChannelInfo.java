package dream.work.modules.task.domain;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author Yang
* @date 2019-06-22
*/
@Entity
@Data
@Table(name="channel_info")
public class ChannelInfo implements Serializable {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 渠道名
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 渠道描述
     */
    @Column(name = "channel_describe")
    private String channelDescribe;

    /**
     * 渠道平台
     */
    @Column(name = "channel_platform")
    private String channelPlatform;

    /**
     * 任务类型
     */
    @Column(name = "channel_type")
    private Integer channelType;

    /**
     * 图片
     */
    @Column(name = "img")
    private String img;

    /**
     * 推广类型
     */
    @Column(name = "channel_generalize")
    private Integer channelGeneralize;

    /**
     * 单次积分
     */
    @Column(name = "channel_onepoint")
    private Integer channelOnepoint;

    /**
     * 是否启用
     */
    @Column(name = "channel_using",nullable = false)
    private Integer channelUsing;

    /**
     * 是否主推
     */
    @Column(name = "channel_pri_recommend",nullable = false)
    private Integer channelPriRecommend;

    /**
     * 任务内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 包名
     */
    @Column(name = "package_name")
    private String packageName;

    /**
     * 下载地址
     */
    @Column(name = "url")
    private String url;

    /**
     * 创建人
     */
    @Column(name = "create_by",nullable = false)
    private Integer createBy;

    /**
     * 修改人
     */
    @Column(name = "update_by",nullable = false)
    private Integer updateBy;

    /**
     * 创建日期
     */
    @Column(name = "created_at",nullable = false)
    private Timestamp createdAt;

    /**
     * 更新日期
     */
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}