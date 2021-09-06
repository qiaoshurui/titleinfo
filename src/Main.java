import util.DbUtil;
import view.LoginFrom;
import view.UserPassword;

public class Main {

    public static void main(String[] args) throws Exception {
        DbUtil.getConnection();
        new LoginFrom();
//        new UserPassword();
//        new MainFrm();
    }
}
