package gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pingan.yang
 * @program SpringCloud
 * @description 校验  http://localhost:8084/service/service?accessToken=true
 * @create 2018-05-23 13:32
 */
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println(request.getMethod() + "    " + request.getRequestURI().toString());

        Object accessToken = request.getParameter("accessToken");
        if (null == accessToken) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }

        System.out.println("Token access succeed");
        return null;
    }
}
