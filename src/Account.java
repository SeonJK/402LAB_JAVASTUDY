public class Account {
	
	//TODO: 왠만하면 약자는 
	//		1. 팀원들과 미리 약속되거나
	//		2. 대표적으로 사용되는 약자인 경우 (ex : passwd)
	//		
	//		가 아니라면 사용하지 않습니다.
	//		변수명은 너무 긴것이 아닌 이상 풀네임으로 써주세요
	//		
	
	
    private String name;

    private String accountNum;
	
    private String passwd;
    private int balance;

	//TODO: 해당 방식은 초기화 값이 조건에 맞지 않는 경우에도 객체를 생성하게 됩니다.
	//		다른 방식으로 생성자를 만들어 보세요 (힌트 : static 생성자)
    public Account(String name, String accountNum, String passwd){
        if(accountNum.length() != 13){
            System.out.println("계좌번호 형식이 맞지 않습니다. 000000-000000 형식으로 작성해주세요.");
//        if(!accountNum.equals("/^[0-9]{6}-[0-9]{6}$")){
//            System.out.println("계좌번호 형식이 맞지 않습니다. 000000-000000 형식으로 작성해주세요.");
        }else{
            this.name = name;
            this.accountNum = accountNum;
            this.passwd = passwd;
        }
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAccountNum(){
        return accountNum;
    }
//    public void setAccNum(int accountNum){
//        this.accountNum = accountNum;
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
