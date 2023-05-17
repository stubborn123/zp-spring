
## 目标
实现一个简单的Spring IoC 容器可以加载bean进来。

## 具体步骤

创建IoC容器

IoC 容器，也就是 BeanFactory，存在的意义就是将创建对象与使用对象的业务代码解耦，让业务开发人员无需关注底层对象（Bean）的构建和生命周期管理，专注于业务开发。

（1）定义BeanDefinition

BeanDefinition是Spring容器中最基本的组成部分之一.
作用有以下：
1. 实例化Bean：通过BeanDefinition，Spring容器可以知道如何实例化一个Bean，包括调用哪个构造函数、设置哪些属性等等。
2. 配置Bean：通过BeanDefinition，Spring容器可以知道如何配置一个Bean，包括设置哪些属性、调用哪些方法等等。
3. 管理Bean的作用域：通过BeanDefinition，Spring容器可以知道如何管理Bean的作用域，包括Singleton、Prototype、Request、Session、Global Session等等。
4. 支持AOP：通过BeanDefinition，Spring容器可以知道如何为一个Bean添加AOP代理，包括使用哪种AOP技术、为哪些方法添加代理等等。

帮助Spring容器完成Bean的实例化、配置、管理和AOP等任务