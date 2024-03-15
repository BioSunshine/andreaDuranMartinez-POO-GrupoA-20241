from library import Library

library = Library()
library.testing_info()
band = True
while True:
    print("\n>>>>>Welcome to the Library<<<<<<\n")
    print("What do you want to do?")
    print("1) Register User")
    print("2) Register a Book")
    print("3) Rent a Book")
    print("4) Return a Book")
    print("5) Buy a Book")
    print("6) See registered Users")
    print("7) See users that have rented at least a Book")
    print("8) See All the Books")
    print("9) See Books available")
    print("10) See rented books")
    print("11) See users that have bought a book")
    print("0) Exit system")

    option = int(input())
    if option == 1:
        library.create_user()
    elif option == 2:
        library.register_book()
    elif option == 3:
        library.rent_a_book()
    elif option == 4:
        library.return_book()
    elif option == 5:
        library.buy_a_book()
    elif option == 6:
        library.show_users()
    elif option == 7:
        library.show_users_have_rented_books()
    elif option == 8:
        library.show_all_books()
    elif option == 9:
        library.show_books_available()
    elif option == 10:
        library.show_rented_books()
    elif option == 11:
        library.show_user_with_rented_books()
    elif option == 0:
        band = False
    else:
        print("Invalid input...")
