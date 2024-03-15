from bank import Bank
from transactions import Transactions

print("\n¡Bienvenido_al_banco!")
flag = True
bank = Bank()

while flag:
    print("Opciones :\n1) Crear empleado\n2) Ver empleado\n3) Crear cuenta\n4) Ver cuentas\n5) Transacciones\n0) Salir")
    opt = int(input())

    if opt == 1:
        bank.create_employee()
    elif opt == 2:
        bank.see_employees()
    elif opt == 3:
        if bank.get_employee_list():
            print(">>>Creando cuenta...")
            print("Numero_de_cuenta")
            nC = int(input())
            print("Tipo")
            type_ = input()[0].upper()
            if type_ not in ['A', 'B', 'C']:
                print("Tipo de cuenta no válido")
            else:
                bank.create_account(nC, type_)
        else:
            print("No hay empleados registrados...")
    elif opt == 4:
        bank.check_all_accounts()
    elif opt == 5:
        transactions = Transactions()
        transactions.operation_menu(bank.get_employee_list())
    elif opt == 0:
        flag = False
    else:
        print("Opción no válida")
