import java.time.LocalTime;

class Trade {
    private Integer id;
    private LocalTime time;
    private String type;
    private String securityType;
    private String isin;
    private Integer quantity;
    private Double price;
    private Integer brokerCode;

    public Trade(Integer id, LocalTime time, String type, String securityType, String isin, Integer quantity, Double price, Integer brokerCode) {
        this.id = id;
        this.time = time;
        this.type = type;
        this.securityType = securityType;
        this.isin = isin;
        this.quantity = quantity;
        this.price = price;
        this.brokerCode = brokerCode;
    }

    public Integer getTradeID() {
        return id;
    }

    public LocalTime getTradeDataTime() {
        return time;
    }

    public String getTradeType() {
        return type;
    }

    public String getisin() {
        return isin;
    }

    public String getSecurityType() {
        return securityType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() { return price; }

    public Integer getBrokerID() {
        return brokerCode;
    }

    @Override
    public String toString(){
        return "TradeID:" + id + " TradeTime:" + time + " TradeType:" + type + " SecurityType:" + securityType + " ISIN:" + isin + " Quantity:" + quantity + " Price:" + price + " BrokerID:" + brokerCode;
    }
}