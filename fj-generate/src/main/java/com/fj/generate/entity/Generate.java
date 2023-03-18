package com.fj.generate.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import lombok.Data;

/**
 * <p>
 * 自定生成代码实体类
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 16:07
 */
@Data
public class Generate {
    // 项目根目录
    private String propertyPath = System.getProperty("user.dir");
    // 项目输出路径
    private String moduleDir = "/fj-business/src/main/java";
    // xml配置路径
    private String resources = "/fj-business/src/main/resources/mapper/";
    // 作者
    private String author = "李丰轩";
    // 生成后是否打开资源路径
    private Boolean isOpen = false;
    // 重新生成文件是否覆盖
    private Boolean isFileOverride = true;
    // 是否开启Swagger2模式
    private Boolean isSwagger2 = true;
    // 数据源配置
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/fj?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&allowLoadLocalInfile=true";
    private String userName = "root";
    private String passWord = "root";
    private DbType dbType = DbType.MYSQL;
    // 模块名
    private String moduleName = "student";
    // 基础包名
    private String basePackage = "com.fj.business";
    // 表前缀
    private String prefix = "fj";
    //是否按用户进行分类
    private Boolean isClass = true;
    //是否将表名转大写字母
    private Boolean isTableNameUppercase = true;
    //要生成的表名
    private String[] tables = {"STUDENT"};
    // 表用户
    private String schemaName = "FJ";
}
