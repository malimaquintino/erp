alter table customer.contract add column payment_method varchar(15) not null default 'MONEY';
alter table customer.contract add constraint contract_payment_method CHECK (payment_method IN('MONEY', 'BANK_SLIP', 'PIX', 'CREDIT_CARD', 'DEBIT_CARD'));