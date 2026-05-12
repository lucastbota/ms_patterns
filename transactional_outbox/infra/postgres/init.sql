CREATE TABLE orders (
    id UUID PRIMARY KEY,
    amount NUMERIC NOT NULL
);

CREATE TABLE outbox_event (
    id UUID PRIMARY KEY,

    aggregate_type VARCHAR(100) NOT NULL,
    aggregate_id UUID NOT NULL,

    event_type VARCHAR(150) NOT NULL,
    event_version INT NOT NULL,

    payload JSONB NOT NULL,

    status VARCHAR(20) NOT NULL,
    retry_count INT NOT NULL DEFAULT 0,

    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    processed_at TIMESTAMP
);

CREATE INDEX idx_outbox_status_created
    ON outbox_event(status, created_at);

CREATE INDEX idx_outbox_aggregate
    ON outbox_event(aggregate_type, aggregate_id);
