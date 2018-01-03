package com.qing.core.listener;

import com.qing.core.utils.PropertiesReadUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description 服务器监听
 *
 * @author 谢进伟
 *
 * @createDate 2016年2月28日 下午5:22:04
 */
public class ApplicationListener implements ServletContextListener {

    private static ServletContext servletContext;

    /**
     * 获取服务器缓存值
     *
     * @param key
     *            缓存值Key
     * @return
     */
    public static Object getAttribute(String key) {
        return servletContext.getAttribute(key);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log("The server has stopped...");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log("The server is started...");
        servletContext = sce.getServletContext();
        setLog4jFilePath(servletContext);
//		ResourceBundle rb = ResourceBundle.getBundle("sysconfig");
        String imgReadPath = PropertiesReadUtil.getContextProperty("imgReadPath");
        String cssReadPath = PropertiesReadUtil.getContextProperty("cssReadPath");
        String javaScriptReadPath = PropertiesReadUtil.getContextProperty("javaScriptReadPath");
        // 设置图片读取路径
        log("设置图片读取路径:" + imgReadPath);
        servletContext.setAttribute("imgReadPath", imgReadPath);
        // 设置CSS读取路径
        log("设置CSS读取路径:" + cssReadPath);
        servletContext.setAttribute("cssReadPath", cssReadPath);
        // 设置javaScript脚本读取路径
        log("设置javaScript脚本读取路径:" + javaScriptReadPath);
        servletContext.setAttribute("javaScriptReadPath", javaScriptReadPath);
        String contextPath = servletContext.getContextPath();
        servletContext.setAttribute("ctx", contextPath);
    }

    private void setLog4jFilePath(ServletContext servletContext) {
        String webApp = servletContext.getInitParameter("webAppRootKey");
        String relativeLog4jPath = servletContext.getInitParameter("log4jPath");
        String log4jPath = servletContext.getRealPath(relativeLog4jPath);
        System.setProperty(webApp, log4jPath);
        log("设置日志存储位置：" + log4jPath);
    }

    private void log(String msg) {
        System.out.println("信息:" + msg);
    }
}
