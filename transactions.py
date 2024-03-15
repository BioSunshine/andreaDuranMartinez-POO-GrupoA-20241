

class Transactions:
    def operation_menu(self, employee_list):
        print("Ingrese su nombre")
        name_to_check = input().lower()
        print("Ingrese su apellido")
        lastname_to_check = input().lower()

        identifier = -1
        for id_, employee in enumerate(employee_list):
            if employee.get_name().lower() == name_to_check and employee.get_last_name().lower() == lastname_to_check:
                identifier = id_
                break

        if identifier > -1:
            employee_sel = employee_list[identifier]
            ind = 0

            print(">>>Bienvenido usuario " + employee_sel.get_name() + " " + employee_sel.get_last_name() +
                  " :D \nCuentas : " + "\n")
            id_2 = 0
            for _ in employee_sel.get_list_accounts():
                print("§ ID :" + str(id_2 + 1) + " | Cuenta: " + str(employee_sel.get_list_accounts()[ind].get_account_number()) + " |  Tipo: " + str(employee_sel.get_list_accounts()[ind].get_account_type()) + " | Cantidad: " + str(employee_sel.get_list_accounts()[ind].get_amount()) + " §")
                ind += 1
                id_2 += 1
            print("Seleccione una cuenta (ID)")
            account_index = int(input())
            print("Seleccionaste: \n" +
                  str(employee_sel.get_list_accounts()[account_index - 1].get_account_number()) +
                  "\t. Tipo: " + str(employee_sel.get_list_accounts()[account_index - 1].get_account_type()))

            # quiero seleccionar una cuenta y después poner un menú para ver si desea agregar o retirar dinero
            band = True
            while band:
                print("\t<<<Operaciones>>>\n1) Depositar dinero " + "\n2) Retirar dinero\n3 Consultar saldo\n0)Regresar\n")
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
                    print("Su saldo es de: $ " + str(employee_sel.get_list_accounts()[account_index - 1].get_amount()))
                elif option == 0:
                    band = False
        else:
            print("Usuario invalido :o")
