alter table financial.bill add column payment_method varchar(15) not null default 'MONEY';
alter table financial.bill add constraint bill_payment_method CHECK (payment_method IN('MONEY', 'BANK_SLIP', 'PIX', 'CREDIT_CARD', 'DEBIT_CARD'));
