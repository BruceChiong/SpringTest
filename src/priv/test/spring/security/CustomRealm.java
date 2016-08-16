package priv.test.spring.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service("customRealm")
public class CustomRealm extends AuthorizingRealm{

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection paramPrincipalCollection) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermission("account:create");
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken paramAuthenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToke = (UsernamePasswordToken)paramAuthenticationToken;
		System.out.println(usernamePasswordToke.getUsername());
		System.out.println(usernamePasswordToke.getPassword());
		if ("admin".equals(usernamePasswordToke.getUsername())) {  
            return new SimpleAuthenticationInfo("admin", "123", getName());  
        } else {  
            return null;  
        } 
	}

}
