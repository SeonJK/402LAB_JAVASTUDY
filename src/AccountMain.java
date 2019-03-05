public class AccountMain {
    static public void main(String[] args){
        Account A = new Account("A", "123456-123456", "123456");
        Account B = new Account("B", "123123-456456", "123123");

        System.out.println(A.getName());
        System.out.println(B.getName());

        A.setName("AA");
        B.setName("BB");

        System.out.println(A.getName());
        System.out.println(B.getName());

        System.out.println(A.getAccountNum());
        System.out.println(B.getAccountNum());

        A.deposit(10000, "123456");
        B.deposit(20000, "123123");

        A.setPasswd("654321");
        B.setPasswd("321321");

        System.out.println(A.getBalance());
        System.out.println(B.getBalance());

        A.sendMoney(15000, "123456", B);
        B.sendMoney(15000, "123123", A);

        A.sendMoney(15000, "654321", B);
        B.sendMoney(15000, "321321", A);


    }
}
