package gr.aueb.cf.model;

/**
 * a java class for a joint {@link Account} <br>
 * extends the {@link Account} class and adds a {@link User}<br>
 * contains constructors, getters, setters, toString and isSsnValid methods
 *
 * @author fildim
 */
public class JointAccount extends Account{

    private User secondHolder = new User();

    public JointAccount() {}

    public JointAccount(User holder, String iban, double balance, User secondHolder) {
        super(holder, iban, balance);
        this.secondHolder = secondHolder;
    }

    public User getSecondHolder() {
        return secondHolder;
    }

    public void setSecondHolder(User secondHolder) {
        this.secondHolder = secondHolder;
    }

    @Override
    public String toString() {
        return "JointAccount{" + "First Holder" + getHolder() +
                "secondHolder=" + secondHolder +
                ", iban: " + getIban() + ", balance: " + getBalance() + '}';
    }

    /**
     * validates the given ssn against the ssn of the Users of the Account
     * @param ssn
     *          the given ssn to validate
     * @return
     *          true if the ssn is valid, false otherwise
     */
    @Override
    protected boolean isSsnValid(String ssn) {
        return super.isSsnValid(ssn) || secondHolder.getSsn().equals(ssn);
    }
}
