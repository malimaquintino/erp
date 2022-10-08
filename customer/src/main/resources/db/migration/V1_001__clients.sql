create table if not exists address (
	id                  bigint not null,
	zipcode             varchar(20) not null,
	street              varchar(500) not null,
	neighborhood        varchar(255) not null,
	number              varchar(10) not null,
	city                varchar(255) not null,
	state               varchar(255) not null,
	complement          varchar(255) null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint address_pkey primary key (id)
);
create sequence if not exists address_sequence start 1 increment 1;

create table if not exists client (
	id                  bigint not null,
	name                varchar(255) not null,
	person_type         varchar(2) not null,
	document            varchar(255) not null,
	fantasy_name        varchar(10) null,
	birth               date not null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint client_pkey primary key (id),
	constraint client_person_type CHECK (person_type IN('PF', 'PJ'))
);
create sequence if not exists client_sequence start 1 increment 1;

create table if not exists contract (
	id                  bigint not null,
	client_id           bigint not null,
	address_id          bigint not null,
	due_day             int not null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint contract_pkey primary key (id),
	constraint contract_fkey_client_id foreign key (client_id) references client(id)
);
create sequence if not exists contract_sequence start 1 increment 1;

create table if not exists email (
	id                  bigint not null,
	contract_id         bigint not null,
	email_address       varchar(255) not null,
	observation         text null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint email_pkey primary key (id),
	constraint email_fkey_contract_id foreign key (contract_id) references contract(id)
);
create sequence if not exists email_sequence start 1 increment 1;

create table if not exists phone (
	id                  bigint not null,
	contract_id         bigint not null,
	phone_number        varchar(55) not null,
	observation         text null,
    created_date        timestamp not null,
    updated_date        timestamp not null,
	constraint phone_pkey primary key (id),
	constraint phone_fkey_contract_id foreign key (contract_id) references contract(id)
);
create sequence if not exists phone_sequence start 1 increment 1;

create table if not exists contract_product (
    id                  bigint not null,
	contract_id         bigint not null,
	product_id          bigint not null,
	product_name        varchar(255) not null,
	product_desc        text not null,
	created_date        timestamp not null,
    updated_date        timestamp not null,
    constraint contract_product_pkey primary key (id),
	constraint contract_product_fkey_contract_id foreign key (contract_id) references contract(id)
);
create sequence if not exists contract_product_sequence start 1 increment 1;