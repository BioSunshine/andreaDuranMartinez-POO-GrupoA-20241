from UsersAdministration import UsersAdministration
from Operations import Operations
from Bank import Bank

class MainMenu:
    @staticmethod
    def main():
        print("\nBienvenido al banco")
        flag = True

        while flag:
            print("\t >>>BANCO<<< \n1) Administrar usuarios\n2) Soy empleado y quiero operar mi(s) cuenta(s)\n0) Salir")
            opt = int(input())

            if opt == 1:
                UsersAdministration.admin_users()
            elif opt == 2:
                if not Bank.get_employee_list():
                    print("Actualmente no hay nadie en el registro :[")
                else:
                    Operations.operate_accounts
            elif opt == 0:
                flag = False
            else:
                print("Entrada inválida :(")

MainMenu.main()
