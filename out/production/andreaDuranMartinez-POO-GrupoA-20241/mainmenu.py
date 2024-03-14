from library import Library
from userscontroller import UsersController
from books import Books
from showlists import Showlists


class MainMenu:
    @staticmethod
    def main():

        Library.testing_info()
        band = True
        while band:
            print("""
                    \t\t\t>>>>>Welcome to the Library<<<<<<

                     \tWhat do you want to do?

                     \t1) Register User
                     \t2) Register a Book
                     \t3) Rent a Book
                     \t4) Return a Book
                     \t5) Buy a Book
                     \t6) See the lists
                     \t0) Exit system""")
            option = int(input())
            if option == 1:
                UsersController.create_user()
            elif option == 2:
                Books.register_book()
            elif option == 3:
                Library.rent_a_book()
            elif option == 4:
                Library.return_book()
            elif option == 5:
                Library.buy_a_book()
            elif option == 6:
                Showlists.menu_lists()
            elif option == 0:
                band = False
            else:
                print("Invalid input...")


if __name__ == "__main__":
    MainMenu.main()
