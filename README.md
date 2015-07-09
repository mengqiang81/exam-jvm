# JVM 编程任务
-------------------

**感谢您参与我们的 Java 开发测试，您需要完成以下几个步骤。**

*注意：整个开发过程应该控制在1-2个小时内完成。*

## 准备
* 我们不强制要求您一定要用 java 语言开发，只要是可以在 JVM（Java7 或者 Java8） 上运行的语言都可以（Groovy, Scala... ）。
* 我们不关心您使用什么构建工具，但是您要做到 IDE 无关，并保证我们签出即可运行。
* 我们不关心您使用什么样的持久化方式（可以使用内存），但是一定要内嵌到程序中，因为我们不会专门再去安装一个 Mysql 或者 MongoDB。

## 任务
* Fork 这个 Repo（如果您不知道如何去做的话，Google 之）。
* 创建一个可编译的工程。
* 我们的需求是一个交易记录，交易信息包含「交易 ID」、「创建时间」、「交易状态（例如是否交易成功）」、「交易类型（例如支付还是退款）」、「交易金额」、「交易币种（例如美元还是人民币）」、「客户信息」
* 客户信息包含「客户 ID」、「客户姓名」即可
* 通过 Rest 的方式暴露一个创建交易的接口
* 通过 Rest 的方式暴露一个按交易状态查询交易列表的接口

## 测试
1. 使用用户张三创建一条86元5角人民币的交易记录，验证交易状态为等待付款，并且交易的金额是正确的。
2. 使用你所习惯的测试框架，初始化3条交易成功信息，2条交易失败信息。验证查询接口按全部状态查询共5条交易，只查询成功的交易是3条，只查询失败的交易是2条。


## 完成后
1. 提交代码到您的 Github 仓库。
2. 给我们发送一个 Pull request，我们会 Review 您的代码。

## 其他
* 如果您的构建和运行过程比较难以理解的话，建议您修改 Readme 的这个地方添加一些说明文字。

## 另：数据保存在Excel中
交易状态: Completed:已完成  Pending：待付款  Reversed：已撤销   Refunded：已退款
交易类型: Pay：支付  Refund：付款
交易币种: CNY：人民币  USD：美元

