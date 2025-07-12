package class1.ex;

public class ProductOrderMain2 {
    public static void main(String[] args) {
        // 여러 상품의 주문정보를 담는 배열 생성
        ProductOrder[] productOrders = new ProductOrder[3];

        // 향상된 for문은 지역변수를 사용한다. -> for문 종료 시, 지역변수 제거됨
//        for (ProductOrder o : productOrders) {
//            o = new ProductOrder();
//        }

        // 1. createOrder()를 여러 번 사용해서 상품 주문정보들을 생성하고 배열에 저장
        productOrders[0] = createOrder("김치", 1500, 3);
        productOrders[1] = createOrder("신라면", 3000, 5);
        productOrders[2] = createOrder("김밥", 2000, 3);

        // 향상된 for문의 지역변수는 값을 대입받아서 사용한다.
        // 1. 기본형 변수: 값을 그대로 복사 2. 참조형 변수: 참조값을 그대로 복사
        // for문이 종료되면, 지역변수는 제거된다.
        for (ProductOrder o : productOrders) {
            o.productName = "변경";
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
