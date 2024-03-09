from EmployeeController import EmployeeController
from Bank import Bank
from BankAccountController import BankAccountController


class UsersAdministration:
    @staticmethod
    def admin_users():
        band = True
        while band:
            print("\n\t<<<Administración>>>\n1) Crear empleado\n2) Crear cuenta\n3) Ver empleados\n4) Modificar cuentas\n0) Regresar\n")
            opt = int(input())

            if opt == 1:  # Crear empleado
                EmployeeController.create_employee()
            elif opt == 2:  # Crear cuenta de banco
                if not Bank.get_employee_list():
                    print("No hay empleados registrados...")
                else:
                    print(">>>Creando cuenta...")
                    print("Numero de cuenta")
                    nC = int(input())
                    print("Type")
                    type = input()[0].upper()  # Convertimos a mayúsculas

                    # Validación de tipo de cuenta va en la creación de empleado
                    if type not in ('A', 'B', 'C'):
                        print("Tipo de cuenta no válido")
                    else:
                        BankAccountController.create_account(nC, type)
            elif opt == 3:  # Ver empleados
                if not Bank.get_employee_list():
                    print("No hay empleados registrados...")
                else:
                    EmployeeController.see_employees()
            elif opt == 4:
                if not Bank.get_employee_list():
                    print("No hay empleados")
                else:
                    BankAccountController.modify_account()
            elif opt == 0:
                band = False
            else:
                print("Opción inválida...")

