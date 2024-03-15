class BankAccount:
    def __init__(self, account_number, account_type):
        self.account_number = account_number
        self.account_type = account_type
        self.amount = 0

    def get_account_number(self):
        return self.account_number

    def get_amount(self):
        return self.amount

    def set_amount(self, amount):
        self.amount = amount

    def get_account_type(self):
        return self.account_type

    def deposit_money(self, amount):
        if self.account_type == 'A':
            self.deposit_money_a(amount)
        elif self.account_type == 'B':
            self.deposit_money_b(amount)
        else:
            self.deposit_money_c(amount)

    def deposit_money_a(self, amount):
        if self.amount + amount <= 50000:
            self.amount += amount
            print(f"Se depositó {amount}")
        else:
            print("No se puede tener más de 50,000")

    def deposit_money_b(self, amount):
        if self.amount + amount <= 100000:
            self.amount += amount
            print(f"Se depositó {amount}")
        else:
            print("No se puede tener más de 100,000")

    def deposit_money_c(self, amount):
        self.amount += amount
        print(f"Se depositó {amount}")

    def withdraw_money(self, amount):
        if self.account_type == 'A':
            self.withdraw_money_a(amount)
        elif self.account_type == 'B':
            self.withdraw_money_b(amount)
        else:
            self.withdraw_money_c(amount)

    def withdraw_money_a(self, amount):
        if self.amount - amount > 1000:
            self.amount -= amount
            print(f"Se retiró {amount}")
        else:
            print("No se puede tener un saldo menor a 1000 en la cuenta")

    def withdraw_money_b(self, amount):
        if self.amount - amount > 5000:
            self.amount -= amount
            print(f"Se retiró {amount}")
        else:
            print("No se puede tener un saldo menor a 5000 en la cuenta")

    def withdraw_money_c(self, amount):
        if self.amount - amount > 10000:
            self.amount -= amount
            print(f"Se retiró {amount}")
        else:
            print("No es posible tener un saldo menor a 10,000 en la cuenta")
