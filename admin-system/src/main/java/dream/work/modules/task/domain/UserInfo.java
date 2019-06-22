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
@Table(name="user_info")
public class UserInfo implements Serializable {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 账号
     */
    @Column(name = "account")
    private String account;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 历史总积分
     */
    @Column(name = "his_point")
    private Long hisPoint;

    /**
     * 现有积分
     */
    @Column(name = "point")
    private Long point;

    /**
     * 平台
     */
    @Column(name = "generalize")
    private Integer generalize;

    /**
     * 邀请码
     */
    @Column(name = "invite")
    private String invite;

    /**
     * 提现金额
     */
    @Column(name = "money")
    private Integer money;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private Integer createBy;

    /**
     * 修改人
     */
    @Column(name = "update_by")
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