package dream.work.modules.task.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;


/**
* @author Yang
* @date 2019-06-22
*/
@Data
public class UserInfoDTO implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String phone;

    /**
     * 历史总积分
     */
    private Long hisPoint;

    /**
     * 现有积分
     */
    private Long point;

    /**
     * 平台
     */
    private Integer generalize;

    /**
     * 邀请码
     */
    private String invite;

    /**
     * 提现金额
     */
    private Integer money;

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