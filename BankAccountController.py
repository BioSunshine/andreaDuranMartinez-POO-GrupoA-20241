from BankAccount import BankAccount
from Employee import Employee
from Bank import Bank

class BankAccountController:
    @staticmethod
    def create_account(nC, type):
        cuenta = BankAccount(nC, type)

        print("Elige el empleado para darle la cuenta:")

        for id, emple in enumerate(Bank.get_employee_list()):
            print(f"ID {id + 1}: {emple.get_name()} {emple.get_lastname()}\n")

        emID = int(input()) - 1
        emp = Bank.get_employee_list()[emID]
        emp.add_account(cuenta)
        Bank.get_bank_accounts().append(cuenta)

        print(f">>> Se asignado la cuenta {nC} a {emp.get_name()} {emp.get_lastname()}")

    @staticmethod
    def check_all_accounts():
        for accounts in Bank.get_bank_accounts():
            print(f"{accounts.get_account_number()}, {accounts.get_type()}, {accounts.get_amount()}")

    @staticmethod
    def modify_account():
        print("¿Qué cuenta quiere modificar?")
        for id, cuentas in enumerate(Bank.get_bank_accounts()):
            print(f"§ ID {id + 1} | No. cuenta: {cuentas.get_account_number()} §")
        account = int(input()) - 1
        modify_bank_account = Bank.get_bank_accounts()[account]

        print("Nuevo numero de cuenta:", end=" ")
        modify_bank_account.set_account_number(int(input()))

        print("Nuevo tipo de cuenta:", end=" ")
        modify_bank_account.set_type(input()[0])

        print(">>> Cuenta exitosamente cambiada")
