import com.DAO.UserInfoManager;
import com.entity.UserinfoEntity;

/*
 * Created by Moon° on 2017/1/6.
 */
public class Demo {
    public static void main(String[] args) {
        UserInfoManager userInfoManager = new UserInfoManager();
        UserinfoEntity userinfoEntity = new UserinfoEntity();
        userinfoEntity.setUserName("23333");
        userinfoEntity.setUserPsw("23333");
        userinfoEntity.setUserTel("1111111111");
        userInfoManager.addUser(userinfoEntity);
    }
}
