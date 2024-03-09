class BankAccount:
    def __init__(self, account_number, type):
        self.account_number = account_number
        self.amount = 0
        self.type = type

    def set_account_number(self, account_number):
        self.account_number = account_number

    def set_type(self, type):
        self.type = type

    def get_account_number(self):
        return self.account_number

    def get_amount(self):
        return self.amount

    def set_amount(self, amount):
        self.amount = amount

    def get_type(self):
        return self.type

    def deposit_money(self, amount):
        if self.type == 'A':
            self.deposit_money_A(amount)
        elif self.type == 'B':
            self.deposit_money_B(amount)
        else:
            self.deposit_money_C(amount)

    def deposit_money_A(self, amount):
        if self.amount + amount <= 50000:
            self.amount += amount
            print("Se depositó", amount)
        else:
            print("No se puede tener más de 50,000")

    def deposit_money_B(self, amount):
        if self.amount + amount <= 100000:
            self.amount += amount
            print("Se depositó", amount)
        else:
            print("No se puede tener más de 100,000")

    def deposit_money_C(self, amount):
        self.amount += amount
        print("Se depositó", amount)

    def withdraw_money(self, amount):
        if self.type == 'A':
            self.withdraw_money_A(amount)
        elif self.type == 'B':
            self.withdraw_money_B(amount)
        else:
            self.withdraw_money_C(amount)

    def withdraw_money_A(self, amount):
        if self.amount - amount > 1000:
            self.amount -= amount
            print("Se retiró", amount)
        else:
            print("No se puede tener un saldo menor a 1000 en la cuenta")

    def withdraw_money_B(self, amount):
        if self.amount - amount > 5000:
            self.amount -= amount
            print("Se retiró", amount)
        else:
            print("No se puede tener un saldo menor a 5000 en la cuenta")

    def withdraw_money_C(self, amount):
        if self.amount - amount > 10000:
            self.amount -= amount
            print("Se retiró", amount)
        else:
            print("No es posible tener un saldo menor a 10,000 en la cuenta")
