from Bank import Bank

class Operations:
    @staticmethod
    def operate_accounts():
        print("Ingrese su nombre")
        name_to_check = input().lower()
        print("Ingrese su apellido")
        lastname_to_check = input().lower()

        identifier = -1
        for id, emple in enumerate(Bank.get_employee_list()):
            if emple.get_name().lower() == name_to_check and emple.get_lastname().lower() == lastname_to_check:
                identifier = id
                break

        if identifier > -1:
            employee_sel = Bank.get_employee_list()[identifier]

            print(f">>>Bienvenido usuario {employee_sel.get_name()} {employee_sel.get_lastname()} :D \nCuentas :\n")
            for id2, bank_account in enumerate(employee_sel.get_list_accounts()):
                print(f"§ ID: {id2 + 1} | Cuenta: {bank_account.get_account_number()} | Tipo: {bank_account.get_type()} | Cantidad: {bank_account.get_amount()} §")

            print("Seleccione una cuenta (ID)")
            account_index = int(input())

            print("Seleccionaste:\n" +
                  f"{employee_sel.get_list_accounts()[account_index - 1].get_account_number()}\n" +
                  f"Tipo: {employee_sel.get_list_accounts()[account_index - 1].get_type()}")

            band = True
            while band:
                print("\t<<<Operaciones>>>\n1) Depositar dinero\n2) Retirar dinero\n3) Consultar saldo\n0) Regresar\n")
                option = int(input())
                if option == 1:
                    print("¿Cuánto desea depositar?")
                    amount = float(input())
                    employee_sel.get_list_accounts()[account_index - 1].deposit_money(amount)
                elif option == 2:
                    print("¿Cuánto desea retirar?")
                    amount = float(input())
                    employee_sel.get_list_accounts()[account_index - 1].withdraw_money(amount)
                elif option == 3:
                    print("Su saldo es de: $", employee_sel.get_list_accounts()[account_index - 1].get_amount())
                elif option == 0:
                    band = False
        else:
            print("Usuario inválido :o")
