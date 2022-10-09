create table if not exists bill (
	id                  bigint not null,
	customer_id         bigint not null,
	customer_name       varchar(255) not null,
	customer_document   varchar(14) not null,
	due_date            date not null,
	total               float8 not null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint bill_pkey primary key (id)
);
create sequence if not exists bill_sequence start 1 increment 1;

create table if not exists bill_product (
	id                    bigint not null,
	bill_id               bigint not null,
	product_id            bigint not null,
	product_name          varchar(255) not null,
    product_description   text not null,
    product_price         float8 not null,
    product_type          varchar(255) not null,
    created_date          timestamp not null,
    updated_date          timestamp not null,
	constraint bill_product_pkey primary key (id),
	constraint bill_product_fkey_bill_id foreign key (bill_id) references bill(id)
);
create sequence if not exists bill_product_sequence start 1 increment 1;

