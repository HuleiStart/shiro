import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author Mr.Hu
 * @create 2022/10/27 15:15
 */
public class MyRealm extends AuthenticatingRealm {
//    自定义登录认证方法，shiro的login方法底层会调用该类的认证方法进行认证
//    需要配置自定义的 realm 生效，在 ini 文件中配置，或 Springboot 中配置
//    该方法只是获取进行对比的信息，认证逻辑还是按照 Shiro 的底层认证逻辑完成认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        1.获取身份信息
        String principal = authenticationToken.getPrincipal().toString();
//        2、获取凭证信息
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("认证用户认证信息 = " + principal + "---" + password);
//        3.获取数据库存储的用户信息
        if(principal.equals("zhangsan")){
//            3.1 数据库中已经加盐5次迭代的密码
            String pwdInfo = "690d7828d51fa7f12bc0d8182a0673a5";
//            4.创建封装校验逻辑的对象，封装数据返回
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    authenticationToken.getPrincipal(),
                    pwdInfo,
                    ByteSource.Util.bytes("hu"),
                    authenticationToken.getPrincipal().toString()
            );
            return info;
        }


        return null;
    }
}
