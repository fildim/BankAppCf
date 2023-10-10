package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;

/**
 * a java class for an overdraft {@link Account} <br>
 * extends the {@link Account} class <br>
 * contains constructors and withdraw methods
 *
 *  @author fildim
 */
public class OverdraftAccount extends Account{

    public OverdraftAccount() {}

    public OverdraftAccount(User holder, String iban, double balance) {
        super(holder, iban, balance);
    }

    /**
     * withdraws a given amount for a given ssn, of the ssn is valid
     * @param amount
     *          the given amount to be withdrawn
     * @param ssn
     *          the given ssn
     * @throws SsnNotValidException
     *          if the given ssn is not valid
     * @throws NegativeAmountException
     *          if the given amount is negative
     */
    @Override
    public void withdraw(double amount, String ssn) throws SsnNotValidException, NegativeAmountException {

        try {

            if (amount < 0) throw new NegativeAmountException(amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);

        } catch (SsnNotValidException | NegativeAmountException e) {

            System.err.println("Error: withdrawal");
            throw e;
        }
    }

}
