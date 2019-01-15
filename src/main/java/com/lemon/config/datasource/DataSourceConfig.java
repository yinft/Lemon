package com.lemon.config.datasource;



import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: yinft
 * @Date: 2018/12/13 21:13
 * @Version 1.0
 * 数据源配置类
 */

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.lemon.dao"})
public class DataSourceConfig {

    /**
     * mybatis-plus SQL执行效率插件【生产环境关闭】
     *
     * @return
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor()
    {
        return new PerformanceInterceptor();
    }

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor()
    {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        return paginationInterceptor;
    }
    /**
     * 乐观锁
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}

