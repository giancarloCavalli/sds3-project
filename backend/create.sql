create table sales (id int8 generated by default as identity, amount float8, date date, deals int4, visited int4, seller_id int8, primary key (id));
create table sellers (id int8 generated by default as identity, name varchar(255), primary key (id));
alter table if exists sales add constraint FK5nkni0k9eeac4aer23myxl0l7 foreign key (seller_id) references sellers;