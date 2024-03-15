from user import User
from book import Book
from idgenerator import IdGenerator


class Library:
    def __init__(self):
        self.user_list = []
        self.book_list = []

    def create_user(self):
        name = input("Introduce the name: ")
        lastname = input("Introduce the lastname: ")

        if not name and not lastname:
            print("Input invalid...")
            return

        age = int(input("Introduce the age: "))
        if age < 6:
            print("Not possible to register with that age")
            return

        id_generator = IdGenerator()
        id_ = id_generator.create_id()
        new_user = User(id_, name, lastname, age)
        self.user_list.append(new_user)
        print("User created successfully")

    def register_book(self):
        title = input("Title: ")
        author = input("Author: ")
        if not title and not author:
            print("Invalid input, please introduce correctly the data")
            return

        year = int(input("Publication year: "))
        if year > 2024:
            print("Invalid input, please verify")
            return

        id_generator = IdGenerator()
        id_ = id_generator.create_book_id()
        new_book = Book(id_, title, author, year, True)
        self.book_list.append(new_book)
        print("Book registered successfully")

    def rent_a_book(self):
        print("Select the client who wants to rent a book")
        self.show_users()
        option = int(input()) - 1
        user_selected = self.user_list[option]
        print(f"You chose: code: {user_selected.id}, Name: {user_selected.name}, Lastname: {user_selected.last_name}, Age: {user_selected.age}")

        print("Choose the book the client wants to rent:")
        id_ = 0
        for book in self.book_list:
            if book.is_its_available():
                print(f"| ID {id_ + 1} Id: {book.id}, Title: {book.title}, Author: {book.author}, Publication Year: {book.year}")
            id_ += 1

        selection = int(input()) - 1
        book_selected = self.book_list[selection]
        if not book_selected.is_its_available():
            print("Sorry, that book isn't available, even it is not shown in the list")
            return

        print(f"You selected:\n  Title: {book_selected.title} | Author: {book_selected.author}")
        user_selected.rent_a_book(book_selected)
        user_selected.has_rented_book = True
        self.book_list[selection].its_available = False
        print(">>> Now the rent is authorized\n> The client can take the book")

    def return_book(self):
        print("Select the client who wants to return a book")
        self.show_users_have_rented_books()
        input_ = int(input()) - 1
        user_selected = self.user_list[input_]
        print("Which book wants to return?")
        self.see_rented_books(user_selected)

    def see_rented_books(self, selected_user):
        print("Select the book the client wants to return")
        count = 0
        for book in selected_user.list_rented_books:
            print(f"| ID {count + 1} Id: {book.id} Title: {book.title} Author: {book.author} Publication Year: {book.year}")
            count += 1

        selection = int(input()) - 1
        book_selected = selected_user.list_rented_books[selection]
        book_selected.its_available = True
        selected_user.list_rented_books.remove(book_selected)
        print("The book has been returned")

    def buy_a_book(self):
        print("Select the client who wants to buy a book:")
        ID = 0
        for user in self.user_list:
            print(f"| ID: {ID + 1} | code: {user.id} | Name: {user.name} | Lastname: {user.last_name} | Age: {user.age}")
            ID += 1

        selection = int(input()) - 1
        user_selected = self.user_list[selection]
        print("Select the book the client wants to buy:")
        self.show_books_available()
        input_ = int(input())
        book_selected = self.book_list[input_]
        if not book_selected.is_its_available():
            print("Sorry, that book isn't available, even it is not shown in the list")
            return

        price = float(input("Enter the price: "))
        if price < 0:
            print("Invalid value")
            return

        print(f"The user {user_selected.name} {user_selected.last_name} has bought {book_selected.title} by ${price}")

        user_selected.has_bought_a_book = True
        self.book_list.remove(book_selected)
        book_selected.its_available = False

    def show_users(self):
        for index, user in enumerate(self.user_list):
            print(f"| ID: {index + 1} | code: {user.id} | Name: {user.name} | Lastname: {user.last_name} | Age: {user.age}")

    def show_users_have_rented_books(self):
        for index, user in enumerate(self.user_list):
            if user.has_rented_book:
                print(f"|ID: {index + 1} | code: {user.id} | Name: {user.name} | Lastname: {user.last_name} | Age: {user.age}")

    def show_all_books(self):
        for index, book in enumerate(self.book_list):
            print(f"| ID: {index + 1} | code: {book.id} | Title: {book.title} | Author: {book.author} | Publication year: {book.year}")

    def show_books_available(self):
        for index, available in enumerate(self.book_list):
            if available.is_its_available():
                print(f"|ID: {index + 1} | code: {available.id} | Title: {available.title} | Author: {available.author} | Publication year: {available.year}")

    def show_rented_books(self):
        for index, rented_books in enumerate(self.book_list):
            if not rented_books.is_its_available():
                print(f"|ID: {index + 1} | code: {rented_books.id} | Title: {rented_books.title} | Author: {rented_books.author} | Publication year: {rented_books.year}")

    def show_user_with_rented_books(self):
        for index, user in enumerate(self.user_list):
            if user.has_bought_a_book:
                print(f"|ID: {index + 1} | code: {user.id} | Name: {user.name} | Lastname: {user.last_name} | Age: {user.age}")

    def testing_info(self):
        idgenerator = IdGenerator()
        id_1 = idgenerator.create_id()
        id_2 = idgenerator.create_id()
        id_3 = idgenerator.create_id()
        user_1 = User(id_1, "Alejandro", "Montejano", 20)
        user_2 = User(id_2, "Atziri", "Mancilla", 27)
        user_3 = User(id_3, "Jafet", "Santoyo", 27)
        self.user_list.append(user_1)
        self.user_list.append(user_2)
        self.user_list.append(user_3)
        ##books
        id_b1 = idgenerator.create_book_id()
        id_b2 = idgenerator.create_book_id()
        id_b3 = idgenerator.create_book_id()
        id_b4 = idgenerator.create_book_id()
        id_b5 = idgenerator.create_book_id()
        id_b6 = idgenerator.create_book_id()
        book_1 = Book(id_b1, "Muerte en el Nilo", "Agatha Chriestie", 1937, True)
        book_2 = Book(id_b2, "Las memorias de Sherlock Holmes", "Arthur Conan Doyle", 1894, True)
        book_3 = Book(id_b3, "El pulgar del violinista", "Sam Kean", 2013, True)
        book_4 = Book(id_b4, "Momo", "Michael Ende", 1972, True)
        book_5 = Book(id_b5, "Salvar el fuego", "Guillermo Arriaga", 2020, True)
        book_6 = Book(id_b6, "Ilusiones", "Richard Bach", 1977, True)

        self.book_list.append(book_1)
        self.book_list.append(book_2)
        self.book_list.append(book_3)
        self.book_list.append(book_4)
        self.book_list.append(book_5)
        self.book_list.append(book_6)
