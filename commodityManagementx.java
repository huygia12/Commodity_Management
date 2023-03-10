package cloneRemoteRepo;

import JavaProject.Repository;

public class commodityManagementx {
    public static void menuOfMainFunction(){
        System.out.println("\n********************************");
        System.out.println("* 1. Repository Management     *");
        System.out.println("* 2. Make New Order            *");
        System.out.println("* 3. Current Revenue Overview  *");
        System.out.println("* 4. Exit                      *");
        System.out.println("********************************");
    }

    public static void menuOfRepoManagement(){
        System.out.println("\n********************************");
        System.out.println("* 1. Add New Goods             *");
        System.out.println("* 2. Import Goods              *");
        System.out.println("* 3. Change Goods Infor        *");
        System.out.println("* 4. Delete Goods              *");
        System.out.println("* 5. Show Repository           *");
        System.out.println("* 6. Make a filter             *");
        System.out.println("* 7. Back                      *");
        System.out.println("********************************");
    }

    public static void main(String[] args) {
        menuOfRepoManagement();
        menuOfRepoManagement();
        Repository goodsList = new Repository();
        goodsList.addNewGoods();
        
    }
}
