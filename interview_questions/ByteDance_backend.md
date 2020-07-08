## 1--数据库隔离级别以及可能出现的问题
数据库事务的隔离级别有4个，由低到高依次为Read uncommitted 、Read committed 、Repeatable read 、Serializable

### Read uncommitted 读未提交
当隔离级别设置为Read uncommitted 时，就可能出现脏读
例子：两个并发的事务，“事务A：领导给singo发工资”、“事务B：singo查询工资账户”，事务B读取了事务A尚未提交的数据
dirty read 脏读: 读到未提交更新的数据

### Read committed 读提交
当隔离级别设置为Read committed 时，避免了脏读，但是可能会造成不可重复读和幻读。一个事务在执行过程中可以看到其他事务已经提交的新插入的记录，而且还能看到其他事务已经提交的对已有记录的更新。
例子：两个并发的事务，“事务A：singo消费”、“事务B：singo的老婆网上转账”，事务A事先读取了数据，事务B紧接了更新了数据，并提交了事务，而事务A再次读取该数据时，数据已经发生了改变。
Nonrepeatable read 不可重复读: 读到已经提交更新的数据，但一个事务范围内两个相同的查询却返回了不同数据。这是由于查询时系统中其他事务修改的提交而引起的。比如事务T1读取某一数据，事务T2读取并修改了该数据，T1为了对读取值进行检验而再次读取该数据，便得到了不同的结果。

### Repeatable read 可重复读
当隔离级别设置为Repeatable read 时，可以避免不可重复读, 但还有可能出现幻读。一个事务在执行过程中可以看到其他事务已经提交的新插入的记录，但是不能看到其他事务对已有记录的更新。这种隔离级别使用共享锁来确保其他事务在原始查询读取行之后不会更新该行。但是，将读取新行（幻读），因为在第一个查询运行时这些行不存在。
Phantom read 幻读: 读到已提交插入数据，幻读是指当事务不是独立执行时发生的一种现象，例如第一个事务对一个表中的数据进行了修改，比如这种修改涉及到表中的“全部数据行”。同时，第二个事务也修改这个表中的数据，这种修改是向表中插入“一行新数据”。那么，以后就会发生操作第一个事务的用户发现表中还有没有修改的数据行，就好象发生了幻觉一样。
不可重复读和幻读的区别：幻读与不可重复读类似，幻读是查询到了另一个事务已提交的新插入数据，而不可重复读是查询到了另一个事务已提交的更新数据。简单来说，不可重复读是由于数据修改引起的，幻读是由数据插入引起的。

### Serializable 可串行化
Serializable 是最高的事务隔离级别，同时代价也花费最高，性能很低，一般很少使用，在该级别下，事务顺序执行，不仅可以避免脏读、不可重复读，还避免了幻读。一个事务在执行过程中完全看不到其他事务对数据库所做的更新。当两个事务同时操作数据库中相同数据时，如果第一个事务已经在访问该数据，第二个事务只能停下来等待，必须等到第一个事务结束后才能恢复运行。

![Alt text](pic/db_read.png)

![Alt text](pic/isolation.png)

## 2--输入url发生的事情
- URL输入: 当我们开始在浏览器中输入网址的时候，浏览器其实就已经在智能的匹配可能得 url 了，他会从历史记录，书签等地方，找到已经输入的字符串可能对应的 url, 浏览器解析出url中的域名。
- DNS解析: DNS解析的过程就是寻找哪台机器上有你需要资源的过程。（注：DNS是（1）在DNS服务器的层次结构中实现的分布式数据库，以及（2）是允许主机查询分布式数据库的应用程序层协议。(3) DNS协议通过UDP运行并使用端口53。）首先，浏览器缓存 ：首先会向浏览器的缓存中读取上一次访问的记录, 查询浏览器的DNS缓存。然后所需的IP地址通常存储在“附近”的DNS服务器中，这有助于减少DNS网络流量以及平均DNS延迟。一般本地 DNS 地址由 ISP（Internet Service Provider，互联网服务提供商）通过 DHCP 协议动态分配。每个ISP（例如大学，学术部门，员工公司或住宅ISP）都具有本地DNS服务器（也称为默认名称服务器）。 当主机连接到ISP时，ISP为主机提供一个或多个本地DNS服务器的IP地址（通常通过DHCP）。 您可以通过访问Windows或UNIX中的网络状态窗口轻松地确定本地DNS服务器的IP地址。 主机的本地DNS服务器通常“靠近”主机。 对于机构ISP，本地DNS服务器可能与主机在同一LAN上； 对于住宅ISP，它通常与主机之间的间隔不超过几个路由器。 主机进行DNS查询时，查询将发送到充当代理的本地DNS服务器，将查询转发到DNS服务器层次结构中。浏览器向本地 DNS 服务器发起请求，由于本地 DNS 服务器没有缓存不能直接将域名转换为 IP 地址，需要采用递归或者迭代查询的方式依次向根域名服务器(Root DNS servers)、顶级域名服务器(Top-level domain (TLD) servers)、权威域名服务器(Authoritative DNS servers)发起查询请求，直至找到一个或一组 IP 地址，返回给浏览器。在查询链中，当DNS服务器收到DNS答复（例如，包含从主机名到IP地址的映射）时，它可以将映射缓存在其本地内存中。
![Alt text](pic/dns_1.png)
![Alt text](pic/dns_2.png)
图2.21所示的示例同时使用了递归查询和迭代查询。 从cis.poly.edu发送到dns.poly.edu的查询是递归查询，因为该查询要求dns.poly.edu代表它获取映射。 但是随后的三个查询是迭代的，因为所有答复都直接返回到dns.poly.edu。 从理论上讲，任何DNS查询都可以是迭代的或递归的。 例如，图2.22显示了所有查询都是递归的DNS查询链。 在实践中，查询通常遵循图2.21中的模式：从请求主机到本地DNS服务器的查询是递归的，其余查询是迭代的。
（注：DNS负载均衡：当一个网站有足够多的用户的时候，假如每次请求的资源都位于同一台机器上面，那么这台机器随时可能会蹦掉。处理办法就是用DNS负载均衡技术，它的原理是在DNS服务器中为同一个主机名配置多个IP地址,在应答DNS查询时,DNS服务器对每个查询将以DNS文件中主机记录的IP地址按顺序返回不同的解析结果,将客户端的访问引导到不同的机器上去,使得不同的客户端访问不同的服务器,从而达到负载均衡的目的｡例如可以根据每台机器的负载量，该机器离用户地理位置的距离等等。）
- 建立TCP连接：
TCP（Transmission Control Protocol 传输控制协议）是一种面向连接的、可靠的、基于字节流的传输层通信协议。TCP建立连接需要三次握手，释放连接需要四次握手。
拿到域名对应的IP地址之后，浏览器会以一个随机端口（1024<端口<65535）向服务器的WEB程序（常用的有httpd,nginx等）80端口发起TCP的连接请求。这个连接请求到达服务器端后（这中间通过各种路由设备，局域网内除外），进入到网卡，然后是进入到内核的TCP/IP协议栈（用于识别该连接请求，解封包，一层一层的剥开），还有可能要经过Netfilter防火墙（属于内核的模块）的过滤，最终到达WEB程序，最终建立了TCP/IP的连接。tcp建立的三次握手:
![Alt text](pic/tcp.png)
![Alt text](pic/3waytcp.png)
- 发送HTTP请求：
建立了TCP连接之后，发起一个http请求。一个典型的 http request header 一般需要包括请求的方法，例如 GET 或者 POST 等，不常用的还有 PUT 和 DELETE 、HEAD、OPTION以及 TRACE 方法，一般的浏览器只能发起 GET 或者 POST 请求。
- HTTP 响应：
服务器收到了我们的请求，也处理我们的请求，到这一步，它会把它的处理结果返回，也就是返回一个HTPP响应。 HTTP响应与HTTP请求相似，HTTP响应也由3个部分构成，分别是：状态行，响应头(Response Header)，空行，响应正文
- 浏览器显示 HTML：
构建dom树 -> 构建render树 -> 布局render树 -> 绘制render树
- 连接结束：
这个关闭的过程就是著名的四次挥手。关闭是一个全双工的过程，发包的顺序的不一定的。一般来说是客户端主动发起的关闭，过程如下：
![Alt text](pic/tcpclose_1.png)
![Alt text](pic/tcpclose_2.png)
## 3--http有哪些header

General headers: 同时适用于请求和响应消息，但与最终消息主体中传输的数据无关的消息头。
    最常见的通用首部包括：Date、Cache-Control 或 Connection。

Request headers: 包含更多有关要获取的资源或客户端本身信息的消息头。
    请求头是 HTTP 头的一种，它可在 HTTP 请求中使用，并且和请求主体无关 。某些请求头如 Accept、Accept-*、 If-* 允许执行条件请求。某些请求头如：Cookie, User-Agent 和 Referer 描述了请求本身以确保服务端能返回正确的响应。

Response headers: 包含有关响应的补充信息，如其位置或服务器本身（名称和版本等）的消息头。
    响应头（Response header） 可以定义为：被用于http响应中并且和响应消息主体无关的那一类 HTTP header。像Age, Location 和 Server都属于响应头，他们被用于描述响应。

Entity headers: 包含有关实体主体的更多信息，比如主体长(Content-Length)度或其MIME类型。
    实体报头HTTP header用来描述消息体内容。实体报头既可用于请求也可用于响应中。如Content-Length，Content-Language，Content-Encoding之类的报头都是实体报头。
    ![Alt text](pic/http1.png)
    ![Alt text](pic/http2.png)
    ![Alt text](pic/http3.png)
    ![Alt text](pic/http4.png)
## 4--http状态码
![Alt text](pic/https1.png)
    ![Alt text](pic/https2.png)
    ![Alt text](pic/https3.png)
    ![Alt text](pic/https31.png)
    ![Alt text](pic/https4.png)
    ![Alt text](pic/https41.png)
    ![Alt text](pic/https5.png)
## 5--TCP三次握手，四次挥手
参考[2--输入url发生的事情](#2--输入url发生的事情)
## 6--TCP建立连接时socket相关函数