package com.fj.generate.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.fj.common.utils.LoggerUtil;
import com.fj.generate.entity.Generate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 代码生成工具
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/19 0:17
 */
public class GenerateUtils {

    /*生成代码方法*/
    public static void executeRun(Generate generate) {
        String propertyPath = generate.getPropertyPath();
        // 项目输出路径
        String moduleDir = generate.getModuleDir();
        // xml配置路径
        String resources = generate.getResources();
        // 作者
        String author = generate.getAuthor();
        // 生成后是否打开资源路径
        boolean isOpen = generate.getIsOpen();
        // 重新生成文件是否覆盖
        boolean isFileOverride = generate.getIsFileOverride();
        // 是否开启Swagger2模式
        boolean isSwagger2 = generate.getIsSwagger2();
        // 数据源配置
        String driverName = generate.getDriverName();
        String url = generate.getUrl();
        String userName = generate.getUserName();
        String passWord = generate.getPassWord();
        DbType dbType = generate.getDbType();
        // 模块名
        String moduleName = generate.getModuleName();
        // 基础包名
        String basePackage = generate.getBasePackage();
        // 表前缀
        String prefix = generate.getPrefix();
        //是否按用户进行分类
        boolean isClass = generate.getIsClass();
        //是否将表名转大写字母
        boolean isTableNameUppercase = generate.getIsTableNameUppercase();
        //要生成的表名
        String[] tables = generate.getTables();

        // 1.创建代码生成器
        AutoGenerator ag = new AutoGenerator();


        // 2.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(propertyPath + moduleDir);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(isOpen);
        globalConfig.setFileOverride(isFileOverride);
        // 自定义文件命名
        globalConfig.setMapperName("I%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("I%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        // 定义生成的实体类中日期类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setSwagger2(isSwagger2);
        ag.setGlobalConfig(globalConfig);

        // 3.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setUsername(userName);
        dataSourceConfig.setPassword(passWord);
        dataSourceConfig.setDbType(dbType);
        ag.setDataSource(dataSourceConfig);

        // 4.包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(basePackage);
        packageConfig.setModuleName(moduleName);
        // 包配置
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("domain.pojo");
        packageConfig.setEntityVo("domain.vo");
        ag.setPackageInfo(packageConfig);

        // 5.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        // 表名生成策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setTablePrefix(prefix);
        strategyConfig.setEntityLombokModel(true);//自动lombok
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setControllerMappingHyphenStyle(true);
        // 更换大小写
        if (tables.length > 0) {
            if (isTableNameUppercase) {
                tables = uppercase(tables);
            }
            strategyConfig.setInclude(tables); //需要生成的表
            strategyConfig.setSkipView(true);  // 忽略视图
        }
        // 设置继承
        strategyConfig.setSuperControllerClass("com.fj.generate.controller.BaseController");
        strategyConfig.setSuperEntityClass("com.fj.generate.entity.BaseEntity");
        strategyConfig.setSuperMapperClass("com.fj.generate.mapper.IBaseMapper");
        strategyConfig.setSuperServiceClass("com.fj.generate.service.IBaseService");
        strategyConfig.setSuperServiceImplClass("com.fj.generate.service.impl.BaseServiceImpl");
        ag.setStrategy(strategyConfig);

        // 6.模板配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        ag.setTemplate(templateConfig);

        // 7. 自定义配置
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return  propertyPath + resources + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        injectionConfig.setFileOutConfigList(focList);
        ag.setCfg(injectionConfig);

        // 7.执行
        try {
            ag.execute();
        } catch (Exception e) {
            LoggerUtil.printErr(e);
        }
    }

    /*大小写切换*/
    private static String[] uppercase(String[] tables) {
        if (null != tables && tables.length > 0) {
            for (int i = 0; i < tables.length; i++) {
                tables[i] = tables[i].toUpperCase();
            }
        }
        return tables;
    }
}
