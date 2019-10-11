package seedu.address.statistic;

import static java.util.Objects.requireNonNull;

import org.apache.commons.math3.stat.StatUtils;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.ReadOnlyDataBook;
import seedu.address.model.order.Order;
import seedu.address.model.order.Status;
import seedu.address.model.phone.Phone;

/**
 * Represents the in-memory statistics module of the current SML data.
 */
public class StatisticManager implements Statistic {


    public StatisticManager() {}

    @Override
    public void getOrderBook(ReadOnlyDataBook<Order> orderBook) {

    }

    @Override
    public void calculateTotalCost() {

    }

    @Override
    public String calculateTotalProfit(ReadOnlyDataBook<Order> orderBook, ReadOnlyDataBook<Phone> phoneBook) {
        ObservableList<Order> orderList = orderBook.getList();
        for (Order currentOrder : orderList) {
            currentOrder.getPrice();
        }

        return "test profit";
    }

    @Override
    public String calculateTotalRevenue(ReadOnlyDataBook<Order> orderBook) {
        ObservableList<Order> orderList = orderBook.getList();
        List<Double> completedOrderPriceList = new ArrayList();
        for (Order currentOrder : orderList) {
            if (currentOrder.getStatus() == Status.COMPLETED) {
                Double currentPrice = Double.parseDouble(currentOrder.getPrice().value);
                completedOrderPriceList.add(currentPrice);
            }
        }
        double[] completedOrderPriceArray =
                completedOrderPriceList.stream().mapToDouble(d -> d).toArray();
        double totalRevenue = StatUtils.sum(completedOrderPriceArray);
        return String.valueOf(totalRevenue);
    }

    @Override
    public void calculateTotalRevenue() {

    }
}
