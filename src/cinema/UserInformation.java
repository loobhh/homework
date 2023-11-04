package cinema;

import java.util.HashMap;

public class UserInformation {
    private static HashMap<String, String> nameAndPassword = new HashMap<String, String>();
    private static HashMap<String, String> nameAndUserType = new HashMap<String, String>();
    private static HashMap<String, Boolean> ifLocked = new HashMap<String, Boolean>();;
    ////设置用户名、密码和用户类型
    public static void putInformation(String userName, String passWord, String userType) {
        nameAndPassword.put(userName, passWord);
        nameAndUserType.put(userName, userType);
        ifLocked.put(userName, false);
    }
    ////用户自己修改密码
    public static boolean resetOwnPassword(String userName, String oldPassWord, String newPassword) {
        return nameAndPassword.replace(userName, oldPassWord, newPassword);
    }
    ////管理员重置密码
    public static String resetPassword(String userName, String newPassword) {
        return nameAndPassword.replace(userName, newPassword);
    }
    ////用用户名返回记录的密码
    public static String getRealPassword(String userName) {
        return nameAndPassword.get(userName);
    }
    ////用用户名返回记录的用户类型
    public static String getUserType(String userName) {
        return nameAndUserType.get(userName);
    }
    ////锁定账号
    public static void lock(String userName) {
        ifLocked.replace(userName, true);
    }
    ////解锁账号
    public static void unlock(String userName) {
        ifLocked.replace(userName, false);
    }
    ////获取锁定信息
    public static boolean getLockInformation(String userName) {
        return ifLocked.get(userName);
    }
    ////判断是否存在改该用户名
    public static boolean hasKey(String userName) {
        return nameAndPassword.containsKey(userName);
    }
}
