package cinema;

import java.util.Scanner;

public class SignUp {
    private String userName = new String();
    private String passWord = new String();

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("请输入用户名以完成注册（长度不少于5个字符）：");
            if(scanner.hasNextLine()) {
                userName = scanner.nextLine();
            }
            if(userName.length() >= 5) {
                if(!UserInformation.hasKey(userName)) {
                    System.out.println("用户名输入成功");
                    break;
                }else{
                    System.out.println("您输入的用户名已存在，请重新输入");
                }
            }else {
                System.out.println("您输入的用户名不符合规定，请重新输入");
            }
        }
        while(true) {
            System.out.println("请输入密码以完成注册(密码要求长度大于8个字符)：");
            if(scanner.hasNextLine()) {
                passWord = scanner.nextLine();
            }
            if(passWord.length() > 8) {
                System.out.println("密码输入成功");
                break;
            }else {
                System.out.println("您输入的密码不符合规定，请重新输入");
            }
        }
        UserInformation.putInformation(userName, passWord, "顾客");
        System.out.println("您已完成注册");
    }
}
