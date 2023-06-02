IOC容器的增强
增强3个方面 

（1）Bean默认单例模式
单例模式有助于管理，方便维护

（2）监听
有助于代码解耦

（3）扩展BeanDefinition
添加一些属性，光靠名字，id这些还是信息太少了



### 单例整改
单例有助于系统的维护，方便管理
改造的方式分为两部分<br>
（1）BeanFactory其实改动不大，修改一下注册的方法和参数<br>
（2）定义SingletonBeanRegistry接口，规范单例bean的方法

在这两个基础上实现SingletonBeanRegistry接口DefaultSingletonBeanRegistry
重新改写SimpleBeanFactory<br>


DefaultSingletonBeanRegistry是作为默认实现，同样后面可以自定义其他的单例实现替换扩展
改写SimpleBeanFactory在实现BeanFactory基础上，继承DefaultSingletonBeanRegistry。
将单例操作交给DefaultSingletonBeanRegistry来处理，自己只负责整合。<br>
这样就做到对bean的操作和单例的实现解耦。

### 增加事件监听
创建ApplicationEvent 和 ApplicationEventPublisher

ApplicationEventPublisher是一个发布接口

ApplicationEvent是监听事件（继承了 Java 工具包内的 EventObject，后面可以解耦）

### 注入
Field 注入、Setter 注入和构造器（Constructor）注入

属性类： ArgumentValue 和 PropertyValue  （参数值和属性值）
对应的管理单独创建类ArgumentValues 和 PropertyValues


扩展BeanDefinition
在id和className以外，我们还要加一些别的属性来丰富
scope 表示是单例模式还是原型模式
lazyInit 是不是要懒加载（要不要在bean加载的时候初始化）
dependsOn 记录依赖关系
constructorArgumentValues 构造器参数
propertyValues 属性
initMethodName 初始化方法名称

新增BeanDefinitionRegistry接口来管理BeanDefinition的行为，先定义4个常用的接口方法
： register、remove、get、contains

BeanFactory 增加Singleton，Prototype的单例还是原型的判断，以及获取对应的类型

ClassPathXmlApplicationContext 要多实现事件接口