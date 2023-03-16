package sourceCode;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Order {
    private List<Goods> goodsList = new ArrayList<Goods>();
    private String orderID = null;
    private int discount;
    Scanner sc = new Scanner(System.in);
    public Order() {
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setGoods(Goods goods) {
        for (Goods goods2 : this.goodsList) {
            if (goods2 == null) {
                goods2 = goods;
            }
        }
    }

    public Goods getGoods(int index) {
        return this.goodsList.get(index);
    }

    public int getDiscount() {
        return this.discount;
    }

    public String getOrderID() {
        return this.orderID;
    }

    private int totalPayment() {
        return 0;
    }

    private int totalAfterDiscount(){ 
        return 0;
    }

    //funtion 1
    private void addToOrder() {
        //undeveloped
    }
    
    //function 2
    private void deleteFromOrder(){
        //undeveloped
    }

    //funtion 3
    private void pay(){
        //undeveloped
    }
    
    public void makeNewOrder(){
        
        int choice;
        do {
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addToOrder();
                        break;
                    case 2:
                        deleteFromOrder();
                        break;
                    case 3:
                        pay();
                        break;
                    default:
                        System.out.println("Wrong input! Please type form 1->3!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Wrong input!");
                choice = -1;
            }
        } while (choice != 3);
    }
}
