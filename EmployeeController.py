from Bank import Bank
from BankAccount import BankAccount
from Employee import Employee

class EmployeeController:
    @staticmethod
    def create_employee():
        print("Name: ")
        name = input()
        print("Lastname: ")
        lastname = input()

        if name == "" and lastname == "":
            print("Nombre de cliente inválido")
            return

        print("Numero de cuenta")
        nC = int(input())
        print("Type")
        type = input().upper()

        if type not in ('A', 'B', 'C'):
            print("Tipo de cuenta no válido")
        else:
            new_employee = Employee(name, lastname)
            Bank.add_employee(new_employee)
            print("Empleado creado")
            new_employee.add_account(BankAccount(nC, type))
            Bank.add_account(BankAccount(nC, type))
            print("Cuenta creada")

    @staticmethod
    def see_employees():
        print("1) ver todos\n2) ver solo uno")
        opt2 = int(input())

        if opt2 == 1:
            print("Recuerde que para ver todas las cuentas de un usuario en particular\n"
                  "debe seleccionar un usuario en específico")
            for id, emple in enumerate(Bank.get_employee_list()):
                print(f"§ ID: {id + 1} | Nombre: {emple.get_name()} | Apellido: {emple.get_lastname()} | No. cuenta banco: {emple.get_list_accounts()[0].get_account_number()} §")
        elif opt2 == 2:
            print("¿Cuál desea ver?")
            for id, emple in enumerate(Bank.get_employee_list()):
                print(f"ID {id + 1}: {emple.get_name()} {emple.get_lastname()}\n")
            opt3 = int(input()) - 1

            employee_sel = Bank.get_employee_list()[opt3]
            print("Cuentas:")
            for id2, bank_account in enumerate(employee_sel.get_list_accounts()):
                print(f"§ ID: {id2 + 1} | Cuenta: {bank_account.get_account_number()} | Tipo: {bank_account.get_type()} | Cantidad: {bank_account.get_amount()} §")
