from code_generator import CodeGenerator
from users import Users
from books import Books


class Library:
    __userlist = []  # Lista de usuarios
    __booklist = []  # Lista de libros

    @staticmethod
    def get_userlist():
        return Library.__userlist

    @staticmethod
    def get_booklist():
        return Library.__booklist

    @staticmethod
    def add_user(new_user):
        Library.__userlist.append(new_user)

    @staticmethod
    def add_book(new_book):
        Library.__booklist.append(new_book)

    @staticmethod
    def show_users():
        identifier = 0
        for user in Library.get_userlist():
            print(
                f"| ID: {identifier + 1} | code: {user.get_id()} | Name: {user.get_name()} "
                f"| Lastname: {user.get_lastname()} | Age: {user.get_age()}")
            identifier += 1

    @staticmethod
    def rent_a_book():
        print("Select the client who wants to rent a Book")
        Library.show_users()
        option = int(input()) - 1
        user_selected = Library.get_userlist()[option]
        print(
            f"You choosed: code: {user_selected.get_id()} | Name: {user_selected.get_name()} "
            f"| Lastname: {user_selected.get_lastname()} | Age: {user_selected.get_age()}")
        print("Choose the book the client wants to rent: ")
        identifier = 0
        for book in Library.__booklist:
            if book.is_its_available():
                print(
                    f"| ID {identifier + 1} Id: {book.get_id()} Title: {book.get_title()} "
                    f"Author: {book.get_author()} Publication Year: {book.get_year()}")
            identifier += 1
        selection = int(input()) - 1
        bookselected = Library.__booklist[selection]
        if not bookselected.is_its_available():
            print("Sorry, that book isn't available, even it is not shown in the list")
            return
        print(f"You selected:\n  Title: {bookselected.get_title()} | Author: {bookselected.get_author()}")
        user_selected.rent_a_book(bookselected)
        user_selected.set_has_rented_book(True)
        bookselected.set_its_available(False)
        print(" >>>Now the rent is authorized \n > The client can take the book ")

    @staticmethod
    def return_book():
        print("Select the client who wants to return a book")
        Library.show_users_have_rented_books()
        input_ = int(input()) - 1
        user_selected = Library.__userlist[input_]
        print("Which book wants to return?")
        user_selected.return_book()

    @staticmethod
    def show_users_have_rented_books():
        identifier = 0
        for user in Library.get_userlist():
            if user.has_rented_book():
                print(
                    f"| id: {identifier + 1} | code: {user.get_id()} | Name: {user.get_name()} "
                    f"| Lastname: {user.get_lastname()} | Age: {user.get_age()}")
            identifier += 1

    @staticmethod
    def buy_a_book():
        print("Select the client who wants to buy a Book: ")
        identifier = 0
        for user in Library.get_userlist():
            print(
                f"| id: {identifier + 1} | code: {user.get_id()} | Name: {user.get_name()} "
                f"| Lastname: {user.get_lastname()} | Age: {user.get_age()}")
            identifier += 1
        selection = int(input()) - 1
        user_selected = Library.__userlist[selection]
        print("Select the book the client wants to buy: ")
        Library.show_books_available()
        input_ = int(input()) - 1
        book_selected = Library.__booklist[input_]
        if not book_selected.is_its_available():
            print("Sorry, that book isn't available, even it is not shown in the list")
            return
        print("Enter the price: ")
        price = float(input())
        if price < 0:
            print("Invalid value")
            return
        print(
            f"The user {user_selected.get_name()}  {user_selected.get_lastname()} "
            f"has bought {book_selected.get_title()} by $ {price}")
        book_selected.set_its_available(False)
        user_selected.set_has_bought_a_book(True)
        Library.__booklist.remove(input_)

    @staticmethod
    def show_books_available():
        identifier = 0
        for availables in Library.get_booklist():
            if availables.is_its_available():
                print(
                    f"|id: {identifier + 1} | code: {availables.get_id()} "
                    f"| Title: {availables.get_title()} | Author: {availables.get_author()} "
                    f"| Publication year: {availables.get_year()}")
            identifier += 1

    @staticmethod
    def testing_info():
        id_1 = CodeGenerator.create_id()
        id_2 = CodeGenerator.create_id()
        id_3 = CodeGenerator.create_id()

        user_1 = Users(id_1, "Alejandro", "Montejano", 20)
        user_2 = Users(id_2, "Atziri", "Mancilla", 27)
        user_3 = Users(id_3, "Jafet", "Santoyo", 27)

        Library.add_user(user_1)
        Library.add_user(user_2)
        Library.add_user(user_3)

        id_b1 = CodeGenerator.create_book_id()
        id_b2 = CodeGenerator.create_book_id()
        id_b3 = CodeGenerator.create_book_id()
        id_b4 = CodeGenerator.create_book_id()
        id_b5 = CodeGenerator.create_book_id()
        id_b6 = CodeGenerator.create_book_id()

        book_1 = Books(id_b1, "Muerte en el Nilo", "Agatha Chriestie", 1937)
        book_2 = Books(id_b2, "Las memorias de Sherlock Holmes", "Arthur Conan Doyle", 1894)
        book_3 = Books(id_b3, "El pulgar del violinista", "Sam Kean", 2013)
        book_4 = Books(id_b4, "Momo", "Michael Ende", 1972)
        book_5 = Books(id_b5, "Salvar el fuego", "Guillermo Arriaga", 2020)
        book_6 = Books(id_b6, "Ilusiones", "Richard Bach", 1977)

        Library.add_book(book_1)
        Library.add_book(book_2)
        Library.add_book(book_3)
        Library.add_book(book_4)
        Library.add_book(book_5)
        Library.add_book(book_6)
