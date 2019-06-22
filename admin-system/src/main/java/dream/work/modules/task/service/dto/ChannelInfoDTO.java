package dream.work.modules.task.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author Yang
* @date 2019-06-22
*/
@Data
public class ChannelInfoDTO implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 渠道名
     */
    private String channelName;

    /**
     * 渠道描述
     */
    private String channelDescribe;

    /**
     * 渠道平台
     */
    private String channelPlatform;

    /**
     * 任务类型
     */
    private Integer channelType;

    /**
     * 图片
     */
    private String img;

    /**
     * 推广类型
     */
    private Integer channelGeneralize;

    /**
     * 单次积分
     */
    private Integer channelOnepoint;

    /**
     * 是否启用
     */
    private Integer channelUsing;

    /**
     * 是否主推
     */
    private Integer channelPriRecommend;

    /**
     * 任务内容
     */
    private String content;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 下载地址
     */
    private String url;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 创建日期
     */
    private Timestamp createdAt;

    /**
     * 更新日期
     */
    private Timestamp updatedAt;
}