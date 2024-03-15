
from employee import Employee
from bank_account import BankAccount


class Bank:
    def __init__(self):
        self.bank_accounts = []  # declarar listas
        self.employee_list = []

    def add_account(self, new_bank_account):
        self.bank_accounts.append(new_bank_account)

    def add_employee(self, employee):
        self.employee_list.append(employee)

    def get_bank_accounts(self):
        return self.bank_accounts

    def get_employee_list(self):
        return self.employee_list

    # Crear empleado
    def create_employee(self):
        name = input("Name: ")
        lastname = input("Lastname: ")
        if not name and not lastname:
            print("Nombre de cliente invalido")
            return
        n_c = int(input("Numero de cuenta"))
        type_ = input("Type").upper()  # cambiamos a mayúsculas

        # validacion tipo de cuenta va en creacion de empleado
        if type_ not in ['A', 'B', 'C']:
            print("Tipo de cuenta no válido")
        else:
            new_employee = Employee(name, lastname)
            self.employee_list.append(new_employee)
            print("Empleado creado ")
            new_employee.add_account(BankAccount(n_c, type_))
            self.bank_accounts.append(BankAccount(n_c, type_))
            print("Cuenta creada ")

    # Ver empleados
    def see_employees(self):
        opt2 = int(input("1) ver todos\n2) ver solo uno"))

        if opt2 == 1:
            print("Recuerde que para ver todas las cuentas de un usuario en particular\n" +
                  "debe seleccionar un usuario en especifico")
            for ID, emple in enumerate(self.employee_list, 1):
                print("§ ID: {} | Nombre: {} | Apellido: {} "
                      "| No. cuenta banco: {} "
                      "§".format(ID, emple.get_name(), emple.get_last_name(), emple.get_list_accounts()[0].get_account_number()))

        elif opt2 == 2:
            print("¿cuál desea ver?")
            for ID, emple in enumerate(self.employee_list):
                print("ID {}: {} {}\n".format(ID + 1, emple.get_name(), emple.get_last_name()))

            opt3 = int(input())
            opt3 -= 1

            employee_sel = self.employee_list[opt3]
            print(" Cuentas: ")
            for ID2, bank_account in enumerate(employee_sel.get_list_accounts()):
                print("§ ID: {} | Cuenta: {} "
                      "| Tipo: {} | Cantidad: {} "
                      "§".format(ID2 + 1, employee_sel.get_list_accounts()[ID2].get_account_number(),
                                 employee_sel.get_list_accounts()[ID2].get_account_type(), employee_sel.get_list_accounts()[ID2].get_amount()))


    # Crear cuenta
    def create_account(self, nC, type_):
        cuenta = BankAccount(nC, type_)

        print("Elige el empleado para darle la cuenta:")
        for ID, emple in enumerate(self.employee_list):
            print("ID {}: {} {}\n".format(ID + 1, emple.get_name(), emple.get_last_name()))

        emID = int(input())
        emID -= 1

        emp = self.employee_list[emID]
        emp.add_account(cuenta)
        self.bank_accounts.append(cuenta)

        print(">>> Se asignado la cuenta "+nC+" a "+emp.get_name()+" "+emp.get_last_name())

    # Ver cuentas
    def check_all_accounts(self):
        for accounts in self.bank_accounts:
            print(str(accounts.get_account_number() )+ ", " + accounts.get_account_type() + ", " + str(accounts.get_amount()))
