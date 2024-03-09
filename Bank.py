class Bank:
    BankAccounts = []  # Lista para almacenar las cuentas bancarias
    EmployeeList = []  # Lista para almacenar los empleados

    @staticmethod
    def add_account(new_bank_account):
        Bank.BankAccounts.append(new_bank_account)

    @staticmethod
    def add_employee(employee):
        Bank.EmployeeList.append(employee)

    @staticmethod
    def get_bank_accounts():
        return Bank.BankAccounts

    @staticmethod
    def get_employee_list():
        return Bank.EmployeeList
