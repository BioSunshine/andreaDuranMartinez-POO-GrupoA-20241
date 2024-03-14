class UsersController:
    @staticmethod
    def create_user():
        name = input("Introduce the name: ")
        lastname = input("Introduce the lastname: ")

        # Validación
        if not name or not lastname:
            print("Input invalid...")
            return

        age = int(input("Introduce the age: "))
        if age < 6:
            print("Not possible to register with that age")
            return

        id = IdGenerator.create_id()  # Asegúrate de tener la clase IdGenerator definida
        new_user = Users(id, name, lastname, age)  # Asegúrate de tener la clase Users definida
        Library.add_user(new_user)  # Asegúrate de tener la clase Library definida
        print("User created successfully")
