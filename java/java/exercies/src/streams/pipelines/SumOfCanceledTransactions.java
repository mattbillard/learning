package streams.pipelines;

import java.util.Arrays;
import java.util.List;

class SumOfCanceledTransactions {
  public static void main(String[] args) {
    Transaction t1 = new Transaction(State.CANCELED, 1000l);
    Account a1 = new Account(0l, Arrays.asList(t1));

    Transaction t2 = new Transaction(State.FINISHED, 8000l);
    Transaction t3 = new Transaction(State.CANCELED, 10000l);
    Account a2 = new Account(8000l, Arrays.asList(t2, t3));

    List<Account> accounts = Arrays.asList(a1, a2);

    Long sum = accounts.stream()
            .filter(a -> a.getBalance() > 0)
            .flatMap(
                    a -> a.getTransactions().stream()
                            .filter(t -> t.getState().equals(State.CANCELED))
                            .map(t -> t.getSum())
            )
            .reduce(0l, (b, c) -> b + c);

    System.out.println(sum);

  }
}







class Account {
  Long balance;
  List<Transaction> transactions;

  public Account(Long balance, List<Transaction> transactions) {
    this.balance = balance;
    this.transactions = transactions;
  }

  public Long getBalance() {
    return balance;
  }
  public List<Transaction> getTransactions() {
    return transactions;
  }
}

class Transaction {
  State state;
  Long sum;

  public Transaction(State state, Long sum) {
    this.state = state;
    this.sum = sum;
  }

  public State getState() {
    return state;
  }
  public Long getSum() {
    return sum;
  }
}

enum State {
  CANCELED, FINISHED, PROCESSING
}



/*
You have two classes:

Transaction: uuid: String,  state: State (CANCELED, FINISHED, PROCESSING), sum: Long, created: Date
Account: number: String, balance: Long, transactions: List<Transaction>

Both classes have getters for all fields with the corresponding names (getState(), getSum(), getTransactions() and so on).

Write a method using Stream API that calculates the total sum of canceled transactions for all non-empty accounts (balance > 0). Perhaps, flatMap method can help you to implement it.

Classes Transaction, Account and enum State will be available during testing. You can define your own classes for local testing.

Examples: there are 2 accounts (in JSON notation) below. The result is 10 000.

[
  {
    "number": "1001",
    "balance": 0,
    "transactions": [
      {
        "uuid": "774cedda-9cde-4f53-8bc2-5b4d4859772a",
        "state": "CANCELED",
        "sum": 1000,
        "created": "2016.12.12 18:30:05"
      }
    ]
  },
  {
    "number": "1002",
    "balance": 8000,
    "transactions": [
      {
        "uuid": "337868a7-f469-43c0-9042-3422ce37ee26a",
        "state": "FINISHED",
        "sum": 8000,
        "created": "2016.12.12 17:30:55"
      },
      {
        "uuid": "f8047f86-89e7-4226-8b75-74c55a4d7e31",
        "state": "CANCELED",
        "sum": 10000,
        "created": "2016.12.12 18:10:18"
      }
    ]
  }
]
 */