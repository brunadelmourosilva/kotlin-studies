package br.com.brunadelmouro.bankaccount

fun main(){

    val denisesBankAccount = BankAccount("Denis Panjuta", 1338.20)

    denisesBankAccount.deposit(200.0)
    denisesBankAccount.withdraw(1200.00)
    denisesBankAccount.deposit(3000.00)
    denisesBankAccount.deposit(2000.00)
    denisesBankAccount.withdraw(3333.15)

    denisesBankAccount.displayTransactionHistory()
    denisesBankAccount.acctBalance()

    val saraBankAccount = BankAccount("Sarah", 0.0)
    saraBankAccount.deposit(100.0)
    saraBankAccount.withdraw(10.0)
    saraBankAccount.deposit(300.0)

    saraBankAccount.displayTransactionHistory()
    saraBankAccount.acctBalance()
}