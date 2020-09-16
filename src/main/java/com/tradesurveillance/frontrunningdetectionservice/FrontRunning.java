import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FrontRunning {
    public static List<Trade> frontRunningdetection(List<Trade> trades) {

        Integer tradeQuantity = 5000, timeLimit = 120,i,j,k;
        Trade t1,t2,t3;

        List<Trade> largeQuantityTrades = new ArrayList<>();
        List<Trade> frontRunningTrades = new ArrayList<>();

        for(Trade x : trades) {
            if(x.getQuantity() >= tradeQuantity) {
                largeQuantityTrades.add(x);
            }
        }

        for(i=0; i<largeQuantityTrades.size(); i++) {

            t1 = largeQuantityTrades.get(i);

            for(j=i+1; j<largeQuantityTrades.size(); j++) {

                t2 = largeQuantityTrades.get(j);

                if((t2.getTradeDataTime().compareTo(t1.getTradeDataTime()))>120) {
                    break;
                }

                if((t2.getTradeDataTime().compareTo(t1.getTradeDataTime())<timeLimit) && (t1.getSecurityType().equals(t2.getSecurityType())) && (t1.getTradeType().equals(t2.getTradeType())) && (t1.getisin().equals(t2.getisin())) && (t1.getBrokerID().equals(t2.getBrokerID())) && ((t2.getTradeDataTime().compareTo(t1.getTradeDataTime()))>0)) {
                    for(k=j+1; k<largeQuantityTrades.size(); k++) {

                        t3 = largeQuantityTrades.get(k);

                        if((t3.getTradeDataTime().compareTo(t2.getTradeDataTime()))>120) {
                            break;
                        }

                        if((t3.getTradeDataTime().compareTo(t2.getTradeDataTime())<timeLimit) && (t3.getSecurityType().equals(t3.getSecurityType())) && (t2.getTradeType()!=t3.getTradeType()) && (t3.getisin().equals(t2.getisin())) && (t3.getBrokerID().equals(t2.getBrokerID())) && ((t3.getTradeDataTime().compareTo(t2.getTradeDataTime()))>0)) {
                            frontRunningTrades.add(t1);
                            frontRunningTrades.add(t2);
                            frontRunningTrades.add(t3);
                        }
                    }
                }

                else if((t2.getTradeDataTime().compareTo(t1.getTradeDataTime())<timeLimit) && (t1.getSecurityType().equals(t2.getSecurityType())) && (t1.getTradeType().equals(t2.getTradeType())) && (t1.getisin().equals(t2.getisin())) && (t1.getBrokerID().equals(t2.getBrokerID())) && ((t2.getTradeDataTime().compareTo(t1.getTradeDataTime()))>0)) {
                    for(k=j+1; k<largeQuantityTrades.size(); k++) {

                        t3 = largeQuantityTrades.get(k);

                        if((t3.getTradeDataTime().compareTo(t2.getTradeDataTime()))>120) {
                            break;
                        }

                        if((t3.getTradeDataTime().compareTo(t2.getTradeDataTime())<timeLimit) && (t3.getSecurityType().equals(t2.getSecurityType())) && (t2.getTradeType()!=t3.getTradeType()) && (t3.getisin().equals(t2.getisin())) && (t3.getBrokerID().equals(t2.getBrokerID())) && ((t3.getTradeDataTime().compareTo(t2.getTradeDataTime()))>0)) {
                            frontRunningTrades.add(t1);
                            frontRunningTrades.add(t2);
                            frontRunningTrades.add(t3);
                        }
                    }
                }

                else if((t2.getTradeDataTime().compareTo(t1.getTradeDataTime())<timeLimit) && (t1.getSecurityType().equals(t2.getSecurityType())) && (t1.getTradeType()!=t2.getTradeType()) && (t1.getisin().equals(t2.getisin())) && (t1.getBrokerID().equals(t2.getBrokerID())) && (t1.getQuantity().equals(t2.getQuantity())) && ((t2.getTradeDataTime().compareTo(t1.getTradeDataTime()))>0)) {
                    for(k=j+1; k<largeQuantityTrades.size(); k++) {

                        t3 = largeQuantityTrades.get(k);

                        if((t3.getTradeDataTime().compareTo(t2.getTradeDataTime()))>120) {
                            break;
                        }

                        if((t3.getTradeDataTime().compareTo(t2.getTradeDataTime())<timeLimit) && (t3.getSecurityType().equals(t2.getSecurityType())) && (t1.getTradeType().equals(t3.getTradeType())) && (t3.getisin().equals(t2.getisin())) && (t3.getBrokerID().equals(t2.getBrokerID())) && (t3.getQuantity().equals(t1.getQuantity())) && (t3.getPrice()>(t1.getPrice())) && ((t3.getTradeDataTime().compareTo(t2.getTradeDataTime()))>0)) {
                            frontRunningTrades.add(t1);
                            frontRunningTrades.add(t2);
                            frontRunningTrades.add(t3);
                        }
                    }
                }
            }
        }
        return frontRunningTrades;
    }
}
