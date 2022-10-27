import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author Mr.Hu
 * @create 2022/10/27 15:02
 */
public class shiroMD5 {
    public static void main(String[] args) {
//        密码明文
        String password = "z3";
//        进行MD5加密
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println("md5Hash = " + md5Hash.toHex());
//        带盐的 md5 加密，盐就是在密码明文后拼接新字符串，然后再进行加密
        Md5Hash md5Hash1 = new Md5Hash(password,"hu");
        System.out.println("md5Hash1 = " + md5Hash1.toHex());
//        为了保证安全，避免被破解还可以多次迭代加密，保证数据安全
        Md5Hash md5Hash2 = new Md5Hash(password,"hu",5);
        System.out.println("md5Hash2 = " + md5Hash2.toHex());
//        使用父类实现加密
        SimpleHash simpleHash = new SimpleHash("MD5",password,"hu",5);
        System.out.println("simpleHash = " + simpleHash.toHex());
    }
}
