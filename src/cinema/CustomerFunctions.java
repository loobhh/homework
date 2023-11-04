package cinema;

import java.util.Scanner;

////登录后的顾客界面
public class CustomerFunctions {
    String userType = new String("用户");
    String userName = new String();
    public CustomerFunctions(String userName) {
        this.userName = userName;
    }
    public void functions() {
        Scanner scanner = new Scanner(System.in);
        String function = new String("0");
        System.out.println("登录成功！");
        while(true) {
            System.out.println("选择一种功能（修改密码/退出登录）：");
            if(scanner.hasNextLine()) {
                function = scanner.nextLine();
            }
            if(function.equals("退出登录")) {
                SignInAndSignOut signOut = new SignInAndSignOut();
                if(signOut.signOut()) {
                    break;
                }
            }else if(function.equals("修改密码")) {
                ResetPassword reset = new ResetPassword();
                reset.resetPassword(userType, userName);
            }
        }
    }
}
