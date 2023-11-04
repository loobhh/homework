package cinema;

import java.util.Scanner;
////此类控制登录和退出账户，功能有输入信息以登录、检查登录信息是否正确、返回登录用户名和用户类型、退出确认
public class SignInAndSignOut {
    private String userName = new String("0");
    private String passWord = new String("0");
    private String userType = new String("0");
    Scanner scanner = new Scanner(System.in);
    ////输入用户名与密码
    public void typeIn() {
        System.out.println("请输入用户名：");
        if(scanner.hasNextLine()) {
            userName = scanner.nextLine();
        }
        System.out.println("请输入密码：");
        if(scanner.hasNextLine()) {
            passWord = scanner.nextLine();
        }
        System.out.println("请输入用户类型（经理/管理员/前台/顾客）：");
        if(scanner.hasNextLine()) {
            userType = scanner.nextLine();
        }
    }
    ////检查用户名与密码和用户类型是否匹配
    public boolean examine() {
        if(passWord.equals((UserInformation.getRealPassword(userName)))&&(userType.equals(UserInformation.getUserType(userName)))) {
            return true;
        }
        else {
            return false;
        }
    }
    ////给Start类返回用户类型的方法
    public String userType() {
        return userType;
    }
    public String userName() {
        return userName;
    }
    public boolean signOut() {
        String whetherToSignOut = "0";
        System.out.println("确定要退出吗？是/否");
        if(scanner.hasNextLine()) {
            whetherToSignOut = scanner.nextLine();
        }
        if(whetherToSignOut.equals("是")) {
            return true;
        }else {
            return false;
        }
    }
}
