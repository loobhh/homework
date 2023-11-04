package cinema;

import java.util.Scanner;

public class ResetPassword {
    public void resetPassword(String userType, String userName) {
        Scanner scanner = new Scanner(System.in);
////用户身份修改密码
        if(userType.equals("用户")) {
            System.out.println("请输入原密码：");
            String oldPassword = scanner.nextLine();
            while(!(UserInformation.getRealPassword(userName).equals(oldPassword))){
                System.out.println("密码输入错误,是否要继续尝试输入？");
                String ifContinue = scanner.nextLine();
                if(!ifContinue.equals("是")){
                    return;
                }else {
                    System.out.println("请输入原密码：");
                    oldPassword = scanner.nextLine();
                }
            }

            System.out.println("请输入新密码(长度要求大于8个字符)：");
            String newPassword = scanner.nextLine();
            while(newPassword.length()<=8){
                System.out.println("新密码长度不符合要求，请重新输入(新密码长度要求大于8个字符)：");
                newPassword = scanner.nextLine();
            }

            if(UserInformation.resetOwnPassword(userName, oldPassword, newPassword)) {
                System.out.println("密码修改成功");
            }else {
                System.out.println("密码修改失败");
            }
        }
////管理员身份修改密码
        else if(userType.equals("管理员")) {
            System.out.println("请输入要修改的用户名：");
            String userToReset = scanner.nextLine();
            if(userName == userToReset) {
                System.out.println("请输入原密码：");
                String oldPassword = scanner.nextLine();
                System.out.println("请输入新密码：");
                String newPassword = scanner.nextLine();
                if(UserInformation.resetOwnPassword(userToReset, oldPassword, newPassword)) {
                    System.out.println("密码修改成功!");
                }else {
                    System.out.println("密码修改失败");
                }
            }else {
                System.out.println("请输入新密码：");
                String newPassword = scanner.nextLine();
                String oldPassword = UserInformation.getRealPassword(userToReset);
                if(oldPassword == UserInformation.resetPassword(userToReset, newPassword)) {
                    System.out.println("密码修改成功!");
                }
            }
        }else {
            System.out.println("您没有修改密码的权限");
        }
    }
}
