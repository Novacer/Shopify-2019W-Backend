insert into Orders (orderId)
values (1);


insert into LineItem (lineItemId, price, rate, quantity, name, parentId)
values (1, 10.0, 2.0, 4, 'product', 1);


insert into LineItem (lineItemId, price, rate, quantity, name, parentId)
values (2, 35.0, 1.0, 2, 'service', 1);

insert into LineItem (lineItemId, price, rate, quantity, name, parentId)
values (3, 5.50, 1.0, 10, 'food', 1);