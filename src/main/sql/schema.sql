/*
创建在线书城数据库 online_shop
 */
CREATE DATABASE
IF NOT EXISTS  `online_shop`
DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- 使用数据库
use online_shop;
/*
创建用户表
用户id: user_id
登录名: login_name
密码: login_pass
邮箱: email
激活状态: status
激活码: activation_code
 */
CREATE TABLE user (
`user_id` CHAR(32) NOT NULL COMMENT '用户id',
`login_name` VARCHAR(50) COMMENT '登录名',
`login_pass` VARCHAR(50) COMMENT '登录密码',
`email` VARCHAR(50) COMMENT '注册邮箱',
`status` tinyint(1) COMMENT '激活状态',
`activation_code` CHAR(64) COMMENT '激活码',
PRIMARY KEY (user_id),
KEY idx_user_id (user_id),
KEY idx_login_name (login_name),
KEY idx_login_pass (login_pass)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '用户表';
--初始化数据
INSERT INTO
user (user_id, login_name, login_pass, email, status, activation_code)
 VALUES
 ("001","zhangsan","123","tomcatkai@gmail.com",1,"activecode01"),
 ("002","lisi","123","tomcatkai@gmail.com",1,"activecode02"),
 ("003","wangwu","123","tomcatkai@gmail.com",1,"activecode03");

/*
创建图书分类表
classify_id: 图书分类id
classify_name: 图书分类名
classify_cid: 图书分类子分类id
classify_pid 图书分类父分类id
 */
 CREATE TABLE classify(
`classify_id` CHAR (32) NOT  NULL COMMENT '图书分类id',
`classify_name` VARCHAR (50) COMMENT '图书分类名',
`classify_cid` CHAR (32) COMMENT '图书分类子分类id',
`classify_pid` CHAR (32) COMMENT '图书分类父分类id',
PRIMARY KEY (classify_id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '图书分类表';
ALTER TABLE classify modify `classify_id` CHAR (32) NOT NULL;
/*
创建图书表
图书id: book_id
图书标题: book_name
图书副标题: book_subhead
图书作者: book_author
图书出版社: book_publisher
图书原价: book_price_former
图书现价: book_price_current
图书折扣: book_discount
图书详细描述: book_description
图书出版时间: book_publish_time
图书译者: book_translator
图书缩略图(小图片):book_pic_small
图书预览图(大图片):book_pic_big
图书分类: book_classify
 */
CREATE TABLE book(
`book_id` CHAR(32) NOT NULL COMMENT '图书id',
`book_name` VARCHAR (50) COMMENT '图书标题',
`book_subhead` VARCHAR (200) COMMENT '图书副标题',
`book_author` VARCHAR (50) COMMENT '图书作者',
`book_publisher` VARCHAR (50) COMMENT '图书出版社',
`book_price_former` DOUBLE COMMENT '图书原价',
`book_price_current` DOUBLE COMMENT '图书现价',
`book_discount` DOUBLE COMMENT '图书折扣',
`book_description` VARCHAR (200) COMMENT '图书详细描述',
`book_publish_time` DATE COMMENT '图书出版时间',
`book_translator` VARCHAR (50) COMMENT '图书译者',
`book_pic_small` VARCHAR (200) COMMENT '图书缩略图(小图片)',
`book_pic_big` VARCHAR (200) COMMENT '图书预览图(大图片)',
`book_classify_id` CHAR (32) NOT NULL COMMENT '图书所属分类',
PRIMARY KEY (book_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '图书表';
--初始化数据
INSERT INTO
book(book_id, book_name, book_subhead, book_author, book_publisher, book_price_former, book_price_current, book_discount, book_description, book_publish_time, book_translator, book_pic_small, book_pic_big, book_classify_id)
VALUES
('001','清单人生','霍思燕推荐。巴克曼继《外婆的道歉信》新作。人生有一种艰难，是舍弃无比熟悉的生活，重新开始。随书赠暖心咖啡杯垫','弗雷德里克·巴克曼','天津人民出版社',42.00,31.50,7.5,'全球900万畅销之王巴克曼“暖心三部曲”*终话，美亚近满分五星好评，Goodreads十万读者推荐，来自北欧的治愈系小说，笑中带泪的阅读感受。每个人都有自己的“重新开始”，每一次“重新开始”都值得鼓舞','2018-4-5','','d/abc','d/abc','001');
--增加外键
--图书所属分类id
ALTER TABLE book ADD FOREIGN KEY classifyFK(book_classify_id) REFERENCES classify(classify_id);
/*
创建购物车表
cart_id: 购物车条目id
cart_uid: 购物车条目所属用户id
cart_book_id: 购物车条目所含图书id
cart_book_num: 购物车条目所含图书数量
 */
CREATE TABLE cart(
`cart_id` CHAR (32) NOT NULL COMMENT '购物车条目id',
`cart_uid` CHAR(32) NOT NULL COMMENT '购物车条目所属用户id',
`cart_book_id` CHAR (32) NOT NULL COMMENT '购物车条目所含图书id',
`cart_book_num` INT COMMENT '购物车条目所含图书数量',
PRIMARY KEY (cart_id),
FOREIGN KEY (cart_uid) REFERENCES user (user_id),
FOREIGN KEY (cart_book_id) REFERENCES book (book_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '购物车表';
/*
创建订单表
order_id: 订单id
order_address: 订单收货地址
order_user_id: 订单所属用户id
order_count: 订单总金额
order_time: 订单下单时间
 */
CREATE TABLE orders(
`order_id` CHAR(32) NOT  NULL COMMENT '订单id',
`order_address` VARCHAR (50) COMMENT '订单收货地址',
`order_user_id` CHAR (32) NOT NULL COMMENT '订单所属用户id',
`order_count` DOUBLE COMMENT '订单总金额',
`order_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '订单下单时间',
PRIMARY KEY (order_id),
FOREIGN KEY (order_user_id) REFERENCES user (user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '订单表';

/*
创建管理员表
admin_id: 管理员id
admin_login_name 管理员登录名
admin_login_pass 管理员登录密码
 */
CREATE TABLE administrator(
`admin_id` CHAR (32) COMMENT '管理员id',
`admin_login_name` VARCHAR (50) COMMENT '管理员登录名',
`admin_login_pass` VARCHAR (50) COMMENT '管理员登录密码',
PRIMARY KEY (admin_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = '管理员表';