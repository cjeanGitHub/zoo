
TestWaitNotifyDemo01:
    2个线程，t1 负责给集合对象中追加元素； t2，当集合元素有5个时，结束自身的无限循环；
        结果，极难实现

TestWaitNotifyDemo02:
    通过在t1中追加睡眠时间，来实现t2获取集合大小的几率（1.增加t2持有时间片长度）

TestWaitNotifyDemo03:
    使用volatile，来实现；volatile是对值的同步，不是对对象的成员属性的同步；无法实现

TestWaitNotifyDemo04:
    使用volatile + sleep ，增加同步时间，使t2拿到的数据是及时正确的

TestWaitNotifyDemo05:
    增加一个int size = 0，也是volatile的，和3的情况一直

TestWaitNotifyDemo06:
    增加一个int size = 0 并且是 sleep，也是volatile的，和4的情况一直

TestWaitNotifyDemo07、8、9、10:
    使用 wait、notify，来实现，需要给t2线程反应时间 ， 需要sleep

TestWaitNotifyDemo11:
    使用 locksupport 来实现

写一个固定容量的同步容器，拥有get set 方法以及 getcount方法，能够支持2个生产者和10个消费者的阻塞调用










