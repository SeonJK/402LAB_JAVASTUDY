public class Account {
    private String name;
    private String accNum;
    private String passwd;
    private int balance;


    public Account(String name, String accNum, String passwd){
        if(accNum.length() != 13){
            System.out.println("계좌번호 형식이 맞지 않습니다. 000000-000000 형식으로 작성해주세요.");
//        if(!accNum.equals("/^[0-9]{6}-[0-9]{6}$")){
//            System.out.println("계좌번호 형식이 맞지 않습니다. 000000-000000 형식으로 작성해주세요.");
        }else{
            this.name = name;
            this.accNum = accNum;
            this.passwd = passwd;
        }
    };


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAccNum(){
        return accNum;
    }
//    public void setAccNum(int accNum){
//        this.accNum = accNum;
//    }

//    public String getPasswd(){
//        return passwd;
//    }
    public void setPasswd(String passwd){
        this.passwd = passwd;
    }

    public int getBalance(){
        return balance;
    }
    private void setBalance(int balance){
        this.balance = balance;
    }

    private boolean isPasswdCorrect(String passwd){
        if(passwd.equals(this.passwd)) {
            return true;
        }else{
            return false;
        }
    }

    public void deposit(int money, String passwd){
//        isPasswdCorrect(passwd);

        if(!isPasswdCorrect(passwd)){
           System.out.println("비밀번호가 일치하지 않습니다.");
       }else if(money<=0){
            System.out.println("돈의 액수가 올바르지 않습니다.");
       }else{
             this.setBalance(getBalance() + money);
             System.out.println("계좌 내 현재 잔액: " + this.balance);
        }
    }

    public void sendMoney(int sendMoney, String passwd, Account dstUserAcnt){
//        isPasswdCorrect(passwd);

        if(!isPasswdCorrect(passwd)){
            System.out.println("비밀번호가 일치하지 않습니다.");
        }else if(sendMoney<=0){
            System.out.println("돈의 액수가 올바르지 않습니다.");
        }else if(sendMoney > this.balance) {
            System.out.println("계좌 내 돈이 부족합니다.");
        }else if(dstUserAcnt == null){
            System.out.println("보내려는 사용자가 유효하지 않습니다.");
        }
        else {
            dstUserAcnt.setBalance(getBalance() + sendMoney);
            this.setBalance(getBalance() - sendMoney);
            System.out.println("계좌 내 현재 잔액: " + this.balance);
        }
    }


}
