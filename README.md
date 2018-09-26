[![Build Status](https://travis-ci.org/vancefantasy/flyer-springboot-rest.svg?branch=master)](https://travis-ci.org/vancefantasy/flyer-springboot-rest)

# flyer-springboot-rest是什么？
flyer-springboot-rest是一个示例项目，它由flyer-maker生成。flyer-springboot-rest尝试提供一种项目搭建的最佳实践，让开发人员快速开发生产可用的Restful服务。

# 集成组件
- SpringBoot 2.0.5
- mapper、entity、dao、service、controller及对应单元测试（根据数据库表生成）
- 第三方工具包(Guava,Jodd,vjkit,common-*等)，满足缓存、字符串、日期、Json、集合、Http、IO等的日常处理
- 异常处理最佳实践
- 全局拦截器，记录请求响应信息
- Logback集成(Rest接口设置日志级别等)
- 单元测试、Mock测试

# 关于单元测试
写好单元测试不是一件容易的事，这里分享下自己的理解：多数情况下使用单独的数据库运行单元测试，运行完清空数据库，会是一个明智的选择。在本项目中，也体现了这个规则，为避免误清空其他环境数据，运行单元测试前会检测数据库名是否以'_ut'结尾。

# 贡献
本人水平有限，请不吝赐教。有意见或更好建议，请[邮件](mailto:vance.8807@gmail.com)或提issue，也欢迎提交Pull Request。
