拆分这个基础的容器

在这个基础上继续拆分功能细化

### 定义BeanFactory
创建BeanFactory 这个接口，两个功能：获取Bean，注册Bean

（实际正版Spring的BeanFactory功能更单一，获取bean，看这个bean是不是单例这些。
注册bean由BeanDefinitionRegistry来定义。
举个例子，XmlBeanFactory，AnnotationConfigApplicationContext都是通过继承BeanFactory来完成获取bean
然后再通过实现BeanDefinitionRegistry来获取注册bean的功能

这里就用BeanFactory来一个人干两份活，实际上分开来，更符合功能单一原则
这也算后面一个修改改进的地方
todo 关于处理BeanFactory，获取bean和注册bean分开
）


### 定义Resource
Spring有一个Resource类，和BeanDefinition一样，抽象化定义。
Spring 可以方便地加载和管理各种资源，例如读取配置文件、加载 XML 文件、获取类路径下的资源等
我们把外部的配置信息都当成 Resource（资源）来进行抽象

### 实现XML读取
定义 ClassPathXmlResource
读取的都是 XML 文件配置，扩展Resource接口，完成解析解析 XML
(这里面用的都是dom4j)

XmlBeanDefinitionReader
将解析XML文件做转换，转换成我们需要的BeanDefinition
在 XmlBeanDefinitionReader 中，有一个 loadBeanDefinitions 方法会把解析的 XML 内容转换成 BeanDefinition，
并加载到 BeanFactory 中。

### BeanFactory 功能扩展

### Resource

### 改造ApplicatoinContext
对比之前的ClassPathXmlApplicationContext（也就是现在的ClassPathXmlApplicationContext01）

改造：
（1）引入BeanFactory和Resource概念，
一个专注注册bean和获取bean，一个专注资源，根据不同的资源的解析转换封装，方便后面注册bean，解耦ApplicationContext，并提高了扩展性
（3）根据BeanFactory和Resource接口定义实现类
根据XML文件读取解析，来是想一个对应处理BeanFactory和封装Resource的实现类
（2）重新设计ApplicationContext
只关注采用什么Resource和BeanFactory即可，将之前的很多逻辑分离出去