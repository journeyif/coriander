package com.coriander.system;

import cn.dev33.satoken.SaManager;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 系统模块
 *
 * @author coriander
 */
// 表示通过aop框架暴露该代理对象,AopContext能够访问
@EnableAspectJAutoProxy(exposeProxy = true)
// 开启线程异步执行
@EnableAsync
@ComponentScan("com.coriander")
// 指定要扫描的Mapper类的包的路径
@MapperScan("com.coriander.**.mapper")
@Slf4j
@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        log.info("\n" +
                " \n" +
                "                           _ooOoo_\n" +
                "                          o8888888o\n" +
                "                          88\" . \"88\n" +
                "                          (| -_- |)\n" +
                "                          O\\  =  /O\n" +
                "                       ____/`---'\\____\n" +
                "                     .'  \\\\|     |//  `.\n" +
                "                    /  \\\\|||  :  |||//  \\\n" +
                "                   /  _||||| -:- |||||-  \\\n" +
                "                   |   | \\\\\\  -  /// |   |\n" +
                "                   | \\_|  ''\\---/''  |   |\n" +
                "                   \\  .-\\__  `-`  ___/-. /\n" +
                "                 ___`. .'  /--.--\\  `. . __\n" +
                "              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n" +
                "             | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                "             \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n" +
                "        ======`-.____`-.___\\_____/___.-`____.-'======\n" +
                "                           `=---='\n" +
                "        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n" +
                " ε=ε=(ノ≧∇≦)ノ゜❅。゜。   系统模块启动完成      ε=ε=(ノ≧∇≦)ノ゜❅。゜。\n" +
                "                   // 佛祖保佑 永不宕机 永无BUG //\n\n");

        log.info("Sa-Token配置:\n{}", JSONUtil.toJsonPrettyStr(SaManager.getConfig()));
    }
}
