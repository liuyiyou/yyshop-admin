package cn.liuyiyou.shop.system.filter;

import cn.liuyiyou.shop.system.security.jhsipter.JHipsterProperties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/26
 * @version: V1.0
 */
public class CachingHttpHeadersFilter implements Filter {
    public static final int DEFAULT_DAYS_TO_LIVE = 1461;
    public static final long DEFAULT_SECONDS_TO_LIVE;
    private long cacheTimeToLive;
    private JHipsterProperties jHipsterProperties;

    static {
        DEFAULT_SECONDS_TO_LIVE = TimeUnit.DAYS.toMillis(1461L);
    }

    public CachingHttpHeadersFilter(JHipsterProperties jHipsterProperties) {
        this.cacheTimeToLive = DEFAULT_SECONDS_TO_LIVE;
        this.jHipsterProperties = jHipsterProperties;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.cacheTimeToLive = TimeUnit.DAYS.toMillis((long)this.jHipsterProperties.getHttp().getCache().getTimeToLiveInDays());
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setHeader("Cache-Control", "max-age=" + this.cacheTimeToLive + ", public");
        httpResponse.setHeader("Pragma", "cache");
        httpResponse.setDateHeader("Expires", this.cacheTimeToLive + System.currentTimeMillis());
        chain.doFilter(request, response);
    }
}

