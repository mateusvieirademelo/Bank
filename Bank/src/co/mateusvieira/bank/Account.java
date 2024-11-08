package co.mateusvieira.bank;

public class Account {

    private static final int MAX_LENGTH_NAME = 12;
    private static final int MAX_LENGTH_AG = 4;
    private static final int MAX_LENGTH_CC = 5;

    private String ag;
    private String cc;
    private String name;

    private double balance;

    private Log logger;

    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        this.name = name;
//        setAg(ag);
//        setCc(cc);
//        setName(name);
        logger = new Log();
    }

    public void setName(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            this.name = name.substring(0, MAX_LENGTH_NAME); //vai cortar a string até o máximo permitido
        } else {
            this.name = name;
        }

    }

    public void setAg(String ag) {
        if (ag.length() > MAX_LENGTH_AG) {
            this.ag = ag.substring(0, MAX_LENGTH_AG); //vai cortar a string até o máximo permitido
        } else {
            this.ag = ag;
        }

    }

    public void setCc(String cc) {
        if (cc.length() > MAX_LENGTH_CC) {
            this.cc = cc.substring(0, MAX_LENGTH_CC); //vai cortar a string até o máximo permitido
        } else {
            this.cc = cc;
        }

    }

    public void deposit(double value) {
        balance += value;
        logger.out("DEPOSITO R$ " + value + "- Sua conta agora é de R$ " + balance);
    }

    public boolean withDraw(double value) {
        if (value > balance) {
            logger.out("SAQUE- R$ " + value + " Seu saldo atual é de R$ " + balance);
            return false;
        }
        balance -= value;
        logger.out("SAQUE- R$ " + value + " Sua conta agora é de R$ " + balance);
        return true;
    }

    @Override
    public String toString() {
        return "A conta " + this.name + " " + this.ag + " /" + this.cc + " possui R$ " + balance;
    }
}
