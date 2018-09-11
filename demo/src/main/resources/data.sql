insert into Orders (orderId, name)
values (1, 'Jack Inc. Order Num 01 - Sept 10, 2018');

insert into Products (productId, name, value)
values (1, 'Super Duper Burger', 7.0);


insert into LineItem (lineItemId, price, rate, quantity, name, orderId)
values (1, 10.0, 2.0, 4, 'product', 1);

insert into LineItem (lineItemId, price, rate, quantity, name, orderId)
values (2, 35.0, 1.0, 2, 'service', 1);

insert into LineItem (lineItemId, price, rate, quantity, name, orderId)
values (3, 5.50, 1.0, 10, 'food', 1);

insert into LineItem (lineItemId, price, rate, quantity, name, productId)
values (4, 7.0, 1.0, 2, 'beef patty', 1);

insert into LineItem (lineItemId, price, rate, quantity, name, productId)
values (5, 7.0, 1.0, 7, 'lettuce', 1);

insert into LineItem (lineItemId, price, rate, quantity, name, productId)
values (6, 7.0, 1.0, 1, 'cheese', 1);

insert into LineItem (lineItemId, price, rate, quantity, name, productId)
values (7, 7.0, 1.0, 2, 'bread', 1);