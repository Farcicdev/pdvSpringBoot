--Cria a tabela do Caixa
CREATE TABLE cash_register (
    id BIGSERIAL PRIMARY KEY,--id BIGSERIAL(número automático)
    status VARCHAR(20) NOT NULL,--Status de fechado ou aberto nao pode ser NULL
    opened_at TIMESTAMP NOT NULL,--data/hora que o caixa foi aberto
    closed_at TIMESTAMP NULL,--data/hora do fechamento de caixa
    initial_amount NUMERIC(12,2) NULL DEFAULT 0,--Valor inicial do caixa (12,2 tamanho maximo)
    final_amout NUMERIC (12,2) NULL,--valor final do caixa (Pode ser NULL)


    CONSTRAINT chk_cash_register_status_open_closed
        CHECK (status IN ('OPEN', 'CLOSED'))
);

CREATE INDEX idx_cash_register_status ON cash_register(status);