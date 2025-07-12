package class1.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args) {

        // 상품주문 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = sc.nextInt();
        sc.nextLine(); // 입력버퍼를 비우기 위한 코드 "\n"

        // 여러 상품의 주문정보를 담는 배열 생성
        ProductOrder[] productOrders = new ProductOrder[n];

        // 상품주문 정보입력
        for (int i = 0 ; i < productOrders.length ; i++) {
            System.out.println((i+1) + "번째 상품의 이름을 입력하세요: ");

            System.out.print("상품의 이름: ");
            String productName = sc.nextLine();

            System.out.print("상품의 가격: ");
            int price = sc.nextInt();

            System.out.print("상품의 수량: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // 입력버퍼를 비우기 위한 코드 "\n"

            // 상품주문
            productOrders[i] = createOrder(productName, price, quantity);
        }


        // 2. printOrders()를 사용해서 상품 주문정보 출력
        printOrders(productOrders);

        // 3. getTotalAmount()를 사용해서 결제금액 계산
        // 4. 총 결제금액 출력
        System.out.println("총 결제금액 = " + getTotalAmount(productOrders));
    }


    // createOrder() 구현
    /*
        주문생성 로직이므로, 메서드 내에서 상품주문 인스턴스 생성/관리
     */
    public static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    // printOrders() 구현
    public static void printOrders(ProductOrder[] orders) {
        for(ProductOrder o : orders) {
            System.out.println("상품이름: " + o.productName + " 상품가격: " + o.price + " 상품수량: " + o.quantity);
        }
    }

    // getTotalAmount() 구현
    public static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for(ProductOrder o : orders) {
            totalAmount += o.price * o.quantity;
        }
        return totalAmount;
    }
}
