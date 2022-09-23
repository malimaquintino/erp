create table if not exists product_type (
	id                  bigint not null,
	name                varchar(255) unique not null,
	active              boolean,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint product_type_pkey primary key (id)
);
create sequence if not exists product_type_sequence start 1 increment 1;

create table if not exists product (
	id                  bigint not null,
	name                varchar(255) not null,
	description         text not null,
	price               decimal not null,
	product_type_id     bigint not null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint product_pkey primary key (id),
	constraint product_product_type_id foreign key (product_type_id) references product_type(id)
);
create sequence if not exists product_sequence start 1 increment 1;

create table if not exists combo (
	id                  bigint not null,
	name                varchar(255) not null,
	description         text not null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint combo_pkey primary key (id)
);
create sequence if not exists combo_sequence start 1 increment 1;

create table if not exists combo_product (
	combo_id                  bigint not null,
	product_id                bigint not null,
	constraint combo_product_key_combo_id foreign key (combo_id) references combo(id),
	constraint combo_product_key_product_id foreign key (product_id) references product(id)
);