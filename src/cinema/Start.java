package cinema;

import java.util.Scanner;

public class Start {
    ////主菜单，为登录前的菜单
    public void start() {
        String wayToStart = "0";
        String end = "0";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            ////选择注册或是登录
            System.out.println("请选择（注册/登录）（第一次使用请先注册）:");
            if(scanner.hasNextLine()) {
                wayToStart = scanner.nextLine();
            }

            if(wayToStart.equals("注册")) {
                SignUp signUp = new SignUp();
                signUp.signUp();
            }else if(wayToStart.equals("登录")) {
                SignInAndSignOut signIn = new SignInAndSignOut();
                ////设置计数器，当连续输入五次不匹配的登录信息后，该账户会被锁定
                int i = 0;
                while(true) {
                    ////输入登录信息
                    signIn.typeIn();
                    ////判断用户是否存在
                    if(UserInformation.hasKey(signIn.userName())) {
                        ////判断用户是否被锁定
                        if(!UserInformation.getLockInformation(signIn.userName())) {
                            ////判断登录信息是否匹配
                            if(signIn.examine()) {
                                String userType = signIn.userType();
                                String userName = signIn.userName();
                                ////判断用户类型
                                if(userType.equals("顾客")) {
                                    CustomerFunctions customer = new CustomerFunctions(userName);
                                    customer.functions();
                                }else if(userType.equals("前台")) {
                                    System.out.println("暂时无法使用此用户类型");
                                }else if(userType.equals("管理员")) {
                                    System.out.println("暂时无法使用此用户类型");
                                }else if(userType.equals("经理")) {
                                    System.out.println("暂时无法使用此用户类型");
                                }
                                break;
                            }else {
                                System.out.println("信息不匹配，登录失败，请重试");
                                i++;
                                if(i == 5) {
                                    System.out.println("您已输错5次，账户已被锁定，请寻求管理员的帮助");
                                    UserInformation.lock(signIn.userName());
                                    break;
                                }
                            }
                        }else {
                            System.out.println("您的账户已被锁定，无法登录，请寻求管理员的帮助");
                            break;
                        }
                    }else {
                        System.out.println("不存在此账户名");
                        break;
                    }
                }
            }else {
                System.out.println("选择无效");
            }
////从这里可以退出程序
            System.out.println("是否退出程序？（是/否）:");
            if(scanner.hasNextLine()) {
                end = scanner.nextLine();
            }
            if(end.equals("是")) {
                break;
            }
        }
    }
}
