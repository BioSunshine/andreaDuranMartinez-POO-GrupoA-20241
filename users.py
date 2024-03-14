class Users:
    def __init__(self, code, name, lastname, age):
        self.id = code
        self.name = name
        self.lastname = lastname
        self.age = age
        self.list_rented_books = []
        self.has_rented_book = False
        self.has_bought_a_book = False

    def get_lastname(self):
        return self.lastname

    def __str__(self):
        return f"Users{{id={self.id}, name='{self.name}', lastname='{self.lastname}', age={self.age}}}"

    def is_has_bought_a_book(self):
        return self.has_bought_a_book

    def set_has_bought_a_book(self, has_bought_a_book):
        self.has_bought_a_book = has_bought_a_book

    def get_id(self):
        return self.id

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def is_has_rented_book(self):
        return self.has_rented_book

    def set_has_rented_book(self, has_rented_book):
        self.has_rented_book = has_rented_book

    def get_list_rented_books(self):
        return self.list_rented_books

    def rent_a_book(self, new_book):
        self.list_rented_books.append(new_book)

    def return_book(self):
        print("Select the book the client wants to return")
        count = 0
        for book in self.list_rented_books:
            print(f"| ID {count + 1} Id: {book.get_id()} Title: {book.get_title()} "
                  f"Author: {book.get_author()} Publication Year: {book.get_year()}")
            count += 1
        selection = int(input()) - 1
        book_selected = self.list_rented_books[selection]
        book_selected.set_its_available(True)
        del self.list_rented_books[selection]
        print("The book has been returned")
