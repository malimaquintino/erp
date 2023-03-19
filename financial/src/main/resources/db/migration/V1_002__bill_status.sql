alter table financial.bill add column status varchar(15) not null default 'OPEN';
alter table financial.bill add constraint bill_status CHECK (status IN('OPEN', 'PAYED', 'CANCELED'));
