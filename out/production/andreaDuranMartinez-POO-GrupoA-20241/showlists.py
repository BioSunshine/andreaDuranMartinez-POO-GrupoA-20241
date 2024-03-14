from library import Library


class Showlists:
    @staticmethod
    def menu_lists():
        band = True
        while band:
            print("""
                    \t\t>>>Welcome to database<<<
                     What do you want to check?
                     1) See registered Users
                     2) See users that have rented at least a Book
                     3) See All the Books
                     4) See Books available
                     5) See rented books
                     6) See users that have bought a book
                     0) Return""")
            option = int(input())
            if option == 1:
                Showlists.see_users()
            elif option == 2:
                Showlists.see_rented_users()
            elif option == 3:
                Showlists.see_all_books()
            elif option == 4:
                Showlists.see_available_books()
            elif option == 5:
                Showlists.see_rented_books()
            elif option == 6:
                Showlists.see_bought_users()
            elif option == 0:
                band = False
            else:
                print("Not a valid input...")

    @staticmethod
    def see_users():
        Library.show_users()

    @staticmethod
    def see_rented_users():
        id = 0
        for user in Library.get_userlist():
            if user.is_has_rented_book():
                print("|id: " + str(
                    id + 1) + " | code: " + user.get_id() + " | Name: " + user.get_name() + " | Lastname: " + user.get_lastname() + " | Age: " + str(
                    user.get_age()))
            id += 1

    @staticmethod
    def see_all_books():
        id = 0
        for book in Library.get_booklist():
            print(" | id: " + str(
                id + 1) + " | code: " + book.get_id() + " | Title: " + book.get_title() + " | Author: " + book.get_author() + " | Publication year: " + str(
                book.get_year()))
            id += 1

    @staticmethod
    def see_available_books():
        Library.show_books_available()

    @staticmethod
    def see_rented_books():
        id = 0
        for rented_books in Library.get_booklist():
            if not rented_books.is_its_available():
                print("|id: " + str(
                    id + 1) + " | code: " + rented_books.get_id() + " | Title: " + rented_books.get_title() + "| Author: " + rented_books.get_author() + " | Publication year: " + str(
                    rented_books.get_year()))
            id += 1

    @staticmethod
    def see_bought_users():
        id = 0
        for user in Library.get_userlist():
            if user.is_has_bought_a_book():
                print("|id: " + str(
                    id + 1) + " | code: " + user.get_id() + " | Name: " + user.get_name() + " | Lastname: " + user.get_lastname() + " | Age: " + str(
                    user.get_age()))
            id += 1
