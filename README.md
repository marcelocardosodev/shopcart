#        shop-car
#       CREATE TABLE product (
#       idProduct int not null auto_increment,
#       description varchar(200) not null,
#       category varchar(100) not null,
#       amount int not null,
#       price double not null,
#       online boolean,
#       primary key(idProduct)
#       );
#       
#       CREATE TABLE userstore (
#       idUser int not null auto_increment,
#       name varchar(150) not null,
#       type varchar(100) not null,
#       balance double not null,
#       password varchar(100) not null,
#       primary key(idUser)
#       );
#       
#       CREATE TABLE item (
#       idItem int not null auto_increment,
#       idProduct int not null,
#       amount int not null,
#       PRIMARY KEY(idItem),
#       FOREIGN KEY (idProduct) REFERENCES product(idProduct)
#       );
#       
#       CREATE TABLE shoppingBasket (
#       idBasket int not null auto_increment,
#       idUser int not null,
#       dataCreate varchar(20) not null,
#       active boolean not null,
#       PRIMARY Key(idBasket),
#       FOREIGN KEY(idUser) REFERENCES userstore(idUser)
#       );
#       
#       CREATE TABLE itemBasket(
#       idItemBasket int not null auto_increment,
#       idBasket int not null,
#       idItem int not null,
#       PRIMARY KEY(idItemBasket),
#       FOREIGN KEY(idBasket) REFERENCES shoppingBasket(idBasket),
#       FOREIGN KEY(idItem) REFERENCES item(idItem)
#       );