class Employee:
    def __init__(self, name="", lastname=""):
        self.name = name
        self.lastname = lastname
        self.list_accounts = []

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_lastname(self):
        return self.lastname

    def set_lastname(self, lastname):
        self.lastname = lastname

    def get_list_accounts(self):
        return self.list_accounts

    def set_list_accounts(self, list_accounts):
        self.list_accounts = list_accounts

    def add_account(self, new_account):
        self.list_accounts.append(new_account)
